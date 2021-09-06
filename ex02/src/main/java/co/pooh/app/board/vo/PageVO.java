package co.pooh.app.board.vo;

import lombok.Data;

@Data
public class PageVO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;				//전체 레코드 건수
	private Criteria criteria;		//pageNum, amount

	
	public PageVO(Criteria criteria, int total) {
		super();
		this.criteria = criteria;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) (Math.ceil((total * 1.0) / criteria.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
