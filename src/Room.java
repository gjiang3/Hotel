public class Room {
	private int roomID;
	private double costPerNight; 
	private String roomType;

	public Room(int roomID, double costPerNight, String roomType){
		this.roomID = roomID;
		this.costPerNight = costPerNight;
		this.roomType = roomType;
	}

	public int getRoomId() {
		return roomID;
	}
	
	public double getCostPerNight() {
		return costPerNight;
	}
	
	public String getRoomType() {
		return roomType;
	}
}