package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	// Statement, PreparedStatement ===> SQL문을 데이터베이스에 보내기 위한 객체
		// ResultSet ===> SQL질의에 의해 생성된 테이블을 저장하는 객체

		public static Connection getConnection() {
			Connection conn = null;

			try {
				// JDBC 드라이버 로딩
				Class.forName("com.mysql.cj.jdbc.Driver");
				// characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false ===> 클라이언트와 서버의 시간을
				// 일치시키기 위해서 8버전 이상부터 쓰는것을 의무화 시킴
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost/ssafy?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", "root",
						"ssafy");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			return conn;
		}

		public static void close(Connection conn) {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		public static void close(Statement statement) {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		public static void close(ResultSet rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public static void insertAcc(Account acc) throws SQLException {
			Connection conn = getConnection();
			// 사용할 SQL문 준비
			String sql = "INSERT INTO Account VALUES(?, ?, ?, ?, ?, ?)";
			// Statement 구문 객체에 SQL문을 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			// 필요한 파라메터들을 매칭
			ps.setString(1, acc.getNumber());
			ps.setString(2, acc.getUname());
			ps.setString(3, acc.getAname());
			ps.setString(4, acc.getTotal());
			ps.setString(5, acc.getDescription());
			ps.setString(6, acc.getOtp());

			// Statement구문 객체 던짐
			ps.executeUpdate();

			close(ps);
			close(conn);

		}

		public static void updateAccount(Account acc) throws SQLException {
			Connection conn = getConnection();
			String sql = "UPDATE Account SET number = ?, Uname = ?, Aname = ?, total = ?, description = ?, otp = ? WHERE number = ? and otp = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, acc.getNumber());
			ps.setString(2, acc.getUname());
			ps.setString(3, acc.getAname());
			ps.setString(4, acc.getTotal());
			ps.setString(5, acc.getDescription());
			ps.setString(6, acc.getOtp());

			ps.executeUpdate();

			close(ps);
			close(conn);
		}

		public static void deposit(String n, String o, int money) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				Account a = findAccount(n, o);
				conn = getConnection();

				String sql = "UPDATE Account SET total = ? WHERE number=? && otp=?";
				ps = conn.prepareStatement(sql);
				String newt = "" + (Integer.parseInt(a.getTotal()) + money);
				ps.setString(1, newt);
				ps.setString(2, n);
				ps.setString(3, o);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			close(ps);
			close(conn);
		}

		public static void withdraw(String n, String o, int money) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				Account a = findAccount(n, o);
				conn = getConnection();

				String sql = "UPDATE Account SET total = ? WHERE number=? && otp=?";
				ps = conn.prepareStatement(sql);
				String newt = "" + (Integer.parseInt(a.getTotal()) - money);
				ps.setString(1, newt);
				ps.setString(2, n);
				ps.setString(3, o);

				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			close(ps);
			close(conn);
		}

		public static void deleteAccount(String pk, String pk2) throws SQLException {
			Connection conn = getConnection();
			String sql = "DELETE FROM Account WHERE number = ? and otp = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pk);
			ps.setString(2, pk2);
			ps.executeUpdate();

			close(ps);
			close(conn);
		}

		public static Account findAccount(String num, String otp) throws SQLException {
			Account acc = null;
			Connection conn = getConnection();
			String sql = "SELECT * FROM Account WHERE  number = ? and otp = ? ";
			Statement state = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.setString(2, otp);

			ResultSet rs = state.executeQuery(sql);

			while (rs.next()) {
				String Number = rs.getString("number");
				String Uname = rs.getString("Uname");
				String Aname = rs.getString("Aname");
				String Total = rs.getString("total");
				String Description = rs.getString("description");
				String Otp = rs.getString("otp");
				acc = new Account(Number, Uname, Aname, Total, Description, Otp);
			}

			close(rs);
			close(state);
			close(conn);

			return acc;
		}

		public static List<Account> findAccounts(String uname, String otp) throws Exception {
			List<Account> acc = null;
			Connection conn = getConnection();
			String sql = "SELECT * FROM Account WHERE Uname = ? and otp = ?";
			Statement state = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, otp);

			ResultSet rs = state.executeQuery(sql);

			while (rs.next()) {
				String Number = rs.getString("number");
				String Uname = rs.getString("Uname");
				String Aname = rs.getString("Aname");
				String Total = rs.getString("total");
				String Otp = rs.getString("otp");
				String Description = rs.getString("description");

				acc.add(new Account(Number, Uname, Aname, Total, Otp, Description));
			}

			if (acc == null)
				throw new Exception();

			close(rs);
			close(state);
			close(conn);

			return acc;
		}

		public static List<Account> listAccount() throws SQLException {
			List<Account> list = new ArrayList<>();
			Connection conn = getConnection();
			String sql = "SELECT * FROM Account";
			Statement state = conn.createStatement();
			// SQL 질의 결과를 ResultSet에 저장
			ResultSet rs = state.executeQuery(sql);
			// rs.next()로 커서를 이동 (1개일 경우 if문 사용가능)
			while (rs.next()) {
				String Number = rs.getString("number");
				String Uname = rs.getString("Uname");
				String Aname = rs.getString("Aname");
				String Total = rs.getString("total");
				String Otp = rs.getString("otp");
				String Description = rs.getString("description");

				list.add(new Account(Number, Uname, Aname, Total, Otp, Description));
			}
			close(rs);
			close(state);
			close(conn);

			return list;
		}

		public static int count() throws SQLException {
			Connection conn = getConnection();
			String sql = "SELECT COUNT(*) FROM Account";
			Statement state = conn.createStatement();

			ResultSet rs = state.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}

			close(rs);
			close(state);
			close(conn);

			return count;
		}
		
		public List<Account> getAllList() {
			List<Account> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				String sql = "SELECT * FROM Account";
				pstmt = conn.prepareStatement(sql);// 3. 필요하다면 파라메터를 매칭시킨다.
				// 4. 구문을 던진다.
				rs = pstmt.executeQuery();
				// 5. 4의 리턴으로 튀어나온 ResultSet을 핸들링한다.

				while (rs.next()) {
					Account a = new Account();

					a.setNumber(rs.getString(1));
					a.setUname(rs.getString(2));
					a.setAname(rs.getString(3));
					a.setTotal(rs.getString(4));
					a.setOtp(rs.getString(5));
					a.setDescription(rs.getString(6));

					list.add(a);
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
