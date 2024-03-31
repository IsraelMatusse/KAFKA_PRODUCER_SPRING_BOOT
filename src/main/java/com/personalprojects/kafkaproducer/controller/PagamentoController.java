package com.personalprojects.kafkaproducer.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.personalprojects.kafkaproducer.dto.PagamentoDto;
import com.personalprojects.kafkaproducer.service.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRequestProducer pagamentoRequestProducer;

    @PostMapping
    public String pagamento(@RequestBody PagamentoDto pagamento) throws JsonProcessingException {
        return pagamentoRequestProducer.sendMessage(pagamento);
    }
}
