import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHelper {

	private static ImageHelper instance = new ImageHelper();
	private File[] files = new File("asset").listFiles();
	
	public static ImageHelper getInstance(){
		return instance;
	}
	
	public BufferedImage getImage(int param){
		try {
			return ImageIO.read(new File("asset/" + files[param].getName()));
		} catch (IOException e) {
			return null;
		}
	}
	
	public int getFileLength(){
		return files.length;
	}
	
}
