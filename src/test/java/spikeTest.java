import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Created by stephandowding on 9/3/17.
 */

@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("Some Provider") // Set up name of tested provider
@PactBroker(host = "localhost", port = "80")
public class spikeTest {

    private static final int PORT = 8765;
    private static final Server server = new Server();

    @BeforeClass //Method will be run once: before whole contract test suite
    public static void setUpService() throws IOException {
        //Run DB, create schema
        //Run service
        //...
        server.start(PORT);
    }

    @AfterClass
    public static void tearDownService() {
        server.stop();
    }

    @State(value="test state") // Method will be run before testing interactions that require "default" or "no-data" state
    public void toDefaultState() {
        // Prepare service before interaction that require "default" state
        // ...
        System.out.println("Now service in default state");
    }

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(PORT);
}
