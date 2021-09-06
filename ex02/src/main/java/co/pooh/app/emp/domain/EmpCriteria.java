package co.pooh.app.emp.domain;

import lombok.Data;

@Data
public class EmpCriteria {
	private int pageNum = 1;
	private int amount = 5;
	
	public EmpCriteria() {}
	
	public EmpCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
