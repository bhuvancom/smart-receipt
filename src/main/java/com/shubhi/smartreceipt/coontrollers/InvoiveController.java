package com.shubhi.smartreceipt.coontrollers;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shubhi.smartreceipt.mail.MailHelper;
import com.shubhi.smartreceipt.model.Invoice;
import com.shubhi.smartreceipt.model.Product;
import com.shubhi.smartreceipt.model.Purchase;
import com.shubhi.smartreceipt.model.User;
import com.shubhi.smartreceipt.service.InvoiceService;
import com.shubhi.smartreceipt.service.ProductService;
import com.shubhi.smartreceipt.service.PurchaseService;
import com.shubhi.smartreceipt.service.UserService;

@Controller
public class InvoiveController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private PurchaseService purchaseService;

	public static final Log LOGGER = LogFactory.getLog(InvoiveController.class);

	@GetMapping("/invoice/{id}")
	public String getInvoice(Model model, @PathVariable Integer id) {
		model.addAttribute("invoice", invoiceService.getInvoice(id));

		List<Product> allProducts = productService.getAllProducts();
		List<Purchase> allPurchaseOfInvoiceId = purchaseService.getAllPurchaseOfInvoiceId(id);

		allPurchaseOfInvoiceId.forEach(purchase -> {
			allProducts.remove(purchase.getProduct());
		});

		model.addAttribute("products", allProducts);
		model.addAttribute("purchases", purchaseService.getAllPurchaseOfInvoiceId(id));

		CommonUtil.setModel(model);

		return "editInvoice";
	}

	@RequestMapping(path = "/invoice/save", method = RequestMethod.POST)
	public String saveInvoice(Model model, @ModelAttribute("invoiceForm") Invoice invoice) {
		// System.out.println("got invoice " + invoice);
		invoice.setPurchasedOn(new Date());
		Invoice newInvoice = invoiceService.save(invoice);
		model.addAttribute("messsage", "Invoice saved");
		return "redirect:/invoice/" + newInvoice.getInvoiceId().intValue();
	}

	@GetMapping("/invoice/send/{id}")
	public String sendInvoice(Model model, @PathVariable Integer id) {
		User user = invoiceService.getInvoice(id).getUser();
		try {
			MailHelper mail = new MailHelper();
			mail.sendMail(user.getEmail(), "The Invoice details");
		} catch (Exception e) {

		}
		return "redirect:/invoice/" + id;
	}

}
