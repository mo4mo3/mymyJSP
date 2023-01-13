package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/login")*/
public class LoginServlet extends HttpServlet {
	public void init() {
		System.out.println("init �޼��� ȣ��");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");

		String data = "�ȳ��ϼ���!<br> �α����ϼ̽��ϴ�.<br><br>";
		data += "<html><body>";
		data += "���̵� : " + user_id;
		data += "<br>";
		data += "��й�ȣ : " + user_pw;
		data += "<br>";
		data += "�ּ� : " + user_address;
		data += "<br>";
		data += "email : " + user_email;
		data += "<br>";
		data += "�޴� ��ȭ : " + user_hp;
		data += "</html></body>";
		out.print(data);
	}

	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}
}
