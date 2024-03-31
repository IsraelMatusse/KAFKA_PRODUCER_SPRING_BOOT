package com.personalprojects.kafkaproducer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagamentoDto {

    private String  numeroConta;
    private BigDecimal valor;
    private String descricao;
}
