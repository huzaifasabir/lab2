package interpreter;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class interTest {

	@Test
	
	public void test() {
		
		
		
		//list of commands
		List<String> a1 = new ArrayList();
		int r1 = 0, c1 = 0;
		
		
	    
		try {
			//file
			File file = new File("F:\\sample1.txt");
			FileReader fileReader = new FileReader(file);
			
			//reader
			BufferedReader bufferedReader1 = new BufferedReader(fileReader);
			
			String line;
			
			
			//reading file line by line till EOF
			while ((line = bufferedReader1.readLine()) != null) {
				
				//copy of line
				String s = line;
				a1.add(line);
			
			}
	        
	               fileReader.close();
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//creating variable of class to be tested
		inter n = new inter();
		//after populating inputs calling function to be tested
		n.parse(a1);
		
		
	}

}
