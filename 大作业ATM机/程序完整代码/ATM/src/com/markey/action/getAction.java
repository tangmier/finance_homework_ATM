package com.markey.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts2.ServletActionContext;

import com.markey.service.cardService;
import com.opensymphony.xwork2.ActionContext;

public class getAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	private int number;	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	


	public String getMoney(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		String cardID=(String)session.getAttribute("cardID");	
		Map request = (Map) ActionContext.getContext().get("request");
		cardService cardservice=new cardService();
		if(cardservice.ifEnough(cardID, number)){			
			cardservice.getNumber(cardID,number);			
			request.put("number", number);
			request.put("result", cardservice.checkNumber(cardID));
			System.out.println(number);
			return "success";
		}
		else{
			request.put("result", cardservice.checkNumber(cardID));
			return "noEnough";
		}
		
	}
}