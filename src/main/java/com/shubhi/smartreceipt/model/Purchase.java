package com.shubhi.smartreceipt.model;

import java.util.List;

import javax.persistence.*;

@Entity(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private Integer purchaseId;


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	@Column(name = "quantity")
	private int quantity;


    public Purchase(Product product, Invoice invoice, int quantity) {
        this.product = product;
        this.invoice = invoice;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase() {
	}


	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Purchase{" + "purchaseId=" + purchaseId + ", product=" + product + ", invoice=" + invoice
				+ ", quantity=" + quantity + '}';
	}
}
