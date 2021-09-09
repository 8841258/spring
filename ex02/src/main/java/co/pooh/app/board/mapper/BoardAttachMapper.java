package co.pooh.app.board.mapper;

import java.util.List;

import co.pooh.app.board.vo.BoardAttachVO;

public interface BoardAttachMapper {
	public int insert(BoardAttachVO vo);
	
	public int delete(String uuid);
	
	public List<BoardAttachVO> findByBno(long bno);
	
	public BoardAttachVO read(String uuid);
	
	public int deleteAll(long bno);
	
	public List<BoardAttachVO> getOldFiles();
}
