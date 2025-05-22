package com.mycompany.valida_entrada_por_senha;

import java.util.List;

public class ResultadoValidacao {
    public boolean senhaValida;
    public List<String> erros;

    public ResultadoValidacao(boolean senhaValida, List<String> erros) {
        this.senhaValida = senhaValida;
        this.erros = erros;
    }
}
