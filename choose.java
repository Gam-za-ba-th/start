import java.awt.*;
import javax.swing.*;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
// import com.sun.prism.paint.Color;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Attributes;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javazoom.jl.player.Player;
import jdk.internal.org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.BufferedInputStream;

import javax.sound.sampled.*;

public class choose extends JFrame
{
	JFrame chooseFrame;
	
	JPanel choosePanel;
	
	JButton crossButton, malangButton, matchingButton, tetrisButton;
	
	ImageIcon crossImage, malangImage, matchingImage, tetrisImage;

	public choose()
	{
		chooseFrame = new JFrame();
		chooseFrame.setTitle("choose game");
		
		//chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseFrame.setLocationRelativeTo(null);
		
		choosePanel = new JPanel();
		choosePanel.setLayout(new GridLayout(2,2,15,15));
		
		chooseFrame.getContentPane().add(choosePanel, BorderLayout.CENTER);

        displayWidgets();

        chooseFrame.setSize(1280, 720);
        chooseFrame.setVisible(true); 
	}
	
	public void displayWidgets() 
    {  	
		crossImage = new ImageIcon("button_icon/crossword.png");
		crossButton = new JButton("cross-word", crossImage);
		crossButton.setFont(new Font ("고딕",Font.BOLD,20));
		crossButton.setForeground(Color.BLUE);
		crossButton.setBackground(Color.WHITE);
		choosePanel.add(crossButton);
		
		crossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PuzzleGUI();
            }
            
        });
		
		malangImage = new ImageIcon("button_icon/brain.png");
		malangButton = new JButton("malang-malang-brain-game", malangImage);
		malangButton.setFont(new Font ("고딕",Font.BOLD,20));
		malangButton.setForeground(Color.BLUE);
		malangButton.setBackground(Color.white);
		choosePanel.add(malangButton);
		
		malangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new malang();
            }
            
        });
		
		matchingImage = new ImageIcon("button_icon/matching_card.png");
		matchingButton = new JButton("matching_card", matchingImage);
		matchingButton.setFont(new Font ("고딕",Font.BOLD,20));
		matchingButton.setForeground(Color.BLUE);
		matchingButton.setBackground(Color.white);
		choosePanel.add(matchingButton);
		
		matchingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new MatchingCards();
            }
            
        });
		
		tetrisImage = new ImageIcon("button_icon/tetris.png");
		tetrisButton = new JButton("tetris", tetrisImage);
		tetrisButton.setFont(new Font ("고딕",Font.BOLD,20));
		tetrisButton.setForeground(Color.BLUE);
		tetrisButton.setBackground(Color.white);
		choosePanel.add(tetrisButton);
		
		tetrisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new tetris();
            }
            
        });
	}
	
	public static void main(String[] args)
	{
		choose frame = new choose();
	}
}

class malang extends JFrame implements ActionListener 
{
	JFrame malangFrame;
	
	JPanel malangPanel;
	
	JButton animalButton, numberButton, smallButton;
	
	ImageIcon animalImage, numberImage, smallImage;
	
	public malang()
	{
		malangFrame = new JFrame();
		malangFrame.setTitle("malang game");
			
		malangPanel = new JPanel();
		malangPanel.setLayout(new GridLayout(0,3,5,5));
		
		malangFrame.getContentPane().add(malangPanel, BorderLayout.CENTER);

        displayWidgets();

        malangFrame.setSize(1280, 700);
        malangFrame.setVisible(true); 
	}
	
	public void displayWidgets() 
    {  
		animalImage = new ImageIcon("malang_select/animalImage.png");
		/* animalButton.setFont(new Font ("고딕",Font.BOLD,20));
		animalButton.setForeground(Color.BLUE);
		animalButton.setBackground(Color.white); */
		animalButton = new JButton("", animalImage);
		malangPanel.add(animalButton);
		
		animalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new animal();
            }
            
        });
		
		numberImage = new ImageIcon("malang_select/numberImage.png");
		numberButton = new JButton("", numberImage);
		malangPanel.add(numberButton);
		
		numberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new number();
            }
            
        });
		
		smallImage = new ImageIcon("malang_select/smallImage.png");
		smallButton = new JButton("",smallImage);
		malangPanel.add(smallButton);
		
		smallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new small();
            }
            
        });
		
	}
	
	public static void main(String[] args)
	{
		malang frame = new malang();
	}
}

