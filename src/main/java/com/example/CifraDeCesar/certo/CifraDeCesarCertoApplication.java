package com.example.CifraDeCesar.certo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.text.Normalizer;
import java.util.regex.Pattern;

@SpringBootApplication
public class CifraDeCesarCertoApplication {

	public static void main(String[] args) throws Exception {

		Scanner t = new Scanner(System.in);
		Scanner v = new Scanner(System.in);
		char ascii;
		char x, y;
		String mens = t.nextLine().replaceAll("á|à|â|ã|ä", "a")
				.replaceAll("é|è|ê|ë", "e").replaceAll("Ì|Í|Î|Ï", "i")
				.replaceAll("Ò|Ó|Ô|Õ|Ö", "o").replaceAll("Ù|Ú|Û|Ü", "u")
				.replaceAll("\\p{Punct}","");


		System.out.println("");//chave será um número que deslocará a mensagem pela sua quantidade (msg 'a' e chave = 3, cifra= 'c')
		int chave = v.nextInt();
		while (chave >= 26) {//chave tem que ter o tamanho do alfabeto
			chave = chave - 26;
		}
		int tam = mens.length();
		for (int i = 0; i < tam; i++) {
			//Tratamento Letras minusculas
			if (mens.charAt(i) >= 97 && mens.charAt(i) <= 122) {//letrans minusculas de acordo com a tabela ASCII
				if ((int) (mens.charAt(i) + chave) > 122) {
					x = (char) (mens.charAt(i) + chave);
					y = (char) (x - 122);
					ascii = (char) (96 + y);
					System.out.print(ascii + " ");
				} else {
					ascii = (char) (mens.charAt(i) + chave);
					System.out.print(ascii + "");

				}
			}
			//Tratamento Letras mausculas
			else if (mens.charAt(i) >= 65 && mens.charAt(i) <= 90) {
				if (mens.charAt(i) + chave > 90) {
					x = (char) (mens.charAt(i) + chave);
					y = (char) (x - 90);
					ascii = (char) (64 + y);
					System.out.print(ascii + " ");
				} else {
					ascii = (char) (mens.charAt(i) + chave);
					System.out.print(ascii + " ");
				}
			} else {
				System.out.print(mens.charAt(i));
			}
		}
	}
}
