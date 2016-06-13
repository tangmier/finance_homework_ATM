package com.markey.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts2.ServletActionContext;

import com.markey.service.cardService;
import com.opensymphony.xwork2.ActionContext;

public class transferAction extends Action {
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
	private String otherCardID;
	private int bank;
	
	public int getBank() {
		return bank;
	}
	public void setBank(int bank) {
		this.bank = bank;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setOtherCardID(String otherCardID) {
		this.otherCardID = otherCardID;
	}
	public String getOtherCardID() {
		return otherCardID;
	}
	//行内转账
	public String hnTransfer(){
		HttpSession session=ServletActionContext.getRequest().getSession();		
		String cardID=(String)session.getAttribute("cardID");	
		Map request = (Map) ActionContext.getContext().get("request");
		cardService cardservice=new cardService();
		if(cardservice.ifEnough(cardID, number)){
			cardservice.getNumber(cardID, number);
			cardservice.putNumber("hnxscard", otherCardID, number);		
			request.put("number", number);
			request.put("otherCardID", otherCardID);
			request.put("bank","" );
			return "success";
		}
		else{
			request.put("result", cardservice.checkNumber(cardID));
			return "noEnough";
		}
	}
	//跨行转账
	public String khTransfer(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String cardID=(String)session.getAttribute("cardID");	
		Map request = (Map) ActionContext.getContext().get("request");
		cardService cardservice=new cardService();
		if(cardservice.ifEnough(cardID, number)){
			cardservice.getNumber(cardID, number);
			switch(bank){
			case 0:cardservice.putNumber("boccard", otherCardID, number);
			break;
			case 1:cardservice.putNumber("icbccard", otherCardID, number);
			break;
			case 2:cardservice.putNumber("ccbcard", otherCardID, number);
			break;
			case 3:cardservice.putNumber("psbccard", otherCardID, number);
			default: return "error";
			}
			request.put("number", number);
			request.put("otherCardID", otherCardID);
			switch(bank){
			case 0:request.put("bank","中国银行" );
			break;
			case 1:request.put("bank","工商银行" );
			break;
			case 2:request.put("bank","建设银行" );
			break;
			case 3:request.put("bank","邮政储蓄银行");
			default: return "error";
			}
			
			System.out.println(otherCardID);
			return "success";
		}
		else{
			request.put("result", cardservice.checkNumber(cardID));
			return "noEnough";
		}
	}



}