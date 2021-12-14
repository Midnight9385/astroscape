import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;


public class GameFullscreen extends JFrame {

    String filePath=System.getProperty("user.home")+"/Astroscape/images";
    int Highscore=0;
    int Highlevel=1;
    String info="";
    boolean firsttime=true;
    int x = 0;
    int y = 0;
    int score = 0;
    int berries=0;
    boolean rescramble = true;
    int past_score=score;
    int[][] xy_Values = {{20,20,20,20},{20,20,20,20}};
    int times_Completed=1;
    int Lives = 0;
    int[][] E_xy_Values = {{0,0,0,0},{0,0,0,0}};
    boolean rescramble_E=true;
    String menu="menu";
    int starmade=0;
    boolean moved=false;
    int[][] backgroundstar_Values = {{0,30,0,80,0,40,0,160,0,180,0,140,170,0,460},{10,20,30,40,50,60,70,80,90,100,110,120,130,140,150}};
     Writer create = new Writer();   
    DrawPanel drawPanel = new DrawPanel();
    JLabel scoreDisplay = new JLabel("score:"+score);
    JLabel lives = new JLabel("lives:"+Lives);
    JLabel GameFullscreenover = new JLabel("GAMEOVER");
    JLabel Instructions = new JLabel("Use arrow keys to move, avoid these asteroids --->      and collect these --->");
    JLabel Instructions2 = new JLabel("You are --->");
    JLabel title = new JLabel("Astroscape");
    JButton start = new JButton("Start");    
    JButton retry = new JButton("Retry");
    JButton Menu = new JButton("Menu");
    JButton back = new JButton("Back");
    JButton instructions = new JButton("Instructions");
    JLabel intro = new JLabel("How To Play!");
    JButton exit = new JButton("Exit");
    JButton highest = new JButton("Top Scores");
    JButton save = new JButton("Save");
    ImageIcon playerup = new ImageIcon(filePath+"Player30");
    ImageIcon playerdown = new ImageIcon(filePath+"/PlayerDown30.png");
    ImageIcon playerleft = new ImageIcon(filePath+"/PlayerLeft30.png");
    ImageIcon playerright = new ImageIcon(filePath+"/PlayerRight30.png");
    ImageIcon Fuel = new ImageIcon(filePath+"/fuel30.png");
    ImageIcon Star = new ImageIcon(filePath+"/star30.png");
    ImageIcon Asteroid = new ImageIcon(filePath+"/asteroid30.png");
    JLabel fuel = new JLabel(Fuel, JLabel.CENTER);
    JLabel fuel1 = new JLabel(Fuel, JLabel.CENTER);
    JLabel fuel2 = new JLabel(Fuel, JLabel.CENTER);
    JLabel fuel3 = new JLabel(Fuel, JLabel.CENTER);
    JLabel star = new JLabel(Star, JLabel.CENTER);
    JLabel star1 = new JLabel(Star, JLabel.CENTER);
    JLabel star2 = new JLabel(Star, JLabel.CENTER);
    JLabel star3 = new JLabel(Star, JLabel.CENTER);
    JLabel star4 = new JLabel(Star, JLabel.CENTER);
    JLabel star5 = new JLabel(Star, JLabel.CENTER);
    JLabel star6 = new JLabel(Star, JLabel.CENTER);
    JLabel star7 = new JLabel(Star, JLabel.CENTER);
    JLabel star8 = new JLabel(Star, JLabel.CENTER);
    JLabel star9 = new JLabel(Star, JLabel.CENTER);
    JLabel star10 = new JLabel(Star, JLabel.CENTER);
    JLabel star11 = new JLabel(Star, JLabel.CENTER);
    JLabel star12 = new JLabel(Star, JLabel.CENTER);
    JLabel star13 = new JLabel(Star, JLabel.CENTER);
    JLabel star14 = new JLabel(Star, JLabel.CENTER);
    JLabel player = new JLabel(playerright, JLabel.CENTER);
    JLabel asteroid = new JLabel(Asteroid, JLabel.CENTER);
    JLabel asteroid1 = new JLabel(Asteroid, JLabel.CENTER);
    JLabel asteroid2 = new JLabel(Asteroid, JLabel.CENTER);
    JLabel asteroid3 = new JLabel(Asteroid, JLabel.CENTER);
    JLabel level = new JLabel("Level:"+times_Completed);
    JLabel Levels = new JLabel("You got to level "+times_Completed+"!");
    JLabel Score = new JLabel("With a score of "+score+"!");
    JLabel highscore = new JLabel("Highscore:"+Highscore);
    JLabel highlevel = new JLabel("Highest Level:"+Highlevel);

