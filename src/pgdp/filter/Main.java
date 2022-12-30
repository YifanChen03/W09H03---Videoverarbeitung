package pgdp.filter;

public final class Main {
	
	private Main() {}

	public static void main(String[] args) {

		VideoContainer in;
	    FrameProvider fp = new FrameProvider("noot.mp4");
		try {
			in = new VideoContainer(fp);
		} catch (Exception e) {

		}

		// limitiere Laufzeit
		//in.limit(250);

		// Grayscale
		//in.applyFunc(Operations::grayscale);

		// Hochkant
		//in.applyFunc(Operations.crop(in.getProvider().getHeight() * 9 / 16, in.getProvider().getHeight()));

		// Ausschreiben
//		try {
//		    FrameConsumer fc = new FrameConsumer(in.getProvider(), "out_finalFinal_Donev2.mp4", in.getProvider().getHeight() * 9 / 16, in.getProvider().getHeight());
//			in.write(fc);
//		} catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
//			System.err.println("Error writing File");
//		}
	}
}