class number implements ActionListener 
{
       JFrame numberFrame;

       JPanel numberPanel;

       JTextField guessText;

       JLabel rangeLabel, guessLabel, winLabel, scoreLabel;
       
       JButton scoreButton;
       
       ImageIcon number, success, upfail, downfail, numberguess;

       Random rand = new Random();
       int Answer = rand.nextInt(30)+1;
       int guess;
       
       int count = 0;
       boolean win = false;
       int score;

      public number() 
      {
           numberFrame = new JFrame();
           numberFrame.setTitle("Number Guess");
           
           numberPanel = new JPanel();
           numberPanel.setLayout(new GridLayout(5,0));
           
           numberFrame.getContentPane().add(numberPanel, BorderLayout.CENTER);

           displayWidgets();
           
           numberFrame.setSize(500,1000);
           numberFrame.setVisible(true);  
       }

       public void displayWidgets() 
       {  

           guessText = new JTextField();
           guessText.setHorizontalAlignment(JTextField.CENTER);
           
           number = new ImageIcon("malang_select/numberImage.png");
           rangeLabel = new JLabel(number, SwingConstants.CENTER);
           /* rangeLabel.setFont(new Font("굴림", Font.BOLD, 30));
           rangeLabel.setForeground(Color.GREEN); 
           rangeLabel.setBackground(Color.WHITE); */
           
           numberguess = new ImageIcon("malang_select/numberguess.png");
           guessLabel = new JLabel(numberguess, SwingConstants.CENTER);
           /* guessLabel.setFont(new Font("굴림", Font.CENTER_BASELINE, 20)); */
           
           winLabel = new JLabel(" ", SwingConstants.CENTER);
           
           ImageIcon scoreicon = new ImageIcon("malang_select/score.png");
           scoreButton = new JButton("", scoreicon);
           scoreButton.setPressedIcon(scoreicon);
           scoreButton.addMouseListener(new MyMouseListener());

           guessText.addActionListener(this);

           numberPanel.add(rangeLabel);
           numberPanel.add(guessLabel);
           numberPanel.add(guessText);
           numberPanel.add(winLabel);
           numberPanel.add(scoreButton);
          
       }

       public void actionPerformed(ActionEvent event) 
       {        
           guess = Integer.parseInt(guessText.getText());

           if ( guess == Answer)
           {
        	   success = new ImageIcon("malang_select/success.png");
               count ++;
               // winLabel.setText("정답입니다");
               winLabel.setIcon(success);
               winLabel.setBackground(java.awt.Color.white);
               
               winLabel.setFont(winLabel.getFont().deriveFont(20.0f));
               scoreButton.setEnabled(true);
           }
           else if ( guess < Answer)
           {
        	   upfail = new ImageIcon("malang_select/upfail.png");
               // winLabel.setText("너무 작은 숫자입니다");
        	   winLabel.setIcon(upfail);
               // winLabel.setFont(winLabel.getFont().deriveFont(20.0f));
               // winLabel.setForeground(Color.BLUE);
               count ++;
               scoreButton.setEnabled(false);
           }
           else if ( guess > Answer)
           {
        	   downfail = new ImageIcon("malang_select/downfail.png");
               //winLabel.setText("너무 큰 숫자입니다");
        	   winLabel.setIcon(downfail);
               winLabel.setFont(winLabel.getFont().deriveFont(20.0f));
               //winLabel.setForeground(Color.BLUE);
               count ++;
               scoreButton.setEnabled(false);
           }
           
           if (count > 30) score = 10;
           if (count < 20 && count > 10) score = 20;
           if (count < 10 && count > 5) score = 30;
           if (count < 5 && count > 1) score = 40;
           if (count == 1) score = 50;
           
           JOptionPane.showMessageDialog(null, count, "시도 횟수", JOptionPane.INFORMATION_MESSAGE);

       }
       
