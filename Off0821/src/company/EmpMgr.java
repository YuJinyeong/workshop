package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpMgr {
	// 싱글턴 패턴 적용
	private static EmpMgr instance;
	private EmpMgr() {}
	public static EmpMgr getInstance() {
		if(instance == null)
			instance = new EmpMgr();
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		// conn을 지정된 디비에 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/compdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8&useSSL=false", "ssafy", "1007");
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
	
	// 파라메터로 전달된 직원 정보를  DB에 저장
	void add(Employee b) {
		Connection conn = getConnection();
		String sql = "INSERT INTO employee VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, b.getEmpNo());
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPosition());
			pstmt.setString(4, b.getDept());

			pstmt.executeUpdate();

			close(conn);
			close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	List<Employee> search() {
		Connection conn = getConnection();
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM employee";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				
				e.setEmpNo(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPosition(rs.getString(3));
				e.setDept(rs.getString(4));
				
				list.add(e);
			}
			close(conn);
			close(pstmt);
			close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	List<Employee> search(int empNo) {
		Connection conn = getConnection();
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE empNo = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				
				e.setEmpNo(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPosition(rs.getString(3));
				e.setDept(rs.getString(4));
				
				list.add(e);
			}
			close(conn);
			close(pstmt);
			close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	List<Employee> search(String name) {
		Connection conn = getConnection();
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE name like CONCAT('%', ?, '%')";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				
				e.setEmpNo(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPosition(rs.getString(3));
				e.setDept(rs.getString(4));
				
				list.add(e);
			}
			close(conn);
			close(pstmt);
			close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	boolean update(int empNo, String dept) {
		Connection conn = getConnection();
		String sql = "UPDATE employee SET dept=? where empNo=?";
		boolean success = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,dept);
			pstmt.setInt(2, empNo);

			// update 성공하면 true
			// update 실패하면 false 반환
			if(pstmt.executeUpdate()!=0) {
				success =  true;
			}

			close(conn);
			close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	// 파라메터의 사번과 같은 직원을 찾아 삭제
	boolean delete(int empNo) {
		Connection conn = getConnection();
		String sql = "DELETE FROM employee WHERE empNo=?";
		boolean success = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empNo);

			if(pstmt.executeUpdate()!=0) {
				success = true;
			}
			
			close(conn);
			close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
