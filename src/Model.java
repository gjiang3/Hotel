import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Model {
	private static String password = "048561";
	private static String connectionString = "jdbc:mysql://localhost:3306/Hotel?autoReconnect=true&useSSL=false";
	private static Connection conn;
	
	public Model(){
		try{
			conn = DriverManager.getConnection(connectionString, "root", password );
//			command = connection.createStatement();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
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
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

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
	
	
}
