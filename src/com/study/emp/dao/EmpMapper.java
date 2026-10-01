package com.study.emp.dao;

import java.util.List;
import java.util.Map;

/**
 * ⑨ Mapper 인터페이스 : 메서드 이름 = emp_mapper.xml 의 SQL id
 */
public interface EmpMapper {

	List<Map<String, Object>> selectEmpList(Map<String, Object> search);
}
