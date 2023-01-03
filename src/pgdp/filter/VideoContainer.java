package pgdp.filter;

import java.io.FileNotFoundException;
import java.security.spec.ECField;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.NotImplementedException;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameRecorder;

public class VideoContainer {

	private FrameProvider provider;

	private Stream<Frame> frameStream;
	
	/**
	 * Nutzt javacv um Videodatei darzustellen.
	 */
	public VideoContainer(FrameProvider fp) throws FileNotFoundException, IllegalVideoFormatException {
		// TODO: Implementieren
		provider = fp;
		frameStream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				new FrameIterator(fp), Spliterator.ORDERED), false);
		if (!fp.fileExists()) {
			throw new FileNotFoundException();
		}
		if (fp.getHeight() == 0 || fp.getWidth() == 0) {
			throw new IllegalVideoFormatException();
		}
	}

	/**
	 * TODO: zu implementieren Appliziert Funktion auf den Frame Stream
	 *
	 * @param function
	 */
	public void applyFunc(Function<Frame, Frame> function) {
		// TODO: Implementieren
		//throw new NotImplementedException();
		frameStream = getFrameStream().map(function);
	}

	public void limit(long frames) {
		// TODO: Implementieren
		//throw new NotImplementedException();
		if (frames >= 0) {
			frameStream = getFrameStream().limit(frames);
		}
	}

	public FrameProvider getProvider() {
		return provider;
	}
	
	public void setProvider(FrameProvider provider) {
		this.provider = provider;
	}
	
	public Stream<Frame> getFrameStream() {
		return frameStream;
	}

	public void write(FrameConsumer fc) throws FrameRecorder.Exception {
		// TODO: Implementieren
		//throw new NotImplementedException();
		frameStream.forEach(frame -> {
			try {
				if (frame != null) {
					fc.consume(frame);
				}
			} catch (FFmpegFrameRecorder.Exception e) {
				throw new RuntimeException();
			}
		});
		/*FrameIterator fit = new FrameIterator(getProvider());
		while (fit.hasNext()) {
			System.out.println(fit.next().getFrameNumber());
		}*/
		fc.close();
	}
	
	private class FrameIterator implements Iterator<Frame> {
		private FrameProvider fp;
		private Frame current;
		private Frame next;
		public FrameIterator(FrameProvider fp) {
			this.fp = fp;
			current = null;
			try {
				next = this.fp.nextFrame();
			} catch (FFmpegFrameGrabber.Exception e) {
				next = null;
			}
		}

		@Override
		public boolean hasNext() {
			// TODO: Implementieren
			return next != null;
		}

		@Override
		public Frame next() {
			// TODO: Implementieren
			current = next;
			try {
				next = fp.nextFrame();
			} catch (FFmpegFrameGrabber.Exception e) {
				next = null;
			}
			if (current == null) {
				throw new NoSuchElementException();
			}
			return current;
		}

		/*FrameProvider fp;
		Frame current;
		public FrameIterator(FrameProvider fp) {
			this.fp = fp;
			current = null;
		}
		@Override
		public boolean hasNext() {
			try {
				current = fp.nextFrame();
				return current != null;
			} catch (FFmpegFrameGrabber.Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public Frame next() {
			if (current == null)
				throw new NoSuchElementException();
			return current;
		}*/
	}
}
