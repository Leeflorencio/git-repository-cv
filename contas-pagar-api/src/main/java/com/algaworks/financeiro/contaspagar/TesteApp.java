package com.algaworks.financeiro.contaspagar;

import org.apache.commons.lang3.StringUtils;

public class TesteApp {
	public static void main(String[] args) {
		String nome = "Jo�o da Silva Souza";
		
		System.out.println(StringUtils.abbreviate(nome, 10));
	}

}
