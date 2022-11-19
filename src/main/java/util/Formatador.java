package util;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Formatador {
	
	public static String titulo(String texto) {
		List<String> palavras = Arrays.asList(texto.split(" "));
		
		String formatada = palavras.stream().reduce("", (t, u) -> t + capitalizar(u) + " ");
		
		return formatada.trim();
	}
	
	public static String capitalizar(String palavra) {
		String maiuscula = palavra.substring(0, 1).toUpperCase();
		String minusculas = palavra.substring(1).toLowerCase();
		return maiuscula.concat(minusculas);
	}
	
	public static String toTelefone(String numero) {
		String prefixo = String.format("(%s)", numero.substring(0, 2));
		int indiceHifen = isCelular(numero)? 7 : 6;
		String posfixo = numero.substring(2, indiceHifen) + "-" + numero.substring(indiceHifen);
		
		return prefixo.concat(posfixo);
	}
	
	private static boolean isCelular(String numero) {
		return numero.length() == 11;
	}	

}
