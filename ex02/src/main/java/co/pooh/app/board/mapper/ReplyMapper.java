package co.pooh.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.pooh.app.board.vo.Criteria;
import co.pooh.app.board.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	ReplyVO read(ReplyVO vo);
	
	int insert(ReplyVO vo);
	
	int update(ReplyVO vo);
	
	int delete(ReplyVO vo);
	
	int getCountByBno(ReplyVO vo);
}
