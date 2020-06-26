import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements MouseListener {
	
	private BufferedImage img[][] = new BufferedImage[3][3];
	private Point imgBefore = null;
	private boolean swap = true;
	
	
	public MainPanel(BufferedImage full) {
		for(int i=0 ; i<3 ; i++){
			for(int j=0 ; j<3 ; j++){
				int width = Main.getWidth() / 3;
				int height = Main.getHeight() / 3;
				img[i][j] = full.getSubimage(j*width, i*height, width, height);
			}
		}
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0 ; i<3 ; i++){
			for(int j=0 ; j<3 ; j++){
				int width = Main.getWidth() / 3;
				int height = Main.getHeight() / 3;
				g.drawImage(img[i][j], j*width, i*height, width, height, null);
			}
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX() / (Main.getWidth()/3);
		int y = e.getY() / (Main.getHeight()/3);
		
		System.out.println("");
		
		swap = !swap;
		if(swap == true){
			BufferedImage temp = img[y][x].getSubimage(0, 0, img[y][x].getWidth(), img[y][x].getHeight());
			img[y][x] = img[imgBefore.y][imgBefore.x];
			img[imgBefore.y][imgBefore.x] = temp;
		}
		else{
			imgBefore = new Point(x, y);
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	
}
