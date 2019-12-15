package testOptions;
import java.util.*;

public class Option {
	public int optionhasInt(Scanner input){
	    if(input.hasNextInt()) {
	        int option = input.nextInt();
            return option;
	    }else {
	    	System.err.println("It's not a int");
	    }
	    return 0;
    }
}
