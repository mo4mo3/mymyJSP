package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {

		Exam exam = new NewlecExam();
//		ExamConsole console = new InlineExamConsole(exam); //DI
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		console.print();
	}

}
