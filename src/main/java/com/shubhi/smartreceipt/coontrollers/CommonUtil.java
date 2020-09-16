package com.shubhi.smartreceipt.coontrollers;

import org.springframework.ui.Model;

import com.shubhi.smartreceipt.model.Invoice;
import com.shubhi.smartreceipt.model.Product;
import com.shubhi.smartreceipt.model.Purchase;
import com.shubhi.smartreceipt.model.User;

public class CommonUtil {

	public static void setModel(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("invoiceForm", new Invoice());
		model.addAttribute("productForm", new Product());
		model.addAttribute("purchaseForm", new Purchase());
	}

}
