package co.pooh.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pooh.app.board.mapper.BoardMapper;
import co.pooh.app.board.service.BoardService;
import co.pooh.app.board.vo.BoardVO;
import co.pooh.app.board.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	@Override
	public int insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.update(vo);
	}

	@Override
	public int delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.delete(vo);
	}

	@Override
	public BoardVO read(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.read(vo);
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		// TODO Auto-generated method stub
		return boardMapper.getList(criteria);
	}
	
	//데이터 건수 조회
	public int getTotalCount(Criteria criteria) {
		
		return boardMapper.getTotalCount(criteria);
	}

}
