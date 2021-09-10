package co.pooh.app.emp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pooh.app.emp.domain.EmpVO;
import co.pooh.app.emp.mapper.EmpMapper;
import co.pooh.app.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired EmpMapper empMapper;
	
	@Override
	public List<EmpVO> getList() {
		// TODO Auto-generated method stub
		return empMapper.getList();
	}

	@Override
	public EmpVO read(EmpVO vo) {
		// TODO Auto-generated method stub
		return empMapper.read(vo);
	}

	@Override
	public int insert(EmpVO vo) {
		// TODO Auto-generated method stub
		return empMapper.insert(vo);
	}

	@Override
	public int update(EmpVO vo) {
		// TODO Auto-generated method stub
		return empMapper.update(vo);
	}

	@Override
	public int delete(EmpVO vo) {
		// TODO Auto-generated method stub
		return empMapper.delete(vo);
	}

}
