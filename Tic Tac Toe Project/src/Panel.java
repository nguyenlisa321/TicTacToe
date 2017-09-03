import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
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


public class Panel extends JPanel implements ActionListener{
	
	private ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("linedpaper.png"));
	private Image img = imgIcon.getImage();
	private Graphics2D g2;
	private int x1, x2, y1, y2, smallx2, smally2;
	Timer time = new Timer(0, (ActionListener) this);
	
	public Panel() {
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
	        g2.setColor(Color.BLACK);
	        g2.setPaintMode();
	        g2.setStroke(new BasicStroke(10));
	        
	        g2.drawLine(180, 10, 180, 500);
	        g2.drawLine(360, 10, 360, 500);
	        g2.drawLine(10, 170, 540, 170);
	        g2.drawLine(10, 325, 540, 325);
	        
	        Graphics2D border = (Graphics2D) g;
	        
	        border.setColor(Color.BLACK);
	        border.draw(getBounds());
    
	        Graphics2D gWin = (Graphics2D) g;
	        
	        gWin.setPaintMode();
	        gWin.setStroke(new BasicStroke(10));  
	        gWin.setColor(Color.BLACK);
	        
	        animateLine(gWin);   
	 }

	public void setWinLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1; 
		this.y2 = y2;
		this.smallx2 = x1;
		this.smally2 = y1;
		
		time.start();	
	}
	
	public void animateLine(Graphics2D g){
	    g.drawLine(x1,y1,smallx2,smally2);   
	}
	
	public void actionPerformed(ActionEvent arg0) {
		int xDiff = x2 - smallx2;
		int yDiff = y2 - smally2;
	
		if(xDiff > 0) {
			smallx2++;
			repaint();
		}
		if(xDiff < 0){
			smallx2--;
			repaint();
		}
		
		if(yDiff > 0) {
			smally2++;
			repaint();
		}
		if(yDiff < 0){
			smally2--;
			repaint();
		}
	 }

}
