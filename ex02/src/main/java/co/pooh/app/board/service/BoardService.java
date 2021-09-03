package co.pooh.app.board.service;

import java.util.List;

import co.pooh.app.board.vo.BoardVO;

public interface BoardService {
	//CRUD
	
	//등록
	public int insert(BoardVO vo);
	
	//수정
	public int update(BoardVO vo);
	
	//삭제
	public int delete(BoardVO vo);
	
	//단건조회
	public BoardVO read(BoardVO vo);
	
	//전체조회
	public List<BoardVO> getList();
}
