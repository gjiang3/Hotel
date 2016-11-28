
public class RoomService {
	private final int serviceId;
	private final String description;
	private final int roomID;
//	private final Date date;

	public RoomService(int serviceId, String description, int roomID, Date date) {
		this.serviceId = serviceId;
		this.description = description;
		this.roomID = roomID;
//		this.date = date;
		
	}
	public int getServiceId() {
		return this.serviceId;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getRoomID() {
		return this.roomID;
	}
	
//	public Date getTime() {
//		return time;
//	}
	
}