       class MyMouseListener implements MouseListener{
           @Override
           public void mouseClicked(MouseEvent e) {
        	   if (e.getSource() == scoreButton)
        		   scoreButton.setText(""+ score);
			}

           @Override
           public void mouseEntered(MouseEvent arg0) {

           }

           @Override
           public void mouseExited(MouseEvent arg0) {
		
			
           }

           @Override
           public void mousePressed(MouseEvent arg0) {
			
			
           }

           @Override
           public void mouseReleased(MouseEvent arg0) {
			
			
           }
       }
       
       public static void main(String[] args)
       {
           number frame = new number();
       } 
}

class animal implements ActionListener{
	static String[] images = {
			"animal_image/BSM20.jpg", "animal_image/CAO18.jpg", "animal_image/CCO14.jpg", "animal_image/DOS22.jpg",
			"animal_image/DSC18.jpg", "animal_image/MDS16.jpg", "animal_image/PCC8.jpg", "animal_image/SCP14.jpg"
	};
	
	JFrame legFrame;
	
	JPanel legPanel, imagePanel;
	
	JLabel guessLabel, titleLabel, scoreLabel, textLabel, imageLabel;
	
	ImageIcon imageIcon, animal, animalguess;
	
	JButton scoreButton;
	
	JTextField guessText;
	
	int i;
	
	Random rand = new Random();
    int index = rand.nextInt(8)+1;
    
    int guess;
    int answer;
    int score = 30;
    
    public animal()
	{
		
		legFrame = new JFrame();
		legFrame.setTitle("동물 다리 개수 맞추기");

		
		legPanel = new JPanel();
		legPanel.setLayout(new GridLayout(5,0));
		
        legFrame.getContentPane().add(legPanel, BorderLayout.CENTER);

		
		displayWidgets();
	
		legFrame.pack();
        legFrame.setVisible(true);
	}
    
    public void displayWidgets() 
    {
    	animal = new ImageIcon("malang_select/animalImage.png");
    	titleLabel = new JLabel(animal, SwingConstants.CENTER);
	    /* titleLabel.setFont(new Font("굴림", Font.BOLD, 30));*/
			
	    animalguess = new ImageIcon("malang_select/animalguess.png");
	    guessLabel = new JLabel(animalguess, SwingConstants.CENTER);
	    /* guessLabel.setFont(new Font("굴림", Font.CENTER_BASELINE, 20)); */
	     
	    textLabel = new JLabel(" ", SwingConstants.CENTER);
	    
	    guessText = new JTextField();
	    guessText.setHorizontalAlignment(JTextField.CENTER);
	    guessText.addActionListener(this);

	    imageIcon = new ImageIcon(images[index]);
	    imageLabel = new JLabel(imageIcon);
	    
	    ImageIcon scoreicon = new ImageIcon("malang_select/score.png");
        scoreButton = new JButton(scoreicon);
        scoreButton.setPressedIcon(scoreicon);
        scoreButton.addMouseListener(new MyMouseListener());

	    legPanel.add(titleLabel);
	    legPanel.add(guessLabel);
	    legPanel.add(imageLabel);
	    legPanel.add(guessText);
	    legPanel.add(scoreButton);
	    
	    if (index == 0)	answer = 20;
	    if (index == 1) answer = 18;
	    if (index == 2) answer = 14;
	    if (index == 3) answer = 22;
	    if (index == 4) answer = 18;
	    if (index == 5) answer = 16;
	    if (index == 6) answer = 8;
	    if (index == 7) answer = 14;

    }
    
