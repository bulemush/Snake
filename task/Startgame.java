package task;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Startgame {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		f.setBounds((width-800)/2, (height-800)/2, 800, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel gp=new Gamepanel();
		f.add(gp);
		f.setResizable(false);
		f.setVisible(true);
	}
}

class Gamepanel extends JPanel{
	int length;
	String direction="R";
	int[] snakex=new int[200];
	int[] snakey=new int[200];
	boolean isstart=false;
	boolean isdie=false;
	int foodx=(new Random().nextInt(29)+1)*25;
	int foody=(new Random().nextInt(26)+4)*25;
	int score=0;
	
	public void init() {
		length=3;
		score=0;
		direction="R";
		snakex[0]=175;
		snakey[0]=275;
		
		snakex[1]=150;
		snakey[1]=275;

		snakex[2]=125;
		snakey[2]=275;
	}

	public Gamepanel() {
		init();
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keycode=e.getKeyCode();
				if(keycode==KeyEvent.VK_SPACE) {
					if(isdie) {
						init();
						isdie=false;
					}else {
						isstart=!isstart;
						repaint();
					}
				}
				if(keycode==KeyEvent.VK_UP) {
					direction="U";
				}
				if(keycode==KeyEvent.VK_DOWN) {
					direction="D";
				}				
				if(keycode==KeyEvent.VK_LEFT) {
					direction="L";
				}
				if(keycode==KeyEvent.VK_RIGHT) {
					direction="R";
				}
			}
		});
		
		Timer timer =new Timer(100, new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(isstart==true && isdie==false) {
					for(int i=length-1;i>0;i--) {
						snakex[i]=snakex[i-1];
						snakey[i]=snakey[i-1];
					}
					if("R".equals(direction)) {
						snakex[0]+=25;
					}
					if("L".equals(direction)) {
						snakex[0]-=25;
					}
					if("U".equals(direction)) {
						snakey[0]-=25;
					}
					if("D".equals(direction)) {
						snakey[0]+=25;
					}
					
					if(snakex[0]<25) {
						snakex[0]=750;
					}
					if(snakey[0]<100) {
						snakey[0]=725;
					}
					if(snakey[0]>725) {
						snakey[0]=100;
					}
					if(snakex[0]>750) {
						snakex[0]=25;
					}
					if(snakex[0]==foodx&&snakey[0]==foody) {
						length++;
						
						foodx=(new Random().nextInt(29)+1)*25;
						foody=(new Random().nextInt(26)+4)*25;
						score+=10;
					}
					repaint();
				}
			}
		});
		timer.start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(208,220,226));

		g.setColor(new Color(123, 142, 163));
		g.fillRect(15, 10, 760, 80);  
		Imagephoto.backimg.paintIcon(this, g, 10, 70);

		Imagephoto.foodimg.paintIcon(this, g, foodx, foody);
		if("R".equals(direction)) {
			Imagephoto.rightimg.paintIcon(this, g, snakex[0], snakey[0]);
		}
		if("L".equals(direction)) {
			Imagephoto.leftimg.paintIcon(this, g, snakex[0], snakey[0]);
		}
		if("U".equals(direction)) {
			Imagephoto.upimg.paintIcon(this, g, snakex[0], snakey[0]);
		}
		if("D".equals(direction)) {
			Imagephoto.downimg.paintIcon(this, g, snakex[0], snakey[0]);
		}
		for(int i=1;i<length;i++) {
			Imagephoto.bodyimg.paintIcon(this, g, snakex[i],snakey[i]);
		}
		if(isstart==false) {
			g.setColor(new Color(114,98,255));
			g.setFont(new Font("微软雅黑",Font.BOLD,40));
			g.drawString("Start with space", 250, 330);
		}
		for(int i=1;i<length;i++) {
			if(snakex[0]==snakex[i] && snakey[0]==snakey[i]) {
				isdie=true;
			}
		}
		g.setColor(new Color(255,248,248));
		g.setFont(new Font("微软雅黑",Font.BOLD,20));
		g.drawString("Point "+score, 620, 40);
		
		if(isdie==true) {
			g.setColor(new Color(255,82,68));
			g.setFont(new Font("微软雅黑",Font.BOLD,20));
			g.drawString("FINISHED WITH "+score, 250, 330);

		}
	}
}