import java.util.Scanner;

public class tester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board checkers = new board();
        System.out.println(checkers);
        //System.out.println(checkers.move(1,2,0,3));
        //System.out.println(checkers);
        /*checkers.rngDie();
        checkers.rngDie();
        checkers.rngDie();
        checkers.rngDie();*/
        //System.out.println(checkers);
        while(0==0)
        {
            System.out.println("Enter coordinates of piece to move:");
            int input = in.nextInt();
            int x = input/10;
            int y = input%10;
            System.out.println("Enter coordinates of new location:");
            input = in.nextInt();
            int x2 = input/10;
            int y2 = input%10;

            checkers.move(x,y,x2,y2);
            System.out.println(checkers);
        }
        /*System.out.println(checkers.move(0,5,1,4));
        System.out.println(checkers);
        System.out.println(checkers.move(3,2,2,3));
        System.out.println(checkers);
        //System.out.println(checkers.move(1,4,3,2));
        System.out.println(checkers);
        System.out.println("WHY WONT YOU PRINNNTNNTNTT");
        */

    }
}
