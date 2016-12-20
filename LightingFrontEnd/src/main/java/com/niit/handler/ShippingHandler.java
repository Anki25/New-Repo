package com.niit.handler;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.model.ShippingAddress;


@Component
public class ShippingHandler {

	public ShippingAddress initFlow(){
		return new ShippingAddress();
	}
	


	public String validateDetails(ShippingAddress shippingAddress,MessageContext messageContext){
		String status = "success";
		if(shippingAddress.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"name").defaultText("shippingAddress cannot be Empty").build());
			status = "failure";
			System.out.println("shippingAddress fail");
		}
		if(shippingAddress.getCity().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"id").defaultText("city cannot be Empty").build());
			status = "failure";
			System.out.println("city fail");
		}
		if(shippingAddress.getPincode().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Pincode cannot be Empty").build());
			status = "failure";
			System.out.println("pincode fail");
		}
				
		return status;
	}
}