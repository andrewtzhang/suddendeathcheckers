import java.util.Scanner;

public class tester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board checkers = new board();
        System.out.println(checkers);
        //System.out.println(checkers.move(1,2,0,3));
        System.out.println(checkers);
        /*checkers.rngDie();
        checkers.rngDie();
        checkers.rngDie();
        checkers.rngDie();*/
        System.out.println(checkers);
        System.out.println(checkers.move(0,5,1,4));
        System.out.println(checkers);
        System.out.println(checkers.move(3,2,2,3));
        System.out.println(checkers);
        System.out.println(checkers.move(1,4,3,2));
        System.out.println(checkers);
        System.out.println("WHY WONT YOU PRINNNTNNTNTT");
    }
}
