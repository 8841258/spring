package co.pooh.app.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.pooh.app.board.vo.Criteria;
import co.pooh.app.board.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	public ReplyVO read(ReplyVO vo);
	
	public int insert(ReplyVO vo);
	
	public int update(ReplyVO vo);
	
	public int delete(ReplyVO vo);
	
	int getCountByBno(ReplyVO vo);
}
