package com.markey.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts2.ServletActionContext;

import com.markey.service.cardService;
import com.opensymphony.xwork2.ActionContext;

public class checkAction extends Action {
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
	public String check(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		String cardID=(String)session.getAttribute("cardID");
		//调用数据库操作 查询余额
		cardService cardservice=new cardService();
		
		int number=cardservice.checkNumber(cardID);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("number", number);
		System.out.println(number);
		return "success";
	}
}