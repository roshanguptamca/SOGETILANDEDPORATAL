package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

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

}