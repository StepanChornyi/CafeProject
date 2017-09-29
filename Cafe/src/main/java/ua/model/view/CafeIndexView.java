package ua.model.view;


import ua.entity.Type;

public class CafeIndexView {

	private Integer id;
	
	private int rate;
	
	private int countRate;
	
	private String name;
	
	private String photoUrl;
	
	private int version;
	
	private String address;
	
	private String shortDescription;
	
	private String type;

	public CafeIndexView(Integer id, int rate,int countRate, String name, String photoUrl, int version, String address, String shortDescription, Type type) {
		this.id = id;
		this.rate = rate;
		this.countRate = countRate;
		this.name = name;
		this.photoUrl = photoUrl;
		this.version = version;
		this.address = address;
		this.shortDescription = shortDescription;
		this.type = type.name();
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getCountRate() {
		return countRate;
	}

	public void setCountRate(int countRate) {
		this.countRate = countRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CafeIndexView [id=" + id + ", rate=" + rate + ", countRate=" + countRate + ", name=" + name
				+ ", photoUrl=" + photoUrl + ", version=" + version + ", address=" + address + ", shortDescription="
				+ shortDescription + ", type=" + type + "]";
	}

	
	
}
