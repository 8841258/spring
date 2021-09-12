package co.pooh.app.dept.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.pooh.app.dept.domain.DeptVO;
import co.pooh.app.dept.mapper.DeptMapper;
import co.pooh.app.dept.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired DeptMapper mapper;
	
	@Override
	public List<DeptVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public DeptVO read(DeptVO vo) {
		// TODO Auto-generated method stub
		return mapper.read(vo);
	}

	@Override
	public int insert(DeptVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo);
	}

	@Override
	public int update(DeptVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(DeptVO vo) {
		// TODO Auto-generated method stub
		return mapper.delete(vo);
	}

}
