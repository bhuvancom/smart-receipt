package com.shubhi.smartreceipt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhi.smartreceipt.model.Purchase;
import com.shubhi.smartreceipt.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	public Purchase save(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

	public void deletePurchase(Purchase purchase) {
		purchaseRepository.delete(purchase);
	}

	public List<Purchase> getAllPurchases() {
		return purchaseRepository.findAll();
	}

	public Optional<Purchase> getPurchasesById(Integer id) {
		return purchaseRepository.findById(id);
	}

	public List<Purchase> saveAll(List<Purchase> purchases) {
		return purchaseRepository.saveAll(purchases);
	}

	public List<Purchase> getAllPurchaseOfInvoiceId(Integer id) {
		return purchaseRepository.getPuchasesByInvoiceId(id);
	}
}
