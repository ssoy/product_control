package org.spring.item.service;

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
	public List<ItemDTO> selectList(Map<String, String> findMap) {
		
		return idao.selectList(findMap);
	}
	@Override
	public ItemDTO selectOne(String itemcode) {
		
		return idao.selectOne(itemcode);
	}
	@Override
	public void update(ItemDTO idto) {
		idao.update(idto);
		
	}
	@Override
	public void delete(String itemcode) {
		idao.delete(itemcode);
	}
	
}
