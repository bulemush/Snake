package task;

import java.net.URL;
import javax.swing.ImageIcon;

public class Imagephoto {
	public static URL bodyimage=Imagephoto.class.getResource("/Photo/body.png");
	public static ImageIcon bodyimg=new ImageIcon(bodyimage);
	
	public static URL downimage=Imagephoto.class.getResource("/Photo/down.png");
	public static ImageIcon downimg=new ImageIcon(downimage);

	public static URL upimage=Imagephoto.class.getResource("/Photo/up.png");
	public static ImageIcon upimg=new ImageIcon(upimage);

	public static URL leftimage=Imagephoto.class.getResource("/Photo/left.png");
	public static ImageIcon leftimg=new ImageIcon(leftimage);

	public static URL rightimage=Imagephoto.class.getResource("/Photo/right.png");
	public static ImageIcon rightimg=new ImageIcon(rightimage);
	
	public static URL foodimage=Imagephoto.class.getResource("/Photo/food.png");
	public static ImageIcon foodimg=new ImageIcon(foodimage);
	
	public static URL backgoundimage=Imagephoto.class.getResource("/Photo/backgound.png");
	public static ImageIcon backimg=new ImageIcon(backgoundimage);
}
