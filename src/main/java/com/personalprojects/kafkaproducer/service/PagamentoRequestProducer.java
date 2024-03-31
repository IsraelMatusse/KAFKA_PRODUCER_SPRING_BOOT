package com.personalprojects.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalprojects.kafkaproducer.dto.PagamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestProducer {

    @Value("${topicos.pagamento.request.topic}")
    private String pagamentoRequestTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String>kafkaTemplate;

    public String sendMessage(PagamentoDto pagamento) throws JsonProcessingException {
        try {
            String content = objectMapper.writeValueAsString(pagamento);
            kafkaTemplate.send(pagamentoRequestTopic, content);
            return "Pagamento enviado com sucesso";
        }catch (JsonProcessingException e){
            return "Houve um erro ao solicitar pagamento " +e.getMessage();
        }
    }

}
