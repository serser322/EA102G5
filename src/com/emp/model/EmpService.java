package com.emp.model;

import java.util.List;

public class EmpService {
	private EmpDAO_I daoI;
	
	public EmpService() {
		daoI = new EmpDAO();
	}
	
	public EmpVO addEmp(String empName,  String empPhone, String empEmail) {
		EmpVO empVO = new EmpVO();
		
		empVO.setEmpName(empName);
//		empVO.setEmpPsd(empPsd);
		empVO.setEmpEmail(empPhone);
		empVO.setEmpPsd(empEmail);
		daoI.insert(empVO);
		
		return empVO;		
	}
	
	public EmpVO updateEmp(String empName,  String empPhone, String empEmail) {
		EmpVO empVO = new EmpVO();
		
		empVO.setEmpName(empName);
//		empVO.setEmpPsd(empPsd);
		empVO.setEmpEmail(empPhone);
		empVO.setEmpPsd(empEmail);
		daoI.update(empVO);
		
		return empVO;
	}
	
	public void deleteEmp(String empNo) {
		daoI.delete(empNo);
	}
	
	public EmpVO getOndEmp(String empNo) {
		return daoI.getOne(empNo);
	}
	
	public List<EmpVO> getAll() {
		return daoI.getAll();
	}
	

}
