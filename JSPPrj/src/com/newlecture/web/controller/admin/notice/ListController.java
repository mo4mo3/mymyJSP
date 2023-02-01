package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] openIds = request.getParameterValues("open-id");// 3, 5, 8
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		String ids_ = request.getParameter("ids");
		String[] ids = ids_.trim().split("  "); // 1,2,3,4,5,6,7,8,9,10

		NoticeService service = new NoticeService();

		switch (cmd) {
		case "老褒傍俺":
			for(String openId : openIds)
				System.out.printf("open id : %s\n", openId);

			List<String> oids = Arrays.asList(openIds);
			// 1,2,3,4,5,6,7,8,9,10- // 3, 5, 8
			// 12,4,6,7,9,10
			List<String> cids = new ArrayList(Arrays.asList(ids));
			cids.removeAll(oids);
			System.out.println(Arrays.asList(ids));
			System.out.println(oids);
			System.out.println(cids);

			//Transaction 贸府
			service.pubNoticeAll(oids, cids);//update notice set pub=1 wehre id in(...):
//			service.closeNoticeList(clsIds);

			break;
		case "老褒昏力":
			int[] ids1 = new int[delIds.length];
			for (int i = 0; i<delIds.length; i++)
				ids1[i] = Integer.parseInt(delIds[i]);
 
			int result = service.deleteNoticeAll(ids1);
//			for (String delId : delIds)
//				System.out.printf("del id : %s\n", delId);
			break;
		}
		response.sendRedirect("list");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* list?f=title&q=a */

		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");

		String field = "title";
		if (field_ != null && !field_.equals(""))
			field = field_;

		String query = "";
		if (query_ != null && !query_.equals(""))
			query = query_;

		int page = 1;
		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		NoticeService service = new NoticeService();
		List<NoticeView> list = service.getNoticeList(field, query, page);
		int count = service.getNoticeCount(field, query);

		request.setAttribute("list", list);

		request.setAttribute("count", count);

		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(request, response);
	}
}
