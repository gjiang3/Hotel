import java.util.ArrayList;

public class Customer extends User{
	ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	public Customer(String username, String password, String name, String securityQuestion, String answer) {
		super(username, password, name, securityQuestion, answer);
		// TODO Auto-generated constructor stub
	}
	
	public void makeReservation(){
		
	}

}
