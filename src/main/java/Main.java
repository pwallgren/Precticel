import com.petwal.server.EmbeddedJettyServer;

public class Main {

    public static void main(String[] args) throws Exception {
        new EmbeddedJettyServer("/", "com.petwal").start(8080);
    }
}
