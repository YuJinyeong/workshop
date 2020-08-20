import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	public Connection getConnection() {
		Connection conn = null;
		// conn을 지정된 디비에 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8&useSSL=false",
					"ssafy", "1007");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		// con을 close
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Statement stmt) {
		// stmt을 close
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs) {
		// rs을 close
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertBook(Book b) {
		Connection conn = getConnection();
		String sql = "INSERT INTO book VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getIsbn());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setInt(5, b.getPrice());
			pstmt.setString(6, b.getDescription());

			pstmt.executeUpdate();

			close(conn);
			close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Book b) {
		Connection conn = getConnection();
		String sql = "UPDATE book SET price=? where isbn=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, b.getPrice());
			pstmt.setString(2, b.getIsbn());

			pstmt.executeUpdate();

			close(conn);
			close(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBook(Book b) {
		Connection conn = getConnection();
		String sql = "DELETE FROM book WHERE isbn=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getIsbn());

			pstmt.executeUpdate();
			close(conn);
			close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book findBook(String isbn) {
		Connection conn = getConnection();
		ResultSet rs = null;
		Book book = new Book();
		String sql = "SELECT * FROM book WHERE isbn=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, isbn);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setDescription(rs.getString(6));
			}
			close(conn);
			close(pstmt);
			close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public List<Book> getBookList() {
		List<Book> list = new ArrayList<>();
		try {
			Connection conn = getConnection();
			// 1. SQL문을 준비한다.
			String sql = "SELECT * FROM book";
			// 2. 구문객체를 준비한다.
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(sql);// 3. 필요하다면 파라메터를 매칭시킨다.
			// 4. 구문을 던진다.
			ResultSet rs = pstmt.executeQuery();
			// 5. 4의 리턴으로 튀어나온 ResultSet을 핸들링한다.

			while (rs.next()) {
				Book b = new Book();
				b.setIsbn(rs.getString(1)); // 순서맞게
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setPrice(rs.getInt(5));
				b.setDescription(rs.getString(6));

				list.add(b);
			}
			close(conn);
			close(pstmt);
			close(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int count() {
		return 0;
	}
}
