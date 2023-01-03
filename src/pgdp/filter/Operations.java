
package pgdp.filter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Function;

import org.apache.commons.lang3.NotImplementedException;

public final class Operations {
	
	//Verstecke den Konstruktor einer utility KlasseS
	private Operations() {}

	public static Frame grayscale(Frame frame) {
		// TODO: Implementieren
		if (frame == null) {
			return null;
		}
		int frameHeight = frame.getHeight();
		int frameWidth = frame.getWidth();

		//for every pixel in frame get the RGB and set it to Grayscale
		for (int w = 0; w < frameWidth; w++) {
			for (int h = 0; h < frameHeight; h++) {
				int px_rgb = frame.getPixels().getRGB(w, h);
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
				frame.getPixels().setRGB(w, h, rgb);
			}
		}

		return frame;
	}

	public static Function<Frame, Frame> crop(int width, int height) {
		// TODO: Implementieren
		Function<Frame, Frame> output = new Function<Frame, Frame>() {
			@Override
			public Frame apply(Frame frame) {
				int frameHeight = frame.getHeight();
				int frameWidth = frame.getWidth();
				BufferedImage framePixels = frame.getPixels();
				BufferedImage newFramePixels = framePixels;
				Frame outFrame;
				int cutOff;

				if (height > 0) {
					//if cropping to smaller height
					if (height < frameHeight) {
						int heightDiff = frameHeight - height;
						cutOff = heightDiff / 2;
						//cut off equal amount of pixels on top and on the bottom
						//cut off one more Pixel on the side that's further from the Pixel (0, 0)
						newFramePixels = newFramePixels.getSubimage(0, cutOff, newFramePixels.getWidth(),
								height);
					}
					//if cropping to bigger height
					if (height > frameHeight) {
						int heightDiff = height - frameHeight;
						cutOff = heightDiff / 2;
						//add equal amount of pixels on top and on the bottom
						//add one more on the side that's further from the Pixel (0, 0)
						//also works for both the same way
						//source: https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
						BufferedImage tempBI = new BufferedImage(newFramePixels.getWidth(), height,
								newFramePixels.getType());
						//color all Pixels Black
						for (int w = 0; w < tempBI.getWidth(); w++) {
							for (int h = 0; h < tempBI.getHeight(); h++) {
								tempBI.setRGB(w, h, Color.BLACK.getRGB());
							}
						}
						Graphics2D graphics = tempBI.createGraphics();
						graphics.drawImage(newFramePixels, 0, cutOff, null);
						graphics.dispose();

						newFramePixels = tempBI;
					}
				}

				if (width > 0) {
					//if cropping to smaller width
					if (width < frameWidth) {
						int widthDiff = frameWidth - width;
						cutOff = widthDiff / 2;
						//cut off equal amount of pixels on left and rigth side
						//cut off one more Pixel on the side that's further from the Pixel (0, 0)
						newFramePixels = newFramePixels.getSubimage(cutOff, 0,
								width, newFramePixels.getHeight());
					}
					//if cropping to bigger width
					if (width > frameWidth) {
						int widthDiff = width - frameWidth;
						cutOff = widthDiff / 2;
						//add equal amount of pixels on left and rigth side
						//add one more on the side that's further from the Pixel (0, 0)
						BufferedImage tempBI = new BufferedImage(width, newFramePixels.getHeight(),
								newFramePixels.getType());
						//color all Pixels Black
						for (int w = 0; w < tempBI.getWidth(); w++) {
							for (int h = 0; h < tempBI.getHeight(); h++) {
								tempBI.setRGB(w, h, Color.BLACK.getRGB());
							}
						}
						Graphics2D graphics = tempBI.createGraphics();
						graphics.drawImage(newFramePixels, cutOff, 0, null);
						graphics.dispose();

						newFramePixels = tempBI;
					}
				}
				outFrame = new Frame(newFramePixels, frame.getFrameNumber());
				return outFrame;
			}
		};
		return output;
	}

	public static Function<Frame, Frame> encode(String msg) {
		// TODO: Implementieren
		Function<Frame, Frame> output = new Function<Frame, Frame>() {
			@Override
			public Frame apply(Frame frame) {
				return null;
			}
		};

		return output;
	}

	public static String decode(Frame frame) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}

}
