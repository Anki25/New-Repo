package com.niit.exception;

import java.io.IOException;
import java.sql.SQLException;
//import org.hibernate.hql.ast.QuerySyntaxException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CartExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CartExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request,Exception e){
		logger.error("SQLException Occured::URL= " + request.getRequestURL());
		logger.error("SQLException Occured::Exception= " + e.getMessage());
		ModelAndView mv=new ModelAndView("database_error");
		mv.addObject("error", e.getMessage());
		
		return mv;
	}

	/*@ExceptionHandler(QuerySyntaxException.class)
	public ModelAndView QuerySyntaxException(HttpServletRequest request,Exception e){
		logger.error("Query Syntax Exception Occured::URL= " + request.getRequestURL());
		logger.error("Query Syntax Exception Occured::Exception= " + e.getMessage());
		ModelAndView mv=new ModelAndView("database_error");
		mv.addObject("error", e.getMessage());
		
		return mv;
	}*/

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView NoHandlerFoundException(HttpServletRequest request,Exception e){
		logger.error("NoHandlerFound Exception Occured::URL= " + request.getRequestURL());
		logger.error("NoHandlerFound Exception Occured::Exception= " + e.getMessage());
		ModelAndView mav=new ModelAndView("error");
		mav.addObject("message", "No handler found...please contact administration");
		mav.addObject("exception",e);
		
		return mav;
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public ModelAndView IOException(HttpServletRequest request,Exception e){
		logger.error("IOException handler executed");
		logger.error("IOException Occured::Exception= " + e.getMessage());
		
		ModelAndView mav=new ModelAndView("/404");
		mav.addObject("message", "No handler found...please contact administration");
		mav.addObject("exception",e);
		
		return mav;
	}
}
