package com.cg.pmc.dto;

public class UserBean {
	
	private int userId;
	private String FirstName;
	private String middleName;
	private String lastName;
	private String businessName;
	private String emailId;
	private boolean isActive;
	private long mobileNo;
	private int i=0;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserBean(int userId, String firstName, String middleName,
			String lastName, String businessName, String emailId, long mobileNo,boolean isActive) {
		super();
		this.userId = userId;
		FirstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.businessName = businessName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.isActive = isActive;
	}

	public UserBean(String firstName, String middleName,
			String lastName, String businessName, String emailId, long mobileNo,boolean isActive) {
		super();
		FirstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.businessName = businessName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.isActive = isActive;
	}

	
	
	
	
	public boolean isActive() {
		return isActive;
	}




	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}




	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public String getFirstName() {
		return FirstName;
	}





	public void setFirstName(String firstName) {
		FirstName = firstName;
	}





	public String getMiddleName() {
		return middleName;
	}





	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getBusinessName() {
		return businessName;
	}





	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}





	public String getEmailId() {
		return emailId;
	}





	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}





	public long getMobileNo() {
		return mobileNo;
	}





	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", FirstName=" + FirstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", businessName=" + businessName + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + "]";
	}
}