    public void actionPerformed(ActionEvent event) 
    {        
    	guess = Integer.parseInt(guessText.getText());

        if (guess == answer)
        {
            score++;
            JOptionPane.showMessageDialog(null, "정답입니다", "", JOptionPane.INFORMATION_MESSAGE);
            scoreButton.setEnabled(true);
        }
        
        else
        {
        	score--;
        	JOptionPane.showMessageDialog(null, "오답입니다", "", JOptionPane.INFORMATION_MESSAGE);
        	scoreButton.setEnabled(false);
        }
	}
    
    class MyMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
     	   if (e.getSource() == scoreButton)
     		   scoreButton.setText("점수는 " + score);
			}

        @Override
        public void mouseEntered(MouseEvent arg0) {

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
		
			
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
			
			
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
			
			
        }
    }
    
    public static void main(String[] args)
    {
        animal frame = new animal();
    } 
}

class small extends JFrame{
    int c=0;
    int score;
    
    JButton b;
    
    static long beforeTime = System.currentTimeMillis();
    JLabel[] la=new JLabel[20];
    small(){
        this.setTitle("작은 숫자 빠르게 클릭하기");

        this.setLayout(null);
        for(int i=0; i<20; i++){
            la[i]= new JLabel("");
            la[i].setText(""+i);
            la[i].setSize(30,30);
            la[i].setFont(new Font ("", Font.BOLD, 20));
            int x=(int)(Math.random()*450);
            int y=(int)(Math.random()*450);
            la[i].setLocation(x,y);
            
            la[i].addMouseListener(new MyMouseListener());
            this.add(la[i]);
        }
        this.setSize(500, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(java.awt.Color.blue);

        }
    class MyMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
        	
        	long afterTime = 0;
        	JLabel a =(JLabel)e.getSource();
            if(la[c]==a){
                la[c].setText("");
                a.setText("");
                c++;
            }
            
            if (c > 19) {
            	afterTime = System.currentTimeMillis();
            	JOptionPane.showMessageDialog(null, "성공하셨습니다", "성공", JOptionPane.INFORMATION_MESSAGE);
            	
            }
            
            long secDiffTime = (afterTime - beforeTime) / 1000;
            if (c > 19)
            {         
            
            	if (secDiffTime > 50) score = 10;
            	if (secDiffTime < 50 && secDiffTime > 40) score = 20;
            	if (secDiffTime < 40 && secDiffTime > 30) score = 30;
            	if (secDiffTime < 30 && secDiffTime > 20) score = 40;
            	if (secDiffTime < 20) score = 50;

            	JOptionPane.showMessageDialog(null, secDiffTime, "걸린 시간", JOptionPane.INFORMATION_MESSAGE);
            	JOptionPane.showMessageDialog(null, score, "점수", JOptionPane.INFORMATION_MESSAGE);

            }
            
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public static void main(String[] args) {
        new small();
    }
}

class tetris extends JFrame {
	   Container c = getContentPane();
	   TetrisPanel TP = new TetrisPanel();
	   JDialog JD = new JDialog();
	   TetrisThread th;
	   
	   static int blocksize = 20;
	   
	   int End = 0;
	   int random = 0 , random2 = (int)(Math.random()*7);
	   
	   int score =0;
	   
	   int wid=100;
	   int hgt= 0;
	   int rotation = 0;
	   
	   boolean limit = false;
	   
	   int curX[]= new int[4], curY[] = new int [4]; // 블록들의 좌표 저장
	   
