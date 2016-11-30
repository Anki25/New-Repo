package com.niit.controller;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Controller
public class CategoryController {

	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategories(@ModelAttribute("category") Category category,BindingResult result,HttpServletRequest request,Model model) {
		log.debug("Starting");
		model.addAttribute("categoryList", "this.categoryDAO.list()");
		log.debug("Ending");
		return "redirect:/managecategory";
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category,Model model) {
		log.debug("Starting");
		ModelAndView mv = new ModelAndView("/category");
		if (categoryDAO.get(category.getCat_id()) == null) {
			categoryDAO.saveOrUpdate(category);
		} else {
			mv.addObject("errorMessage", "The record exist with this id" + category.getCat_id());
		}
		log.debug("Ending");
		model.addAttribute("categoryList", categoryDAO.list());
		return "/category";
	}

	@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id,@ModelAttribute("category") Category category,BindingResult result, Model model) throws Exception {
		log.debug("Starting");
		category = categoryDAO.get(id);
		ModelAndView mv = new ModelAndView("/category");
		if (category == null) {
			mv.addObject("errorMessage", "Could not delete");
		} else {
			categoryDAO.delete(category);
		}
        model.addAttribute("categoryList",categoryDAO.list());
		return mv;
	}

	@RequestMapping("category/edit/{id}")
	public String editCategory(@PathVariable("id") String id, @ModelAttribute("category") Category c,BindingResult result,Model model) {
				log.debug("Starting");
				c = categoryDAO.get(id);
				model.addAttribute("categoryList",categoryDAO.list());
				model.addAttribute("cat",c);
				
		if (c.getCat_id() != null) {
			categoryDAO.saveOrUpdate(c);
			System.out.println("edited");
			model.addAttribute("message","Succesfully updated");
		} else {
			model.addAttribute("errorMessage", "Could not be updated");
		}
		log.debug("Ending");
		return "category";
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Model model){
		ModelAndView mv=new ModelAndView("form");
		model.addAttribute("Category", new Category());
		model.addAttribute("categoryList", "this.categoryDAO.list()");
		
		return mv;
	}

	@RequestMapping("/newcategory/add")
	public String editNewCategory(@PathVariable("id") String id, Model model) {
				log.debug("Starting");
				category = categoryDAO.get(id);
				model.addAttribute("categoryList",categoryDAO.list());
				model.addAttribute("cat",category);
				
		if (category != null) {
			//categoryDAO.saveOrUpdate(category);
			model.addAttribute("message","Succesfully updated");
		} else {
			model.addAttribute("errorMessage", "Could not be updated");
		}
		log.debug("Ending");
		return "category";
	}


	
}