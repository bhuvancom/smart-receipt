package com.shubhi.smartreceipt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "invoice")
public class Invoice {

	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Temporal(TemporalType.DATE)
	@Column(name = "purchased_on")
	private Date purchasedOn;

	public Invoice(User user, Date purchasedOn) {
		this.user = user;
		this.purchasedOn = purchasedOn;
	}

	public Invoice() {
		this.purchasedOn = new Date();
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPurchasedOn() {
		return purchasedOn;
	}

	public void setPurchasedOn(Date purchasedOn) {
		this.purchasedOn = purchasedOn;
	}

	@Override
	public String toString() {
		return "Invoice{" + "invoiceId=" + invoiceId + ", user=" + user + ", purchasedOn=" + purchasedOn + '}';
	}
}
