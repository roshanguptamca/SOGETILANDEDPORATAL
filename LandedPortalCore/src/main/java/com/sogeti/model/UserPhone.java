package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_phone database table.
 * 
 */
@Entity
@Table(name="user_phone")
@NamedQuery(name="UserPhone.findAll", query="SELECT u FROM UserPhone u")
public class UserPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;

	private String contactno;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="uid")
	private User user;

	public UserPhone() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getContactno() {
		return this.contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}