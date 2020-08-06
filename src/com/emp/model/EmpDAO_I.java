package com.emp.model;
import java.util.List;

public interface EmpDAO_I {
	public void insert(EmpVO empVO);
	public void update(EmpVO empVO);
	public void delete(String empNo);
	public EmpVO getOne(String empNo);
	public List<EmpVO> getAll();

}
