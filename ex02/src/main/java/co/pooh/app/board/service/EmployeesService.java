package co.pooh.app.board.service;

import java.util.List;

import co.pooh.app.emp.domain.EmpCriteria;
import co.pooh.app.emp.domain.EmployeesVO;

public interface EmployeesService {
	List<EmployeesVO> getList(EmpCriteria cri);
	
	EmployeesVO read(EmployeesVO vo);
	
	int insert(EmployeesVO vo);
	
	int update(EmployeesVO vo);
	
	int delete(EmployeesVO vo);

}
