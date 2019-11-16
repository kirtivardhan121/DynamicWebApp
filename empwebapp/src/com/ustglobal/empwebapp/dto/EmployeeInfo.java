package com.ustglobal.empwebapp.dto;

import lombok.Data;

@Data 				//it adds all the overridden methods to the class

public class EmployeeInfo {
	
	private int id;
	private String name;
	private String email;
	private String password;
	
	
	
}//end of EmployeeInfo
