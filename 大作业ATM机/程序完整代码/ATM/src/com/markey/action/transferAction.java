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
	//����ת��
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
	//����ת��
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
			case 0:request.put("bank","�й�����" );
			break;
			case 1:request.put("bank","��������" );
			break;
			case 2:request.put("bank","��������" );
			break;
			case 3:request.put("bank","������������");
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