package co.pooh.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pooh.app.board.service.EmployeesService;
import co.pooh.app.emp.domain.EmpCriteria;
import co.pooh.app.emp.domain.EmployeesVO;
import co.pooh.app.emp.mapper.EmployeesMapper;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired EmployeesMapper mapper;
	
	@Override
	public List<EmployeesVO> getList(EmpCriteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}

	@Override
	public EmployeesVO read(EmployeesVO vo) {
		// TODO Auto-generated method stub
		return mapper.read(vo);
	}

	@Override
	public int insert(EmployeesVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo);
	}

	@Override
	public int update(EmployeesVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(EmployeesVO vo) {
		// TODO Auto-generated method stub
		return mapper.delete(vo);
	}

}
