package co.pooh.app.board.vo;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum = 1;
	private int amount = 5;
	private String type;
	private String keyword;
	
	public Criteria() {}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type==null ? new String[] {} : type.split("");
	}
}
