package co.pooh.app.dept.service;

import java.util.List;

import co.pooh.app.dept.domain.DeptVO;

public interface DeptService {
	public List<DeptVO> getList();
	
	public DeptVO read(DeptVO vo);
	
	public int insert(DeptVO vo);
	
	public int update(DeptVO vo);
	
	public int delete(DeptVO vo);
}
