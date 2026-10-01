package com.study.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.emp.service.EmpService;

/**
 * ⑦ Controller : Submission의 action 주소(/emp/search)를 받는 곳
 */
@Controller
public class EmpController {

	@Autowired
	private EmpService empService;

	/**
	 * 요청 JSON  : {"dma_search": {"empNm": "홍"}}          ← Submission ref="data:json,dma_search"
	 * 응답 JSON  : {"dlt_emp": [ {...}, {...} ]}             → Submission target="data:json,dlt_emp"
	 */
	@RequestMapping("/emp/search")
	public @ResponseBody Map<String, Object> searchEmp(@RequestBody Map<String, Object> param) {
		Map<String, Object> search = (Map<String, Object>) param.get("dma_search");

		List<Map<String, Object>> list = empService.searchEmp(search);   // ⑧ Service 호출

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dlt_emp", list);   // ⑩ 이 key 이름이 화면의 DataList id(dlt_emp)와 같아야 함
		return result;
	}
}
