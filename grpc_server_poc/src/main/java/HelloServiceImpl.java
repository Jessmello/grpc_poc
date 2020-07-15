import io.grpc.stub.StreamObserver;
import pb.HelloRequest;
import pb.HelloResponse;
import pb.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase{
    @Override
    public void hello(HelloRequest req, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse reply = HelloResponse.newBuilder().setMsg("Hello Mr. " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
