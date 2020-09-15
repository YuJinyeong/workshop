package com.ssafy.cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.cafe.model.MenuDto;
import com.ssafy.util.DBUtil;

public class SearchDaoImpl implements SearchDao {

	private static SearchDao searchDao;

	private SearchDaoImpl() {
	}

	public static SearchDao getSearchDao() {
		if (searchDao == null)
			searchDao = new SearchDaoImpl();
		return searchDao;
	}

	@Override
	public List<String> searchMenuList(String keyword) {
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select pname \n");
			sql.append("from ssafy_cafe \n");

			if (keyword.equals("ㄱ")) {
				sql.append("where pname rlike '^(ㄱ|ㄲ)' or ( pname >= '가' AND pname < '나' ) \n");
			} else if (keyword.equals("ㄴ")) {
				sql.append("where pname rlike '^ㄴ' or ( pname >= '나' AND pname < '다' ) \n");
			} else if (keyword.equals("ㄷ")) {
				sql.append("where pname rlike '^(ㄷ|ㄸ)' or ( pname >= '다' AND pname < '라' ) \n");
			} else if (keyword.equals("ㄹ")) {
				sql.append("where pname rlike '^ㄹ' or ( pname >= '라' AND pname < '마' ) \n");
			} else if (keyword.equals("ㅁ")) {
				sql.append("where pname rlike '^ㅁ' or ( pname >= '마' AND pname < '바' ) \n");
			} else if (keyword.equals("ㅂ")) {
				sql.append("where pname rlike '^ㅂ' or ( pname >= '바' AND pname < '사' ) \n");
			} else if (keyword.equals("ㅅ")) {
				sql.append("where pname rlike '^(ㅅ|ㅆ)' or ( pname >= '사' AND pname < '아' ) \n");
			} else if (keyword.equals("ㅇ")) {
				sql.append("where pname rlike '^ㅇ' or ( pname >= '아' AND pname < '자' ) \n");
			} else if (keyword.equals("ㅈ")) {
				sql.append("where pname rlike '^(ㅈ|ㅉ)' or ( pname >= '자' AND pname < '차' ) \n");
			} else if (keyword.equals("ㅊ")) {
				sql.append("where pname rlike '^ㅊ' or ( pname >= '차' AND pname < '카' ) \n");
			} else if (keyword.equals("ㅋ")) {
				sql.append("where pname rlike '^ㅋ' or ( pname >= '카' AND pname < '타' ) \n");
			} else if (keyword.equals("ㅌ")) {
				sql.append("where pname rlike '^ㅌ' or ( pname >= '타' AND pname < '파' ) \n");
			} else if (keyword.equals("ㅍ")) {
				sql.append("where pname rlike '^ㅍ' or ( pname >= '파' AND pname < '하' ) \n");
			} else if (keyword.equals("ㅎ")) {
				sql.append("where pname rlike '^ㅎ' or ( pname >= '하')) \n");
			} else {
				sql.append("where pname like '" + keyword + "%' \n");
			}
			sql.append("order by cnt desc");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("pname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	@Override
	public void updateCnt(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update ssafy_cafe \n");
			sql.append("set cnt = cnt + 1 \n");
			sql.append("where pname = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<MenuDto> popularMenuList() {
		List<MenuDto> list = new ArrayList<MenuDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select idx, pid, pname, price, picture, cnt \n");
			sql.append("from ssafy_cafe \n");
			sql.append("order by cnt desc limit 0, 4");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuDto menuDto = new MenuDto();
				menuDto.setIdx(rs.getInt("idx"));
				menuDto.setPid(rs.getString("pid"));
				menuDto.setPname(rs.getString("pname"));
				menuDto.setPrice(rs.getInt("price"));
				menuDto.setPicture(rs.getString("picture"));
				menuDto.setCnt(rs.getInt("cnt"));

				list.add(menuDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

}