	   int blocks[][][][]  = 
	      {
	         {
	            //■
	            //■■■
	            {
	               {0,0,0,0},
	               {1,0,0,0},
	               {1,1,1,0},
	               {0,0,0,0}
	            },
	            {
	               {0,1,1,0},
	               {0,1,0,0},
	               {0,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {1,1,1,0},
	               {0,0,1,0},
	               {0,0,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,1,0},
	               {0,0,1,0},
	               {0,1,1,0},
	               {0,0,0,0}
	            }
	         },
	         {
	               //  ■
	               //■■■
	            {
	               {0,0,0,0},
	               {0,0,1,0},
	               {1,1,1,0},
	               {0,0,0,0}
	            },
	            {
	               {0,1,0,0},
	               {0,1,0,0},
	               {0,1,1,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,0,0},
	               {1,1,1,0},
	               {1,0,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,1,1,0},
	               {0,0,1,0},
	               {0,0,1,0},
	               {0,0,0,0}
	            }
	         },
	         {
	               //  ■■
	               //  ■■
	            {
	               {0,0,0,0},
	               {1,1,0,0},
	               {1,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,0,0},
	               {1,1,0,0},
	               {1,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,0,0},
	               {1,1,0,0},
	               {1,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,0,0},
	               {1,1,0,0},
	               {1,1,0,0},
	               {0,0,0,0}
	            }
	         },
	         {
	               // ■■■■
	            {
	               {0,0,0,0},
	               {0,0,0,0},
	               {1,1,1,1},
	               {0,0,0,0}
	            },
	            {
	               {0,1,0,0},
	               {0,1,0,0},
	               {0,1,0,0},
	               {0,1,0,0}
	            },
	            {
	               {0,0,0,0},
	               {0,0,0,0},
	               {1,1,1,1},
	               {0,0,0,0}
	            },
	            {
	               {0,1,0,0},
	               {0,1,0,0},
	               {0,1,0,0},
	               {0,1,0,0}
	            }
	         },
	         {
	                //■
	               //■■■
	            {
	               {0,0,0,0},
	               {0,1,0,0},
	               {1,1,1,0},
	               {0,0,0,0}
	            },
	            {
	               {0,1,0,0},
	               {0,1,1,0},
	               {0,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,0,0},
	               {1,1,1,0},
	               {0,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,1,0,0},
	               {1,1,0,0},
	               {0,1,0,0},
	               {0,0,0,0}
	            }   
	         },
	         {
	                //  ■■
	                //   ■■
	            {
	               {0,0,0,0},
	               {1,1,0,0},
	               {0,1,1,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,1,0},
	               {0,1,1,0},
	               {0,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,0,0},
	               {1,1,0,0},
	               {0,1,1,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,1,0},
	               {0,1,1,0},
	               {0,1,0,0},
	               {0,0,0,0}
	            }
	         },
	         {
	                //  ■■
	               //  ■■
	            {
	               {0,0,0,0},
	               {0,1,1,0},
	               {1,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,1,0,0},
	               {0,1,1,0},
	               {0,0,1,0},
	               {0,0,0,0}
	            },
	            {
	               {0,0,0,0},
	               {0,1,1,0},
	               {1,1,0,0},
	               {0,0,0,0}
	            },
	            {
	               {0,1,0,0},
	               {0,1,1,0},
	               {0,0,1,0},
	               {0,0,0,0}
	            }   
	         }
	   };
	   
	   int[][] gameboard = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	                     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	                     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

	   JButton btn = new JButton("재도전");
	   JLabel lbl = new JLabel();
	   JLabel lbl2 = new JLabel();
	      
	   tetris(){
	      setTitle("테트리스");
	      setLayout(null);
	      TP.setSize(720,600);
	      
	      add(TP);
	      
	      th = new TetrisThread();
	      
	      // JDialog 
	      JD.setTitle("점수");
	      JD.setSize(250,190);
	      JD.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 30));
	      
	      
	      
	      lbl.setFont(new Font("arial",Font.PLAIN,15));
	      lbl2.setText("점  수");
	      lbl2.setFont(new Font("나눔고딕",Font.PLAIN,15));
	      
	      
	      TP.addKeyListener(new KeyAdapter(){
	            public void keyPressed(KeyEvent e){
	               int keyCode = e.getKeyCode();
	                        
	               if(keyCode == KeyEvent.VK_UP)
	                  TP.moveUp();
	               if(keyCode == KeyEvent.VK_DOWN)
	                  TP.moveDown();
	               if(keyCode == KeyEvent.VK_LEFT)
	                  TP.moveLeft();
	               if(keyCode == KeyEvent.VK_RIGHT)
	                  TP.moveRight();
	            }
	         });
	      
