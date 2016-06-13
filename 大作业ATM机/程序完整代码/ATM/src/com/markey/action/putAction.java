package com.markey.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts2.ServletActionContext;

import com.markey.service.cardService;
import com.markey.util.sqlHelper;
import com.opensymphony.xwork2.ActionContext;

public class putAction extends Action {
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


	public String putMoney(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String cardID=(String)session.getAttribute("cardID");		
		cardService cardservice=new cardService();
		cardservice.putNumber("hnxscard",cardID, number);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("number", number);
		request.put("result", cardservice.checkNumber(cardID));
		System.out.println(number);
		return "success";
	}
}