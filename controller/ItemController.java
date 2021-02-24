package org.spring.item.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.item.dto.ItemDTO;
import org.spring.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<ItemDTO> list(@RequestParam Map<String, String> findMap) {
		logger.info(findMap.toString());
		List<ItemDTO> list = iservice.selectList(findMap);
		logger.info(list.toString());
		return list;
	}
	
	//���������� �̵�
	//@PathVariable : url�� ���� �д´�
	@RequestMapping(value = "/{itemcode}", method = RequestMethod.GET)
	public String modify(@PathVariable("itemcode") String itemcode, Model model) {
		logger.info(itemcode);
		//�Ѱ��� �����͸� ��ȸ�ؼ� view�� ����
		ItemDTO dto = iservice.selectOne(itemcode);
		model.addAttribute("dto",dto);
		return "modify";
	}
	
	//���� : @RequestBody :json��ü ó��
	@ResponseBody
	@RequestMapping(value = "/{itemcode}", 
						method = {RequestMethod.PUT,RequestMethod.PATCH },
						produces = "application/text;charset=utf-8")
	public String modify(@PathVariable("itemcode") String itemcode, @RequestBody ItemDTO idto) {
		logger.info(itemcode);
		logger.info(idto.toString());
		//����ó��
		iservice.update(idto);
		
		return "�����Ϸ�";
	}
	
	//����
	@ResponseBody 
	@RequestMapping(value="/{itemcode}",
					method = RequestMethod.DELETE,
					produces = "application/text;charset=utf-8")
	public String remove(@PathVariable("itemcode") String itemcode) {
		logger.info(itemcode);
		//����ó��
		iservice.delete(itemcode);
		
		return "�����Ϸ�";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

	@RequestMapping(value = "/test", method = RequestMethod.PUT)
	public String test(String name, Model model) {
		logger.info(name);
		return "";
	}
	
	
	

}
