package com.fdmgroup.icode.cipher.pigpen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PigpenTranslator {
	
	public static List<String> encryptPhrase(String string) throws Exception{
		
		if(string.isBlank() || string.isEmpty()) {
			return Collections.emptyList();
		}
		
		Map<Character, String> pigpenMap = new HashMap<>();
		
		pigpenMap.put('a', "/cipher/pigpen/a.png");
		pigpenMap.put('b', "/cipher/pigpen/b.png");
		pigpenMap.put('c', "/cipher/pigpen/c.png");
		pigpenMap.put('d', "/cipher/pigpen/d.png");
		pigpenMap.put('e', "/cipher/pigpen/e.png");
		pigpenMap.put('f', "/cipher/pigpen/f.png");
		pigpenMap.put('g', "/cipher/pigpen/g.png");
		
		List<String> encrypted = new ArrayList<>();
		
		for(char character : string.toLowerCase().toCharArray()) {
			String imagePath = pigpenMap.get(character);
			if(imagePath != null) {
				encrypted.add(imagePath);
			}
			else {
				throw new Exception("Image path does not exist");
			}
		}
		
		return encrypted;
	}
	public static String decriptPhrase(List<String> pigPenLetters) throws Exception {
		
		if(pigPenLetters == null || pigPenLetters.isEmpty()) {
			return "Invalid Input";
		}
		
		Map<String, Character> revPigpenMap = new HashMap<>();
		
		revPigpenMap.put("/cipher/pigpen/a.png", 'a');
		revPigpenMap.put("/cipher/pigpen/b.png", 'b');
		revPigpenMap.put("/cipher/pigpen/c.png", 'c');
		revPigpenMap.put("/cipher/pigpen/d.png", 'd');
		revPigpenMap.put("/cipher/pigpen/e.png", 'e');
		revPigpenMap.put("/cipher/pigpen/f.png", 'f');
		revPigpenMap.put("/cipher/pigpen/g.png", 'g');
		
		StringBuilder decrypted = new StringBuilder();
		for(String imagePath : pigPenLetters) {
			Character character = revPigpenMap.get(imagePath);
			if( character != null) {
				decrypted.append(character);
			}
			else {
				throw new Exception("Unknown image path!");
			}
		}
		
		return decrypted.toString();
	}

}
