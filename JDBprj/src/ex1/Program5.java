package ex1;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsole;

public class Program5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeConsole console = new NoticeConsole();
		
		EXIT:
			while(true) {
		console.printNoticeList();
		int menu  = console.inputNoticeMenu();
		
		switch(menu) {
		case 1: //상세조회
			break;
		case 2: //이전
				break;
		case 3: //다음
					break;
		case 4: //글쓰기
			break;
		case 5: //종료
		  	System.out.println("Bye-");
			break EXIT;
			default:
				System.out.println("<<사용방법>> 메뉴는 1~4까지만 입력할 수 있습니다");
			break;
		}
			}
	}

	private static void Noticeconsole() {
		// TODO Auto-generated method stub

	}

}
