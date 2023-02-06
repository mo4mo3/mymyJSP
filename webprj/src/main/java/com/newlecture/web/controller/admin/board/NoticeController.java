 package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	//<bean name="adminnoticeController" class="com.newlecture.web.controller.admin.board.NoticeController" /> 
		@Autowired
		private ServletContext ctx;

		@RequestMapping("list")
		public String list() {

			return "admin.board.notice.list";
		}
		@GetMapping("reg")
		public String reg() {
			return "admin.board.notice.reg";

			
		}
		@PostMapping("reg")
		public String reg(HttpServletRequest request, String title, String content, MultipartFile[] files, String category, String[] foods, String food) throws IllegalStateException, IOException {

			
			for (MultipartFile file : files) {
				long size = file.getSize();
				String fileName = file.getOriginalFilename();
				System.out.printf("fileName:%s, fileSize:%d\n", fileName, size);
				// ServletContext ctx = request.getServletContext();
				String webPath = "/static/upload";
				String realPath = ctx.getRealPath(webPath);
				System.out.printf("realPath: %s\n", realPath);
				// 업로드 하기 위한 경로가 없을경우
				File savePath = new File(realPath);
				if (!savePath.exists())
					savePath.mkdir();

				realPath += File.separator + fileName;
				File saveFile = new File(realPath);
				file.transferTo(saveFile);
			}
			System.out.println(category);
			for(String f : foods)
				System.out.println(f);
			

			
			return "admin.board.notice.reg";

//			return String.format("title:%s<br> content:%s<br>category:%s", title, content, category);
		}
		@RequestMapping("edit")
		public String edit() {
			
			
			return "admin.board.notice.edit";
		}
		@RequestMapping("del")
		public String del() {
			
			
			return "";
		}
	

}
