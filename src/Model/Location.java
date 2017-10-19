package Model;

public class Location {
	private int id;
	private String locationDate;
	private String devolutionDate;
	private float price;
	private boolean returned;
	private int clientId;
	private int projectorId;
	
	public Location() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLocationDate() {
		return locationDate;
	}
	
	public void setLocationDate(String locationDate) {
		this.locationDate = locationDate;
	}
	
	public String getDevolutionDate() {
		return devolutionDate;
	}
	
	public void setDevolutionDate(String devolutionDate) {
		this.devolutionDate = devolutionDate;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean isReturned() {
		return returned;
	}
	
	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	
	public int getClientId() {
		return clientId;
	}
	
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	public int getProjectorId() {
		return projectorId;
	}
	
	public void setProjectorId(int projectorId) {
		this.projectorId = projectorId;
	}	
}
