package co.edu.uniandes.mati;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

	@Override
	public Uni<HelloReply> sayHello(HelloRequest request) {
		return Uni.createFrom().item(ConsumeKafka.getList)
				.map(msg -> HelloReply.newBuilder().setMessage(msg).build());
	}



}
