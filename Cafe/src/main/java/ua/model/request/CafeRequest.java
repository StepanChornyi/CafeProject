package ua.model.request;


import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.OpenClose;

public class CafeRequest {

	private Integer id;

	private BigDecimal rate = new BigDecimal(5);
	
	@Pattern(regexp = "^([A-Z][a-z]+)?$", message = "the name must start with a capital letter")
	@NotBlank(message = "this field is required")
	private String name;
	
	

	private String photoUrl;

	private int version;

	@NotBlank(message = "this field is required")
	private String address;

	private String fullDescription;
	
	@NotBlank(message = "this field is required")
	private String shortDescription;

	private String type;

	@Pattern(regexp = "^(\\+380[0-9]{9})?$", message = "value must +380XXXXXXXXX")
	@NotBlank(message = "this field is required")
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

	

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
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
