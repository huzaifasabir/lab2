package interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class inter {

	//list of variables
	List<variable> a2 = new ArrayList<variable>();
	
	
	
	//function parsing each line and calling appropriate function
	void parse(List<String> lines){
		
		inter n = new inter();
		
		
		int temp = lines.size();
		int i;
		for( i = 0;i<temp;i++){
			String l = lines.get(i);
			
			if((l.startsWith("let")== true)){
				n.declare(l);
			}else{
				if((l.startsWith("print")== true)){
				n.print(l);
			}else{
				n.compute(l);
			}
			}
			//System.out.println(lines.get(i));
		}
		
		
		}
	//function for printing
	void print(String prn){
		
		System.out.println(prn);
		StringTokenizer t1 = new StringTokenizer(prn, "print");
		String var1 = t1.nextToken();
		String op1 = var1.replace(" ","");
		op1 = op1.replace(";","");
		variable n = new variable();
		//String var = t1.nextToken();
		//System.out.println(op1);
		int size = a2.size();
		int check = 0;
		//System.out.println(size);
		for(int i = 0;i<size;i++){
			
			n = a2.get(i);
			//if variable name is found in list print its value
			if(op1.equals(n.name)){
				check = 1;
				System.out.println(n.getvalue());
				break;
				
			}
			if(check == 0){
				if(op1 != null){
					//if string is to be printed
					if(op1.startsWith("\"")&&op1.endsWith("\"")){
						check =1;
						String tx = op1.replace("\"", "");
						System.out.println(tx);
						break;
					}
				}
			}
			
					
		}
		if(check == 0){
			System.out.println("invalid print statement");
		}
		
	}
	
	//function for computations
	void compute(String op){
		
		System.out.println("In compute function");
		System.out.println(op);
		
		String op1 = op.replace(" ","");
		 op1 = op1.replace(";","");
		StringTokenizer t1 = new StringTokenizer(op1, "=");
		variable n = new variable();
		variable n1 = new variable();
		String var = t1.nextToken();
		String temp1 = t1.nextToken();
		int i;
		int size = a2.size();
		int check = 0;
		
		for( i = 0;i<size;i++){
			
			n1 = a2.get(i);
			if(n1.name.equals(var)){
				
				check = 1;
				break;
				
			}
					
		}
		if(check == 0){
			
			if(Character.isDigit(var.charAt(0))){
				System.out.println("Invalid compute statement");
			}
		}
		int length = temp1.length();
		char []arrry = new char[length];
		
		arrry=temp1.toCharArray();
		
		int cq = 0;
		if(check == 1){
			int v = 0;
			int de = 0;
			
			if(temp1.contains("+")){
				int chq = 0;
				int chq1 = 0;
				StringTokenizer t2 = new StringTokenizer(temp1, "+");
				int vr1 = 0,vr2=0;
				String d = t2.nextToken();
				String d1 = t2.nextToken();
				
				if(Character.isDigit(d.charAt(0))){
					vr1 = Integer.parseInt(d);
					chq = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d)){
							chq = 1;
							vr1 = n.getvalue();
							check = 1;
							cq = 1;
							break;
							
						}
								
					}
				}
				if(Character.isDigit(d1.charAt(0))){
					vr2 = Integer.parseInt(d1);
					chq1 = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d1)){
							chq1 = 1; 
							vr2 = n.getvalue();
							check = 1;
							cq = 1;
							break;
							
						}
								
					}
				}
				
				

				if(chq == 1&&chq1 == 1){
				int r = vr1 + vr2;
				
				n1.value = r;
				
				}else{
					System.out.println("invalid compute statement");
				}
				
				
				
			}else{if(temp1.contains("-")){
				
				//StringTokenizer t2 = new StringTokenizer(temp1, "-");
				int chq = 0;
				int chq1 = 0;
				StringTokenizer t2 = new StringTokenizer(temp1, "-");
				int vr1 = 0,vr2=0;
				String d = t2.nextToken();
				String d1 = t2.nextToken();
				if(t2.hasMoreElements()){
					
				}
				if(Character.isDigit(d.charAt(0))){
					vr1 = Integer.parseInt(d);
					chq = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d)){
							chq = 1;
							vr1 = n.getvalue();
							check = 1;
							break;
							
						}
								
					}
				}
				if(Character.isDigit(d1.charAt(0))){
					vr2 = Integer.parseInt(d1);
					chq1 = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d1)){
							chq1 = 1; 
							vr2 = n.getvalue();
							check = 1;
							break;
							
						}
								
					}
				}
				
				

				if(chq == 1&&chq1 == 1){
				int r = vr1 - vr2;
				
				n1.value = r;
				
				}else{
					System.out.println("invalid compute statement");
				}
				
				
			}else{if(temp1.contains("/")){
				
				
				int chq = 0;
				int chq1 = 0;
				StringTokenizer t2 = new StringTokenizer(temp1, "/");
				int vr1 = 0,vr2=0;
				String d = t2.nextToken();
				String d1 = t2.nextToken();
				if(t2.hasMoreElements()){
					
				}
				if(Character.isDigit(d.charAt(0))){
					vr1 = Integer.parseInt(d);
					chq = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d)){
							chq = 1;
							vr1 = n.getvalue();
							check = 1;
							break;
							
						}
								
					}
				}
				if(Character.isDigit(d1.charAt(0))){
					vr2 = Integer.parseInt(d1);
					chq1 = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d1)){
							chq1 = 1; 
							vr2 = n.getvalue();
							check = 1;
							break;
							
						}
								
					}
				}
				
				

				if(chq == 1&&chq1 == 1){
				int r = vr1 / vr2;
				
				n1.value = r;
				
				}else{
					System.out.println("invalid compute statement");
				}
				
			
			}else{if(temp1.contains("*")){
			
				
				int chq = 0;
				int chq1 = 0;
				StringTokenizer t2 = new StringTokenizer(temp1, "*");
				int vr1 = 0,vr2=0;
				String d = t2.nextToken();
				String d1 = t2.nextToken();
				if(t2.hasMoreElements()){
					
				}
				if(Character.isDigit(d.charAt(0))){
					vr1 = Integer.parseInt(d);
					chq = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d)){
							chq = 1;
							vr1 = n.getvalue();
							check = 1;
							break;
							
						}
								
					}
				}
				if(Character.isDigit(d1.charAt(0))){
					vr2 = Integer.parseInt(d1);
					chq1 = 1;
				}else{
					for( v = 0;v<size;v++){
						
						n = a2.get(v);
						if(n.name.equals(d1)){
							chq1 = 1; 
							vr2 = n.getvalue();
							check = 1;
							break;
							
						}
								
					}
				}
				
				

				if(chq == 1&&chq1 == 1){
				int r = vr1 * vr2;
				
				n1.value = r;
				
				}else{
					System.out.println("invalid compute statement");
				}
				
			}
			}
			}
			}
			a2.remove(i);
			a2.add(n1);
		}else{
			
			System.out.println("variable not declared : "+var);
			
		}
		
		//a2.remove(i);
		
		
		
		
		
		
	}
	//function to save declarations
	void declare(String dec){
		variable n = new variable();
		StringTokenizer t = new StringTokenizer(dec, "let");
		String temp = t.nextToken();
		
		String dec1 = temp.replace(" ","");
		dec1 = dec1.replace(";","");
		StringTokenizer t1 = new StringTokenizer(dec1, "=");
		String x = t1.nextToken();
		n.name = x;
		n.setName(x);
		if(t1.hasMoreTokens()){
		int va = Integer.parseInt(t1.nextToken());
		n.value = va;
		}
		
		//n.setvalue(va); 
		
		a2.add(n);
		System.out.println("value of "+n.getName()+" = "+ n.getvalue());
		
		
		
		
	}
	
	
	

}
