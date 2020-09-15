package com.ssafy.cafe.dao;

import java.util.List;

import com.ssafy.cafe.model.MenuDto;

public interface SearchDao {

	List<String> searchMenuList(String keyword);
	void updateCnt(String keyword);
	
	List<MenuDto> popularMenuList();

}
