package com.sogeti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	private String customername;

	private String location;

	// bi-directional one-to-one association to CustomerDetail
	@OneToOne(mappedBy = "customer")
	private CustomerDetail customerDetail;

	// bi-directional many-to-one association to KnowledgeBase
	@OneToMany(mappedBy = "customer")
	private List<KnowledgeBase> knowledgeBases;

	public Customer() {
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CustomerDetail getCustomerDetail() {
		return this.customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public List<KnowledgeBase> getKnowledgeBases() {
		return this.knowledgeBases;
	}

	public void setKnowledgeBases(List<KnowledgeBase> knowledgeBases) {
		this.knowledgeBases = knowledgeBases;
	}

	public KnowledgeBase addKnowledgeBas(KnowledgeBase knowledgeBas) {
		getKnowledgeBases().add(knowledgeBas);
		knowledgeBas.setCustomer(this);

		return knowledgeBas;
	}

	public KnowledgeBase removeKnowledgeBas(KnowledgeBase knowledgeBas) {
		getKnowledgeBases().remove(knowledgeBas);
		knowledgeBas.setCustomer(null);

		return knowledgeBas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result
				+ ((customerDetail == null) ? 0 : customerDetail.hashCode());
		result = prime * result
				+ ((customername == null) ? 0 : customername.hashCode());
		result = prime * result
				+ ((knowledgeBases == null) ? 0 : knowledgeBases.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
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
		Customer other = (Customer) obj;
		if (cid != other.cid)
			return false;
		if (customerDetail == null) {
			if (other.customerDetail != null)
				return false;
		} else if (!customerDetail.equals(other.customerDetail))
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (knowledgeBases == null) {
			if (other.knowledgeBases != null)
				return false;
		} else if (!knowledgeBases.equals(other.knowledgeBases))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

}