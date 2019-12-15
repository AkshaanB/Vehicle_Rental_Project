package testOptions;

import java.util.Scanner;

public class Type {
	public int typehasInt(Scanner input){
	    if(input.hasNextInt()) {
	        int option = input.nextInt();
            return option;
	    }else {
	    	System.err.println("It's not a int");
	    }
	    return 0;
    }
}
