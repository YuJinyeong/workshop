package abcDigitalStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDao {
	// Statement, PreparedStatement ===> SQL문을 데이터베이스에 보내기 위한 객체
	// ResultSet ===> SQL질의에 의해 생성된 테이블을 저장하는 객체

	public Connection getConnection() {
		Connection conn = null;

		try {
			// JDBC 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false ===> 클라이언트와 서버의 시간을
			// 일치시키기 위해서 8버전 이상부터 쓰는것을 의무화 시킴
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/ssafydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", "ssafy",
					"ssafy");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void close(Statement statement) {
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(Product p) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		// 사용할 SQL문 준비
		String sql = "INSERT INTO product VALUES(?, ?, ?, ?, ?)";
		try {
			// Statement 구문 객체에 SQL문을 준비
			ps = conn.prepareStatement(sql);
			// 필요한 파라메터들을 매칭
			ps.setString(1, p.getNum());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getPrice());
			ps.setInt(4, p.getQuant());
			ps.setInt(5, p.getSize());
			// Statement구문 객체 던짐
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(ps);
		close(conn);
	}

	public List<Product> searchByName(String str) {
		List<Product> list = new ArrayList<>();
		Connection conn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM product WHERE name=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, str);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product();

				p.setNum(rs.getString(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setQuant(rs.getInt(4));
				p.setSize(rs.getInt(5));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		close(pstmt);
		close(rs);
		
		return list;
	}

	public List<Product> searchByPrice(int Price) {
		List<Product> list = new ArrayList<>();
		Connection conn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM product WHERE price <= ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Price);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product();

				p.setNum(rs.getString(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setQuant(rs.getInt(4));
				p.setSize(rs.getInt(5));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		close(pstmt);
		close(rs);
		
		return list;
	}

	public List<Product> searchByNum(String num) {
		List<Product> list = new ArrayList<>();
		Connection conn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM product WHERE num=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product();

				p.setNum(rs.getString(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setQuant(rs.getInt(4));
				p.setSize(rs.getInt(5));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		close(pstmt);
		close(rs);
		
		return list;
	}

	public void delete(String num) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM product WHERE num=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		close(pstmt);
	}

	public void update(String num, int price, int change) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		String sql = "UPDATE product SET price=? where num=? && price=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, change);
			pstmt.setString(2, num);
			pstmt.setInt(3, price);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close(conn);
		close(pstmt);
	}

	public List<Product> getProductList() {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM product";
			pstmt = conn.prepareStatement(sql);// 3. 필요하다면 파라메터를 매칭시킨다.
			// 4. 구문을 던진다.
			rs = pstmt.executeQuery();
			// 5. 4의 리턴으로 튀어나온 ResultSet을 핸들링한다.

			while (rs.next()) {
				Product p = new Product();

				p.setNum(rs.getString(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setQuant(rs.getInt(4));
				p.setSize(rs.getInt(5));

				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		close(pstmt);
		close(rs);

		return list;

	}

}
