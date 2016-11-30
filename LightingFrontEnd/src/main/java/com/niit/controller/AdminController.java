package com.niit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class AdminController {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;	
	
    @Autowired
    Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/manageproduct")
	public ModelAndView products(@ModelAttribute("prod") Product p1, BindingResult result){
		//Category category = new Category();
		ModelAndView mv=new ModelAndView("/product");
		mv.addObject("product",product);
		mv.addObject("productList",productDAO.list());
		mv.addObject("categoryList",categoryDAO.list());
		mv.addObject("supplierList",supplierDAO.list());
		return mv;
	}
	
	@RequestMapping("/managecategory")
	public ModelAndView categories(){
		//Category category = new Category();
		ModelAndView mv=new ModelAndView("/category");
		mv.addObject("category",category);
		mv.addObject("categoryList",categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/managesupplier")
		public ModelAndView suppliers(@ModelAttribute("supplier") Supplier supplier,BindingResult result,HttpServletRequest request,Model model)throws JsonGenerationException, JsonMappingException, IOException {
			//log.debug("Starting");
			List<Supplier> list = supplierDAO.list();
			System.out.println("supplier list=" + list);
			ObjectMapper om = new ObjectMapper();
			String listjson = om.writeValueAsString(list);
			System.out.println(listjson);
			
		model.addAttribute("Supplier", new Supplier());
		model.addAttribute("supplierList","this.supplierDAO.list()");
		//log.debug("Ending");
		return new ModelAndView("supplier", "listofitem", listjson);
		}
		String setName;
		List<Supplier> slist;

		@SuppressWarnings("unchecked")
		@RequestMapping("/GsonCon")
		public @ResponseBody String getValues() throws Exception {
			String result = "";
			slist = supplierDAO.list();
			Gson gson = new Gson();
			result = gson.toJson(slist);
			return result;

		}		

	
	
}