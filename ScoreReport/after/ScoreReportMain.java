package before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Command {
	QUIT(0),
	ADD_STUDENT(1),
	ADD_SCORE(2),
	SHOW_STUDENT_REPORT(3),
	CLEAR_STUDENT_SCORES(4),
	INIT_STUDENT(-1);
	private final int index;
	Command(int index){
		this.index=index;
	}
	public int getIndex() {
		return this.index;
	}
	
}

public class ScoreReportMain {
	private static Scanner scanner = new Scanner(System.in) ;
	private List<Student> studentList = new ArrayList<Student>();
	private final String PROMPT_MSG_FOR_STUDENT = "Enter student name";

	public static void main(String[] args) {
		ScoreReportMain newMain = new ScoreReportMain() ;

		boolean isQuit = false ;
		while ( ! isQuit ) {
			Command command = newMain.getCommand();
			switch ( command ) {
			case Quit: isQuit = true ; break ;
			case ADD_STUDENT: newMain.addStudent("student") ; break ;
			case ADD_SCORE: newMain.addScores("scores") ; break ;
			case SHOW_STUDENT_REPORT: newMain.showStudentReport() ; break ;
			case CLEAR_STUDENT_SCORES: newMain.clearStudentScores() ; break ;
			case INIT_STUDENT: newMain.initStudent() ; break ;
			default: break ;
			}
		}
		System.out.println("Bye");
	}
	
	private Command getCommand() {
		int inputCommand = scanner.nextInt();
		for (Command command : Command.values()) {
			if (command.getIndex()==inputCommand) {
				return command;
			}
		}
		return null;
	}
	private int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t -1. Init");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. Add student");
		System.out.println("\t 2. Add scores");
		System.out.println("\t 3. Show student report");
		System.out.println("\t 4. Clear student scores");
		
		int cmd = scanner.nextInt() ;
		return cmd ;
	}
	private void initStudent() {
		St james = new St("James") ;
		james.getScores().add(20) ;
		james.getScores().add(10) ;

		St brown = new St("Brown") ;
		brown.getScores().add(30) ;
		brown.getScores().add(10) ;
		brown.getScores().add(20) ;
		brown.getScores().add(60) ;
		brown.getScores().add(50) ;

		studentList.addStudent(james) ;
		studentList.addStudent(brown) ;
	}
	//sts=studentList
	private void clearStudentScores() {
		System.out.println("Enter student name: ");
		String score = scanner.next() ;
		for ( St student : studentList ) {
			if ( student.getName().equals(score)) {
				student.getScores().clear();
				System.out.println("Score cleared");
				break;
			}
		}
	}

	private void showStudentReport() {
		System.out.println("Enter student name: ");
		String name = scanner.next() ;
		for ( St student : studentList ) {
			if ( student.getName().equals(name)) {
				int sum = 0 ;
				for ( Integer i: student.getScores()) {
					System.out.print(i + " ");
					sum += i ;
				}
				System.out.println("Sum: " + sum);
				break;
			}
		}
	}
	//validTest구현하기 목적은 case addstudent,score,show,clea를 값들중 어디로 가는지 확인하는 함
	private void addStudent() {
		String studentName = getStudentName(PROMPT_MSG_FOR_STUDENT, new isValidName() {
			@Override
			public boolean validTest (String name) {
				return true;
			}
		});
		Student newStudent = new Student(studentName);
		studentList.add(newStudent);
		
	}
	
	private void addScores() {
		String studentName = getStudentName(PROMPT_MSG_FOR_STUDENT, new isValidName() {
			@Override
			public boolean validTest (String name) {
				return true;
			}
		});
		isValidScore isValid = new isValidScore() {
			@Override
			public boolean validTest (int score){
				return true;
			}
		};

		for ( St student : studentList ) {
			if ( student.getName().equals(name)) {
				System.out.println("Enter scores( -1 for quit): ") ;
				while ( true ) {
					int score = scanner.nextInt() ;
					if ( score == -1 ) break ;
					if (isValid.validTest(score)) { //아래에서 구현한 isValidScroe인터페이스 활용
						student.getScores().add(score) ;
					}
				}
				break;
			}
		}

	}
	
	private String getStudentName(final string prompt, isValidName isValid) {
		System.out.println("Enter student name: ");
		String studentName = scanner.next();
		if (isValid.validTest(studentName)) {
			return studentName;
		}
		else {
			return null;
		}
	}
	//검사하는 함수들.
	public interface isValidScore {
		boolean validTest(int score);
	}

	public interface isValidName {
		boolean validTest(String name);
	}
}
