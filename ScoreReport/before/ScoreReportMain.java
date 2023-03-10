package before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreReportMain {
	private static Scanner scanner = new Scanner(System.in) ;
	private List<St> sts = new ArrayList<St>();

	public static void main(String[] args) {
		ScoreReportMain ui = new ScoreReportMain() ;

		boolean q = false ;
		while ( ! q ) {
			int cmd = ui.shCmd() ;
			switch ( cmd ) {
			case 0: q = true ; break ;
			case 1: ui.add("student") ; break ;
			case 2: ui.add("scores") ; break ;
			case 3: ui.showStuRpt() ; break ;
			case 4: ui.clStScs() ; break ;
			case -1: ui.init() ; break ;
			default: break ;
			}
		}
		System.out.println("Bye");
	}
	private int shCmd() {
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
	private void init() {
		St james = new St("James") ;
		james.getScs().add(20) ;
		james.getScs().add(10) ;

		St brown = new St("Brown") ;
		brown.getScs().add(30) ;
		brown.getScs().add(10) ;
		brown.getScs().add(20) ;
		brown.getScs().add(60) ;
		brown.getScs().add(50) ;

		sts.add(james) ;
		sts.add(brown) ;
	}
	private void clStScs() {
		System.out.println("Enter student name: ");
		String n1 = scanner.next() ;
		for ( St st : sts ) {
			if ( st.getNm().equals(n1)) {
				st.getScs().clear();
				System.out.println("Score cleared");
				break;
			}
		}
	}
	private void showStuRpt() {
		System.out.println("Enter student name: ");
		String n1 = scanner.next() ;
		for ( St st : sts ) {
			if ( st.getNm().equals(n1)) {
				int s = 0 ;
				for ( Integer i: st.getScs()) {
					System.out.print(i + " ");
					s += i ;
				}
				System.out.println("Sum: " + s);
				break;
			}
		}
	}
	private void add(String kind) {
		if ( kind.equals("student") ) {
			System.out.println("Enter student name: ");
			String n = scanner.next() ;
			St s = new St(n) ;
			sts.add(s) ;
		}
		else {
			System.out.println("Enter student name: ");
			String n1 = scanner.next() ;
			for ( St st : sts ) {
				if ( st.getNm().equals(n1)) {
					System.out.println("Enter scores( -1 for quit): ") ;
					while ( true ) {
						int n2 = scanner.nextInt() ;
						if ( n2 == -1 ) break ;

						st.getScs().add(n2) ;
					}
					break;
				}
			}
		}
	}

}