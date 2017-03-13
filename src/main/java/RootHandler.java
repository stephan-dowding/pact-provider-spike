import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by stephandowding on 9/3/17.
 */
public class RootHandler implements HttpHandler {
    public void handle(HttpExchange he) throws IOException {
        String response = "Blah";
        he.getResponseHeaders().add("Content-Type", "text/plain");
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
