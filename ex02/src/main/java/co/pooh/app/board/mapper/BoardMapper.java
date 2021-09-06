package co.pooh.app.board.mapper;

import java.util.List;

import co.pooh.app.board.vo.BoardVO;
import co.pooh.app.board.vo.Criteria;

public interface BoardMapper {
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
	public List<BoardVO> getList(Criteria criteria);
	
	//데이터 건수 조회
	public int getTotalCount(Criteria criteria);
}
