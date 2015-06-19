package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_resumes database table.
 * 
 */
@Entity
@Table(name="user_resumes")
@NamedQuery(name="UserResume.findAll", query="SELECT u FROM UserResume u")
public class UserResume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;

	@Lob
	private byte[] resume;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public UserResume() {
	}

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public byte[] getResume() {
		return this.resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}