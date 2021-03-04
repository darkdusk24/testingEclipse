import java.util.HashMap;

public class Converter {
	HashMap<String, String> alphabet = new HashMap<>();

	public Converter() {
		alphabet.put("A", "*-");
		alphabet.put("B", "-***");
		alphabet.put("C", "-*-*");
		alphabet.put("D", "-**");
		alphabet.put("E", "*");
		alphabet.put("F", "**-*");
		alphabet.put("G", "--*");
		alphabet.put("H", "****");
		alphabet.put("I", "**");
		alphabet.put("J", "*---");
		alphabet.put("K", "-*-");
		alphabet.put("L", "*-**");
		alphabet.put("M", "--");
		alphabet.put("N", "-*");
		alphabet.put("O", "---");
		alphabet.put("P", "*--*");
		alphabet.put("Q", "--*-");
		alphabet.put("R", "*-*");
		alphabet.put("S", "***");
		alphabet.put("T", "-");
		alphabet.put("U", "**-");
		alphabet.put("V", "***-");
		alphabet.put("W", "*--");
		alphabet.put("X", "-**-");
		alphabet.put("Y", "-*--");
		alphabet.put("Z", "--**");
		alphabet.put("1", "*----");
		alphabet.put("2", "**---");
		alphabet.put("3", "***--");
		alphabet.put("4", "****-");
		alphabet.put("5", "*****");
		alphabet.put("6", "-****");
		alphabet.put("7", "--***");
		alphabet.put("8", "---**");
		alphabet.put("9", "----*");
		alphabet.put("0", "-----");
		alphabet.put(".", "*-*-*-");
		alphabet.put(",", "--**--");
		alphabet.put("?", "**--**");
		alphabet.put("*-", "A");
		alphabet.put("-***", "B");
		alphabet.put("-*-*", "C");
		alphabet.put("-**", "D");
		alphabet.put("*", "E");
		alphabet.put("**-*", "F");
		alphabet.put("--*", "G");
		alphabet.put("****", "H");
		alphabet.put("**", "I");
		alphabet.put("*---", "J");
		alphabet.put("-*-", "K");
		alphabet.put("*-**", "L");
		alphabet.put("--", "M");
		alphabet.put("-*", "N");
		alphabet.put("---", "O");
		alphabet.put("*--*", "P");
		alphabet.put("--*-", "Q");
		alphabet.put("*-*", "R");
		alphabet.put("***", "S");
		alphabet.put("-", "T");
		alphabet.put("**-", "U");
		alphabet.put("***-", "V");
		alphabet.put("*--", "W");
		alphabet.put("-**-", "X");
		alphabet.put("-*--", "Y");
		alphabet.put("--**", "Z");
		alphabet.put("*----", "1");
		alphabet.put("**---", "2");
		alphabet.put("***--", "3");
		alphabet.put("****-", "4");
		alphabet.put("*****", "5");
		alphabet.put("-****", "6");
		alphabet.put("--***", "7");
		alphabet.put("---**", "8");
		alphabet.put("----*", "9");
		alphabet.put("-----", "0");
		alphabet.put("*-*-*-", ".");
		alphabet.put("--**--", ",");
		alphabet.put("**--**", "?");
	}

	// Kallas för att börja omvandlingen.
	public String getLetter(String letter) {
		String result = "";
		result = convert(letter);

		return result;
	}

	// Jag omvandlar engelska till morsekod och morsekod till engelska.
	// Detta görs bokstav för bokstav.
	private String convert(String letter) {
		letter = letter.toUpperCase();
		String result = "";
		int space = 0;

		if (letter.startsWith("-") || letter.startsWith("*")) {
			if (letter.indexOf(" ") != -1) {
				for (int i = 0; i <= countSpaces(letter); i++) {
					if (i != countSpaces(letter)) {
						if (alphabet.get(letter.substring(space, letter.indexOf(" ", space))) == null) {
							result = "Du skrev in en felaktig morsekod. Försök igen med rätt kod.";
							break;
						} else {
							result += alphabet.get(letter.substring(space, letter.indexOf(" ", space)));
							space = letter.indexOf(" ", space) + 1;
						}
					} else if (space != letter.length()) {
						if (alphabet.get(letter.substring(space)) == null) {
							result = "Du skrev in en felaktig morsekod. Försök igen med rätt kod.";
						} else {
							result += alphabet.get(letter.substring(space));
						}
					}
				}
			} else {
				if (alphabet.get(letter.substring(space)) == null) {
					result = "Du skrev in en felaktig morsekod. Försök igen med rätt kod.";
				} else {
					result += alphabet.get(letter);
				}
			}
		} else {
			for (int i = 0; i < letter.length(); i++) {
				if (!letter.substring(i, (i + 1)).equals(" ")) {
					if (alphabet.get(letter.substring(i, (i + 1))) == null) {
						result = "Skriv bara bokstäver ifrån det engelska alfabetet, siffror eller symbolerna . , ?";
						break;
					} else {
						result += alphabet.get(letter.substring(i, (i + 1))) + " ";
					}
				}
			}
		}

		return result;
	}

	// Räknar hur många mellanslag som finns i strängen för att avgöra hur många ord
	// som ska omvandlas.
	private int countSpaces(String letter) {
		boolean active = true;
		int spaces = 0;
		int lastSpace = 0;

		while (active) {
			if (letter.indexOf(" ", (lastSpace + 1)) != -1) {
				spaces++;
				lastSpace = letter.indexOf(" ", (lastSpace + 1));
			} else {
				active = false;
			}
		}

		return spaces;
	}

}
