package co.pooh.app.emp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeesVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private int salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
