package pgdp.filter;

public final class Main {
	
	private Main() {}

	public static void main(String[] args) {

		VideoContainer in = null;
	    FrameProvider fp = new FrameProvider("noot.mp4");
		try {
			in = new VideoContainer(fp);
		} catch (Exception e) {
			System.out.println("An Exception was thrown when constructing new VideoContainer");
		}

		// limitiere Laufzeit
		//in.limit(250);

		// Grayscale
		//in.applyFunc(Operations::grayscale);
		//in.applyFunc(Operations.crop(800, 800));

		// Hochkant
		//in.applyFunc(Operations.crop(in.getProvider().getHeight() * 9 / 16, in.getProvider().getHeight()));
		in.applyFunc(Operations.crop(in.getProvider().getWidth() + 501, in.getProvider().getHeight() + 500));
		/*in.applyFunc(frame -> {
			System.out.println(frame.getPixels().getRGB(0, 0));
			return frame;
		});*/

		// Ausschreiben
		try {
		    FrameConsumer fc = new FrameConsumer(in.getProvider(), "out_finalFinal_Donev2.mp4", in.getProvider().getHeight() * 9 / 16, in.getProvider().getHeight());
			in.write(fc);
		} catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
			System.err.println("Error writing File");
		}
	}
}
