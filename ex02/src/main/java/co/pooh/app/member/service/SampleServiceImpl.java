package co.pooh.app.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.pooh.app.sample.mapper.Sample1Mapper;
import co.pooh.app.sample.mapper.Sample2Mapper;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired Sample1Mapper sample1;
	@Autowired Sample2Mapper sample2;
	
//	@Transactional
	@Override
	public void addData(String value) {
		sample1.insert(value);
		sample2.insert(value);
		
	}

}
