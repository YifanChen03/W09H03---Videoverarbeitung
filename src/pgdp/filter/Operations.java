
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
		Function<Frame, Frame> output = new Function<Frame, Frame>() {
			@Override
			public Frame apply(Frame frame) {
				int frameHeight = frame.getHeight();
				int frameWidth = frame.getWidth();
				BufferedImage framePixels = frame.getPixels();
				BufferedImage newFramePixels = framePixels;
				Frame outFrame;
				int cutOff;

				//if cropping to smaller height
				if (height < frameHeight) {
					int heightDiff = frameHeight - height;
					cutOff = heightDiff / 2;
					if (heightDiff % 2 == 0) {
						//cut off equal amount of pixels on top and on the bottom
						newFramePixels = newFramePixels.getSubimage(0, cutOff, frameWidth, heightDiff);
					} else {
						//cut off one more on the side that's further from the Pixel (0, 0)
						newFramePixels = newFramePixels.getSubimage(0, cutOff - 1, frameWidth, heightDiff);
					}
				}
				//if cropping to smaller width
				if (width < frameWidth) {
					int widthDiff = frameWidth - width;
					cutOff = width / 2;
					if (width % 2 == 0) {
						//cut off equal amount of pixels on left and rigth side
						newFramePixels = newFramePixels.getSubimage(cutOff, 0, widthDiff, frameHeight);
					} else {
						//cut off one more on the side that's further from the Pixel (0, 0)
						newFramePixels = newFramePixels.getSubimage(cutOff, 0, widthDiff - 1, frameHeight);
					}
				}
				//if cropping to bigger height
				if (height > frameHeight) {
					int heightDiff = height - frameHeight;
					cutOff = heightDiff / 2;
					if (heightDiff % 2 == 0) {
						//add equal amount of pixels on top and on the bottom
						newFramePixels = newFramePixels.getSubimage(0, cutOff, frameWidth,
								frameHeight + cutOff);
					} else {
						//add one more on the side that's further from the Pixel (0, 0)
						newFramePixels = newFramePixels.getSubimage(0, cutOff, frameWidth,
								frameHeight + cutOff + 1);
					}
				}
				//if cropping to bigger width
				if (width > frameWidth) {
					int widthDiff = width - frameWidth;
					cutOff = widthDiff / 2;
					if (widthDiff % 2 == 0) {
						//add equal amount of pixels on left and rigth side
						newFramePixels = newFramePixels.getSubimage(cutOff, 0, frameWidth + cutOff,
								frameHeight);
					} else {
						//add one more on the side that's further from the Pixel (0, 0)
						newFramePixels = newFramePixels.getSubimage(cutOff, 0, frameWidth + cutOff + 1,
								frameHeight);
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
		throw new NotImplementedException();
	}

	public static String decode(Frame frame) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}

}
