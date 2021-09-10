package co.pooh.app.emp.mapper;

import java.util.List;

import co.pooh.app.emp.domain.EmpVO;

public interface EmpMapper {
	public List<EmpVO> getList();
	
	public EmpVO read(EmpVO vo);
	
	public int insert(EmpVO vo);
	
	public int update(EmpVO vo);
	
	public int delete(EmpVO vo);
}
