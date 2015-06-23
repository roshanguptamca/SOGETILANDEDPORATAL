package com.sogeti.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedNativeQueries({ @NamedNativeQuery (name=User.getUserCustomeData, query="select  users.emp_id,users.name,user_address.address,user_phone.contactno from users,user_address,user_phone")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String getUserCustomeData = "User.getUserCustomeData";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="emp_id")
	private String empId;

	@Lob
	@Column(name="emp_photo")
	private byte[] empPhoto;

	@Temporal(TemporalType.DATE)
	@Column(name="landed_date")
	private Date landedDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastlogin;

	private String name;

	private String password;

	//bi-directional many-to-one association to CustomerDetail
	@OneToMany(mappedBy="user")
	private List<CustomerDetail> customerDetails;

	//bi-directional many-to-one association to KnowledgeBase
	@OneToMany(mappedBy="user")
	private List<KnowledgeBase> knowledgeBases;

	//bi-directional many-to-one association to UserAddress
	@OneToMany(mappedBy="user")
	private List<UserAddress> userAddresses;

	//bi-directional many-to-one association to UserMotivation
	@OneToMany(mappedBy="user")
	private List<UserMotivation> userMotivations;

	//bi-directional many-to-one association to UserPhone
	@OneToMany(mappedBy="user")
	private List<UserPhone> userPhones;

	//bi-directional many-to-one association to UserResume
	@OneToMany(mappedBy="user")
	private List<UserResume> userResumes;

	//bi-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="role_Id")
	private UserRole userRole;

	public User() {
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public byte[] getEmpPhoto() {
		return this.empPhoto;
	}

	public void setEmpPhoto(byte[] empPhoto) {
		this.empPhoto = empPhoto;
	}

	public Date getLandedDate() {
		return this.landedDate;
	}

	public void setLandedDate(Date landedDate) {
		this.landedDate = landedDate;
	}

	public Date getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CustomerDetail> getCustomerDetails() {
		return this.customerDetails;
	}

	public void setCustomerDetails(List<CustomerDetail> customerDetails) {
		this.customerDetails = customerDetails;
	}

	public CustomerDetail addCustomerDetail(CustomerDetail customerDetail) {
		getCustomerDetails().add(customerDetail);
		customerDetail.setUser(this);

		return customerDetail;
	}

	public CustomerDetail removeCustomerDetail(CustomerDetail customerDetail) {
		getCustomerDetails().remove(customerDetail);
		customerDetail.setUser(null);

		return customerDetail;
	}

	public List<KnowledgeBase> getKnowledgeBases() {
		return this.knowledgeBases;
	}

	public void setKnowledgeBases(List<KnowledgeBase> knowledgeBases) {
		this.knowledgeBases = knowledgeBases;
	}

	public KnowledgeBase addKnowledgeBas(KnowledgeBase knowledgeBas) {
		getKnowledgeBases().add(knowledgeBas);
		knowledgeBas.setUser(this);

		return knowledgeBas;
	}

	public KnowledgeBase removeKnowledgeBas(KnowledgeBase knowledgeBas) {
		getKnowledgeBases().remove(knowledgeBas);
		knowledgeBas.setUser(null);

		return knowledgeBas;
	}

	public List<UserAddress> getUserAddresses() {
		return this.userAddresses;
	}

	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public UserAddress addUserAddress(UserAddress userAddress) {
		getUserAddresses().add(userAddress);
		userAddress.setUser(this);

		return userAddress;
	}

	public UserAddress removeUserAddress(UserAddress userAddress) {
		getUserAddresses().remove(userAddress);
		userAddress.setUser(null);

		return userAddress;
	}

	public List<UserMotivation> getUserMotivations() {
		return this.userMotivations;
	}

	public void setUserMotivations(List<UserMotivation> userMotivations) {
		this.userMotivations = userMotivations;
	}

	public UserMotivation addUserMotivation(UserMotivation userMotivation) {
		getUserMotivations().add(userMotivation);
		userMotivation.setUser(this);

		return userMotivation;
	}

	public UserMotivation removeUserMotivation(UserMotivation userMotivation) {
		getUserMotivations().remove(userMotivation);
		userMotivation.setUser(null);

		return userMotivation;
	}

	public List<UserPhone> getUserPhones() {
		return this.userPhones;
	}

	public void setUserPhones(List<UserPhone> userPhones) {
		this.userPhones = userPhones;
	}

	public UserPhone addUserPhone(UserPhone userPhone) {
		getUserPhones().add(userPhone);
		userPhone.setUser(this);

		return userPhone;
	}

	public UserPhone removeUserPhone(UserPhone userPhone) {
		getUserPhones().remove(userPhone);
		userPhone.setUser(null);

		return userPhone;
	}

	public List<UserResume> getUserResumes() {
		return this.userResumes;
	}

	public void setUserResumes(List<UserResume> userResumes) {
		this.userResumes = userResumes;
	}

	public UserResume addUserResume(UserResume userResume) {
		getUserResumes().add(userResume);
		userResume.setUser(this);

		return userResume;
	}

	public UserResume removeUserResume(UserResume userResume) {
		getUserResumes().remove(userResume);
		userResume.setUser(null);

		return userResume;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerDetails == null) ? 0 : customerDetails.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + Arrays.hashCode(empPhoto);
		result = prime * result
				+ ((knowledgeBases == null) ? 0 : knowledgeBases.hashCode());
		result = prime * result
				+ ((landedDate == null) ? 0 : landedDate.hashCode());
		result = prime * result
				+ ((lastlogin == null) ? 0 : lastlogin.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + uid;
		result = prime * result
				+ ((userAddresses == null) ? 0 : userAddresses.hashCode());
		result = prime * result
				+ ((userMotivations == null) ? 0 : userMotivations.hashCode());
		result = prime * result
				+ ((userPhones == null) ? 0 : userPhones.hashCode());
		result = prime * result
				+ ((userResumes == null) ? 0 : userResumes.hashCode());
		result = prime * result
				+ ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (customerDetails == null) {
			if (other.customerDetails != null)
				return false;
		} else if (!customerDetails.equals(other.customerDetails))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (!Arrays.equals(empPhoto, other.empPhoto))
			return false;
		if (knowledgeBases == null) {
			if (other.knowledgeBases != null)
				return false;
		} else if (!knowledgeBases.equals(other.knowledgeBases))
			return false;
		if (landedDate == null) {
			if (other.landedDate != null)
				return false;
		} else if (!landedDate.equals(other.landedDate))
			return false;
		if (lastlogin == null) {
			if (other.lastlogin != null)
				return false;
		} else if (!lastlogin.equals(other.lastlogin))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uid != other.uid)
			return false;
		if (userAddresses == null) {
			if (other.userAddresses != null)
				return false;
		} else if (!userAddresses.equals(other.userAddresses))
			return false;
		if (userMotivations == null) {
			if (other.userMotivations != null)
				return false;
		} else if (!userMotivations.equals(other.userMotivations))
			return false;
		if (userPhones == null) {
			if (other.userPhones != null)
				return false;
		} else if (!userPhones.equals(other.userPhones))
			return false;
		if (userResumes == null) {
			if (other.userResumes != null)
				return false;
		} else if (!userResumes.equals(other.userResumes))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}

}