package br.com.crm.util;

import java.util.StringTokenizer;

public class Testes {

	public static void main(String[] args) {

		//STRING
		String s1 = "String Original";
		String s2 = new String("String Original") ;
		
		//String s2 = new String("String Original"); falso == e verdadeiro equals
		//String s2 = "String " +"Original"; verdadeiro == e equals
		//String s2 = "String Original"; verdadeiro == e equals
		//String s2 = new String(s1); falso == e verdadeiro equals
		//String s2 = s1; verdadeiro == e equals
		
		if(s1 == s2){
			System.out.println("== Verdadeiro");
		}else{
			System.out.println("== Falso");
		}
		
		if (s1.equals(s2)){
			System.out.println("equals verdadeiro");
		}else{
			System.out.println("equals falso");
		}
		
		
		//STRING BUFFER
		StringBuffer stb = new StringBuffer();
		stb.append("select ");
		stb.append("* from clientes ");
		stb.append("where clientes.id = 1 ");
		
		System.out.println(stb.toString());
		
		//StringTokenizer
		String linha = "teste$teste1$teste2";
		StringTokenizer stk = new StringTokenizer(linha,"$");
		
		while(stk.hasMoreTokens()){
			System.out.println(stk.nextToken());
		}
		
		
		
		
	}

}
