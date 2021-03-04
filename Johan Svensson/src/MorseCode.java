import java.util.Scanner;

public class MorseCode {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Converter convert = new Converter();
		String morse = "";
		System.out.println(
				"Vilken engelsk symbol/siffra/symbol eller morsekod vill du omvandla? * betyder punkt och - betyder streck.");
		morse = scan.nextLine();

		System.out.println(convert.getLetter(morse));

	}

}
