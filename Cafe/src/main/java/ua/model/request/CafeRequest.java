package ua.model.request;


import ua.entity.OpenClose;

public class CafeRequest {

	private Integer id;

	private int rate;
	
	private int countRate;

	private String name;

	private String photoUrl;

	private int version;

	private String address;

	private String fullDescription;
	
	private String shortDescription;

	private String type;

	private String phone;

	private String email;

	private OpenClose open;

	private OpenClose close;

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

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OpenClose getOpen() {
		return open;
	}

	public void setOpen(OpenClose open) {
		this.open = open;
	}

	public OpenClose getClose() {
		return close;
	}

	public void setClose(OpenClose close) {
		this.close = close;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	

	

	
	
}