	      btn.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	            limit = false;
	            for(int y=0; y<19;y++)
	               for(int x=1; x<12; x++)
	                  gameboard[y][x] =0 ;
	            score =0;
	            wid =100; hgt = 0;
	         }
	      });
	      
	      TP.setBackground(Color.WHITE);
	      setSize(530,520);
	      setVisible(true);


	      // 화면 중앙 정렬
	      Dimension frameSize = this.getSize();
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
	      JD.setLocation((screenSize.width - frameSize.width)/2 + 220, (screenSize.height - frameSize.height)/2 +220);
	      
	      
	      TP.requestFocus(true);
	      th.start();
	   }
	   
	   
	   
	   class TetrisPanel extends JPanel{
	      public void paintComponent(Graphics g){
	         
	         int cnt = 0 , cnt2 = 0;
	         TP.requestFocus(true);
	         super.paintComponent(g);
	         
	         
	         lbl2.setLocation(353,120);
	         TP.add(lbl2);
	         
	         lbl.setLocation(360,145);
	         TP.add(lbl);
	         lbl.setText(Integer.toString(score*100));
	         
	         g.setColor(Color.ORANGE); // 새로 떨어지는 블럭,미리보기  블럭 색깔
	         
	         // 다음 나올 도형 출력
	         blockLookAhead(g);
	         
	         // 벽이 천장에 닿으면 게임 오버
	         gameOverCheck();
	                
	         // 한 행이 모두 블록으로 채워진 경우 블록들 제거(채워지지않은 경우 블록 떨어지도록)
	         removeBlock(cnt, cnt2, g);
	         
	         // 블록이 벽에 착지하면 블록->벽으로 변환(떨어지는 블록 초기화)
	         blockToWall();
	         
	         // 벽들을 생성
	         makeBlock(g);
	         
	         // 테두리 생성
	         makeBorder(g);
	       
	       
	         if(End == 1){
	            random2 = (int)(Math.random()*7);
	            End = 0;
	         }
	      }
	      
	      public void blockLookAhead(Graphics g){
	         for(int a = 0; a<4 ;a++){
	              for(int b = 0; b<4;b++){
	                 if(blocks[random2][0][a][b] == 1){
	                    g.fill3DRect(b*blocksize+120, a*blocksize, blocksize, blocksize, true);
	                 }
	              }
	          }
	      }
	      
	      public void gameOverCheck(){
	         for(int x=1;x<12;x++)
	             if(gameboard[2][x]==1){
	                limit = true;
	                
	               
	                //lbl.setLocation(50,50);
	                JD.add(lbl);
	                JD.add(btn);
	               
	                //btn.setLocation(50,30);
	                JD.setVisible(true);
	             }
	      }
	      
	      public void removeBlock(int cnt, int cnt2, Graphics g){
	         for(int y =0;y<19;y++){
	             for(int x =1; x<12 ; x++){
	                if(gameboard[y][x] == 1){
	                   cnt2++;
	                }
	             }
	             if(cnt2 == 11){
	                for(int i=y;i>1;i--)
	                   for(int j=1;j<13;j++){
	                      gameboard[i][j] = 0;
	                      gameboard[i][j] = gameboard[i-1][j];
	                   }
	               score++;
	             }else{
	                blockDown(cnt,g); // 한 행이 모두 블록으로 채워지지 않을 때만 블록이 내려가도록 함
	             }
	             cnt2 = 0 ;
	          }
	      }
	      
	      public void makeBlock(Graphics g){
	         g.setColor(Color.GRAY); 
	          for(int y=0; y<19;y++){
	             for(int x=1; x<12; x++){
	                if(gameboard[y][x]== 1){
	                   g.fill3DRect( x*blocksize+20, y*blocksize+60, blocksize, blocksize, true);
	                }
	             }
	          }
	      }
	      
	      public void blockDown(int cnt, Graphics g){
	         for(int j = 0; j<4 ;j++){
	              for(int k = 0; k<4;k++){
	                 if(blocks[random][rotation][j][k] == 1){
	                    curX[cnt] = ((k*blocksize)+wid)/blocksize; curY[cnt] = ((j*blocksize)+hgt)/blocksize;//curX,Y[0][1][2][3]에 좌표 4개 저장
	                    g.fill3DRect(curX[cnt]*blocksize+20, curY[cnt]*blocksize+60, blocksize, blocksize, true);
	                    
	                    cnt ++;
	                 }
	              }
	           }
	      }
	      
	      // 떨어지던 블록이 벽이 되는지 검사
	      // 벽이 되면 wid=120, hgt=0 으로 블록 초기화, rotation도 초기화 
	      public void blockToWall(){
	         try{
	         for(int z = 0; z<4 ; z++)
	              if(gameboard[curY[z]+1][curX[z]] == 1)
	                    for (int j= 0; j<4;j++){
	                      
	                          gameboard[curY[j]][curX[j]] = 1;
	                          wid =100; 
	                          hgt =0;
	                          End = 1;
	                          rotation = 0;
	                          random = random2;
	                    }
	         }catch(ArrayIndexOutOfBoundsException e){ System.out.println("Error");
	         for(int i=0; i<4 ; i++)
	               System.out.print("("+curY[i]+","+curX[i]+")");
	            System.out.println();}
	        
	         
	      }
	      
	      // 왼쪽 벽에 충돌하면 못움직이도록
	      public int collision_LEFT(){
	         for(int i=0; i<4; i++){
	            if(gameboard[curY[i]][curX[i]-1] == 1)  // 충돌시 1 반환
	               return 1;
	         }
	         return 0; // 충돌하지 않으면 0 반환
	      }
	      
	      // 오른쪽 벽에 충돌하면 못 움직이도록
	      public int collision_RIGHT(){

	         for(int i=0; i<4; i++){
	            if(gameboard[curY[i]][curX[i]+1] == 1)   // 충돌시 1반환
	               return 1;
	         }
	         return 0; // 충돌하지 않으면 0반환
	      }
	      
	      // curX,Y에 다음 회전 도형의 절대좌표를 모두 기록해두고, 만약 오른쪽이나 왼쪽 X좌표1,2칸 안에 벽이 있으면 그만큼 오른쪽 혹은 왼쪽으로 밀어서 배치
	      public void rotationCheck(){
	       // curX,Y에 다음 회전 도형의 절대좌표를 모두 기록해두고, 밑에 구문에서 그 절대좌표의 값이 벽에 닿는지 판단
	         int cnt2=0;
	          for(int j = 0; j<4 ;j++){
	              for(int k = 0; k<4;k++){
	                 int rotation2 = (rotation%4)+1 ;
	                 if(rotation2 == 4)
	                    rotation2 = 0;
	                 if(blocks[random][rotation2][j][k] == 1){
	                    curX[cnt2] = ((k*blocksize)+wid)/blocksize; curY[cnt2] = ((j*blocksize)+hgt)/blocksize;
	                    cnt2++;
	                 }    
	              }
	          }
	          
	       // curX,Y에 저장된 좌표를 이용
	          int chk = 0;
	          int blank =0;
	          int error = 0;
	           // 왼쪽 벽
	             
	                
	                      if(gameboard[curY[0]][curX[0]] == 1 || (random == 6 && gameboard[curY[2]][curX[2]] == 1) || (random == 1 && gameboard[curY[1]][curX[1]] ==1 )){
	                         chk = 1; // 만약 다음 회전한 도형의 위치가 벽과 겹친다면 chk=1로 표시함           
	                         error++;
	                         System.out.println("chk1");
	                         if(random == 3){ // 일자막대의 경우 회전할 여유가 있는 공백이 없으면 회전막음
	                            for(int i=1;i<5;i++)
	                               if(gameboard[curY[0]][curX[0]+i] == 0)
	                                  blank++;
	                            if(blank < 4)
	                               chk = 4;
	                            
	                              System.out.println(blank);
	                         }else{ // 그 외의 경우 회전할 여유가 없는 공백이 없으면 회전 막음
	                            for(int i=1; i<4;i++)
	                               if(gameboard[curY[0]][curX[0]+i] == 0)
	                                  blank++;
	                            if(blank <3)
	                               chk = 4;
	                            System.out.println("blank2");
	                            System.out.println(blank);
	                         }
	                         
	                      }
	            
	          //오른쪽 벽
	             
	                 
	                      else if(gameboard[curY[2]][curX[2]] == 1){
	                        error++;
	                       chk = 2; // 만약 다음 회전한 도형의 위치가 벽과 겹친다면 chk=2로 표시함  
	                       System.out.println("chk2");
	                       
	                       for(int i=1; i<5;i++)
	                          if(gameboard[curY[2]][curX[2]-i] == 0)
	                             blank ++;
	                       if(blank < 4)
	                          chk = 4;
	                       System.out.println("blank2");
	                       System.out.println(blank);
	                             
	                       
	                    }
	                      else if(gameboard[curY[3]][curX[3]] == 1){
	                       error++;
	                       chk = 3; // 만약 다음 회전한 도형의 위치가 벽과 겹친다면 chk=3로 표시함    
	                       System.out.println("chk3");
	                       for(int i=0; i<5;i++)
	                          if(gameboard[curY[3]][curX[3]-i] == 0)
	                             blank ++;
	                       if(blank < 4)
	                          chk = 4;
	                       System.out.println(blank);
	                       
	                    }
	                 
	             
	          
	          
	          if(chk == 1){ // chk = 1(다음 회전한 도형의 위치가 벽과 중복되면)면 wid(가로)로 30이동
	             wid += blocksize;
	             rotation++;
	             rotation = rotation%4;
	            }else if (chk ==2){
	               wid -= blocksize*2;
	               rotation++;
	               rotation = rotation%4;
	            }else if (chk ==3){
	               wid -= blocksize;
	               rotation++;
	               rotation = rotation%4;
	            }else if(chk == 4){
	               System.out.println("ban");
	            }else{
	               rotation++;
	                rotation = rotation%4;
	            }
	      
	          
	      }
	      
	      public void makeBorder(Graphics g){
	         g.setColor(Color.GRAY);
	         
	         g.draw3DRect(28, 70, 5, 375,true); // 기둥
	         g.draw3DRect(265, 70, 5, 375, true); // 기둥
	         g.draw3DRect(15, 445, 270, 5,true); // 바닥
	         g.draw3DRect(15, 65, 270, 5, true); // 천장
	      }
	      
	      void down(){
	         hgt +=blocksize;
	         TP.repaint();
	      }
	      void moveUp(){
	         rotationCheck();
	          if(limit == false)
	             repaint();
	      }
	      void moveDown(){
	         if(limit == false){
	            hgt += blocksize;
	            TP.repaint();
	         }
	      }
	      void moveLeft(){
	         int sel = collision_LEFT();// sel이 1이면 충돌, 0이면 충돌X
	         if(sel == 0 && limit == false){
	            wid -= blocksize;
	               TP.repaint();
	         }
	      }
	      void moveRight(){
	         int sel = collision_RIGHT();// sel이 1이면 충돌, 0이면 충돌X
	         if(sel == 0 && limit == false){ 
	            wid += blocksize;
	            TP.repaint();
	         }
	      }
	   }
	   
	   class TetrisThread extends Thread{
	      TetrisPanel TP = new TetrisPanel();
	      public void run(){
	         while(true){
	            try{
	               sleep(500);
	               if(limit == false) // limit이 false일 경우에만 작동. true가 되면 테트리스 작동중지
	                  TP.down();
	            }catch(InterruptedException e){
	               return;
	            }
	         }
	      }
	   }
	   
	   public static void main(String[] args){
	      new tetris();
	   }
	}
