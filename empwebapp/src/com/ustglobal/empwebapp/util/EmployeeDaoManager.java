package com.ustglobal.empwebapp.util;

import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dao.EmployeeDAOJdbcImpl;

public class EmployeeDaoManager {

	
	private EmployeeDaoManager() {}
	
	public static EmployeeDAO getEmployeeDAO() {
		
		return new EmployeeDAOJdbcImpl();
		
	}

}//end of EmployeeDaoManager
