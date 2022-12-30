
package pgdp.filter;

import java.awt.*;
import java.util.function.Function;

import org.apache.commons.lang3.NotImplementedException;

public final class Operations {
	
	//Verstecke den Konstruktor einer utility KlasseS
	private Operations() {}

	public static Frame grayscale(Frame frame) {
		// TODO: Implementieren
		int frameHeight = frame.getHeight();
		int frameWidth = frame.getWidth();

		//for every pixel in frame get the RGB and set it to Grayscale
		for (int w = 0; w < frameWidth; w++) {
			for (int h = 0; h < frameHeight; h++) {
				int px_rgb = frame.getPixels().getRGB(h, w);
				int r, g, b;
				int grayscaleRGB;
				Color px_color = new Color(px_rgb);
				r = px_color.getRed();
				g = px_color.getGreen();
				b = px_color.getBlue();
				//grayscaleRGB is the value for Red, Green and Blue
				grayscaleRGB = (int) (0.299 * r + 0.587 * g + 0.114 * b);
				//convert into one rgb int
				int rgb = new Color(grayscaleRGB, grayscaleRGB, grayscaleRGB).getRGB();
				frame.getPixels().setRGB(h, w, rgb);
			}
		}

		return frame;
	}

	public static Function<Frame, Frame> crop(int width, int height) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}

	public static Function<Frame, Frame> encode(String msg) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}

	public static String decode(Frame frame) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}

}
