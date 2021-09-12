package co.pooh.app.dept.domain;

import lombok.Data;

@Data
public class DeptVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
