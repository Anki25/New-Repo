package com.niit.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
//import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
//import com.niit.model.Cart;
import com.niit.model.Product;
import com.niit.model.User;


//@controller is a predefined annotation which we need to specified for our class to be act like as controller 
@Controller
public class HomeController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
		
	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	@Autowired
	Category category;

	/* @Autowired
	CartDAO cartDAO;

*/	
	// request mapping is also predefined a annotation for map the address which
	// jsp page //u need to execute .
	// here in these example my home page should display as soon as I will run
	// my project
	// Without giving a extension of jsp page

	@RequestMapping("/")
	// user defined function which return a ModelAndViewobject .
	public ModelAndView LandingPage(HttpSession session) {
		System.out.println("In Home page");
		// creating a object for modelandview class and passing the parameter
		// for //jsppage .without extension of jsp page. It will execute your
		// main //page.
		session.setAttribute("categoryList", categoryDAO.list());
		return new ModelAndView("home");

	}
	
	@RequestMapping("/home")
	public ModelAndView homePage() {
		System.out.println("In home page");
        
		return new ModelAndView("home");

	}

	
	@RequestMapping("/adminhome")
	public ModelAndView adminPage() {
		System.out.println("In Admin page");

		return new ModelAndView("adminhome");

	}

	
		@RequestMapping("/home1")
	public ModelAndView showHome() {
		System.out.println("In home page");
		return new ModelAndView("home1");

	}

	@RequestMapping("/aboutus")
	public ModelAndView showAboutUs() {
		System.out.println("In About us page");
		return new ModelAndView("aboutus");

	}

	@RequestMapping("/contactus")
	public ModelAndView showContactUs() {
		System.out.println("In Contact us page");
		return new ModelAndView("contactus");

	}

	@RequestMapping("/privacynotice")
	public ModelAndView showPrivacy() {
		System.out.println("In Privacy Notice page");
		return new ModelAndView("privacynotice");

	}

	@RequestMapping("/conditionsofsale")
	public ModelAndView showCondition() {
		System.out.println("In Conditions of Sale page");
		return new ModelAndView("conditionsofsale");

	}

	@RequestMapping("/cancelpolicy")
	public ModelAndView showCancelPolicy() {
		System.out.println("In Cancel&Return Policy page");
		return new ModelAndView("cancelpolicy");

	}

	@RequestMapping("/images")
	public ModelAndView showImages(Model model) {
		System.out.println("In images home page");
		/*category=categoryDAO.get(cid);
		product=productDAO.getByCatId(cid);
		model.addAttribute("productList", product);
		*/ModelAndView mv= new ModelAndView("home");
		
		mv.addObject("signinmsg","please Sign In to continue...");
		return mv;

	}
	
	@RequestMapping("/productsuser")
	public ModelAndView viewItems(Model model){   
		ModelAndView mv=new ModelAndView("productsuser");
		model.addAttribute("productList", productDAO.list());
	return mv;
	
	}
	
	@RequestMapping("/viewProduct")
	public ModelAndView viewEachItem(@RequestParam("pro_Id") String id,Model model){
		System.out.println("viewing product");
		product = productDAO.get(id);
		model.addAttribute("productList", productDAO.list());
		return new ModelAndView("viewProduct", "product", product);
	
		}
		
		
		@RequestMapping("/denied")
	public ModelAndView showDenied() {
		System.out.println("In access denied page");
		return new ModelAndView("denied");

	}

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		System.out.println("In login page");
		return new ModelAndView("login");
	}
		
	
	
	
		@RequestMapping("/new")
		public ModelAndView newone() {
			System.out.println("In new page");
			return new ModelAndView("new");

		}

	}

	

 