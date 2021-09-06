package co.pooh.app.emp.mapper;

import java.util.List;

import co.pooh.app.emp.domain.EmpCriteria;
import co.pooh.app.emp.domain.EmployeesVO;

public interface EmployeesMapper {
	List<EmployeesVO> getList();
	
	List<EmployeesVO> getListWithPaging(EmpCriteria cri);
	
	EmployeesVO read(EmployeesVO vo);
	
	int insert(EmployeesVO vo);
	
	int update(EmployeesVO vo);
	
	int delete(EmployeesVO vo);
}
