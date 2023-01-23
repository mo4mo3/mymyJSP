package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

public class NoticeConsole {

	private NoticeService service;
	

	public NoticeConsole() {
	
	service = new NoticeService();
}	
	
	
	
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		
	List<Notice>list = service.getList(2);
	System.out.println("---------------------------------");
	System.out.printf("<공지사항> 총 %d 게시글\n", 12);
	System.out.println("---------------------------------");
	
	for(Notice n : list) {
	System.out.printf("%d. %s / %s / %s \n", 
					n.getId(), 
					n.getTitle(), 
					n.getWriterId(),
					n.getRegDate());
	}
	System.out.println("---------------------------------");
	System.out.printf("	%d/%d page\n", 1, 2);


	}

	
	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("1.상세조회/2.이전/3.다음/4.글쓰기/5.종료>");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		return menu;
	}

}
