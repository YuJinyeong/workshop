package com.ssafy.cafe.service;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.cafe.dao.SearchDaoImpl;
import com.ssafy.cafe.model.MenuDto;

public class SearchServiceImpl implements SearchService {
	
	private List<String> list;
	private static SearchService searchService;
	
	private SearchServiceImpl() {}
	
	public static SearchService getSearchService() {
		if(searchService == null)
			searchService = new SearchServiceImpl();
		return searchService;
	}
	
	@Override
	public String searchMenuList(String isFirst, String keyword) {
		String resultText = "";
		if (isFirst.equals("first")) {
			list = SearchDaoImpl.getSearchDao().searchMenuList(keyword);
			resultText = makeText(list);
		} else {
			List<String> result = new ArrayList<String>();
			for (String pname : list) {
				if (pname.toUpperCase().startsWith(keyword.toUpperCase())) {
					result.add(pname);
				}
			}
			resultText = makeText(result);
		}
		
		return resultText;
	}
	
	@Override
	public void updateCnt(String keyword) {
		SearchDaoImpl.getSearchDao().updateCnt(keyword);
	}

	@Override
	public String popularMenuList() {
		List<MenuDto> list = SearchDaoImpl.getSearchDao().popularMenuList();
		String popularList = "[";
		int size = list.size();
		for(int i=0;i<size;i++) {
			MenuDto memberDto = list.get(i);
			popularList += "{";
			popularList += "\"pid\" : \"" + memberDto.getPid() + "\",";
			popularList += "\"pname\" : \"" + memberDto.getPname() + "\",";
			popularList += "\"price\" : \"" + memberDto.getPrice() + "\",";
			popularList += "\"picture\" : \"" + memberDto.getPicture() + "\"";
			popularList += "}";
			if(i < size - 1)
				popularList += ",";
		}
		popularList += "]";
		return popularList;
	}
	
	private String makeText(List<String> list) {
		int len = list.size();
		String txt = len + "|";
		for (int i = 0; i < len; i++) {
			txt += list.get(i);
			if (i < len - 1)
				txt += ",";
		}
		return txt;
	}

}
