package com.study.emp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.emp.dao.EmpMapper;

/**
 * ⑧ Service : 업무 로직을 처리하고 DB 조회는 Mapper에 맡김
 */
@Service
public class EmpService {

	@Autowired
	private EmpMapper empMapper;

	public List<Map<String, Object>> searchEmp(Map<String, Object> search) {
		return empMapper.selectEmpList(search);   // ⑨ SQL 실행 (emp_mapper.xml 의 selectEmpList)
	}
}
