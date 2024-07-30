import java.util.*; //Scanner
import static java.lang.System.out;
public class operationwith {


		 public static void main (String[] args) {
		        out.println("OPERATIONS ON NATURAL NUMBERS " + "IN CHARACTER STRINGS");
		        // enter two natural numbers
		        Scanner in = new Scanner (System.in);
		        out.println("two natural numbers:");
		        out.println("Number 1: ");
		        String num1 = in.next();
		        out.println("Number 2: ");
		        String num2 = in.next();
		        out.println();
		       
		        // add the numbers and show the result
		       
		        String sum = add (num1, num2);
		        show(num1, num2, sum, '+');
		       
		        // subtract the numbers and show the result
		       
		        String subtract = subtract(num1, num2);
		        show(num1, num2, subtract, '-');
		    }
		   
		 // the add method accepts two natural numbers represented
		    // as character strings and returns their sum as a a
		    // character string.
		    //public static String add (String num1, String num2){
		       
		 public static String add(String num1, String num2) {
		          
			 // declare string builder
		           
			        StringBuilder sb = new StringBuilder();
		            int dig1;
		            int dig2;

		           
		            // loop starts at the least significant digit on each number
		            
		            for ( int i1 = num1.length() - 1, i2 = num2.length() - 1, carry = 0;

		            		
		            		  // as long as least significant digit (current digit), of any number (or carry is not 0)
		                    // is greater than 0, go up
		                    // to next least significant digit
		            		
		            		i1 >= 0 || i2 >= 0 || carry != 0;
		                    i1--, i2--)
		              {
		                  // Initialise the integers digit1 and digit 2
		            	 dig1 = i1 < 0 ? 0 : Integer.parseInt(Character.toString(num1.charAt(i1)));
		                 dig2 = i2 < 0 ? 0 : Integer.parseInt(Character.toString(num2.charAt(i2)));

		                 int tempSum = dig1 + dig2 + carry;
		                 //
		                 if (tempSum > 9) {
		                     carry = 1;
		                     tempSum -= 10;
		                 }
		                 else {
		                     carry = 0;
		                 }
		                 // add tempSum to the string sb from the string builder
		                 sb.append(tempSum);
		             }
		             // returns a string representation of the object
		             return sb.reverse().toString();
		         }
		        
		    
		 
		        
		         // The subtract method accepts two natural numbers
		        // represented as character strings and returns  their
		        // difference as a character string.
		        // The first number is not smaller than the second
		       
		 
		        public static String subtract (String num1, String num2){
		             
		        	// declare string builder
		            
		        	StringBuilder sb = new StringBuilder();
		            int dig1;
		            int dig2;

		            for ( int i1 = num1.length() - 1, i2 = num2.length() - 1, carry = 0;
		            		
		            		 i1 >= 0 || i2 >= 0 || carry != 0;
		                    i1--, i2--)
		              {
		                  dig1 = i1 < 0 ? 0 : Integer.parseInt(Character.toString(num1.charAt(i1))) - carry;
		                  dig2 = i2 < 0 ? 0 : Integer.parseInt(Character.toString(num2.charAt(i2)));

		                  int tempDiff;
		                 
		                  // subtracting a smaller digit from a larger one
		                  if ((dig2 <= dig1)){
		                      tempDiff = dig1 - dig2;
		                      carry = 0;
		                  }
		                  else{
		                      
		                	  // subtracting a larger digit from a smaller one
		                      tempDiff = (dig1 + 10) - dig2;
		                      carry = 1;
		                  }
		                  sb.append(tempDiff);
		              }
		              // returns a string representation of the object
		              return sb.reverse().toString();
		          }

		          
		        
		        // The show method presents two natural numbers, an
		          // operator and the result string.
		         
		        public static void show (String num1, String num2, String result, char operator){
		              // set an appropriate length on numbers and result
		              int len1 = num1.length();
		              int len2 = num2.length();
		              int len = result.length();
		              int maxLen = Math.max(Math.max(len1, len2), len);
		              num1 = setLen (num1, maxLen - len1);
		              num2 = setLen (num2, maxLen - len2);
		              result = setLen (result, maxLen - len);
		              // show the expression
		              out.println(" " + num1);
		              out.println("" + operator + " " + num2);
		              for (int i = 1; i < maxLen + 2; i++)
		                  out.print("-");
		              out.println();
		              out.println(" " + result + "\n");
		          }
		          // The setLen method prepends the supplied number of
		          // spaces at to the beginning of a string
		        
		        public static String setLen (String s, int nofSpaces){
		              StringBuilder sb = new StringBuilder(s);
		              for (int i = 1 ; i < nofSpaces; i++)
		                  sb.insert(0, " ");
		              return sb.toString();
		          }
	}
	


