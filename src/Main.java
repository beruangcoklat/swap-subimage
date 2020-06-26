import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements ActionListener {

	private static ImageHelper imageController;
	private static JFrame frame;
	private static int indexImage = 0;
	
	private JButton btnNext, btnPrev;
	private MainPanel panel;
	
	public Main() {
		imageController = ImageHelper.getInstance();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		BufferedImage currImage = imageController.getImage(indexImage);
		frame.setSize(currImage.getWidth() + 10, currImage.getHeight() + 35);
		frame.setLayout(new BorderLayout());
		panel = new MainPanel(currImage);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(southPanel(), BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	private JPanel southPanel(){
		JPanel panel = new JPanel();
		btnNext = new JButton("Next");
		btnPrev = new JButton("Prev");
		panel.add(btnPrev);
		panel.add(btnNext);
		btnNext.addActionListener(this);
		btnPrev.addActionListener(this);
		return panel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.remove(panel);
		
		if(e.getSource() == btnNext) indexImage++;
		else if(e.getSource() == btnPrev) indexImage--;
		
		if(indexImage == -1) indexImage = imageController.getFileLength() - 1;
		else if(indexImage == imageController.getFileLength()) indexImage = 0;
		
		BufferedImage currImage = imageController.getImage(indexImage);
		panel = new MainPanel(currImage);
		frame.add(panel);
		frame.revalidate();
		frame.setSize(currImage.getWidth() + 10, currImage.getHeight() + 35);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public static int getWidth(){
		return imageController.getImage(indexImage).getWidth();
	}
	
	public static int getHeight(){
		return imageController.getImage(indexImage).getWidth();
	}
}
