package org.spring.item.service;

import java.util.List;
import java.util.Map;

import org.spring.item.dto.ItemDTO;

public interface ItemService {
	public void insert(ItemDTO idto);
	public void update(ItemDTO idto);
	public List<ItemDTO> selectList(Map<String, String> findMap);
	public ItemDTO selectOne(String itemcode);
	public void delete(String itemcode);

}
