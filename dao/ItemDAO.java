package org.spring.item.dao;

import java.util.List;
import java.util.Map;

import org.spring.item.dto.ItemDTO;

public interface ItemDAO {

	public void insert(ItemDTO idto);
	public void update(ItemDTO idto);
	public void delete(String itemcode);
	
	public List<ItemDTO> selectList(Map map);
	public ItemDTO selectOne(String itemcode);
	
}
