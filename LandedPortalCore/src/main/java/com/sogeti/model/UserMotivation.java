package com.sogeti.model;

import java.io.Serializable;
import java.util.Arrays;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mid;
		result = prime * result + Arrays.hashCode(motivation);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserMotivation other = (UserMotivation) obj;
		if (mid != other.mid)
			return false;
		if (!Arrays.equals(motivation, other.motivation))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}