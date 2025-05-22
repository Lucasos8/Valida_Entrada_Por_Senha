package com.mycompany.valida_entrada_por_senha;

import java.util.ArrayList;
import java.util.List;

public class Valida_Entrada_Por_Senha {

    public static ResultadoValidacao validarSenha(String senha) {
        List<String> erros = new ArrayList<>();

        // Requisito 1: pelo menos 8 caracteres
        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        // Requisito 2: pelo menos 2 dígitos
        int digitos = 0;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                digitos++;
            }
        }
        if (digitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        // Requisito 3: pelo menos uma letra maiúscula
        boolean temMaiuscula = senha.chars().anyMatch(Character::isUpperCase);
        if (!temMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        // Requisito 4: pelo menos um caractere especial
        boolean temEspecial = senha.matches(".[^a-zA-Z0-9].");
        if (!temEspecial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        boolean senhaValida = erros.isEmpty();
        return new ResultadoValidacao(senhaValida, erros);
    }

    // Método main para execução direta (opcional)
    public static void main(String[] args) {
        ResultadoValidacao resultado = validarSenha("mypass");
        if (resultado.senhaValida) {
            System.out.println("Senha válida!");
        } else {
            System.out.println("Senha inválida:");
            resultado.erros.forEach(System.out::println);
        }
    }
}