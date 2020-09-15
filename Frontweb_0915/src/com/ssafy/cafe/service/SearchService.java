package com.ssafy.cafe.service;

public interface SearchService {

	String searchMenuList(String isFirst, String keyword);
	void updateCnt(String keyword);
	
	String popularMenuList();
	
}
