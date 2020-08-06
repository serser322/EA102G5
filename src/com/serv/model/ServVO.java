package com.serv.model;
import java.io.Serializable;
import java.sql.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ServVO implements Serializable{
	private String servNo;
	private String empNo;
	private String orderNo;
	private String servCont;
	private Date servContTime;
	
	public void ServNo() {
		
	}
	
	public String getServNo() {
		return servNo;
	}
	public void setServNo(String servNo) {
		this.servNo = servNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getServCont() {
		return servCont;
	}
	public void setServCont(String servCont) {
		this.servCont = servCont;
	}
	public Date getServContTime() {
		return servContTime;
	}
	public void setServContTime(Date servContTime) {
		this.servContTime = servContTime;
	}
	

}
