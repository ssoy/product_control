package org.spring.item.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.spring.item.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl implements ItemDAO{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(ItemDTO idto) {
		session.insert("org.spring.item.ItemMapper.insert", idto);
	}

	@Override
	public List<ItemDTO> selectList(Map map) {
		return session.selectList("org.spring.item.ItemMapper.selectList", map);
	}

	@Override
	public ItemDTO selectOne(String itemcode) {
		return session.selectOne("org.spring.item.ItemMapper.selectOne", itemcode);
	}

	@Override
	public void update(ItemDTO idto) {
		session.selectOne("org.spring.item.ItemMapper.update", idto);
		
	}

	@Override
	public void delete(String itemcode) {
		session.delete("org.spring.item.ItemMapper.delete", itemcode);
		
	}
	

}
