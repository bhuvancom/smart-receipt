package com.shubhi.smartreceipt.coontrollers;

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

import com.shubhi.smartreceipt.model.User;
import com.shubhi.smartreceipt.service.InvoiceService;
import com.shubhi.smartreceipt.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private InvoiceService invoiceService;

	private static final Log LOGGER = LogFactory.getLog(UserController.class);

	@RequestMapping(path = "/user/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("userForm") User user, Model model) {
		LOGGER.debug("user " + user);
		userService.save(user);
		model.addAttribute("message", "User Added/Updated");
		return "redirect:/";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable Integer id, Model model) {
		invoiceService.deleteInvoiceOfUserId(id);
		userService.deleteUser(id);
		model.addAttribute("message", "User Deleted Along with user's invoices");
		return "redirect:/";
	}

	@GetMapping("user/{id}")
	public String getUser(@PathVariable Integer id, Model model) {
		CommonUtil.setModel(model);
		model.addAttribute("userForm", userService.getUserById(id));
		return "editUser";
	}
}
