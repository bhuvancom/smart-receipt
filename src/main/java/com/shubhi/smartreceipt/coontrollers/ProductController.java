package com.shubhi.smartreceipt.coontrollers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shubhi.smartreceipt.model.Product;
import com.shubhi.smartreceipt.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "product/save")
	public String saveProduct(@ModelAttribute("productForm") Product product, Model model) {

		productService.save(product);
		model.addAttribute("message", "Product Added");
		return "redirect:/products";
	}

	@GetMapping("/products")
	public String allProducts(Model model) {
		CommonUtil.setModel(model);
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(Model model, @PathVariable Integer id) throws SQLException {
		Product product = new Product();
		product.setProductId(id);
		productService.delete(product);
		return "redirect:/products";
	}
}
