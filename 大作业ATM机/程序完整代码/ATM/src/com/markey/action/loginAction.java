package com.markey.action;

import org.apache.struts.action.Action;

import com.markey.service.cardService;
import com.opensymphony.xwork2.ActionContext;


public class loginAction extends Action {
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
	private String cardID;
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	private String passWord;
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
	public String login(){
		//将cardID和passWord放入session
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("cardID",cardID);
		ac.getSession().put("passWord",passWord);
		cardService cardservice=new cardService();
		if(cardservice.checkCardID(cardID, passWord)){
			System.out.println(passWord+cardID);
			return "success";			
		}
		else{
			System.out.println(passWord);
			return "error";
		}
			
		
	}
}