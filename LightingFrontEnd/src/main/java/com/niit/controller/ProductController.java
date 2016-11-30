package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	Supplier supplier;

	@Autowired
	Category category;

	@Autowired
	Product product;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/product") // , method=RequestMethod.POST)
	public ModelAndView showAddProduct(@Valid @ModelAttribute("prod") Product p1, BindingResult result,
			HttpServletRequest request, HttpSession session) throws IOException {
		
		
		// session.setAttribute("supplier",supplier);
		session.setAttribute("supplierList", supplierDAO.list());

		session.setAttribute("productList", productDAO.list());

		// session.setAttribute("category",category);
		session.setAttribute("categoryList", categoryDAO.list());
		System.out.println("In add product page");
		return new ModelAndView("product");

	}

	@RequestMapping("/registerP")
	public String createProduct(@Valid @ModelAttribute("prod") Product p2,BindingResult result, @RequestParam("image") MultipartFile file,
			@RequestParam("img") MultipartFile file1, Model model, HttpSession session) throws IOException {
		// productDAO.saveOrUpdate(p2);
		
		if (result.hasErrors()) {
			return "product";
		}
		

		System.out.println("image");
		MultipartFile image = p2.getImage();
		Path path;
		path = Paths.get(
				"F://Separate//LightingFrontEnd//src//main//webapp//resources//images//" + p2.getPro_Id() + ".jpg");
		System.out.println("Path = " + path);
		System.out.println("File name = " + p2.getImage().getOriginalFilename());

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("First Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("First Image not saved");
			}
		}

		System.out.println("second image");
		MultipartFile img = p2.getImg();
		Path path1;
		path1 = Paths.get(
				"F://Separate//LightingFrontEnd//src//main//webapp//resources//images//" + p2.getProd_ID() + ".jpg");

		if (img != null && !img.isEmpty()) {
			try {
				img.transferTo(new File(path1.toString()));
				System.out.println("Second Image Saved in:" + path1.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Second Image not saved");
			}
		}
		 Supplier supplier = supplierDAO.getName(p2.getSupplier().getSup_name());
		supplierDAO.saveOrUpdate(supplier);

		 Category category = categoryDAO.getName(p2.getCategory().getCat_name());
		categoryDAO.saveOrUpdate(category);

		p2.setCategory(category);
		p2.setSupplier(supplier);
		// product.setSupplier((Set<Supplier>) supplier);
		System.out.println("set");
		
		p2.setCat_id(category.getCat_id());
		p2.setSup_id(supplier.getSup_id());		
		
		productDAO.saveOrUpdate(p2);
		System.out.println("product added");

		model.addAttribute("message", "Products added successfully");
		model.addAttribute("productList", productDAO.list());
		
		System.out.println("price should be min 10");
		return "product";
	}

	@RequestMapping("product/remove/{id}")
	public ModelAndView deleteProduct(@ModelAttribute("prod") Product p4,@PathVariable("id") String id,Model model) throws Exception {
		
		p4 = productDAO.get(id);
		ModelAndView mv = new ModelAndView("product");
		if (p4 == null) {
			mv.addObject("errorMessage", "Could not delete");
		} else {
			productDAO.delete(p4);
		}
		model.addAttribute("productList",productDAO.list());
		return mv;
	}
	
	@RequestMapping("product/edit/{id}") // @ModelAttribute("category"),Category
	// category
	public String editCategory(@ModelAttribute("id") Product p5, BindingResult result,
			HttpServletRequest request, Model model) {
		System.out.println("in product editpage ");
		
		p5 = productDAO.get(product.getPro_Id());
		System.out.println(product.getPro_Id());
		if (category != null) {
			productDAO.saveOrUpdate(p5);
			model.addAttribute("message", "Successfully updated");
		} else {
			model.addAttribute("errorMessage", "Could not be updated");
		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		return "redirect:/product";
	}

}
