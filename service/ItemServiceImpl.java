package org.spring.item.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.item.dao.ItemDAO;
import org.spring.item.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDAO idao;
	
	@Override
	public void insert(ItemDTO idto) {
		idao.insert(idto);
		
	}

	@Override
	public List<ItemDTO> selectList(String findKey, String findValue) {
		// findKey, findValue : map¿∏∑Œ
		Map<String,String> map = new HashMap<>();
		map.put("findKey",findKey);
		map.put("findValue",findValue);
		
		return idao.selectList(map);
	}
	
}
