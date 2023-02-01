package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {

/*	스프링에게 지시하는 방법으로 코드를 변경
  Exam exam = new NewlecExam();
  ExamConsole console = new GridExamConsole();
  
  console.setExam(exam);*/
			
		
		ExamConsole console = ?;
			console.print();
	}

}

//ExamConsole console = new GridExamConsole(exam);
//ExamConsole console = new InlineExamConsole(exam); //DI