import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class TicTacToe extends JFrame{
	
	private TicTacToeButton[][] cell = new TicTacToeButton[3][3];
	private char turn = 'x';
	private char winner = '\u0000';
	private boolean gameOver = false;	
	private char loser3x3 = 'x';
	private String x = "";
	private String o = "";
	private String won = "";
	Panel panel;

	private static JFrame frame = new TicTacToe();
	
	
	public static void main(String[] args) {
		ImageIcon imgIcon = new ImageIcon(frame.getClass().getResource("xo.png"));
		Image img = imgIcon.getImage();
		frame.setIconImage(img);
		frame.setTitle("9x9 Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 550, 550);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
	public void setLoser3x3(char c){
		this.loser3x3 = c;
	}

	public TicTacToe() {
		
		panel = new Panel();
		
		//creates new game
		Button restart = new Button();
		restart.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == restart) {

		        frame.dispose();
		        frame = new TicTacToe();
		        frame.setTitle("9x9 Board");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setBounds(0, 0, 550, 550);
		        frame.setLocationRelativeTo(null); 
		        frame.setVisible(true);
				frame.setResizable(false); 
				
				}
			}
			
			

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        restart.setSize(60, 60);
        restart.setText("RESTART");
        restart.setFont(new Font("Verdana",1,20));
     
        restart.setOpaque(false);
		restart.setContentAreaFilled(false);
		restart.setBorderPainted(false);
		restart.setHorizontalAlignment(SwingConstants.TRAILING);
     
        
        Button exit = new Button();
        exit.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == exit) {

		        System.exit(0);
		        
				
				}
			}
			
			

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        exit.setSize(60, 60);
        exit.setText("EXIT");
        exit.setFont(new Font("Verdana",1,20));
        exit.setHorizontalAlignment(SwingConstants.TRAILING);
        exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		JPanel subPanel = new JPanel();
		subPanel.add(restart);
		subPanel.add(exit);
		add(subPanel, BorderLayout.SOUTH);
	       
        panel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        panel.setLayout(new GridLayout(3,3,3,3));
        
        //Creates buttons that give references to 3x3 boards
        for(int i = 0; i < 3; i ++) {
			 for(int j = 0; j < 3; j++) {
				 
				MainBoard m = new MainBoard(this);
        		TicTacToeButton b = new TicTacToeButton(m);
        		
        		//opens 3x3 board
        		b.addMouseListener( new MouseListener() {

    				@Override
    				public void mouseClicked(MouseEvent e) {
    					// TODO Auto-generated method stub
    					m.setTurn(loser3x3);
    			        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			        m.setBounds(0, 0, 550, 550);
    			        m.setLocationRelativeTo(null); 
    			     
    				    b.setHolder(m.getWinner()); 
    				    
    				    m.setVisible(true);
    			        frame.setVisible(false);
    			        m.setResizable(false);
    			        frame.setResizable(false);
    				}
    				
    				

    				@Override
    				public void mousePressed(MouseEvent e) {
    					// TODO Auto-generated method stub
    					
    				}

    				@Override
    				public void mouseReleased(MouseEvent e) {
    					// TODO Auto-generated method stub
    					
    					
   					
    					
    				}

    				@Override
    				public void mouseEntered(MouseEvent e) {
    					// TODO Auto-generated method stub
    					
    					
    				}

    				@Override
    				public void mouseExited(MouseEvent e) {
    					// TODO Auto-generated method stub
    					
    				}
    	        	
    	        });
        		
        		cell[i][j] = b;
        		b.setOpaque(false);
        		b.setContentAreaFilled(false);
        		b.setBorderPainted(false);
        		panel.add(b);		
			 } 	
        add(panel);  	
        }     
 }
 
	//triggers game over frame
	public void displayGameOver() {
		JFrame gameOverFrame = new JFrame();
        Panel2 gameOverPanel = new Panel2();
        ImageIcon imgIcon = new ImageIcon(frame.getClass().getResource("xo.png"));
		 Image img = imgIcon.getImage();
		gameOverFrame.setIconImage(img);
        gameOverPanel.setString("GAME OVER!!! The winner is: " + this.winner + "!", "", "", "");
        repaint();
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setBounds(0, 0, 600, 600);
        gameOverFrame.setLocationRelativeTo(null); 
        gameOverFrame.add(gameOverPanel, BorderLayout.CENTER);
        gameOverFrame.setVisible(true);
        frame.setVisible(false);
        gameOverFrame.setResizable(false);
        
        //creates new game
        Button restart = new Button();
		restart.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == restart) {

				gameOverFrame.dispose();
		        frame = new TicTacToe();
		        frame.setTitle("9x9 Board");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setBounds(0, 0, 550, 550);
		        frame.setLocationRelativeTo(null); 
		        frame.setVisible(true);
				frame.setResizable(false); 
				
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		restart.setSize(60, 60);
        restart.setText("PLAY AGAIN");
        restart.setFont(new Font("Verdana",1,20));
     
        restart.setOpaque(false);
		restart.setContentAreaFilled(false);
		restart.setBorderPainted(false);
        gameOverFrame.add(restart, BorderLayout.SOUTH );
	}

	//ends current game
	public void restart() throws Exception {
		Runtime.getRuntime().exec("java - jar TicTacToe.jar");
		System.exit(0);
	}
	
	//updates buttons and states of their mainboards
	 public void refresh(){
		  for(int i = 0; i < 3; i ++) {
				 for(int j = 0; j < 3; j++) {
				
					cell[i][j].setHolder(cell[i][j].getFrame().getWinner());

				 }
		  }
		  
		 //determines if game is over
		 if(isWon('x')) {
			 winner = 'x';
			 gameOver = true;
		 }
		  else if(isWon('o')){
			  winner = 'o';
			  gameOver = true;
		  }
		  else if (isFull ()) {
			tie();
		  } 
		 if(gameOver) {
			 displayGameOver();
			 return;
		}
	 }
	 
	 //checks if tie game
	 public boolean isFull() {
		
		 for(int i = 0; i < 3; i++) {
			 for(int j = 0; j < 3; j++) {
				if(cell[i][j].getHolder() == '\u0000') {
					return false;
				}
			 }
		 }
		 return true;
	 }

	 public boolean isWon(char c) {
		 //checks horizontal entries
		 for(int i = 0; i < 3; i++) {
			 if(cell[i][0].getHolder() == c && cell[i][1].getHolder() == c && cell[i][2].getHolder() == c) {
				 panel.setWinLine(0,900, 150*i+90, 150*i+90);
				 panel.repaint();
				 return true;
		 	}
		 }
		 //checks vertical entries
		 for(int j = 0; j < 3; j++) {
			 if(cell[0][j].getHolder() == c && cell[1][j].getHolder() == c && cell[2][j].getHolder() == c) {
				 panel.setWinLine(175*j+90, 175*j+90, 900, 0);
				 panel.repaint();
				 return true;
			 }
		 }
		 //checks diagonal entry
		 if(cell[0][0].getHolder() == c && cell[1][1].getHolder() == c && cell[2][2].getHolder() == c) {
			 panel.setWinLine(0, 500, 0, 500);
			 panel.repaint();
			 return true;
		 }
		 //checks other diagonal entry
		 if(cell[0][2].getHolder() == c && cell[1][1].getHolder() == c && cell[2][0].getHolder() == c) {
			 panel.setWinLine(500, 0, 500, 0);
			 panel.repaint();
			 return true;
		 }
		 return false;
	 }
	 
	 //triggers tie breaker frame
	 public void tie() {
			JFrame tieFrame = new JFrame();
	        Panel2 tiePanel = new Panel2();

	        ImageIcon imgIcon = new ImageIcon(frame.getClass().getResource("xo.png"));
			Image img = imgIcon.getImage();
			tieFrame.setIconImage(img);
	        
	        tiePanel.setBounds(0,0,600,600);
	        tiePanel.setString("Tie Game! Roll dice to see who wins!", x, o, won);

	        tieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        tieFrame.setBounds(0, 0, 600, 600);
	        tieFrame.setLocationRelativeTo(null); 
	        tieFrame.add(tiePanel, BorderLayout.CENTER);
	        tieFrame.setVisible(true);
	        frame.setVisible(false);
	        tieFrame.setResizable(false);
	        
	        //Player x dice roll
	        Button xRoll = new Button();
	        xRoll.setSize(100, 100);
	        xRoll.setText("X Roll");
	        xRoll.setFont(new Font("Verdana",1,20));
	        xRoll.addMouseListener(new MouseListener(){
	        	
				@Override
				public void mouseClicked(MouseEvent e) {
				
					//randomly creates number
					int max = 6;
					int min = 1;
					int range = (max - min) + 1;     
					int number =(int)(Math.random() * range) + min;

					x = Integer.toString(number);
					 
					tiePanel.setString("Tie Game! Roll dice to see who wins!", x, o, won);
				    tiePanel.repaint();
				        
				    int xInt = Integer.parseInt(x);
				    int oInt = Integer.parseInt(o);
				    
				    //compares player x and player o dice roll numbers, greater number wins
				    if(xInt > oInt) {
				        won = "x wins!";
				       	tiePanel.setString("Tie Game! Roll dice to see who wins!", x, o, won);
				       	tiePanel.repaint();
					    winner = 'x';
					    turn = 'o';
					} else if(xInt < oInt) {
						won = "o wins!";
				      	tiePanel.setString("Tie Game! Roll dice to see who wins!", x, o, won);
				      	tiePanel.repaint();
					    winner = 'o';
					    turn = 'x';
				    } else if(x == o){
				    	tiePanel.setString("Tie Game! Roll dice again to see who wins!", x, o, "Roll again");
					    tiePanel.repaint();	
				    }	
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
	        	
	        });
	        
	        xRoll.setOpaque(false);
	        xRoll.setContentAreaFilled(false);
	        xRoll.setBorderPainted(false);
	        tiePanel.add(xRoll);
	        xRoll.setBounds(75, 150, 100, 100);
	        
	        //Player o dice roll 
	        Button oRoll = new Button();
	        oRoll.setSize(120,100);
	        oRoll.setText("O Roll");
	        oRoll.setFont(new Font("Verdana",1,20));
	        oRoll.addMouseListener(new MouseListener(){
	        	
				@Override
				public void mouseClicked(MouseEvent e) {
				
					int max = 100;
					int min = 0;
					int range = (max - min) + 1;     
					int number =(int)(Math.random() * range) + min;
					  
					o = Integer.toString(number);

					tiePanel.setString("Tie Game! Roll dice to see who wins!", x, o, won);
				    tiePanel.repaint();
				        
				    int xInt = Integer.parseInt(x);
				    int oInt = Integer.parseInt(o);
				    
				    //compares player x and player o dice roll numbers, greater number wins
			        if(xInt > oInt) {
			        	won = "x wins!";
				       	tiePanel.setString("Tie Game! Roll dice to see who wins!", x, o, won);
					    tiePanel.repaint();
					    winner = 'x';
					    turn = 'o';    
				    } else if(xInt < oInt) {
				        won = "o wins!";
				       	tiePanel.setString("Tie Game! Roll dice to see who wins!", x, o, won);
					    tiePanel.repaint();
					    winner = 'o';
					    turn = 'x';
				    } else if(x == o){	
				        tiePanel.setString("Tie Game! Roll dice again to see who wins!", x, o, "Roll again");
					    tiePanel.repaint();   	
				    }	
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
	        	
	        });
	        
	        oRoll.setOpaque(false);
	        oRoll.setContentAreaFilled(false);
	        oRoll.setBorderPainted(false);
	        tiePanel.add(oRoll);
	        oRoll.setBounds(350, 150, 120, 100);	        
		}
}
