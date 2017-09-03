import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class Button extends JButton{

	ImageIcon X,O;
	private char holder = '\u0000';
	
	public Button() {
		X = new ImageIcon(this.getClass().getResource("X.png"));
		O = new ImageIcon(this.getClass().getResource("o.png"));
		this.setFocusPainted(false);
	}
	
	public void setHolder(char c){
		this.holder = c;
		if(holder == 'x'){
			setIcon(X);
		}
		else if(holder == 'o'){
			setIcon(O); 
		}
			
	}

	public char getHolder() {
		return holder;
	}

}
