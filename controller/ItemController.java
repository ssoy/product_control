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
	
	//���������
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String add() {
		return "add";
	}

	//�߰�
	//'application/json' �������� ������ ������
	//�����͸� ���� : @ResponseBody=>��ȯ���� ������ ��ü�� �ν�(text,json,xml)
	//@RequestBody : json������ ���ε�
	@ResponseBody
	@RequestMapping(value="/", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
	public String add(@RequestBody ItemDTO idto) {
		logger.info(idto.toString());
		iservice.insert(idto);
		return "�߰��Ϸ�";
	}
	
	//application/x-www-form-urlencoded �� ������ ������
//	@ResponseBody
//	@RequestMapping(value="/", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
//	public String add(ItemDTO idto) {
//		logger.info(idto.toString());
//		iservice.insert(idto);
//		return "�߰��Ϸ�";
//		
//	}
	
	
	//����Ʈ������
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "list";
	}
	
	
	//����Ʈ ��ȸ
	//jackson-databind : list�� json���ε�
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
