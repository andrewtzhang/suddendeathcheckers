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


public class MainMenu {

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


        JFrame f1 = new JFrame("Main Menu"), f2 = new JFrame("Gameplay"), f3 = new JFrame("Instructions");
        JButton startButton = new JButton("Start"), instructionsButton = new JButton("Instructions"); //main
        startButton.setPreferredSize(new Dimension(200, 100));
        instructionsButton.setPreferredSize(new Dimension(200, 100));

        JLabel instruct = new JLabel("<html><font color=white><center><b>Yes we understand there are chess pieces<br> on the front, but hey, it looks cool!<br> To start playing, press \"Start\" on<br> the main menu. Next, you and another<br> person take turns moving pieces to new spots.<br> Player to remove all other's pieces wins!</b></html>");
        
        JButton back2 = new JButton("Back to Main");
        back2.setPreferredSize(new Dimension(200, 100));
        back2.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                f3.setEnabled(false);
                f3.setVisible(false);
                f1.setEnabled(true);
                f1.setVisible(true);
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


        JLabel areYouSure = new JLabel("<html><font color=white><b> Are you<br>sure? </b></html>");
        areYouSure.setPreferredSize(new Dimension(200, 100));
        JButton sureYes = new JButton("Yes"), sureNo = new JButton("No");
        sureYes.setPreferredSize(new Dimension(200, 100));
        sureNo.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setEnabled(false);
                f2.setVisible(false);
                // runCheckers();
            }
        });
        sureNo.setPreferredSize(new Dimension(200, 100));
        sureNo.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setEnabled(false);
                f2.setVisible(false);
                f1.setEnabled(true);
                f1.setVisible(true);
            }
        });

        JPanel[][] p2 = new JPanel[5][3]; //creates array for grid cells (for more panels)
        f2.setLayout(new GridLayout(5, 3));
        for(int m = 0; m < 5; m++) {
            for(int n = 0; n < 3; n++) {
                p2[m][n] = new JPanel();
                f2.add(p2[m][n]);
            }
        }

        p2[1][1].add(areYouSure);
        p2[2][1].add(sureYes);
        p2[3][1].add(sureNo);

        p2[0][0].setBackground(Color.black);
        p2[0][1].setBackground(Color.red);
        p2[0][2].setBackground(Color.black);
        p2[1][0].setBackground(Color.red);
        p2[1][1].setBackground(Color.black);
        p2[1][2].setBackground(Color.red);
        p2[2][0].setBackground(Color.black);
        p2[2][1].setBackground(Color.red);
        p2[2][2].setBackground(Color.black);
        p2[3][0].setBackground(Color.red);
        p2[3][1].setBackground(Color.black);
        p2[3][2].setBackground(Color.red);
        p2[4][0].setBackground(Color.black);
        p2[4][1].setBackground(Color.red);
        p2[4][2].setBackground(Color.black);

        JPanel[][] p3 = new JPanel[4][3]; //creates array for grid cells (for more panels)
        f3.setLayout(new GridLayout(4, 3));
        for(int m = 0; m < 4; m++) {
            for(int n = 0; n < 3; n++) {
                p3[m][n] = new JPanel();
                f3.add(p3[m][n]);
                p3[m][n].setBackground(Color.blue);
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
                f2.setEnabled(true);
                f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f2.pack();
                f2.setVisible(true);
                f1.setEnabled(false);
                f1.setVisible(false);
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