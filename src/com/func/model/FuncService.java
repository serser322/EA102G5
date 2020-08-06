package com.func.model;

import java.util.List;

public class FuncService {
	private FuncDAO_I daoI;
	
	public FuncService() {
		daoI = new FuncDAO();
	}
	
	public FuncVO addFunc(String funcName, String funcDesc) {
		FuncVO funcVO = new FuncVO();
		
		funcVO.setFuncName(funcName);
		funcVO.setFuncDesc(funcDesc);
		daoI.insert(funcVO);
		
		return funcVO;
	}
	
	
	public FuncVO updateFunc(String funcName, String funcDesc) {
		FuncVO funcVO = new FuncVO();
		
		funcVO.setFuncName(funcName);
		funcVO.setFuncDesc(funcDesc);
		daoI.update(funcVO);
		
		return funcVO;
	}
	
	
	public void deleteFunc(String funcNo) {
		daoI.delete(funcNo);
	}
	
	
	public FuncVO getOneFunc(String funcNo) {
		return daoI.getOne(funcNo);
	}
	
	
	public List<FuncVO> getAll() {
		return daoI.getAll();
	}

}
