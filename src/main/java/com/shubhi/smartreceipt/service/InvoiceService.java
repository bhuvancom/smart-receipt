package com.shubhi.smartreceipt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhi.smartreceipt.model.Invoice;
import com.shubhi.smartreceipt.model.User;
import com.shubhi.smartreceipt.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	public void deleteInvoice(Invoice invoice) {
		invoiceRepository.delete(invoice);
	}

	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	public Invoice getInvoice(Integer id) {
		return invoiceRepository.getOne(id);
	}

	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	public void deleteInvoiceOfUserId(Integer id) {
		User user = new User();
		user.setUserId(id);
		List<Invoice> invoices = invoiceRepository.getInvoiceOfUser(user);
		invoiceRepository.deleteInBatch(invoices);
	}

}
