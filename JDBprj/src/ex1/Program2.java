package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String title = "TEST2";
		String writer_Id = "newlec";
		String content = "hahaha  ";
		String files = "";

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO notice ( " + " title," + " writer_id," + " content," + " files"
				+ " ) VALUES (?, ?, ?, ? )";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
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
	}
}