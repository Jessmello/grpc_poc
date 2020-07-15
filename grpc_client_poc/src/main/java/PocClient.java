import io.grpc.StatusRuntimeException;
import io.grpc.Channel;
import pb.HelloRequest;
import pb.HelloResponse;
import pb.HelloServiceGrpc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PocClient {
    private static final Logger logger = Logger.getLogger(PocClient.class.getName());

    private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    public PocClient(Channel channel) {
        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = HelloServiceGrpc.newBlockingStub(channel);
    }

    public void hello(String name) {
        logger.info("Will try to greet " + name + " ...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloResponse response;
        try {
            response = blockingStub.hello(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getMsg());
    }

}
