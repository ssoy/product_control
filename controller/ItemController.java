package org.spring.item.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.item.dto.ItemDTO;
import org.spring.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private ItemService iservice;
	
	//등록폼으로
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String add() {
		return "add";
	}

	//추가
	//'application/json' 형식으로 데이터 받을때
	//데이터만 전송 : @ResponseBody=>반환값을 데이터 자체로 인식(text,json,xml)
	//@RequestBody : json데이터 바인딩
	@ResponseBody
	@RequestMapping(value="/", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
	public String add(@RequestBody ItemDTO idto) {
		logger.info(idto.toString());
		iservice.insert(idto);
		return "추가완료";
	}
	
	//application/x-www-form-urlencoded 로 데이터 받을때
//	@ResponseBody
//	@RequestMapping(value="/", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
//	public String add(ItemDTO idto) {
//		logger.info(idto.toString());
//		iservice.insert(idto);
//		return "추가완료";
//		
//	}
	
	
	//리스트폼으로
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "list";
	}
	
	
	//리스트 조회
	//jackson-databind : list를 json바인딩
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<ItemDTO> list(String findKey, String findValue) {
		logger.info(findKey);
		logger.info(findValue);
		List<ItemDTO> list = iservice.selectList(findKey, findValue); 
		logger.info(list.toString());
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
