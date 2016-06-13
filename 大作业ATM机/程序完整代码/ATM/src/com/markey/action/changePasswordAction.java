package com.markey.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts2.ServletActionContext;

import com.markey.service.cardService;
import com.markey.util.sqlHelper;

public class changePasswordAction extends Action {
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
	//���ݿ��м�¼��ԭ����
	
	private String oldPassword;
	private String newPassword;
	private String newPassword1;
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}
	public String changePassword(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String cardID=(String)session.getAttribute("cardID");
		
		if(!newPassword.equals(newPassword1)){
			System.out.println("�������������벻һ��");
			return "error";
		}else{
			//�������ݿ���� ��ѯ������
			cardService cardservice=new cardService();
			if(!oldPassword.equals(cardservice.checkPassword(cardID))){
				System.out.println(oldPassword+"��������벻��"+cardservice.checkPassword(cardID));
				return "error";
			}
			else{
				cardservice.updatePassword(cardID, newPassword);
			    return "success";
			}
		}		
	}
}