package co.pooh.app.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.pooh.app.dept.domain.DeptVO;
import co.pooh.app.dept.service.DeptService;

@Controller
@RequestMapping("/dept/*")
public class DeptController {
	
	@Autowired DeptService deptService;
	
	@GetMapping
	public void list() {
	}
	
	@GetMapping("deptList")
	@ResponseBody
	public List<DeptVO> deptList() {
		return deptService.getList();
	}
	
	@PostMapping("insert")
	@ResponseBody
	public DeptVO insert(@RequestBody DeptVO vo) {
		deptService.insert(vo);
		
		return deptService.read(vo);
	}
	
	@DeleteMapping("delete/{departmentId}")
	@ResponseBody
	public int delete(@PathVariable int departmentId) {
		DeptVO vo = new DeptVO();
		vo.setDepartmentId(departmentId);
		return deptService.delete(vo);

	}
}
