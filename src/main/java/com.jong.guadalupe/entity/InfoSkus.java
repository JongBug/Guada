package com.jong.guadalupe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoSkus {
    private Boolean atualizaInfoPreco;
    private String apresentacaoVariacao;
    private Boolean atualizaInfoPeso;
    private ArrayList<Detail> details;
}
