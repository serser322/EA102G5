package com.emp.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.func.model.FuncVO;

public class EmpDAO implements EmpDAO_I{
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "EA102G5";
	String userpsd = "EA102G5";
	
	@Override
	public void insert(EmpVO empVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url , userid , userpsd);
			pstmt = conn.prepareStatement(
						"insert into emp (emp_no, emp_name, emp_psd, emp_phone, emp_email)"
					  + "values(('e' || lpad(seq_emp_no.nextval, 3 ,'0')),? ,? ,? ,?)"
					  );
			pstmt.setString(1, empVO.getEmpName());
			pstmt.setString(2, empVO.getEmpPsd());
			pstmt.setString(3, empVO.getEmpPhone());
			pstmt.setString(4, empVO.getEmpEmail());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("�L�k���J��Ʈw�X�� "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("��Ʈw�o�Ϳ��~ "
					+ se.getMessage());	
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(EmpVO empVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url , userid , userpsd);
			pstmt = conn.prepareStatement(
						"update emp set emp_name=?, emp_psd=?, emp_phone=?, emp_email=? where emp_no =?"
					  );
			pstmt.setString(1, empVO.getEmpName());
			pstmt.setString(2, empVO.getEmpPsd());
			pstmt.setString(3, empVO.getEmpPhone());
			pstmt.setString(4, empVO.getEmpEmail());
			
			pstmt.setString(5, empVO.getEmpNo());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("�L�k���J��Ʈw�X�� "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("��Ʈw�o�Ϳ��~ "
					+ se.getMessage());	
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void delete(String empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url , userid , userpsd);
			pstmt = conn.prepareStatement(
						"delete from emp where emp_no=?"
					  );
			pstmt.setString(1, empNo);
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("�L�k���J��Ʈw�X�� "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("��Ʈw�o�Ϳ��~ "
					+ se.getMessage());	
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	@Override
	public EmpVO getOne(String empNo) {
		EmpVO empVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpsd);
			pstmt = conn.prepareStatement(
					"select emp_no, emp_name, emp_phone, emp_email from emp where emp_no=?"
					);

			pstmt.setString(1, empNo);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				empVO = new EmpVO();
			
				empVO.setEmpNo(rs.getString("emp_no"));
				empVO.setEmpName(rs.getString("emp_name"));
//				empVO.setEmpPsd(rs.getString("emp_psd"));
				empVO.setEmpPhone(rs.getString("emp_phone"));
				empVO.setEmpEmail(rs.getString("emp_email"));
				
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("�L�k���J��Ʈw�X�� "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("��Ʈw�o�Ϳ��~ "
					+ se.getMessage());		
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url , userid , userpsd);
			pstmt = conn.prepareStatement(
						"select emp_no, emp_name, emp_phone, emp_email from emp"
					  );
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				empVO = new EmpVO();
				empVO.setEmpNo(rs.getString("emp_no"));
				empVO.setEmpName(rs.getString("emp_name"));
//				empVO.setEmpPsd(rs.getString("emp_psd"));
				empVO.setEmpPhone(rs.getString("emp_phone"));
				empVO.setEmpEmail(rs.getString("emp_email"));
				list.add(empVO);
				
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("�L�k���J��Ʈw�X�� "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("��Ʈw�o�Ϳ��~ "
					+ se.getMessage());	
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	
//	public static void main(String[] args) {
//		
//			EmpDAO dao = new EmpDAO();
//			
//			//�s�W����
//			EmpVO empVO1 = new EmpVO();
//			
//			empVO1.setEmpName("�����}");
//			empVO1.setEmpPsd("456789");
//			empVO1.setEmpPhone("0938110222");
//			empVO1.setEmpEmail("Akane_Mochida@gmail.com");
//			dao.insert(empVO1);
			
//			//�ק����
//			EmpVO empVO2 = new EmpVO();
//			empVO2.setEmpNo("e013");
//			empVO2.setEmpName("�����}");
//			empVO2.setEmpPsd("456789");
//			empVO2.setEmpPhone("0938110444");
//			empVO2.setEmpEmail("Akane_Mochida@gmail.com");
//			dao.update(empVO2);
			
//			//�R������
//			dao.delete("e013");
					
//			//�d�߳浧		
//			EmpVO empVO3 = dao.getOne("e001");
//			
//			System.out.println(empVO3.getEmpNo());
//			System.out.println(empVO3.getEmpName());
//			System.out.println(empVO3.getEmpPsd());
//			System.out.println(empVO3.getEmpPhone());
//			System.out.println(empVO3.getEmpEmail());
			
		
//			//�d�ߥ���
//			List<EmpVO> list = dao.getAll();
//			for(EmpVO emp : list) {
//				System.out.println(emp.getEmpNo());
//				System.out.println(emp.getEmpName());
//				System.out.println(emp.getEmpPsd());
//				System.out.println(emp.getEmpPhone());
//				System.out.println(emp.getEmpEmail());
//			}	
//	}
//	
//		
	
}
