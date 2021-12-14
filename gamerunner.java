import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.Scanner;
import java.io.*;
import java.net.*;  
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class gamerunner extends JFrame{
   
   DrawPanel drawpanel = new DrawPanel();
   JLabel intro=new JLabel("Select a game mode");
   JButton Window = new JButton("Play Windowed");
   JButton Fullscreen = new JButton("Play Fullscreen");
   public static final Color GOLD = new Color(255,204, 51);
   int x = 0;
    int y = 0;
    int score = 0;
    int berries=0;
    boolean rescramble = true;
    int past_score=score;
    int[][] xy_Values = {{10,60,30,80},{50,20,70,40}};
    int times_Completed=1;
    int Lives = 3;
    int[][] E_xy_Values = {{0,0,0,0},{0,0,0,0}};
    boolean rescramble_E=true;
    int enimesLeft=0;
    int LivesLost=0;
   
    DrawPanel drawPanel = new DrawPanel();
    JLabel scoreDisplay = new JLabel("score:"+score);
    JLabel lives = new JLabel("lives:"+Lives);
    JLabel Gameover = new JLabel("GAMEOVER");    
    private JTextField scores;

    public gamerunner(){
             InputMap inputMap = drawPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = drawPanel.getActionMap();

        Action upAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
             
                drawPanel.repaint();
            }
        };

        inputMap.put(KeyStroke.getKeyStroke("UP"), "upAction");
        actionMap.put("upAction", upAction);

        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true); 
        
        Window.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Game();
        }
    });
      }
    });
    
    
    Fullscreen.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new GameFullscreen();
        }
    });
      }
    });
    } 

private class DrawPanel extends JPanel {


        protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Font fnt = new Font("Exo",Font.BOLD,50);
        Font fnt2 = new Font("Exo",Font.BOLD,15);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,400);
        intro.setBounds(160,117-50,800,100);
        intro.setForeground(Color.RED);
        intro.setFont(fnt);
        this.add(intro);
        Window.setBounds(220,175,160,50);
        Window.setFont(fnt2);
        Window.setForeground(Color.BLACK);
        Window.setBackground(GOLD);
        this.add(Window);
        Fullscreen.setBounds(390,175,150,50);
        Fullscreen.setFont(fnt2);
        Fullscreen.setForeground(Color.BLACK);
        Fullscreen.setBackground(GOLD);
        this.add(Fullscreen);
        drawpanel.repaint();
}
    
        public Dimension getPreferredSize() {
            return new Dimension(800, 400);
        }
    }



   public static void main(String args[]){
   //sets a string with the file path need for images
    String filePath=System.getProperty("user.home");
    //makes folder for images if there is no one
    if(new File(filePath+"/Astroscape/images").mkdirs()==false)
      new File(filePath+"/Astroscape/images").mkdirs();
    //adds the folder to the string with the path  
    filePath+="/Astroscape/images/";
    try{
    //creates files for the images to be writen into
      File Player = new File(filePath+"Player.png");
      File PlayerD = new File(filePath+"PlayerDown.png");
      File PlayerL = new File(filePath+"PlayerLeft.png");
      File PlayerR = new File(filePath+"PlayerRight.png");
      File A = new File(filePath+"asteroid.png");
      File F = new File(filePath+"fuel.png");
      File S = new File(filePath+"star.png");
    //does same for the large images
      File Player30 = new File(filePath+"Player30.png");
      File PlayerD30 = new File(filePath+"PlayerDown30.png");
      File PlayerL30 = new File(filePath+"PlayerLeft30.png");
      File PlayerR30 = new File(filePath+"PlayerRight30.png");
      File F30 = new File(filePath+"fuel30.png");
      File A30 = new File(filePath+"asteroid30.png");
      File S30 = new File(filePath+"star30.png");
    //create buffered images for the images to be loaded onto
      BufferedImage pu = ImageIO.read(Game.class.getResourceAsStream("/Player.png"));
      BufferedImage pd = ImageIO.read(Game.class.getResourceAsStream("/PlayerDown.png"));
      BufferedImage pl = ImageIO.read(Game.class.getResourceAsStream("/PlayerLeft.png"));
      BufferedImage pr = ImageIO.read(Game.class.getResourceAsStream("/PlayerRight.png"));
      BufferedImage f = ImageIO.read(Game.class.getResourceAsStream("/fuel.png"));
      BufferedImage s = ImageIO.read(Game.class.getResourceAsStream("/star.png"));
      BufferedImage a = ImageIO.read(Game.class.getResourceAsStream("/asteroid.png"));
    //does same for large images
      BufferedImage pu30 = ImageIO.read(Game.class.getResourceAsStream("/Player30.png"));
      BufferedImage pd30 = ImageIO.read(Game.class.getResourceAsStream("/PlayerDown30.png"));
      BufferedImage pl30 = ImageIO.read(Game.class.getResourceAsStream("/PlayerLeft30.png"));
      BufferedImage pr30 = ImageIO.read(Game.class.getResourceAsStream("/PlayerRight30.png"));
      BufferedImage f30 = ImageIO.read(Game.class.getResourceAsStream("/fuel30.png"));
      BufferedImage s30 = ImageIO.read(Game.class.getResourceAsStream("/star30.png"));
      BufferedImage a30 = ImageIO.read(Game.class.getResourceAsStream("/asteroid30.png"));  
    //Finally Writes the image to the file  
      ImageIO.write(pu, "PNG", Player);
      ImageIO.write(pd, "PNG", PlayerD);
      ImageIO.write(pl, "PNG", PlayerL);
      ImageIO.write(pr, "PNG", PlayerR);
      ImageIO.write(f, "PNG", F);
      ImageIO.write(s, "PNG", S);
      ImageIO.write(a, "PNG", A);
    //writes large images
      ImageIO.write(pu30, "PNG", Player30);
      ImageIO.write(pd30, "PNG", PlayerD30);
      ImageIO.write(pl30, "PNG", PlayerL30);
      ImageIO.write(pr30, "PNG", PlayerR30);
      ImageIO.write(f30, "PNG", F30);
      ImageIO.write(s30, "PNG", S30);
      ImageIO.write(a30, "PNG", A30);
      }catch(IOException z){}
      java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new gamerunner();
        }
    });
   }
   }