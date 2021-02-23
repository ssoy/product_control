package org.spring.item.dao;

import java.util.List;
import java.util.Map;

import org.spring.item.dto.ItemDTO;

public interface ItemDAO {

	public void insert(ItemDTO idto);

	public List<ItemDTO> selectList(Map map);

}
