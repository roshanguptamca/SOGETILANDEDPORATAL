package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;

	private String customername;

	private String location;

	//bi-directional one-to-one association to CustomerDetail
	@OneToOne(mappedBy="customer")
	private CustomerDetail customerDetail;

	//bi-directional many-to-one association to KnowledgeBase
	@OneToMany(mappedBy="customer")
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

}