package com.shubhi.smartreceipt.coontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shubhi.smartreceipt.service.InvoiceService;
import com.shubhi.smartreceipt.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/")
	public String home(Model model) {
		CommonUtil.setModel(model);
		model.addAttribute("users", userService.getAllUser());
		model.addAttribute("invoices", invoiceService.getAllInvoices());
		return "index";
	}
}