   public static final Color GOLD = new Color(255,204, 51);
   public static final Color SKY = new Color(0,162,255);

    public GameFullscreen(){  
    
    highest.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
         menu="highest";
         drawPanel.repaint();
      }
});
       
start.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        menu="game";
        Lives=3;
        score=0;
        x=0;
        y=0;
        rescramble=true;
        rescramble_E=true;
        drawPanel.repaint();
      }
    }); 
    
     save.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
         create.write(Highscore,Highlevel);
         drawPanel.repaint();
      }
});
    
    back.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        menu="menu";
        drawPanel.repaint();
      }
    });
    
    retry.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        menu="game";
        times_Completed=1;
        Lives=3;
        score=0;
        x=0;
        y=0;
        rescramble=true;
        rescramble_E=true;
        drawPanel.repaint();
      }
    }); 
    
    exit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
    });
    
    Menu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        menu="menu";
        drawPanel.repaint();
      }
    }); 
    
    instructions.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        menu="instructions";
        drawPanel.repaint();
      }
    });

        Action leftAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
               if(Lives>0){
               if(x>0){
               if(moved==false){
               player.setIcon(playerleft);
                x -=20;
                moved=true;
                }
                }
            }
            drawPanel.repaint();
            }
        };

            InputMap inputMap = drawPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = drawPanel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        actionMap.put("leftAction", leftAction);

        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        Action rightAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                if(Lives>0){
                if(x<1570){
                if(moved==false){
                moved=true;
                x +=20;
                player.setIcon(playerright);
                }
                }
            }
            drawPanel.repaint();
            }
        };

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        actionMap.put("rightAction", rightAction);

        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        Action downAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                if(Lives>0){
                if(y<780){
                if(moved==false){
                moved=true;
                y +=20;
                player.setIcon(playerdown);
                }
                }
            }
            drawPanel.repaint();
            }
        };

        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        actionMap.put("downAction", downAction);

        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        Action upAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
               if(Lives>0){
               if(y>0){
               if(moved==false){
                moved=true;
                y -=20;
                player.setIcon(playerup);
                }
                }
            }
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
    } 


    private class DrawPanel extends JPanel {


        protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        
        
        if(menu=="instructions"){
        this.removeAll();
        
        g.setColor(SKY);
        g.fillRect(0,0,1600,800);
        back.setForeground(Color.BLACK);
	     back.setBackground(GOLD);
        Font fnt2 = new Font("Calibri",Font.BOLD,18*2);
        back.setFont(fnt2);
        back.setBounds(0,0,100*2,50*2);
        this.add(back);
        Instructions.setForeground(Color.BLACK);
        Instructions.setFont(fnt2);
        Instructions.setBounds(100*2,150*2,800*2,100*2);
        this.add(Instructions);
        asteroid.setBounds(484*2,192*2,15*2,15*2);
        fuel.setBounds(669*2,192*2,15*2,15*2);
        this.add(fuel);
        this.add(asteroid);
        Instructions2.setForeground(Color.BLACK);
        Instructions2.setFont(fnt2);
        Instructions2.setBounds(101*2,175*2,800*2,100*2);
        this.add(Instructions2);
        player.setBounds(195*2,219*2,15*2,15*2);
        this.add(player);
        intro.setForeground(GOLD);
        Font fntT = new Font("Impact",Font.BOLD,50);
        intro.setFont(fntT);
        intro.setBounds(248*2,117*2,800*2,50*2);
        this.add(intro);
        }
        
        if(menu=="gameover"){
        this.removeAll();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1600,800);
        Levels.setText("You got to level"+times_Completed+"!");
        Score.setText("With a score of "+score+"!");
         GameFullscreenover.setForeground(Color.RED);
         Font fnt = new Font("Exo",Font.BOLD,25*2);
         Font fnt5 = new Font("Exo",Font.BOLD,15*2);
         GameFullscreenover.setFont(fnt);
         GameFullscreenover.setBounds(317*2,25*2,150*2,150*2);
         this.add(GameFullscreenover);
         Levels.setForeground(Color.RED);
         Levels.setFont(fnt5);
         Levels.setBounds(317*2,55*2,150*2,150*2);
         this.add(Levels);
         Score.setForeground(Color.RED);
         Score.setFont(fnt5);
         Score.setBounds(317*2,75*2,250*2,150*2);
         this.add(Score);
       	retry.setForeground(Color.BLACK);
	      retry.setBackground(GOLD);
         Font fnt1 = new Font("Calibri",Font.BOLD,18*2);
         retry.setFont(fnt1);
         retry.setBounds(280*2,175*2,100*2,50*2);
         this.add(retry);
         Menu.setForeground(Color.BLACK);
	      Menu.setBackground(GOLD);
         Menu.setFont(fnt1);
         Menu.setBounds(400*2,175*2,100*2,50*2);
         this.add(Menu);
         Font fnt4 = new Font("Calibri",Font.BOLD,14*2);
         exit.setFont(fnt4);
         exit.setBackground(GOLD);
         exit.setBounds(0,0,60*2,25*2);
         this.add(exit);
         if(score>Highscore){
         Highscore=score;
         }
         if(times_Completed>Highlevel){
         Highlevel=times_Completed;
         }
        }    
        
        if(menu=="highest"){
        this.removeAll();
        
        highscore.setText("Highscore:"+Highscore);
        highlevel.setText("Highest Level:"+Highlevel);
        
        g.setColor(SKY);
        g.fillRect(0,0,800*2,400*2);
        Font fnt22 = new Font("Calibri",Font.BOLD,18*2);
        back.setFont(fnt22);
        back.setBounds(0,0,100*2,50*2);
        back.setBackground(GOLD);
        this.add(back);
        Font fntTt = new Font("Impact",Font.BOLD,25);
        highscore.setForeground(GOLD);
        highscore.setFont(fntTt);
        highscore.setBounds(248*2,117*2,800*2,50*2);
        this.add(highscore);
        highlevel.setForeground(GOLD);
        highlevel.setFont(fntTt);
        highlevel.setBounds(248*2,150*2,800*2,50*2);
        this.add(highlevel); 
        }
        
	if(menu=="menu"){
   this.removeAll();
   if(firsttime==true)
   {
      try{
    
        File usernames = new File("C:\\Users\\Zachary\\Desktop\\savecodes.txt");
        File saves = new File("C:\\Users\\Zachary\\Desktop\\saveInfo.txt");
        WriteToFile writing = new WriteToFile();
        //checks if the files exists, if not makes said file
        if(usernames.exists()!=true)
        {
            writing.create("usernames");
        }
        if(saves.exists()!=true)
        {
            writing.create("saveInfo");
        }
        
        BufferedReader u = new BufferedReader(new FileReader(usernames));
        BufferedReader v = new BufferedReader(new FileReader(saves));   

        GFG Run = new GFG();   
        info=Run.run(u,v,"");
        } catch(IOException e) {
        System.out.println("uh oh");
        e.printStackTrace();
        }
        if(info.equals("cancel"))
        {
            Highscore=0;
            Highlevel=1;
        }
        else if(info.indexOf("%")!=-1)
        {
        Highscore=Integer.parseInt(info.substring(0,info.indexOf("%")));
        Highlevel=Integer.parseInt(info.substring(info.indexOf("%")+1,info.length()));
        }
        
        firsttime=false;
        
   }
   g.setColor(Color.BLACK);
	g.fillRect(0,0,1600,800);
 	start.setForeground(Color.BLACK);
	start.setBackground(GOLD);
   Font fnt = new Font("Calibri",Font.BOLD,18*2);
   start.setFont(fnt);
   start.setBounds(260*2,175*2,125*2,50*2);
   this.add(start);
   instructions.setBackground(GOLD);
   instructions.setFont(fnt);
   instructions.setBounds(390*2,175*2,150*2,50*2);
   this.add(instructions);
   int title_y=117;
   title.setForeground(GOLD);
   Font fntTitle = new Font("Impact",Font.BOLD,50*2);
   title.setFont(fntTitle);
   title.setBounds(283*2,title_y*2,800*2,50*2);
   this.add(title);
   highest.setBackground(GOLD);
   highest.setFont(fnt);
   highest.setBounds(315*2,230*2,150*2,50*2);
   this.add(highest);
   Font fnt3 = new Font("Calibri",Font.BOLD,14*2);
   exit.setFont(fnt3);
   exit.setBackground(GOLD);
   exit.setBounds(0,0,60*2,25*2);
   this.add(exit);
   save.setFont(fnt3);
   save.setBackground(GOLD);
   save.setBounds(700*2,0,70*2,25*2);
   this.add(save);
           g.setColor(Color.WHITE);
    for (int ii = 0; ii < backgroundstar_Values.length; ii++) 
     {
      for(int jj = 0; jj < backgroundstar_Values[ii].length-1; jj++) 
       {
       if(jj==0){
         star.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star);
         }
         if(jj==0){
         star.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star);
         }
         if(jj==1){
         star1.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star1);
         }
         if(jj==2){
         star2.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star2);
         }
         if(jj==3){
         star3.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star3);
         }
         if(jj==4){
         star4.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star4);
         }
         if(jj==5){
         star5.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star5);
         }
         if(jj==6){
         star6.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star6);
         }
         if(jj==7){
         star7.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star7);
         }
         if(jj==8){
         star8.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star8);
         }
         if(jj==9){
         star9.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star9);
         }
         if(jj==10){
         star10.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star10);
         }
         if(jj==11){
         star11.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star11);
         }
         if(jj==12){
         star12.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star12);
         }
         if(jj==13){
         star13.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star13);
         }
         if(jj==14){
         star14.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star14);
         }
       }
     }
     
     for(int rr=0;rr<backgroundstar_Values[0].length;rr++)
        {
          if(backgroundstar_Values[0][rr]<=-10)
          {
            backgroundstar_Values[0][rr]=1700+(int) (Math.random() * 15);
            int aaa=1 + (int) (Math.random() * 79);
            int bbb= aaa*10;
            backgroundstar_Values[1][rr]=bbb;
          }
          else if(backgroundstar_Values[0][rr]>-10)
          {
            backgroundstar_Values[0][rr]-=1*2;
          }  
          if(rr==E_xy_Values[0].length-1){
          try
            {
                Thread.sleep(1);
 
            } catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
          drawPanel.repaint();
	}
   }
   }
                     
	if(menu=="game"){
   this.removeAll();
     Font fnt99 = new Font("Impact",Font.BOLD,18);   
     scoreDisplay.setText("score:"+score);
     scoreDisplay.setForeground(Color.WHITE);
     scoreDisplay.setBounds(350*2,-20*2,150*2,50*2);
     scoreDisplay.setFont(fnt99);
     lives.setText("lives:"+Lives);
     lives.setForeground(Color.WHITE);
     lives.setFont(fnt99);
     lives.setBounds(300*2,-20*2,50*2,50*2);
     level.setText("level:"+times_Completed);
     level.setForeground(Color.WHITE);
     level.setFont(fnt99);
     level.setBounds(250*2,-20*2,50*2,50*2);
         this.add(scoreDisplay);
         this.add(lives);
         this.add(level);
         
         
         for (int k = 0; k < xy_Values.length; k++) 
         {
            for(int l = 0; l < xy_Values[k].length; l++) 
            {
               if(xy_Values[0][l] == x && xy_Values[1][l] == y )
               {
                  score+=100;
                  xy_Values[0][l]=-50;
                  xy_Values[1][l]=-50;
                  berries+=1;
                  if(berries/times_Completed==xy_Values[0].length)
                  {
                     times_Completed+=1;
                     rescramble=true;
                     rescramble_E=true;
                     if(Lives<3){
                     Lives+=1;
                  }
                 }
               }
           }
         }  
         
         if(rescramble==true)
     {
       for(int z=0;z<xy_Values[0].length;z++)
       {
        int a = 1 + (int) (Math.random() * 77);
        int b = a*20;
        xy_Values[0][z] = b;
        a = 1 + (int) (Math.random() * 38);
        b = a*20;
        xy_Values[1][z] = b;
       }
       rescramble=false;
     }   
     
     
              if(rescramble_E==true){
     for(int q=0;q<E_xy_Values[0].length;q++)
       {
        int aa = 1 + (int) (Math.random() * 79);
        int bb = aa*20;
        E_xy_Values[0][q] = bb;
        aa = 1 + (int) (Math.random() * 39);
        bb = aa*20;
        E_xy_Values[1][q] = bb;
       }
       rescramble_E=false;
       }

     
      for (int kk = 0; kk < E_xy_Values.length; kk++) 
         {
            for(int ll = 0; ll < E_xy_Values[kk].length; ll++) 
            {
               if(E_xy_Values[0][ll] == x && E_xy_Values[1][ll] == y )
               {
                  score-=50;
                  E_xy_Values[0][ll]=-50000000;
                  E_xy_Values[1][ll]=-50000000;
                  Lives-=1;
               }
           }
         }
                 
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 1600, 800);
            player.setBounds(x,y,15*2,15*2);
            this.add(player);
