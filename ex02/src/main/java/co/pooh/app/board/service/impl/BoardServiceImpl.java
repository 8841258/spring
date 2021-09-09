package co.pooh.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pooh.app.board.mapper.BoardAttachMapper;
import co.pooh.app.board.mapper.BoardMapper;
import co.pooh.app.board.service.BoardService;
import co.pooh.app.board.vo.BoardAttachVO;
import co.pooh.app.board.vo.BoardVO;
import co.pooh.app.board.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	@Autowired BoardAttachMapper attachMapper;
	
	@Override
	public int insert(BoardVO vo) {
		// TODO Auto-generated method stub
		boardMapper.insert(vo);
		
		if(vo.getAttachList() == null)
			return 1;
		for(BoardAttachVO attach : vo.getAttachList()) {
				attach.setBno(vo.getBno());
				attachMapper.insert(attach);
			}
			
		return 1;
		
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
		vo = boardMapper.read(vo);
		vo.setAttachList(attachMapper.findByBno(vo.getBno()));
		
		return vo;
		
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
