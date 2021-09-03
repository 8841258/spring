package co.pooh.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pooh.app.board.mapper.BoardMapper;
import co.pooh.app.board.service.BoardService;
import co.pooh.app.board.vo.BoardVO;

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
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return boardMapper.getList();
	}

}
