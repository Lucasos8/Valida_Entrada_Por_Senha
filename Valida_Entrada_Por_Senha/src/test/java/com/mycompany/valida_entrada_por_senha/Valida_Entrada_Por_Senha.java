package com.mycompany.valida_entrada_por_senha;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class Valida_Entrada_Por_SenhaTest {

    @Test
    public void testSenhaInvalidaComErros() {
        ResultadoValidacao resultado = Valida_Entrada_Por_Senha.validarSenha("mypass");

        List<String> erros = resultado.erros;

        assertFalse(resultado.senhaValida);
        assertTrue(erros.contains("A senha deve ter pelo menos 8 caracteres"));
        assertTrue(erros.contains("A senha deve conter pelo menos 2 dígitos"));
        assertTrue(erros.contains("A senha deve conter pelo menos uma letra maiuscula"));
        assertTrue(erros.contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    public void testSenhaValida() {
        ResultadoValidacao resultado = Valida_Entrada_Por_Senha.validarSenha("Senha@123");

        assertTrue(resultado.senhaValida);
        assertTrue(resultado.erros.isEmpty());
    }
}
