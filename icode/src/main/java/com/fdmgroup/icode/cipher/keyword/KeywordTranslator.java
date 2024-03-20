package com.fdmgroup.icode.cipher.keyword;

public class KeywordTranslator {
	
	private static String key;

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		KeywordTranslator.key = key;
	} 
	
	public static String encriptPhrase(String string) {
		
		//Base case
		if(!isValidInput(string)) {
			return "invalid";
		}
		StringBuilder encrypted = new StringBuilder();
		for(char character : string.toCharArray()) {
			if(character >= 'a' && character < 'z') {
				encrypted.append((char) (character+1));
			}
			else if(character == 'z') {
				encrypted.append('a');
			}
			else {
				encrypted.append(character);
			}
		}
		
		return encrypted.toString();
	}



	public static String decriptPhrase(String string) {
		if(!isValidInput(string)) {
			return "Invaild input";
		}
		StringBuilder decrypted = new StringBuilder();
		for(char character : string.toCharArray()) {
			if(character > 'a' && character <= 'z') {
				decrypted.append((char) (character-1));
			}
			else if(character == 'a') {
				decrypted.append('z');
			}
			else {
				decrypted.append((char) (character));
			}
		}
		return decrypted.toString();
	}
	private static boolean isValidInput(String string) {
		
		return string != null && !string.isEmpty();
	}
}
