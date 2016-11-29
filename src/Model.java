import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Model {
	private static String password = "048561";
	private static String connectionString = "jdbc:mysql://localhost:3306/Hotel?autoReconnect=true&useSSL=false";
	private static Connection conn;
	private static Statement statement;
	public static final GregorianCalendar TODAY = new GregorianCalendar();
	private String currentUser;
	
	public Model(){
		try{
			conn = DriverManager.getConnection(connectionString, "root", password );
			statement = conn.createStatement();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void setUser(String currentUser){
		this.currentUser = currentUser;
	}
	
	public void registerNewUser(String username, String password, String firstName, String lastName, 
			String userRole, int age, String gender, String securityQuestion, String answer) throws SQLException{
		PreparedStatement pstmt = null; 
		try { 
			String SQL = "Insert into user (userName,password,firstName,lastName, userRole, age, gender, question, answer) Values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.setString(3,firstName);
			pstmt.setString(4,lastName);
			pstmt.setString(5,userRole);
			pstmt.setInt(6,age);
			pstmt.setString(7,gender);
			pstmt.setString(8,securityQuestion);
			pstmt.setString(9,answer);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally { 
			pstmt.close(); 
		} 
	}
	
	public boolean checkUserExistence(String username){
		String query = "SELECT userName FROM USER";
		
		try {
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				if (rs.getString("username").equals(username)) return true;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean checkUserPassword(String username, String password) {
		String query = "SELECT password FROM USER WHERE userName = '" + username + "'";
		
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next() && rs.getString("password").equals(password)) {
				rs.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false; 
	}
	
	public String getAccountType(String username){
		String accountType = "";
		String query = "SELECT userRole FROM USER where username ='" + username + "'";
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				accountType = rs.getString("userRole");
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountType;
	}
	
	public String getSecurityQuestion(String username){
		String question = "";
		String query = "SELECT question FROM USER where username ='" + username + "'";
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				question = rs.getString("question");
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return question;
	}

	public boolean checkUserSecurityAnwser(String username, String answer){
		String correctAnswer = "";
		String query = "SELECT answer FROM USER where username ='" + username + "'";
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				correctAnswer = rs.getString("answer");
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return correctAnswer.equals(answer);
	}

	public String getPassword(String username){
		String password = "";
		String query = "SELECT password FROM USER where username ='" + username + "'";
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				password = rs.getString("password");
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return password;
	}
	
	public ArrayList<Room> getAvailRooms(String in, String out) {
		ArrayList<Room> rooms = new ArrayList<>();
		String checkIn = sqlToDate(in);
		String checkOut = sqlToDate(out);
		String query = "select * from room where roomId not in "
				+ "(select distinct room.roomId "
				+ "from room left outer join reservation on room.roomId = reservation.roomId "
				+ "where " + checkIn + " = reservation.startdate"
				+ " or " + checkIn + " = reservation.enddate"
				+ " or " + checkOut + "= reservation.startdate"
				+ " or " + checkOut + " = reservation.enddate"
				+ " or " + "(reservation.startdate < " + checkOut + " and reservation.enddate > " + checkIn + ")"
				+ " or (" + checkIn + " < reservation.startdate and " + checkOut + " > reservation.startdate)"
				+ " or (" + checkIn + " < reservation.enddate and " + checkOut + " > reservation.enddate))";

		try {
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				rooms.add(new Room(rs.getInt("roomid"), rs.getDouble("costpernight"), rs.getString("roomtype")));
			}
			rs.close();
			return rooms;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rooms;
	}
	
	public void addReservation(int roomId, String checkIn, String checkOut, int days, double cost) {

		String query = "Insert into reservation (roomId,customer,startDate,endDate, numOfDays, totalCost) Values "
				+ "(" + roomId + "," + "'" + currentUser + "'" + "," + sqlToDate(checkIn) + "," + sqlToDate(checkOut)
				+ "," + days + "," + cost +")";
			
		try {
			statement.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public ArrayList<User> getAllUsers(){
		ArrayList<User> users = new ArrayList<User>();
		String query = "SELECT * FROM USER order by userRole";
		
		try {
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()){
				users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("userRole"), rs.getInt("age"), rs.getString("gender"), rs.getString("question"), rs.getString("answer")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public String sqlToDate(String date) {
		return "str_to_date('" + date + "', '%m/%d/%Y')";
	}
}
