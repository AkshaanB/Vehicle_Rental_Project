package testOptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class OptionTest {
	private Option option;

	@BeforeEach
	void initEach() {
		option = new Option();
	}

	@Test
	public void testingOption() {
		System.out.println("Enter option: ");
		Scanner input = new Scanner(System.in);
		int optionNum = option.optionhasInt(input);
		if (optionNum>=1 && optionNum<=7){
			System.out.println("Test case passed");
		}else {
			fail("Test case failed");
		}
	}

}
