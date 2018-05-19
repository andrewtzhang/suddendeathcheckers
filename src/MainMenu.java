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



public class MainMenu {

    public static void runCode() {

        Scanner in = new Scanner(System.in);

        board checkers = new board();
        System.out.println(checkers);
        boolean gameRunning = true;
        while(gameRunning == true)
        {
            if(checkers.amtBlack() == 0) {
                for(int x = 0; x < 100; x++) {
                    System.out.println("WHITE WINS!");
                }
                gameRunning = false;
            }
            if(checkers.amtWhite() == 0) {
                for(int x = 0; x < 100; x++) {
                    System.out.println("BLACK WINS!");
                }
                gameRunning = false;
            }

            if(gameRunning == false) {
                break;
            }

            if(checkers.isBlackTurn() == true) {
                System.out.println("It's black's turn.");
            }
            else {
                System.out.println("It's white's turn.");
            }

            System.out.println("The score is: " + "B" + (12 - checkers.amtWhite()) + " W" + (12 - checkers.amtBlack()));

            System.out.println("Enter coordinates of piece to move (enter like \"##\"):");
            int input = in.nextInt();
            int x = input/10;
            int y = input%10;
            System.out.println("Enter coordinates of new location (enter like \"##\"):");
            input = in.nextInt();
            int x2 = input/10;
            int y2 = input%10;

            if(!checkers.move(x,y,x2,y2)){
                System.out.println("Cannot move piece onto another piece. Try again.");
            }else {
                System.out.println(checkers);
            }
        }
    }

    public static void music() {

        try {
            File soundFile = new File("realBackMusic.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);
            clip.start();
        } catch(UnsupportedAudioFileException add) {
            add.printStackTrace();
        } catch(IOException err) {
            err.printStackTrace();
        } catch(LineUnavailableException unn) {
            unn.printStackTrace();
        }

    }

    public static void main(String[] args) {

        JFrame loadFrame = new JFrame("Load Screen");
        JButton loadMain = new JButton("Start");
        loadMain.setPreferredSize(new Dimension(200, 100));

        JPanel[][] loadPanel = new JPanel[3][3];
        loadFrame.setLayout(new GridLayout(3, 3));
        for(int m = 0; m < 3; m++) {
            for(int n = 0; n < 3; n++) {
                loadPanel[m][n] = new JPanel();
                loadFrame.add(loadPanel[m][n]);
                loadPanel[m][n].setBackground(Color.blue);
            }
        }
        loadPanel[1][1].add(loadMain);

        JLabel k = new JLabel(), q = new JLabel(), b = new JLabel(), r = new JLabel(), kn = new JLabel(), p = new JLabel();

        k.setSize(150, 150);
        BufferedImage kingImage = null;
        try {
            kingImage =  ImageIO.read(new File("king.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image king = kingImage.getScaledInstance(k.getWidth(), k.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon kingIcon = new ImageIcon(king);


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





        JButton startButton = new JButton("Start"), instructionsButton = new JButton("Instructions"); //main
        startButton.setPreferredSize(new Dimension(200, 100));
        instructionsButton.setPreferredSize(new Dimension(200, 100));

        JLabel instruct = new JLabel("<html><font color=white><center><b>Yes we understand there are chess pieces<br> on the front, but hey, it looks cool!<br> To start playing, press \"Start\" on<br> the main menu. Next, you and another<br> person take turns moving pieces to new spots.<br> Player to remove all other's pieces wins!</b></html>");
        
        JButton back2 = new JButton("Back to Main");
        back2.setPreferredSize(new Dimension(200, 100));
        back2.addActionListener(new ActionListener(){
        
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

        JLabel t = new JLabel();
        t.setSize(450, 60);
        BufferedImage titleImage = null;
        try {
            titleImage =  ImageIO.read(new File("title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image title = titleImage.getScaledInstance(t.getWidth(), t.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleIcon = new ImageIcon(title);

        JPanel[][] p1 = new JPanel[3][3]; //creates array for grid cells (for more panels)
        f1.setLayout(new GridLayout(3, 3));
        for(int m = 0; m < 3; m++) {
            for(int n = 0; n < 3; n++) {
                p1[m][n] = new JPanel();
                f1.add(p1[m][n]);
            }
        }
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

        p1[0][0].setBackground(Color.red);
        p1[0][1].setBackground(Color.black);
        p1[0][2].setBackground(Color.red);
        p1[1][0].setBackground(Color.black);
        p1[1][1].setBackground(Color.red);
        p1[1][2].setBackground(Color.black);
        p1[2][0].setBackground(Color.red);
        p1[2][1].setBackground(Color.black);
        p1[2][2].setBackground(Color.red);

        JPanel[][] p3 = new JPanel[4][3]; //creates array for grid cells (for more panels)
        f3.setLayout(new GridLayout(4, 3));
        for(int m = 0; m < 4; m++) {
            for(int n = 0; n < 3; n++) {
                p3[m][n] = new JPanel();
                f3.add(p3[m][n]);
            }
        }
        p3[1][1].add(instruct);
        p3[1][1].setBackground(Color.white);
        p3[2][1].add(back2);

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


        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadFrame.pack();
        loadFrame.setVisible(true);

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

        startButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setEnabled(false);
                f1.setVisible(false);
                runCode();
            }
        });
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

}