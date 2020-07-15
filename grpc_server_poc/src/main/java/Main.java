import java.io.IOException;

public class Main {
    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final PocServer server = new PocServer();
        server.start();
        server.blockUntilShutdown();
    }
}
