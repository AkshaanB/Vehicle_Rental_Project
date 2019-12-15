package testOptions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerWorkTest {
	
	private ManagerWork managerWork;
	
	@BeforeEach
	void initEach() {
		managerWork = new ManagerWork();
	}
	
	@Test
	void plateNumbertest() {
		System.out.println("Enter plateNumber: ");
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		String plateNumber = managerWork.plateNumber(string);
		if (!(plateNumber.length()==8 || plateNumber.length()==7|| plateNumber.length()==6)){
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void capacitytest() {
		System.out.println("Enter capacity: ");
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String capacity = managerWork.capacity(string);
		if (!capacity.contains("cc")) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void transmissiontest() {
		System.out.println("Enter transmission: ");
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String transmission = managerWork.transmission(string);
		if (!(transmission.equalsIgnoreCase("auto")|| (transmission.equalsIgnoreCase("manual")))) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void fuelType() {
		System.out.println("Enter fuelType: ");
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String fuelType = managerWork.fuelType(string);
		if (!(fuelType.equalsIgnoreCase("petrol")|| (fuelType.equalsIgnoreCase("diesel")))) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	
	@Test
	void yearOfProduction() {
		System.out.println("Enter yearOfProduction: ");
		Scanner input = new Scanner(System.in);
		int integer = input.nextInt();
		int yearOfProduction = managerWork.yearOfProduction(integer);
		if (!(yearOfProduction<=2019)) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void noOfDoors() {
		System.out.println("Enter noOfDoors: ");
		Scanner input = new Scanner(System.in);
		int integer = input.nextInt();
		int noOfDoors = managerWork.noOfDoors(integer);
		if (!(noOfDoors<6 && noOfDoors>1)) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void noOfSeats() {
		System.out.println("Enter noOfSeats: ");
		Scanner input = new Scanner(System.in);
		int integer = input.nextInt();
		int noOfSeats = managerWork.noOfSeats(integer);
		if (!(noOfSeats<10 && noOfSeats>=2)) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void hybridStatus() {
		System.out.println("Enter hybridStatus: ");
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String hybridStatus = managerWork.hybridStatus(string);
		if (!((hybridStatus.equalsIgnoreCase("hybrid")|| (hybridStatus.equalsIgnoreCase("nonhybrid"))))) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void startType() {
		System.out.println("Enter startType: ");
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String startType = managerWork.startType(string);
		if (!((startType.equalsIgnoreCase("push")|| (startType.equalsIgnoreCase("key"))))) {
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
	
	@Test
	void bikeType() {
		System.out.println("Enter bikeType: ");
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String bikeType = managerWork.bikeType(string);
		if(!((bikeType.equalsIgnoreCase("scooty")|| (bikeType.equalsIgnoreCase("normal"))))){
			fail("Test case failed");
        }else {
			System.out.println("Test case passed");
		}
		input.close();
	}
}
