package pgdp.filter;

public class IllegalVideoFormatException extends Exception {
    public String toString() {
        return "One of the Dimensions of the FrameProvider is 0";
    }
}
