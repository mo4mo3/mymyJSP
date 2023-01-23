package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "scott";
	private String pwd = "tiger";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public List<Notice> getList(int page) throws ClassNotFoundException, SQLException {
		int start = 1 + (page-1)*10; //1 ,11 , 21, 31 ...
		int end =  10*page; //10 , 20, 30, 40.....
		String sql = "SELECT * FROM (" + "SELECT ROWNUM NUM, N.* FROM (" + "SELECT * FROM NOTICE ORDER BY REGDATE DESC"
				+ "" + "    )N" + ") " + "WHERE ROWNUM BETWEEN ? AND ?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, end);
		ResultSet rs = st.executeQuery();

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");

			Notice notice = new Notice(id, title, writerId, regDate, content, hit, files);

			list.add(notice);

		}

		rs.close();
		st.close();
		con.close();
		return list;
	}

	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String writer_Id = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO notice ( " + " title," + " writer_id," + " content," + " files"
				+ " ) VALUES (?, ?, ?, ? )";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		// Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writer_Id);
		st.setString(3, content);
		st.setString(4, files);

		int result = st.executeUpdate();
		System.out.println(result);

		st.close();
		con.close();
		return result;
	}

	public int update(Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE NOTICE " + "SET" + "    TITLE=?," + "    CONTENT=?," + "    FILES=?" + "    WHERE ID=?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		// Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);

		int result = st.executeUpdate();

		System.out.println(result);

		st.close();
		con.close();
		return result;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE NOTICE WHERE ID=?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		// Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		int result = st.executeUpdate();

		System.out.println(result);

		st.close();
		con.close();
		return result;
	}
}
