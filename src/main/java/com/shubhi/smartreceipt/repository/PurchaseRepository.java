package com.shubhi.smartreceipt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shubhi.smartreceipt.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	@Query("from purchase where invoice_id = ?1")
	List<Purchase> getPuchasesByInvoiceId(Integer id);
}
