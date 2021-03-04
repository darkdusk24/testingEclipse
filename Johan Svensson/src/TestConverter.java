import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConverter {

	@Test
	void testAReturnDotDash() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("A");

		// Assert
		assertEquals("*- ", answer);
	}

	@Test
	void testKReturnDashDotDash() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("K");

		// Assert
		assertEquals("-*- ", answer);
	}

	@Test
	void testDotReturnE() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("*");

		// Assert
		assertEquals("E", answer);
	}

	@Test
	void testDashDotReturnN() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("-*");

		// Assert
		assertEquals("N", answer);
	}

	@Test
	void testaReturnDotDash() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("a");

		// Assert
		assertEquals("*- ", answer);
	}

	@Test
	void test1ReturnDotDashDashDashDash() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("1");

		// Assert
		assertEquals("*---- ", answer);
	}

	@Test
	void testQuestionMarkReturnDotDotDashDashDotDot() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("?");

		// Assert
		assertEquals("**--** ", answer);
	}

	@Test
	void testYesReturnDashDotDashDashSpaceDotSpaceDotDotDot() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("Yes");

		// Assert
		assertEquals("-*-- * *** ", answer);
	}

	@Test
	void testDashDotDashDashSpaceDotSpaceDotDotDotReturnYES() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("-*-- * ***");

		// Assert
		assertEquals("YES", answer);
	}

	@Test
	void testHiSpaceHoReturnDotDotDotDotSpaceDotDotSpaceDotDotDotDotSpaceDashDashDash() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("Hi Ho");

		// Assert
		assertEquals("**** ** **** --- ", answer);
	}

	@Test
	void testÅMarkReturnLetterErrorMessage() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("Å");

		// Assert
		assertEquals("Skriv bara bokstäver ifrån det engelska alfabetet, siffror eller symbolerna . , ?", answer);
	}

	@Test
	void testDotDotDotDotDotDotMarkReturnMorseCodeErrorMessage() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("******");

		// Assert
		assertEquals("Du skrev in en felaktig morsekod. Försök igen med rätt kod.", answer);
	}

	@Test
	void testDotDotDotDotSpaceDotSpaceDotDotDotDotDotDotMarkReturnMorseCodeErrorMessage() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("**** * ******");

		// Assert
		assertEquals("Du skrev in en felaktig morsekod. Försök igen med rätt kod.", answer);
	}

	@Test
	void testDotDashDashDashDashDashSpaceDotMarkReturnMorseCodeErrorMessage() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("*----- *");

		// Assert
		assertEquals("Du skrev in en felaktig morsekod. Försök igen med rätt kod.", answer);
	}

	@Test
	void testDotDotDotDotSpaceDotSpaceMarkReturnHE() {
		// Arrange
		Converter con = new Converter();

		// Act
		String answer = con.getLetter("**** * ");

		// Assert
		assertEquals("HE", answer);
	}

}
