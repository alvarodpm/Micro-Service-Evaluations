package co.edu.uniandes.mati;

import java.util.List;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uniandes.mati.entity.Input;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.SneakyThrows;

@ApplicationScoped
public class ConsumeKafka {

    @Inject
    Logger log;
    @Inject
    ObjectMapper mapper;

    public static String getList;
    @SneakyThrows
    @Incoming("uniandes-payment")
    public void consumeKafkaMessage(String listProof) {
        log.info(listProof);
        List<Input> list = mapper.readValue(listProof, new TypeReference<>() {
        });
        getList = list.toString();
    }
}
