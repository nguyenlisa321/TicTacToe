import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel2 extends JPanel {
	
	private ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("linedpaper.png"));
	private Image img = imgIcon.getImage();
	private Graphics2D g2;
	private String title = "";
	private String x = "";
	private String o = "";
	private String winner = "";
	
	//Tie Game Panel
	public Panel2() {    
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	@Override
	 public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
	        Graphics2D g2 = (Graphics2D) g;
	        
	        g2.drawImage(img, 0, 0, null);    
	        g2.setPaintMode();
	        g2.setFont(new Font("Verdana",1,20));
	        g2.drawString(title, 100, 50);   
	        g2.drawString(x, 100, 250);
	        g2.drawString(o, 370, 250);
	        g2.drawString(winner, 250, 300);
     
	 }

	public void setString(String s, String x, String o, String winner){
		this.title = s;
		this.x = x;
		this.o = o;
		this.winner = winner;
	}
	
	
	

}
