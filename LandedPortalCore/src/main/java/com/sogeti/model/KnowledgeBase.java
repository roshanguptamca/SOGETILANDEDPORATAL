package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the knowledge_base database table.
 * 
 */
@Entity
@Table(name="knowledge_base")
@NamedQuery(name="KnowledgeBase.findAll", query="SELECT k FROM KnowledgeBase k")
public class KnowledgeBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int kid;

	private String answer;

	@Temporal(TemporalType.DATE)
	@Column(name="interview_date")
	private Date interviewDate;

	private String question;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="cid")
	private Customer customer;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="uid")
	private User user;

	public KnowledgeBase() {
	}

	public int getKid() {
		return this.kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getInterviewDate() {
		return this.interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}