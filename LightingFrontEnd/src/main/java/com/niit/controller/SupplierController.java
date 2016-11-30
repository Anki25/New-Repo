package com.niit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	/*@Autowired
	private Supplier supplier;
	*/
	@RequestMapping(value="/supplier" ,method=RequestMethod.GET)
	public String listCategories(@ModelAttribute("supplier") Supplier supplier,BindingResult result,HttpServletRequest request,Model model){
		//log.debug("Starting");
	model.addAttribute("Supplier", new Supplier());
	model.addAttribute("supplierList","this.supplierDAO.list()");
	//log.debug("Ending");
	return "supplier";
	}	
	
	
	
	
	@RequestMapping(value="/supplier/add",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier")Supplier supplier,Model model){
		//log.debug("Starting");
		ModelAndView mv = new ModelAndView("/supplier");
		if(supplierDAO.get(supplier.getSup_id())==null)
		{
			supplierDAO.saveOrUpdate(supplier);
		}
		else
		{
			mv.addObject("errorMessage","The record exist with this id" + supplier.getSup_id());
		}
	//log.debug("Ending");
		model.addAttribute("supplierList",supplierDAO.list());
	return "/supplier";
}
	
	
	@RequestMapping("supplier/delete/{id}")
	public ModelAndView deleteSupplier(@ModelAttribute("supplier") Supplier supplier,@PathVariable("id") String id, Model model) throws Exception {
		log.debug("Starting");
		supplier = supplierDAO.get(id);
		ModelAndView mv = new ModelAndView("supplier");
		if (supplier == null) {
			mv.addObject("errorMessage", "Could not delete");
		} else {
			supplierDAO.delete(supplier);
		}
		model.addAttribute("supplierList",supplierDAO.list());
		System.out.println("deleted");
		return mv;
	}

	
	@RequestMapping("supplier/edit/{id}")
	public String editSupplier(@PathVariable("id")String id,@ModelAttribute("supplier")Supplier supplier,BindingResult result,HttpServletRequest request,Model model){  //model because we want to retrieve whole object to edit anything we want
		
		//log.debug("Starting");
		if(supplierDAO.get(id)!=null)
		{
			model.addAttribute("message","Succesfully updated");
		}
		else
		{
			model.addAttribute("errorMessage","Could not be updated");
		}
		System.out.println("in edit supplier page");
		model.addAttribute("supplierList",supplierDAO.list());
		//log.debug("Ending");
		return "supplier";
	}
	
	
}