//             g.setColor(Color.BLUE);
//             g.fillRect(x, y, 10, 10);
            // g.setColor(Color.BLUE);
//             g.fillRect(x+2, y+2, 2, 2);
//             g.fillRect(x+6, y+2, 2, 2);
//             g.fillRect(x+1, y+7, 8, 1);
            g.setColor(Color.RED);
    for (int i = 0; i < xy_Values.length; i++) 
     {
      for(int j = 0; j < xy_Values[i].length; j++) 
       {
         if(j==0){
         fuel.setBounds(xy_Values[0][j],xy_Values[1][j],15*2,15*2);
         this.add(fuel);
         } 
         if(j==1){
         fuel1.setBounds(xy_Values[0][j],xy_Values[1][j],15*2,15*2);
         this.add(fuel1);
         }  
         if(j==2){
         fuel2.setBounds(xy_Values[0][j],xy_Values[1][j],15*2,15*2);
         this.add(fuel2);
         }  
         if(j==3){
         fuel3.setBounds(xy_Values[0][j],xy_Values[1][j],15*2,15*2);
         this.add(fuel3);
         }      
       }
     }
     
     g.setColor(Color.MAGENTA);
     for (int y = 0; y < E_xy_Values.length; y++) 
     {
      for(int f = 0; f < E_xy_Values[y].length; f++) 
       {
         if(f==0){
         asteroid.setBounds(E_xy_Values[0][f],E_xy_Values[1][f],15*2,15*2);
         this.add(asteroid);
         } 
         if(f==1){
         asteroid1.setBounds(E_xy_Values[0][f],E_xy_Values[1][f],15*2,15*2);
         this.add(asteroid1);
         }  
         if(f==2){
         asteroid2.setBounds(E_xy_Values[0][f],E_xy_Values[1][f],15*2,15*2);
         this.add(asteroid2);
         }  
         if(f==3){
         asteroid3.setBounds(E_xy_Values[0][f],E_xy_Values[1][f],15*2,15*2);
         this.add(asteroid3);
         }   
       }
     }
              if(Lives>0){
     scoreDisplay.setText("score:"+score);
     lives.setText("lives:"+Lives);
         this.add(scoreDisplay);
         this.add(lives);
         }
         
         if(Lives<=0){
         menu="gameover";
         drawPanel.repaint();
         }
         
         g.setColor(Color.WHITE);
    for (int ii = 0; ii < backgroundstar_Values.length; ii++) 
     {
      for(int jj = 0; jj < backgroundstar_Values[ii].length-1; jj++) 
       {
       if(jj==0){
         star.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star);
         }
         if(jj==0){
         star.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star);
         }
         if(jj==1){
         star1.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star1);
         }
         if(jj==2){
         star2.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star2);
         }
         if(jj==3){
         star3.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star3);
         }
         if(jj==4){
         star4.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star4);
         }
         if(jj==5){
         star5.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star5);
         }
         if(jj==6){
         star6.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star6);
         }
         if(jj==7){
         star7.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star7);
         }
         if(jj==8){
         star8.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star8);
         }
         if(jj==9){
         star9.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star9);
         }
         if(jj==10){
         star10.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star10);
         }
         if(jj==11){
         star11.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star11);
         }
         if(jj==12){
         star12.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star12);
         }
         if(jj==13){
         star13.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star13);
         }
         if(jj==14){
         star14.setBounds(backgroundstar_Values[0][jj], backgroundstar_Values[1][jj], 20, 20);     
         this.add(star14);
         }
       }
     }
     
     for(int rr=0;rr<backgroundstar_Values[0].length;rr++)
        {
          if(backgroundstar_Values[0][rr]<=0)
          {
            backgroundstar_Values[0][rr]=1601+(int) (Math.random() * 15);
            int aaa=1 + (int) (Math.random() * 79);
            int bbb= aaa*10;
            backgroundstar_Values[1][rr]=bbb;
          }
          else if(backgroundstar_Values[0][rr]>0)
          {
            backgroundstar_Values[0][rr]-=2*2;
          } 
          } 
         
     for(int r=0;r<E_xy_Values[0].length;r++)
        {
          if(E_xy_Values[0][r]<x)
          {
            if(times_Completed>1){
            E_xy_Values[0][r]+=1;
            }
            else{
            E_xy_Values[0][r]+=1;
            }
          }
          else if(E_xy_Values[0][r]>x)
          {
            if(times_Completed>1){
            E_xy_Values[0][r]-=1;
            }
            else{
            E_xy_Values[0][r]-=1;
            }
          }
          if(E_xy_Values[1][r]<y)
          {
            if(times_Completed>1){
            E_xy_Values[1][r]+=1;
            }
            else{
            E_xy_Values[1][r]+=1;
            }
          } 
          else if(E_xy_Values[1][r]>y)
          {
          if(times_Completed>1){
            E_xy_Values[1][r]-=1;
            }
            else{
            E_xy_Values[1][r]-=1;
            }
          }  
          if(r==E_xy_Values[0].length-1){
          try
            {
            if(times_Completed>1){
                Thread.sleep(Math.round(50/times_Completed*2/2));
                }
                else{
                Thread.sleep(50);
                }
 
            } catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            moved=false;
          drawPanel.repaint();
          } 
        }
         }
        }
    
        public Dimension getPreferredSize() {
            return new Dimension(1600, 800);
        }
    }
       
    public static void main(String args[]) {
}
}