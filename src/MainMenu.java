//Nicholas Haddad
//May 12, 2018
//Brandon Kerr AP Computer Science 1A

//all the imports for our specific classes, music, images, graphics, and inputs
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.sound.*;
import java.io.*;
import java.util.*;


//this is the main menu which has the ui and runs the game
public class MainMenu {
/*
    //preconditions: none
    //postcondition: the game is running
    public static void runCode() { //method to actually run the game itself

        Scanner in = new Scanner(System.in);

        board checkers = new board(); //creates new game board
        System.out.println(checkers);
        boolean gameRunning = true;
        while(gameRunning == true) //infinite loop to keep game running (unless someone wins)
        {
            if(checkers.amtBlack() == 0) { //checks if all black pieces are gone
                for(int x = 0; x < 100; x++) {
                    System.out.println("WHITE WINS!");
                }
                gameRunning = false;
            }
            if(checkers.amtWhite() == 0) { //checks if all white pieces are gone
                for(int x = 0; x < 100; x++) {
                    System.out.println("BLACK WINS!");
                }
                gameRunning = false;
            }

            if(gameRunning == false) {
                break;
            }

            //checks whose turn it is
            if(checkers.isBlackTurn() == true) {
                System.out.println("It's black's turn.");
            }
            else {
                System.out.println("It's white's turn.");
            }

            //prints score every round
            System.out.println("The score is: " + "B" + (12 - checkers.amtWhite()) + " W" + (12 - checkers.amtBlack()));

            //piece to be moved
            System.out.println("Enter coordinates of piece to move (enter like \"##\"):");
            int input = in.nextInt();
            int x = input/10;
            int y = input%10;
            //location to be moved to
            System.out.println("Enter coordinates of new location (enter like \"##\"):");
            input = in.nextInt();
            int x2 = input/10;
            int y2 = input%10;

            if(!checkers.move(x,y,x2,y2)){
                System.out.println("Cannot move piece onto another piece. Try again."); //checks if error was made when trying to move a piece (bad spot, onto another piece, wrong direction)
            }else {
                System.out.println(checkers); //prints updated board
            }
        }
    }

    //preconditions: none
    //postcondition: music is playing
    public static void music() { //method to play music in background

        try {
            File soundFile = new File("realBackMusic.wav"); //imports new wav file
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);
            clip.start(); //plays music

            //errors to check if file invalid
        } catch(UnsupportedAudioFileException add) {
            add.printStackTrace();
        } catch(IOException err) {
            err.printStackTrace();
        } catch(LineUnavailableException unn) {
            unn.printStackTrace();
        }

    }

    //preconditions: none
    //postcondition: the ui appears
    public static void main(String[] args) { //main method to create gui and run the runcode method

        JFrame loadFrame = new JFrame("Load Screen"); //load screen jframe
        JButton loadMain = new JButton("Start");
        loadMain.setPreferredSize(new Dimension(200, 100));

        //creates 2d array of panels so that gridlayout can be used to set specific location of objects
        JPanel[][] loadPanel = new JPanel[3][3];
        loadFrame.setLayout(new GridLayout(3, 3));
        for(int m = 0; m < 3; m++) {
            for(int n = 0; n < 3; n++) {
                loadPanel[m][n] = new JPanel();
                loadFrame.add(loadPanel[m][n]);
                loadPanel[m][n].setBackground(Color.red);
            }
        }
        //sets location of button in center
        loadPanel[1][1].add(loadMain);


        //labels for main menu pics
        JLabel k = new JLabel(), q = new JLabel(), b = new JLabel(), r = new JLabel(), kn = new JLabel(), p = new JLabel();

        k.setSize(150, 150); //sets size of label
        BufferedImage kingImage = null;
        try {
            kingImage =  ImageIO.read(new File("king.png")); //creates new image from file
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image king = kingImage.getScaledInstance(k.getWidth(), k.getHeight(), Image.SCALE_SMOOTH); //sets image to actual image object
        ImageIcon kingIcon = new ImageIcon(king); //sets image to imageicon for displaying

        //repeated code
        q.setSize(150, 150);
        BufferedImage queenImage = null;
        try {
            queenImage =  ImageIO.read(new File("queen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image queen = queenImage.getScaledInstance(q.getWidth(), q.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon queenIcon = new ImageIcon(queen);


        b.setSize(150, 150);
        BufferedImage bishopImage = null;
        try {
            bishopImage =  ImageIO.read(new File("bishop.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image bishop = bishopImage.getScaledInstance(b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bishopIcon = new ImageIcon(bishop);


        r.setSize(150, 150);
        BufferedImage rookImage = null;
        try {
            rookImage =  ImageIO.read(new File("rook.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image rook = rookImage.getScaledInstance(r.getWidth(), r.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon rookIcon = new ImageIcon(rook);


        kn.setSize(150, 150);
        BufferedImage knightImage = null;
        try {
            knightImage =  ImageIO.read(new File("knight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image knight = knightImage.getScaledInstance(kn.getWidth(), kn.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon knightIcon = new ImageIcon(knight);


        p.setSize(150, 150);
        BufferedImage pawnImage = null;
        try {
            pawnImage =  ImageIO.read(new File("pawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image pawn = pawnImage.getScaledInstance(p.getWidth(), p.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pawnIcon = new ImageIcon(pawn);


        //main menu jframe and instructions screen
        JFrame f1 = new JFrame("Main Menu"), f3 = new JFrame("Instructions");





        // JFrame game = new JFrame("King Me");
        // game.setSize(500, 500);
        // game.setVisible(false);
        // game.setEnabled(false);

        // JTextArea console = new JTextArea();
        // console.setPreferredSize(new Dimension(300, 600));
        // console.setEditable(false);
        
        // PrintStream printer = new PrintStream(new TextAreaOutputStream(console));
        // System.setOut(printer);
        // System.setErr(printer);

        // JTextField input = new JTextField();
        // input.setPreferredSize(new Dimension(350, 50));

        // JButton quit = new JButton("Quit"), upload = new JButton("Upload"), enableAll = new JButton("Press to Start!");
        // enableAll.setPreferredSize(new Dimension(100, 50));
        // enableAll.addActionListener(new ActionListener(){
        
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         runCode();
        //     }
        // });
        // quit.setPreferredSize(new Dimension(100, 50));
        // quit.addActionListener(new ActionListener(){
        
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         System.exit(1);
        //     }
        // });
        // upload.setPreferredSize(new Dimension(100, 50));
        // upload.addActionListener(new ActionListener(){
        
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         console.append("\n" + input.getText() + "\n");
        //         input.setText("");
        //     }
        // });

        // JPanel[][] bigTwo = new JPanel[2][3]; //creates array for grid cells (for more panels)
        // game.setLayout(new GridLayout(2, 3));
        // for(int m = 0; m < 2; m++) {
        //     for(int n = 0; n < 3; n++) {
        //         bigTwo[m][n] = new JPanel();
        //         game.add(bigTwo[m][n]);
        //     }
        // }

        // bigTwo[0][1].add(console);
        // bigTwo[1][1].add(input);
        // bigTwo[1][0].add(quit);
        // bigTwo[1][2].add(upload);
        // bigTwo[0][0].add(enableAll);

        // game.pack();





        JButton startButton = new JButton("Start"), instructionsButton = new JButton("Instructions"); //main menu buttons
        startButton.setPreferredSize(new Dimension(200, 100));
        instructionsButton.setPreferredSize(new Dimension(200, 100));

        //label that displays instructions using html formatting
        JLabel instruct = new JLabel("<html><font color=white><center><b>Yes we understand there are chess pieces<br> on the front, but hey, it looks cool!<br> To start playing, press \"Start\" on<br> the main menu. Next, you and another<br> person take turns moving pieces to new spots.<br> Player to remove all other's pieces wins!</b></html>");
        
        JButton back2 = new JButton("Back to Main"); //back button
        back2.setPreferredSize(new Dimension(200, 100));
        back2.addActionListener(new ActionListener(){ //closes instructions screen and opens main menu again
        
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setEnabled(true);
                f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f1.pack();
                f1.setVisible(true);
                f3.setEnabled(false);
                f3.setVisible(false);
            }
        });
        //no u

        JLabel t = new JLabel(); //label and image setting for title on main menu
        t.setSize(450, 60);
        BufferedImage titleImage = null;
        try {
            titleImage =  ImageIO.read(new File("title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image title = titleImage.getScaledInstance(t.getWidth(), t.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleIcon = new ImageIcon(title);

        //creates 2d array of panels so that gridlayout can be used to set specific location of objects
        JPanel[][] p1 = new JPanel[3][3];
        f1.setLayout(new GridLayout(3, 3));
        for(int m = 0; m < 3; m++) {
            for(int n = 0; n < 3; n++) {
                p1[m][n] = new JPanel(); //sets panel to each grid cell (of another panel)
                f1.add(p1[m][n]);
            }
        }
        //adding each object to the main menu gridlayout
        p1[1][1].add(startButton);
        p1[2][1].add(instructionsButton);
        t.setIcon(titleIcon);
        p1[0][1].add(t);
        k.setIcon(kingIcon);
        q.setIcon(queenIcon);
        b.setIcon(bishopIcon);
        r.setIcon(rookIcon);
        kn.setIcon(knightIcon);
        p.setIcon(pawnIcon);
        p1[0][0].add(k);
        p1[0][2].add(q);
        p1[1][2].add(b);
        p1[1][0].add(r);
        p1[2][2].add(kn);
        p1[2][0].add(p);

        //sets background color of main menu cells
        p1[0][0].setBackground(Color.red);
        p1[0][1].setBackground(Color.black);
        p1[0][2].setBackground(Color.red);
        p1[1][0].setBackground(Color.black);
        p1[1][1].setBackground(Color.red);
        p1[1][2].setBackground(Color.black);
        p1[2][0].setBackground(Color.red);
        p1[2][1].setBackground(Color.black);
        p1[2][2].setBackground(Color.red);

        //creates 2d array of panels so that gridlayout can be used to set specific location of objects
        JPanel[][] p3 = new JPanel[4][3]; 
        f3.setLayout(new GridLayout(4, 3));
        for(int m = 0; m < 4; m++) {
            for(int n = 0; n < 3; n++) { //sets panel to each grid cell (of another panel)
                p3[m][n] = new JPanel();
                f3.add(p3[m][n]);
            }
        }
        //adds objects
        p3[1][1].add(instruct);
        p3[1][1].setBackground(Color.white);
        p3[2][1].add(back2);

        //sets background colors
        p3[0][0].setBackground(Color.red);
        p3[0][1].setBackground(Color.black);
        p3[0][2].setBackground(Color.red);
        p3[1][0].setBackground(Color.black);
        p3[1][1].setBackground(Color.red);
        p3[1][2].setBackground(Color.black);
        p3[2][0].setBackground(Color.red);
        p3[2][1].setBackground(Color.black);
        p3[2][2].setBackground(Color.red);
        p3[3][0].setBackground(Color.black);
        p3[3][1].setBackground(Color.red);
        p3[3][2].setBackground(Color.black);

        //default settings for load screen jframe
        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadFrame.pack();
        loadFrame.setVisible(true);

        //load screen button that plays music, closes load screen, and opens main menu
        loadMain.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                music();
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.pack();
                f1.setVisible(true);
                loadFrame.setEnabled(false);
                loadFrame.setVisible(false);
            }
        });

        //closes main menu and starts game in terminal
        startButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setEnabled(false);
                f1.setVisible(false);
                runCode();
            }
        });
        //opens instructions menu and closes main menu button
        instructionsButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                f3.setEnabled(true);
                f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f3.pack();
                f3.setVisible(true);
                f1.setEnabled(false);
                f1.setVisible(false);
            }
        });

    }
*/
}