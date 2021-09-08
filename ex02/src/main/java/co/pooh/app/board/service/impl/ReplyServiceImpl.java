package co.pooh.app.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pooh.app.board.mapper.BoardMapper;
import co.pooh.app.board.mapper.ReplyMapper;
import co.pooh.app.board.service.ReplyService;
import co.pooh.app.board.vo.Criteria;
import co.pooh.app.board.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired ReplyMapper mapper;
	@Autowired BoardMapper boardMapper;

	@Override
	public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") Long bno) {
		// TODO Auto-generated method stub
		return mapper.getList(cri, bno);
	}

	@Override
	public ReplyVO read(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.read(vo);
	}

	@Override
	public int insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		boardMapper.updateReplycnt(vo.getBno(), 1L);
		return mapper.insert(vo);
	}

	@Override
	public int update(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(ReplyVO vo) {
		// TODO Auto-generated method stub
		boardMapper.updateReplycnt(vo.getBno(), -1L);
		return mapper.delete(vo);
	}

	@Override
	public int getCountByBno(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.getCountByBno(vo);
	}

}
