package ua.model.view;


public class TableView {

	private Integer id;
	
	private int countOfPeople;
	
	private int tableNumber;
	
	private boolean isFree;
	
	private String user;
	
	private String userPhone;
	
	private String cafe;
	

	public TableView(Integer id,  int countOfPeople, int tableNumber, boolean isFree, String user, String userPhone, String cafe) {
		this.id = id;
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
		this.user = user;
		this.userPhone = userPhone;
		this.cafe = cafe;
		this.tableNumber = tableNumber;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getCountOfPeople() {
		return countOfPeople;
	}


	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}


	public boolean getIsFree() {
		return isFree;
	}


	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getCafe() {
		return cafe;
	}


	public void setCafe(String cafe) {
		this.cafe = cafe;
	}


	public int getTableNumber() {
		return tableNumber;
	}


	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	
	
}
