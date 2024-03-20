package com.fdmgroup.icode.cipher.grid;

public class GridCodeTranslator {
	/**
	 * 
	 * @param user input 
	 * @return encoded user information
	 */
	public static String encodeUserInput(String input) {
		
		StringBuilder encoded = new StringBuilder();
		for(char character : input.toCharArray()) {
			char shifted = (char) (character + 3); 
			encoded.append(shifted);
		}
		
		return encoded.toString();
	}
	/**
	 * 
	 * @param encoded user input
	 * @return original user input
	 */
	public static String decodeUserInput(String input) {
		
		StringBuilder decoded = new StringBuilder();
		for(char character : input.toCharArray()) {
			char shifted = (char) (character - 3);
			decoded.append(shifted);
		}
		return decoded.toString();
	}

}
