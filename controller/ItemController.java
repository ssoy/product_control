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
	public List<ItemDTO> list(@RequestParam Map<String, String> findMap) {
		logger.info(findMap.toString());
		List<ItemDTO> list = iservice.selectList(findMap);
		logger.info(list.toString());
		return list;
	}
	
	//수정폼으로 이동
	//@PathVariable : url의 값을 읽는다
	@RequestMapping(value = "/{itemcode}", method = RequestMethod.GET)
	public String modify(@PathVariable("itemcode") String itemcode, Model model) {
		logger.info(itemcode);
		//한건의 데이터를 조회해서 view에 전송
		ItemDTO dto = iservice.selectOne(itemcode);
		model.addAttribute("dto",dto);
		return "modify";
	}
	
	//수정 : @RequestBody :json객체 처리
	@ResponseBody
	@RequestMapping(value = "/{itemcode}", 
						method = {RequestMethod.PUT,RequestMethod.PATCH },
						produces = "application/text;charset=utf-8")
	public String modify(@PathVariable("itemcode") String itemcode, @RequestBody ItemDTO idto) {
		logger.info(itemcode);
		logger.info(idto.toString());
		//수정처리
		iservice.update(idto);
		
		return "수정완료";
	}
	
	//삭제
	@ResponseBody 
	@RequestMapping(value="/{itemcode}",
					method = RequestMethod.DELETE,
					produces = "application/text;charset=utf-8")
	public String remove(@PathVariable("itemcode") String itemcode) {
		logger.info(itemcode);
		//삭제처리
		iservice.delete(itemcode);
		
		return "삭제완료";
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
