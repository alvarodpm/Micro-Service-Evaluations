package co.edu.uniandes.mati;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class ProofGrpcService implements  ProofGrpc {

    @Inject
    ObjectMapper mapper;

    private String list;

    @Override
    public Uni<ProofListReply> getListProof(ProofListRequest request) {
        list = ConsumeKafka.getList;
        list.replaceAll("\\\"","");
        return Uni.createFrom().item(list)
                .map(msg -> ProofListReply.newBuilder().setProofList(msg).build());
    }
}
