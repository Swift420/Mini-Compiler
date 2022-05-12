import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class compiler {
	
	 private static final char[][] precedence = {
		        {'/','1'},
		        {'*','1'},
		        {'+','2'},
		        {'-','2'}
		    };

		    private static int precedenceOf(String t){
		        char token = t.charAt(0);
		        for (int i=0; i < precedence.length; i++){
		            if(token == precedence[i][0]){
		                return Integer.parseInt(precedence[i][1]+"");
		            }
		        }
		        return -1;
		    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
       

        int lines = 1;
        int count = 0;
        HashMap<String,String> codeGen = new HashMap<String,String>();
        ArrayList<String> codeGenArrayList = new ArrayList<String>();
    //    String[] codeGenArr = new String[8];
        String cont = "0";
        
            while (cont.equalsIgnoreCase("0")) {
            	//cont = "0";
                System.out.println("===Enter a String===");
                System.out.println("-Every String/line must end with a semicolon (;)");
                System.out.println("-Enter String Containing 0 to 9 and/or operators: +,/,*,-");
                System.out.println("-Strings must have no spaces in between them");
                System.out.println("-Enter 99 to exit program");
                
                String input = scan.nextLine();
                
                String yourString = input;
                String inputSpaces =  yourString.replace("", " ").trim();
                
                
               
                	
                
              //  String tokenType ="";
                String mainKey = "main", intKey = "int", scanKey= "scanf", openBracket = "(", closeBracket = ")", leftBrace = "{", rightBrace = "}",
                        atSy ="@", dollar ="$", percent ="%", excla ="!";
                String id1 = "sum", id2= "div" , id3 = "mult", id4 = "diff", id5="den";
                String zero="0", one="1", two="2",three="3",four="4",five="5",six="6",seven="7", eight="8",nine="9";
                String a="A", b= "B", c="C", d= "D", e= "E", f="F",g="G",h="H",I="I",J="J", k="K",l="L",m= "M", n="N", o="O",p="P",q="Q",r="R", s="S", t="T",u="U",
                        v="V",w="W",x="X",y="Y",z="Z",
                        plus= "+", minus="-", div="/", multi= "*", equals= "=", square="^";
                String E = "E", E1 = "E1", E2 = "E2", E3 = "E3", E4 = "E4", E5 = "E5", E6 = "E6", C = "C", B = "B", A = "A", EQ = "=", mult = "*", EVA = "EVA";
                String rep2 = " ", rep3 = " ", rep4 = " ", rep5 = " ", rep6 = " ", rep7 = " ", rep8 = " ", rep9 = " ", rep10 = " ", rep11 = " ";
                final String multdiv = "*/";
                final String adddiv = "+/";
                final String subdiv = "-/";
                final String addmult = "+*";
                final String submult = "-*";
                final String divmult = "/*";
                final String subadd = "-+";
                final String divadd = "/+";
                final String multadd = "*+";
                final String divsub = "+-";
                final String multsub = "*-";
                final String addsub = "+-";
                final String slashzero = "/0";
                final String equalSign = "=";
                final String slashspacezero = "/ 0";
                
                
                int j = 0;
                int error = 0;
                String errorType = " ";
               
                	//cont = "1";
                    //j++;
                   // String name = (String) st.nextElement();
                    char last = input.charAt(input.length()-1);
                    char last2 = input.charAt(input.length()-2);
                    char first = input.charAt(0);
                    String firstChar = Character.toString(first);
                    char semicolon = ';';
                    String lastVar = Character.toString(last2);
                    
                    String regex = ".*[a-zA-Z].*";  // regex to check if string contains any letters
                    Pattern pattern = Pattern.compile(regex);
                    
                    Matcher matcherText = pattern.matcher(input);
                    
                    Boolean textMatches = matcherText.matches();
                    
                    if(input.equalsIgnoreCase("99")) {
                    	error = 1;
                    	System.out.println("Exited -1");
                    	break;
                    }
                    
                    if (textMatches) {
                    	error = 1;
                    	System.out.println(" SYNTAX ERROR: Alphabets a-z or A-Z not allowed. String should be Nos 0,1,2..9 & operators +,-,*,/");
                    }
                    
                    if(last != semicolon) {
                    	error = 1;
                    	System.out.println("SYNTAX ERROR: A Number followed by semicolon (;) should end a string");
                    } 
                    
                    if(!lastVar.equalsIgnoreCase(one) &&!lastVar.equalsIgnoreCase(two) &&!lastVar.equalsIgnoreCase(three)&& !lastVar.equalsIgnoreCase(four) &&!lastVar.equalsIgnoreCase(five) &&
                    		!lastVar.equalsIgnoreCase(six) &&!lastVar.equalsIgnoreCase(seven) &&!lastVar.equalsIgnoreCase(eight) &&!lastVar.equalsIgnoreCase(nine) &&!lastVar.equalsIgnoreCase(zero) ) {
                    	
                    	error = 1;
                    	System.out.println("SYNTAX ERROR: Last Character before semicolon should be a Number");
                    }
                    
                    if(!firstChar.equalsIgnoreCase(one) &&!firstChar.equalsIgnoreCase(two) &&!firstChar.equalsIgnoreCase(three)&& !firstChar.equalsIgnoreCase(four) &&!firstChar.equalsIgnoreCase(five) &&
                    		!firstChar.equalsIgnoreCase(six) &&!firstChar.equalsIgnoreCase(seven) &&!firstChar.equalsIgnoreCase(eight) &&!firstChar.equalsIgnoreCase(nine) &&!firstChar.equalsIgnoreCase(zero) ) {
                    	
                    	error = 1;
                    	System.out.println("SYNTAX ERROR: First Character should be a Number");
                    }
                    
                    
                    if(input.contains(multdiv) || input.contains(adddiv) || input.contains(subdiv) || input.contains(addmult) || input.contains(submult) ||input.contains(divmult) || 
                    		input.contains(subadd) || input.contains(divadd) || input.contains(multadd) || input.contains(divsub) || input.contains(multsub) || input.contains(addsub) || 
                    		input.contains(slashzero) || input.contains(slashspacezero) || input.contains(equalSign)
                    		) {
                    	
                    	//Semi colon at the end
                    	error = 1;
                    	System.out.println("two operators (*,-,+,/) or numbers (0,1,..9) cannot be written together! Moreso semicolon (;) is needed at the end of each line");
                    	System.out.println("CONCLUSION-->Wrong expression: " +input +" No Derivation done! PLS RE-ENTER A VALID STRING");
                    }
                    
                    
                   //8+2-1/6*5;
                    
                    
                    
                   // System.out.println(error);
                    if (error == 0) {
                        System.out.println("===============================");
                        System.out.println("Stage 1: Lexical Analysis");
                        System.out.println("===============================");
                    	StringTokenizer st = new StringTokenizer(inputSpaces);
                        StringTokenizer st1 = new StringTokenizer(inputSpaces);

                        
                        String tokenType ="";
                        int j1 = 0;
                        
                        while (st.hasMoreTokens()) {
                        	j1++;
                        	String name = (String) st.nextElement();
                        	
                        	if ( name.equals(atSy) || name.equals(dollar) || name.equals(percent) || name.equals(excla) ) { tokenType = "Symbol"; }
                            if(name.equals(openBracket)){tokenType = "0penBracket";}
                            if(name.equals(closeBracket)){tokenType = "CloseBracket";}
                            
                            if ( name.equals(id1) || name.equals(id2) || name.equals(id3) || name.equals(id4) || name.equals(id5) ||name.equalsIgnoreCase(a) ||name.equalsIgnoreCase(b)||name.equalsIgnoreCase(c)||name.equals(d)
                                    ||name.equalsIgnoreCase(e)||name.equalsIgnoreCase(f)||name.equalsIgnoreCase(g)||name.equalsIgnoreCase(h)||name.equalsIgnoreCase(I)) { tokenType = "identifier"; }

                            if(name.equalsIgnoreCase(J) ||name.equalsIgnoreCase(k) ||name.equalsIgnoreCase(l) ||name.equalsIgnoreCase(m) ||name.equalsIgnoreCase(n) ||name.equalsIgnoreCase(o) ||name.equalsIgnoreCase(p)
                                    ||name.equalsIgnoreCase(q) ||name.equalsIgnoreCase(r) ||name.equalsIgnoreCase(s) ||name.equalsIgnoreCase(t) ||name.equalsIgnoreCase(u) ||name.equalsIgnoreCase(v)
                                    ||name.equalsIgnoreCase(w) ||name.equalsIgnoreCase(x) ||name.equalsIgnoreCase(y) ||name.equalsIgnoreCase(z)){tokenType = "Identifier";}
                            if (name.equals(zero) || name.equals(one) || name.equals(two)|| name.equals(three)||name.equals(four)||name.equals(five)||name.equals(six)
                                    ||name.equals(seven)||name.equals(eight) || name.equals(nine) ){tokenType = "Identifier";}
                            if ( name.equals(mainKey) || name.equals(intKey) || name.equalsIgnoreCase(scanKey)  ) { tokenType = "Keyword"; }
                            if ( name.equals(plus) || name.equals(minus) || name.equals(div)  || name.equals(multi) || name.equals(equals) || name.equals(square)  ) { tokenType = "operator"; }
                            
                            
                            System.out.println("TOKEN #"+ j1 + " "+ name + " "+ tokenType);
                        	
                        }
                        System.out.println("TOTAL NUMBER OF TOKENS FOR STRING: "+ st1.countTokens());
               
                    }
                if(error == 0) {
                	 input = input.replaceAll("\\s+", "");
                System.out.println("===============================");
                System.out.println("Stage 2: Syntax Analysis");
                System.out.println("===============================");
                System.out.println("GIVING THE GRAMMAR: E=E1 | E=E1*E2 | E=E1+E2 | E=digit | E={0,1,2,3,4,5,6,7,8,9}");
                System.out.println("GET A DERIVATION FOR : " + input);
                //System.out.println(input);
                String replace0 = input.replace("0", "E0");
                String replace1 = replace0.replace("1", E1);
                //System.out.println(replace1);
                String replace2 = replace1.replace("2", E2);
                //System.out.println(replace2);
                String replace3 = replace2.replace("3", E3);
                //System.out.println(replace3);
                String replace4 = replace3.replace("4", E4);
                //System.out.println(replace4);
                String replace5 = replace4.replace("5", E5);
                //System.out.println(replace5);
                String replace6 = replace5.replace("6", E6);
                //System.out.println(replace6);
                String replace7 = replace6.replace("7", "E7");
                //System.out.println(replace7);
                String replace8 = replace7.replace("8", "E8");
               // System.out.println(replace8);
                String replace9 = replace8.replace("9", "E9");
                System.out.println(replace9);
                if (replace9.contains("E0")) {
                    String repE0 = replace9.replace("E0", "digit0");
                    System.out.println(repE0);
                    replace9 = repE0;
                }
                if (replace9.contains("E1")) {
                     String replaceE1 = replace9.replace("E1", "digit1");
                    System.out.println(replaceE1);
                    replace9 = replaceE1;
                }
                if (replace9.contains("E2")) {
                     String replaceE2 = replace9.replace("E2", "digit2");
                    System.out.println(replaceE2);
                    replace9 = replaceE2;
                }
                if (replace9.contains("E3")) {
                     String replaceE3 = replace9.replace("E3", "digit3");
                    System.out.println(replaceE3);
                    replace9 = replaceE3;
                }
                if (replace9.contains("E4")) {
                     String replaceE4 = replace9.replace("E4", "digit4");
                    System.out.println(replaceE4);
                    replace9 = replaceE4;
                }
                if (replace9.contains("E5")) {
                    final String replaceE5 = replace9.replace("E5", "digit5");
                    System.out.println(replaceE5);
                    replace9 = replaceE5;
                }
                if (replace9.contains("E6")) {
                    final String replaceE6 = replace9.replace("E6", "digit6");
                    System.out.println(replaceE6);
                    replace9 = replaceE6;
                }
                if (replace9.contains("E7")) {
                     String replaceE7 = replace9.replace("E7", "digit7");
                    System.out.println(replaceE7);
                    replace9 = replaceE7;
                }
                if (replace9.contains("E8")) {
                	String replaceE8 = replace9.replace("E8", "digit8");
                    System.out.println(replaceE8);
                    replace9 = replaceE8;
                }
                if (replace9.contains("E9")) {
                    final String replaceE9 = replace9.replace("E9", "digit9");
                   
                    System.out.println(replaceE9);
                    replace9 = replaceE9;
                }
                if (replace9.contains("digit0")) {
                    final String replaceDigit0 = replace9.replace("digit0", "0");
                   
                    System.out.println(replaceDigit0);
                    replace9 = replaceDigit0;
                }
                if (replace9.contains("digit1")) {
                    String replaceDigit1 = replace9.replace("digit1", "1");
                   
                    System.out.println(replaceDigit1);
                    replace9 = replaceDigit1;
                }
                if (replace9.contains("digit2")) {
                    String replaceDigit2 = replace9.replace("digit2", "2");
                   
                    System.out.println(replaceDigit2);
                    replace9 = replaceDigit2;
                }
                if (replace9.contains("digit3")) {
                   String replaceDigit3 = replace9.replace("digit3", "3");
                   
                    System.out.println(replaceDigit3);
                    replace9 = replaceDigit3;
                }
                if (replace9.contains("digit4")) {
                    String replaceDigit4 = replace9.replace("digit4", "4");
                    
                     System.out.println(replaceDigit4);
                     replace9 = replaceDigit4;
                 }
                if (replace9.contains("digit5")) {
                    String replaceDigit5 = replace9.replace("digit5", "5");
                    
                     System.out.println(replaceDigit5);
                     replace9 = replaceDigit5;
                 }
                if (replace9.contains("digit6")) {
                    String replaceDigit6 = replace9.replace("digit6", "6");
                    
                     System.out.println(replaceDigit6);
                     replace9 = replaceDigit6;
                 }
                if (replace9.contains("digit7")) {
                    String replaceDigit7 = replace9.replace("digit7", "7");
                    
                     System.out.println(replaceDigit7);
                     replace9 = replaceDigit7;
                 }
                if (replace9.contains("digit8")) {
                    String replaceDigit8 = replace9.replace("digit8", "8");
                    
                     System.out.println(replaceDigit8);
                     replace9 = replaceDigit8;
                 }
                if (replace9.contains("digit9")) {
                    String replaceDigit9 = replace9.replace("digit9", "9");
                    
                     System.out.println(replaceDigit9);
                     replace9 = replaceDigit9;
                 }
                
                System.out.println("============================");
                System.out.println("Stage 3: Sematic Analysis");
                System.out.println("============================");
                System.out.println("This expression: "+ replace9 +" is Syntactically and Sematically correct");
                System.out.println("============================");
                System.out.println("Stage 4: Intermediate Code Representation");
                System.out.println("============================");
                int i2, j2, opc=0;
                char token;
                boolean processed[];
                String[][] operators = new String[10][2];
                String expr = "", temp;
                String icrReplacement = replace9.replaceAll("\\s+", "");
                
                expr = icrReplacement;
                processed = new boolean[expr.length()];
                for (int i=0; i<processed.length; i++){
                    processed[i] = false;
                }
                
                for (int i=0; i< expr.length(); i++){
                    token = expr.charAt(i);
                    for (j=0; j< precedence.length; j++){
                        if(token == precedence[j][0]){
                            operators[opc][0] =token+"";
                            operators[opc][1] = i+"";
                            opc++;
                            break;
                        }
                    }
                }
                
                for (int i=opc-1; i >= 0; i--){
                    for(j=0; j<i; j++){
                        if(precedenceOf(operators[j][0]) > precedenceOf(operators[j+1][0])){
                            temp = operators[j][0];
                            operators[j][0] = operators[j+1][0];
                            operators[j+1][0] = temp;
                            temp = operators[j][1];
                            operators[j][1] = operators[j+1][1];
                            operators[j+1][1] = temp;
                        }
                    }
                }
                System.out.println();
                for (int i = 0; i < opc; i++){
                    j = Integer.parseInt(operators[i][1] + "");
                    String op1 = "", op2 = "";
                    if( processed[j-1]== true){
                        if (precedenceOf(operators[i-1][0])== precedenceOf(operators[i][0])){
                            op1 = "t" +i;
                            
                        }
                        else{
                            for (int x1 = 0; x1 < opc; x1++){
                                if((j-2)== Integer.parseInt(operators[x1][1])){
                                    op1 = "t" + (x1+1) + "";
                                  
                                }
                            }
                        }
                    }
                    else{
                        op1 = expr.charAt(j-1) + "";
                        
                    }
                    if (processed[j+1] == true){
                        for(int x1 = 0; x1 < opc; x1++){
                            if((j+2) == Integer.parseInt(operators[x1][1])){
                                op2 = "t" + (x1 + 1) + "";
                               
                            }
                        }
                    }
                    else{
                        op2 = expr.charAt(j+1) + "";
                        
                    }
                    System.out.println("t"+ (i+1) + " = " + op1 + operators[i][0] + op2);
                    processed[j] = processed[j-1] = processed[j+1] = true;
                    String tempCG = "t"+ (i+1) + " = " + op1 + operators[i][0] + op2;
                    
                   // codeGen.put(op1, operators[i][0]+" "+op2);
                    codeGenArrayList.add( "t"+ (i+1) + " = " + op1 + operators[i][0] + op2);
                }
                for( int i = 0; i < operators.length; i++ ) {
             	   Arrays.fill( operators[i], null );
                }
                System.out.println("CONCLUSION-->The expression was correctly generated in ICR");
                System.out.println("============================");
                System.out.println("Stage 5: Code Generation");
                System.out.println("============================");
               String tempVar = " ";
               char s1 = ' ';
               char s2 = ' ';
               char s3 = ' ';
               
               char s2Alt = ' '; 
               String sType = "";
                for (int k1 = 0; k1 < codeGenArrayList.size(); k1++) {
					tempVar = codeGenArrayList.get(k1);
					String[ ] arr = tempVar.split(" ");
					
					sType = arr[0];
					
					s1 = arr[2].charAt(0); //9*5 -> 9
					 s2 = arr[2].charAt(1); //9*5 -> *
					 s3 = arr[2].charAt(2); //9*5 -> 5
					 
					 s2Alt =  arr[2].charAt(2);
					 
					 if(s1 != 't') {
						 
						 System.out.println("LDA " + s1);
					 } 
					 
					 if(s1 == 't') {
						 System.out.println("LDA "+ arr[2].charAt(0)+ arr[2].charAt(0+1));
					 }
					 
					 if (s2 == '*' || s2Alt == '*') {
						
						 if (s3 == '*') {
							 if(arr[2].charAt(3) == 't') {
								 System.out.println("MUL " +arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("MUL " +arr[2].charAt(3));
							 }
						 } else {
						 System.out.println("MUL " + s3); 
						 }
					 } 
					 if(s2 == '/' || s2Alt == '/') {
						 if (s3 == '/') {
							 if(arr[2].charAt(3) == 't') {
								 System.out.println("DIV " +arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("DIV " +arr[2].charAt(3));
							 }
						 } else {
						 System.out.println("DIV " + s3); 
						 }
					 } 
					 if(s2 == '+'  || s2Alt == '+') {
						 if (s3 == '+') {
							 if(arr[2].charAt(2) == 't') {
								 System.out.println("ADD " +arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("ADD " +arr[2].charAt(3));
							 }
						 }else if(arr[2].charAt(2) == 't') {
							 System.out.println("ADD " +arr[2].charAt(2)+arr[2].charAt(3)); 
						 } else {
							 
						 System.out.println("ADD " + s3 ); 
						 }
					 } 
					 
					 if(s2 == '-' ||  s2Alt == '-') {
 
						 if (s3 == '-') {
							 if(arr[2].charAt(3) == 't') {
								 System.out.println("SUB " +arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("SUB " +arr[2].charAt(3));
							 }
						 } else {
						 System.out.println("SUB " + s3); 
						 }
					 }
					 
					 
					 
					
					 
					 
					 System.out.println("STR " + sType);
					
					
					
					//9*5-2*4+3
					//9*6-3+2*4
                	
				}
                System.out.println("============================");
                System.out.println("Stage 6: Code Optimization");
                System.out.println("============================");
                for (int k1 = 0; k1 < codeGenArrayList.size(); k1++) {
					tempVar = codeGenArrayList.get(k1); // saves t1 = 9*5 in tempVar
					//tempVar -> t1 = 9*5
					String[ ] arr = tempVar.split(" "); //t1 = 9*5
					
					sType = arr[0]; //t1
					
					s1 = arr[2].charAt(0); //9*5 -> 9
					 s2 = arr[2].charAt(1); //9*5 -> *
					 s3 = arr[2].charAt(2); //9*5 -> 5
					 s2Alt =  arr[2].charAt(2); 
					 
					 if(s1 != 't') {
						 
						// System.out.println("LDA " + s1);
					 } 
					 
					 if(s1 == 't') {
						// System.out.println("LDA "+ arr[2].charAt(0)+ arr[2].charAt(0+1));
					 }
					 
					 if (s2 == '*' || s2Alt == '*') {
						
						 if (s3 == '*') {
							 if(arr[2].charAt(3) == 't') {
								 System.out.println("MUL " + sType+","+s1+s2+","+arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("MUL " +sType+","+s1+","+arr[2].charAt(3));
							 }
						 } else {
						 System.out.println("MUL " +sType+ ","+s1+","+s3); 
						 }
					 } 
					 if(s2 == '/' || s2Alt == '/') {
						 if (s3 == '/') {
							 if(arr[2].charAt(3) == 't') {
								 System.out.println("DIV " + sType+","+s1+s2+","+arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("DIV " + sType+","+s1+arr[2].charAt(3));
							 }
						 } else {
						 System.out.println("DIV "+ sType+","+s1 +","+ s3); 
						 }
					 } 
					 if(s2 == '+'  || s2Alt == '+') {
						 if (s3 == '+') {
							 if(arr[2].charAt(3) == 't') {
								 System.out.println("ADD " + sType+","+s1+s2+","+arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("ADD " + sType+","+s1+arr[2].charAt(3));
							 }
						 } else if(arr[2].charAt(2) == 't') {
							// System.out.println("ADD " +arr[2].charAt(2)+arr[2].charAt(3)); 
							 System.out.println("ADD "+ sType+","+s1 +","+ arr[2].charAt(2)+arr[2].charAt(3)); 
						 }else {
						 System.out.println("ADD "+ sType+","+s1 +","+ s3); 
						 }
					 } 
					 
					 if(s2 == '-' ||  s2Alt == '-') {
 
						 if (s3 == '-') {
							 if(arr[2].charAt(3) == 't') {
								 System.out.println("SUB "+ sType+","+s1+s2+","+arr[2].charAt(3)+arr[2].charAt(4)); 
							 }else {
							 System.out.println("SUB "+ sType+","+s1+s2 +"," +arr[2].charAt(3));
							 }
						 } else {
						 System.out.println("SUB "+ sType+","+s1 +","+ s3); 
						 }
					 }
					 
		              
					 
					
					 
					 
					
                }
                System.out.println("============================");
                System.out.println("Stage 7: Target Machine Code");
                System.out.println("============================");
                
                for (int k1 = 0; k1 < codeGenArrayList.size(); k1++) {
					tempVar = codeGenArrayList.get(k1); // 
					
					String[ ] arr = tempVar.split(" "); //t1 = 9*5
					
					sType = arr[0]; //t1
					
					s1 = arr[2].charAt(0); //9*5 -> 9
					 s2 = arr[2].charAt(1); //9*5 -> *
					 s3 = arr[2].charAt(2); //9*5 -> 5
					 s2Alt =  arr[2].charAt(2); 
					 
					
					 if (s2 == '*' || s2Alt == '*') {
						
						 if (s3 == '*') {
							 if(arr[2].charAt(3) == 't') {
								
								 
								if(arr[2].charAt(3) == 't') {
									System.out.println("001 010 10 010");
								}else {
									char aa =  (char) (arr[2].charAt(3)+arr[2].charAt(4));
									 String a2 = Character.toString(aa);
									 int a3 = Integer.parseInt(a2);
									 String a4 = Integer.toBinaryString(a3);
									
								 System.out.println("001 010 10 0" +a4);
								}
								  
							 }else {
								 if(arr[2].charAt(3) == 't') {
										System.out.println("001 010 11 010");
									} else {
										
								 char aa =  (arr[2].charAt(3));
								 String a2 = Character.toString(aa);
								 int a3 = Integer.parseInt(a2);
								 String a4 = Integer.toBinaryString(a3);
								
							 System.out.println("001 010 11 0" +a4);
									}
							 }
						 } else {
							 if(arr[2].charAt(2) == 't') {
									System.out.println("001 010 11 010");
								} else {
									
							 String a2 = Character.toString((s3));
							 int a3 = Integer.parseInt(a2);
							 String a4 = Integer.toBinaryString(a3);
							 System.out.println("001 010 11 0"+a4);
								} 
						 }
					 } 
					 if(s2 == '/' || s2Alt == '/') {
						
						 if (s3 == '/') {
							 if(arr[2].charAt(3) == 't') {
								 if(arr[2].charAt(3) == 't') {
										System.out.println("001 011 11 100");
									}else {
										char aa =  (char) (arr[2].charAt(3)+arr[2].charAt(4));
										 String a2 = Character.toString(aa);
										 int a3 = Integer.parseInt(a2);
										 String a4 = Integer.toBinaryString(a3);
										
									 System.out.println("001 011 11 0" +a4);
									}
							 }else {
								 if(arr[2].charAt(3) == 't') {
										System.out.println("001 010 11 100");
									} else {
										
								 char aa =  (arr[2].charAt(3));
								 String a2 = Character.toString(aa);
								 int a3 = Integer.parseInt(a2);
								 String a4 = Integer.toBinaryString(a3);
								
							 System.out.println("001 010 11 0" +a4);
									}
							 }
						 } else {
							 if(arr[2].charAt(2) == 't') {
									System.out.println("001 010 11 100");
								} else {
									
							 String a2 = Character.toString((s3));
							 int a3 = Integer.parseInt(a2);
							 String a4 = Integer.toBinaryString(a3);
							 System.out.println("001 010 11 0"+a4);
								}
						 }
					 } 
					 if(s2 == '+'  || s2Alt == '+') {
						
						 if (s3 == '+') {
							 
							 //7+2/1;
							 if(arr[2].charAt(2) == 't') {
								 
								 if(arr[2].charAt(2) == 't') {
										System.out.println("001 010 11 011");
									}else {
										
										
										
										char aa =  (char) (arr[2].charAt(3)+arr[2].charAt(4));
										 String a2 = Character.toString(aa);
										 int a3 = Integer.parseInt(a2);
										 String a4 = Integer.toBinaryString(a3);
										
									 System.out.println("001 010 11 0" +a4);
										
									}
							 }else {
								 
								 if(arr[2].charAt(3) == 't') {
										System.out.println("001 010 11 011");
									} else {
										
								 char aa =  (arr[2].charAt(3));
								 String a2 = Character.toString(aa);
								 int a3 = Integer.parseInt(a2);
								 String a4 = Integer.toBinaryString(a3);
								
							 System.out.println("001 010 11 0" +a4);
									}
							 }
						 } else {
							 
							 if(arr[2].charAt(2) == 't') {
									System.out.println("001 010 11 011");
								} else {
									
							 String a2 = Character.toString((s3));
							 int a3 = Integer.parseInt(a2);
							 String a4 = Integer.toBinaryString(a3);
							 System.out.println("001 010 11 0"+a4);
								}
						 }
					 } 
					 
					 if(s2 == '-' ||  s2Alt == '-') {
						 	
						 if (s3 == '-') {
							 if(arr[2].charAt(2) == 't') {
								 if(arr[2].charAt(2) == 't') {
										System.out.println("001 011 01 101");
									}else {
										
										char aa =  (char) (arr[2].charAt(3)+arr[2].charAt(4));
										 String a2 = Character.toString(aa);
										 int a3 = Integer.parseInt(a2);
										 String a4 = Integer.toBinaryString(a3);
										
									 System.out.println("001 011 01 0" +a4);
									}
							 }else {
								 if(arr[2].charAt(3) == 't') {
										System.out.println("001 010 11 101");
									} else {
										
								 char aa =  (arr[2].charAt(3));
								 String a2 = Character.toString(aa);
								 int a3 = Integer.parseInt(a2);
								 String a4 = Integer.toBinaryString(a3);
								
							 System.out.println("001 010 11 0" +a4);
									}
							 }
						 } else {
							 if(arr[2].charAt(2) == 't') {
									System.out.println("001 010 11 101");
								} else {
									
							 String a2 = Character.toString((s3));
							 int a3 = Integer.parseInt(a2);
							 String a4 = Integer.toBinaryString(a3);
							 System.out.println("001 010 11 0"+a4);
								}
						 }
					 }
					 
		              
					 
					
					 
					 
					
                }
                
                
                
                System.out.println("============================");
                codeGenArrayList.clear();
			}
               
               
                
               
                
                
                }
            }        }