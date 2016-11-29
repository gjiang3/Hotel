import java.util.Date;

public class Reservation {
	private int reservationId;
	private String username;
	private Room room;
	private Date startDate;
	private Date endDate;
//	private int numOfDays;
	private double totalCost;	
//	private boolean canceled;
	private boolean isConfirmed;
	private String managerId;
	
	public Reservation(int reservationId, String username, Room room, Date starDate, Date endDate, 
			double totalCost, boolean isConfirmed, String managerId){
		this.reservationId = reservationId;
		this.username = username;
		this.room = room;
		this.startDate = starDate;
		this.endDate = endDate;
		this.totalCost = totalCost;
		this.isConfirmed = false;
		this.managerId = managerId;
		
	}
}
