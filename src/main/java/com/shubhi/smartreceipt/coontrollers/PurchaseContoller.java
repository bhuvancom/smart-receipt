package com.shubhi.smartreceipt.coontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shubhi.smartreceipt.model.Purchase;
import com.shubhi.smartreceipt.service.PurchaseService;

@Controller
public class PurchaseContoller {

	@Autowired
	private PurchaseService purchaseService;

	@RequestMapping(path = "/purchase/save", method = RequestMethod.POST)
	public String savePurchases(Model model, @ModelAttribute("purchaseForm") Purchase purchase) {
		purchaseService.save(purchase);
		model.addAttribute("message", "Product Added");
		return "redirect:/invoice/" + purchase.getInvoice().getInvoiceId();
	}

	@GetMapping("/purchase/delete/{id}-{invoice}")
	public String deletePurchase(Model model, @PathVariable Integer id, @PathVariable Integer invoice) {
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(id);
		purchaseService.deletePurchase(purchase);
		model.addAttribute("message", "Product Removed from Invoice");
		return "redirect:/invoice/" + invoice;
	}

}
