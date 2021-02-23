package org.spring.item.service;

import java.util.List;

import org.spring.item.dto.ItemDTO;

public interface ItemService {

	public void insert(ItemDTO idto);
	
	public List<ItemDTO> selectList(String findKey, String findValue);

}
