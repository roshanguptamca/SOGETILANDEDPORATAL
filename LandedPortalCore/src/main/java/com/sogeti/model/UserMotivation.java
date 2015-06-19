package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_motivation database table.
 * 
 */
@Entity
@Table(name="user_motivation")
@NamedQuery(name="UserMotivation.findAll", query="SELECT u FROM UserMotivation u")
public class UserMotivation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mid;

	@Lob
	private byte[] motivation;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="uid")
	private User user;

	public UserMotivation() {
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public byte[] getMotivation() {
		return this.motivation;
	}

	public void setMotivation(byte[] motivation) {
		this.motivation = motivation;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}