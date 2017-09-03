import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class MainBoard extends JFrame {
	
private Button[][] cell = new Button[3][3];
private char turn = 'x';
private ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("linedpaper.png"));
private Image img = imgIcon.getImage();
private boolean gameOver = false;	
private TicTacToe t;
JLabel label = new JLabel("");
private char winner = '\u0000';
JFrame frame;

private String x = "";
private String o = "";
private String won = "";
Panel panel;

	public MainBoard(TicTacToe t) {
			frame = this;
			ImageIcon imgIcon = new ImageIcon(frame.getClass().getResource("xo.png"));
			Image img = imgIcon.getImage();
			frame.setIconImage(img);
			this.setTitle("3x3");
	        panel = new Panel();
	        panel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
	        panel.setLayout(new GridLayout(3,3,3,3));

	        //creates buttons
	        for(int i = 0; i < 3; i ++) {
				 for(int j = 0; j < 3; j++) {

				
	        		Button b = new Button();
	        		b.addMouseListener( new MouseListener() {

	    				@Override
	    				public void mouseClicked(MouseEvent e) {
	    					
	    					if(gameOver) {		
	    						 return;
	    					}
	    					
	    					//alternates turns
	    					if (b.getHolder() == '\u0000' && turn != '\u0000')
	    						b.setHolder(turn);
	    					
	    					//keeps track of who won to determine who starts next game		
	    					if(isWon('o')) {
	    						label.setText( "o won! Game over!");
	    						winner = 'o';
	    						t.setLoser3x3('o');;
	    						turn = '\u0000';
	    						gameOver = true;
	    					 }
	    					 else if(isWon('x')) {
		    					label.setText( "x won! Game over!");
		    					winner = 'x';
		    					t.setLoser3x3('x');;
		    					turn = '\u0000';
		    					gameOver = true;				
		    				 }
	    					 else if (isFull ()) {
	    						label.setText("Tie game! Game over!");
	    						turn = '\u0000';
	    						tie();
	    						gameOver = true;
	    					 } 
	    					 else { 
	    						if(turn == 'x')
	    							turn = 'o';
	    						else if(turn == 'o')
	    							turn = 'x';
	    							label.setText(turn + "'s turn.");
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
	        		cell[i][j] = b;
	        		b.setOpaque(false);
	        		b.setContentAreaFilled(false);
	        		b.setBorderPainted(false);
	        		panel.add(b);
				 }
	        		
	        } 
	        label.setBorder(new LineBorder(Color.yellow, 1));
	        add(panel);  
	        add(label, BorderLayout.SOUTH);
	        
	        //Closes current 3x3 board and opens 9x9 board
	        Button reset = new Button();
	        reset.setSize(60, 60);
	        reset.setText("BACK");
	        reset.setFont(new Font("Verdana",1,20));
	        reset.addMouseListener(new MouseListener(){
	        	
				@Override
				public void mouseClicked(MouseEvent e) {
					t.setVisible(true);
					frame.setVisible(false);
					t.refresh();	
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
	        reset.setOpaque(false);
    		reset.setContentAreaFilled(false);
    		reset.setBorderPainted(false);
	        add(reset, BorderLayout.SOUTH );
	    
	 }
	
	public void setGameOver(boolean b){
		gameOver = b;
	}
	
	public char getWinner() {
		return this.winner;
	}
	
	public void setWinner(char c) {
		this.winner = c;
	}

	public void setTurn(char c){
		this.turn = c;
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
				 panel.setWinLine(0,150*i+90, 900, 150*i+90);
				 panel.repaint();
				 return true;
			 }
		 }
		//checks vertical entries
		 for(int j = 0; j < 3; j++) {
			 if(cell[0][j].getHolder() == c && cell[1][j].getHolder() == c && cell[2][j].getHolder() == c) {
				 panel.setWinLine(175*j+90, 0, 175*j+90, 900);
				 panel.repaint();
				 return true;
			 }
		 }
		//checks diagonal entry
		 if(cell[0][0].getHolder() == c && cell[1][1].getHolder() == c && cell[2][2].getHolder() == c) {
			 panel.setWinLine(0, 0, 500, 500);
			 panel.repaint();
			 return true;
		 }
		//checks other diagonal entry
		 if(cell[0][2].getHolder() == c && cell[1][1].getHolder() == c && cell[2][0].getHolder() == c) {
			 panel.setWinLine(0, 500, 500, 0);
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
				    t.setLoser3x3(turn);
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
				   t.setLoser3x3(turn);	
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

	        Button reset = new Button();
	        reset.setText("BACK");
	        reset.setFont(new Font("Verdana",1,20));
	        reset.addMouseListener(new MouseListener(){
	        	
				@Override
				public void mouseClicked(MouseEvent e) {
				
					frame.setVisible(true);
					tieFrame.setVisible(false);
					t.refresh();
					
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
	        reset.setOpaque(false);
    		reset.setContentAreaFilled(false);
    		reset.setBorderPainted(false);
	        tiePanel.add(reset);
	        reset.setBounds(225, 500, 100, 60);   
		}
}
