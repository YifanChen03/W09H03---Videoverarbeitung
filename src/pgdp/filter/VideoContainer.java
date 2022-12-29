package pgdp.filter;

import java.security.spec.ECField;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.lang3.NotImplementedException;

public class VideoContainer {

	private FrameProvider provider;

	private Stream<Frame> frameStream;
	
	/**
	 * Nutzt javacv um Videodatei darzustellen.
	 */
	public VideoContainer(FrameProvider fp) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}

	/**
	 * TODO: zu implementieren Appliziert Funktion auf den Frame Stream
	 *
	 * @param //checkFunction
	 */
	public void applyFunc(Function<Frame, Frame> function) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}

	public void limit(long frames) {

		// TODO: Implementieren
		throw new NotImplementedException();
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

	public void write(FrameConsumer fc) {

		// TODO: Implementieren
		throw new NotImplementedException();
	}
	
	private class FrameIterator implements Iterator<Frame> {
		private FrameProvider fp;
		private Frame current;
		public FrameIterator(FrameProvider fp) {
			this.fp = fp;
		}

		@Override
		public boolean hasNext() {
			// TODO: Implementieren
			try {
				return fp.nextFrame() != null;
			} catch (Exception e) {
				throw new NoSuchElementException();
			}
		}

		@Override
		public Frame next() {
			// TODO: Implementieren
			try {
				return fp.nextFrame();
			} catch (Exception e) {
				throw new NoSuchElementException();
			}
		}
	}
}
