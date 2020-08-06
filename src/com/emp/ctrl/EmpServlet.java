package com.emp.ctrl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;

//@WebServlet("/emp/emp.do")
public class EmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("add".equals(action)) {

			List<String> errMessages = new LinkedList<String>();
			req.setAttribute("errMessages", errMessages);

			try {
				String empName = req.getParameter("empName");

				if (empName == null || empName.trim().length() == 0) {
					errMessages.add("員工姓名不得空白");
				} else if (empName.trim().matches("^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$")) {
					errMessages.add("請輸入正確姓名格式");
				}

//			String empPsd = req.getParameter("empPsd").trim();
//			if(empPsd == null || empPsd.trim().length()==0) {
//				errMessages.add("請輸入密碼");
//			}

				String empPhone = req.getParameter("empPhone").trim();
				if (empPhone == null || empPhone.trim().length() == 0) {
					errMessages.add("請輸入電話");
				}

				String empEmail = req.getParameter("empEmail").trim();
				if (empEmail == null || empEmail.trim().length() == 0) {
					errMessages.add("請輸入信箱");
				}

				EmpVO empVO = new EmpVO();
				empVO.setEmpName(empName);
//			empVO.setEmpPsd(empPsd);
				empVO.setEmpPhone(empPhone);
				empVO.setEmpEmail(empEmail);

				if (!errMessages.isEmpty()) {
					req.setAttribute("empVO", empVO);
					RequestDispatcher rd = req.getRequestDispatcher("/emp/addEmp.jsp");
					rd.forward(req, res);
					return;
				}

				EmpService empSvc = new EmpService();
				empVO = empSvc.addEmp(empName, empPhone, empEmail);

			} catch (Exception e) {
				errMessages.add(e.getMessage());
				RequestDispatcher rd = req.getRequestDispatcher("/emp/addEmp.jsp");
				rd.forward(req, res);
			}

		}
		// 查詢單筆
		if ("getOne".equals(action)) {
			
			List<String> errMessages = new LinkedList<String>();
			req.setAttribute("errMessages", errMessages);
			
			try {				
				String empNo = req.getParameter("empNo");
				if( empNo==null || (empNo.trim().length() ==0)) {
					errMessages.add("請輸入員工編號");
				}
				if(!errMessages.isEmpty()) {
					RequestDispatcher rd =req.getRequestDispatcher("/emp/emp_test.jsp");
					rd.forward(req,res);
					return;
				}
				
				
				EmpService empSvc = new EmpService();
				EmpVO empVO = empSvc.getOndEmp(empNo);
						
				if(empVO == null) {
					errMessages.add("查無資料");
				}
				if(!errMessages.isEmpty()) {
					RequestDispatcher rd =req.getRequestDispatcher("/emp/emp_test.jsp");
					rd.forward(req,res);
					return;
				}

				req.setAttribute("empVO", empVO);

				RequestDispatcher rd = req.getRequestDispatcher("/emp/showOne.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				errMessages.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher rd =req.getRequestDispatcher("/emp/emp_test.jsp");
				rd.forward(req,res);
			}
		}
		
		//查詢全部
		

	}
}
