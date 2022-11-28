package pgdp.filter;

import java.util.Iterator;
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
	 * @param checkFunction
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

		@Override
		public boolean hasNext() {
			// TODO: Implementieren
			throw new NotImplementedException();
		}

		@Override
		public Frame next() {
			// TODO: Implementieren
			throw new NotImplementedException();
		}
		
	}
}
