package testOptions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTest {
	
	private Type type;

	@BeforeEach
	void initEach() {
		type = new Type();
	}

	@Test
	public void testingOption() {
		System.out.println("Enter option: ");
		Scanner input = new Scanner(System.in);
		int optionNum = type.typehasInt(input);
		if (optionNum==1 || optionNum==2){
			System.out.println("Test case passed");
		}else {
			fail("Test case failed");
		}
	}

}
