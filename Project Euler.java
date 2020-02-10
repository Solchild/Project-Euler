import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;
public class ProjectEuler {
    public static void main(String args[]) {
    	Scanner scanIt = new Scanner(System.in);
    	String problem;
//    	double num = 999167;
//    	for(int i = 0; i < 1000; i++) {
//    		num = collatzNum(num);
//    		System.out.println(num);
//    	}
    	System.out.println("Enter the problem you want.");
    	problem = scanIt.nextLine();
    	
    	
    	
    	switch(problem) {
	    	case "3":
	    		prob3();
	    		break;
	    	case "4":
	    		prob4();
	    		break;
	    	case "5":
	    		prob5();
	    		break;
	    	case "6":
	    		prob6();
	    		break;
	    	case "7":
	    		prob7();
	    		break;
	    	case "8":
	    		prob8();
	    		break;
	    	case "9":
	    		prob9();
	    		break;
	    	case "10":
	    		prob10();
	    		break;
	    	case "11":
	    		prob11();
	    		break;
	    	case "12":
	    		prob12();
	    		break;
	    	case "13":
	    		prob13();
	    		break;
	    	case "14":
	    		prob14();
	    		break;
	    	case "15":
	    		prob15();
	    		break;
	    	default:
	    		System.out.println("Wrong!");
	    		
    	}
    }
    
	//  For 6 digit integers only
	public static boolean isPalindrome(int a ) {
	  	boolean isPalin = true;
	  	int[] theThing = new int[6];
	  	for(int i = 5; i >= 0; i--) {
	  		theThing[i] = a % 10;
	  		a = a / 10;
	  	}
	  	int j = 5;
	  	for(int i = 0; i < 4; i++) {
	  		if(theThing[i] != theThing[j]) {
	  			isPalin = false;
	  			break;
	  		}
	  		j--;
	  	}
	  	return isPalin;
	  }
	public static boolean isPrime(double a) {
		boolean prime = true;
		for(int j = 2; j < a / 2; j++){
            if(a % j == 0)
                prime = false;
        }
		return prime;
	}
	public static ArrayList<Integer> listOfDivisors(double a) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 1; i <= a; i++) {
			if((a / i) % 1 == 0)
				answer.add(i);
		}
		return answer;
	}
	public static int numOfDivisors(double a) {
		int answer = 0;
		boolean odd = false;
		boolean divisByFive = false;
		if(a %  10 / 2 != 0) {
			odd = true;
		}
		if(a % 10 == 0 || a % 10 == 5)
			divisByFive = true;
		for(int i = 1; i < a; i++) {
			if((a / i) % 1 == 0) {
				answer++;
			}
			if(i % 10 == 4 && divisByFive == false)
				i++;
			if(i % 2 != 0 && odd == true) {
				i++;
			}
			if((i + 1) >= Math.sqrt(a)) {
				answer = answer * 2;
				break;
			}
		}
		return answer;
	}
	public static BigInteger factorial(BigInteger a) {
		if(a.compareTo(BigInteger.ONE) > 0)
			return  a.multiply(factorial(a = a.subtract(BigInteger.ONE)));
		else return BigInteger.ONE;
	}
	public static double collatzNum(double a) {
		if(a % 2 == 0)
			return a / 2;
		else return 3 * a + 1;
	}
	public static void prob3() {
    	Scanner scanIt = new Scanner(System.in);
	    double theNum;
	    System.out.println("Enter number:");
	    theNum = scanIt.nextDouble();
	    System.out.println(theNum);
	    double currentLargest = 0;
	    
	    for(double i = 3; i < theNum; i++){
	        
	        boolean prime = true;
	        if(theNum % i == 0){
	            
	            prime = isPrime(i);
	            if(prime == true){
	                currentLargest = i;
	                System.out.println("currentLargest = " + i);
//	                break;
	            }
	        }
	        if(i % 10 == 1 || i % 10 == 7 || i % 10 == 9 || i % 10 == 2)
	        	i++;
	        if(i % 10 == 3)
	        	i += 3;
	    }
	    if(currentLargest == 0)
	    	System.out.println(theNum + " is a prime number.");
	    else System.out.println(theNum + "'s largest prime factor is " +currentLargest);
    }
    
    public static void prob4() {
    	int largest = 0;
    	int currentLargest = 0;
    	boolean isPalin = false;
    	int num1 = 0;
    	int num2 = 0;
    	for(int i = 999; i > 0; i--) {
    		for(int j = 999; j > 0; j--) {
    			isPalin = isPalindrome(i * j);
    			
    			if(isPalin == true)
    				currentLargest = i * j;
    			if(currentLargest > largest) {
    				largest = currentLargest;
    				num1 = i;
    				num2 = j;
    			}
    		}
      	}
    	    	
    	System.out.println("The largest palindrome product found by multiplying two 3 digit integers is " + largest);
    	System.out.println(num1 + " * " + num2 + " = " + largest);
    	
    	
    }

    public static void prob5() {
    	int answer = 40;
//    	boolean broken = false;
    	boolean allMod = false;
    	
    	looptyloop:
    	for(answer = 40; answer < 2147000000; answer+=20) {
    		looptyscoop:
    		for(int j = 2; j < 21; j++) {
    			allMod = true;
    			if(answer % j != 0) { 
    				allMod = false;
    				break looptyscoop;
    			}
    			System.out.println("answer = " + answer);
    		}
    		if(allMod == true)
//    			broken = true;
				break looptyloop;
    	}
    	System.out.println(answer);
//    	answer = 232792560;
    }
    public static void prob6() {
    	int sumOfSquare = 0;
    	int squareOfSum = 0;
    	
//    	sumOfSquare calculation
    	for(int i = 1; i < 101; i++)
    		sumOfSquare += i * i;
    	
//    	squareOfSum calculation
    	for(int i = 1; i < 101; i++)
    		squareOfSum += i;
    	squareOfSum = squareOfSum * squareOfSum;
    	
    	System.out.println(squareOfSum + " - " + sumOfSquare + " = " + (squareOfSum - sumOfSquare));
    }
    public static void prob7() {
    	ArrayList<Integer> primeList = new ArrayList<Integer>();
    	
    	for(int i = 2; primeList.size() < 10002; i++) {
    		boolean prime = true;
	    	prime = isPrime(i);
	    	if(prime == true) {
	    		primeList.add(i);
	    		System.out.println(primeList.size() + " = " + i);
	    		
	    	}
    	}
    	System.out.println(primeList.get(10000));    	
    }
    public static void prob8() {
    	int[] list = {7,3,1,6,7,1,7,6,5,3,1,3,3,0,6,2,4,9,1,9,2,2,5,1,1,9,6,7,4,4,2,6,5,7,4,7,4,2,3,5,5,3,4,9,1,9,4,9,3,4,
    			9,6,9,8,3,5,2,0,3,1,2,7,7,4,5,0,6,3,2,6,2,3,9,5,7,8,3,1,8,0,1,6,9,8,4,8,0,1,8,6,9,4,7,8,8,5,1,8,4,3,
    			8,5,8,6,1,5,6,0,7,8,9,1,1,2,9,4,9,4,9,5,4,5,9,5,0,1,7,3,7,9,5,8,3,3,1,9,5,2,8,5,3,2,0,8,8,0,5,5,1,1,
    			1,2,5,4,0,6,9,8,7,4,7,1,5,8,5,2,3,8,6,3,0,5,0,7,1,5,6,9,3,2,9,0,9,6,3,2,9,5,2,2,7,4,4,3,0,4,3,5,5,7,
    			6,6,8,9,6,6,4,8,9,5,0,4,4,5,2,4,4,5,2,3,1,6,1,7,3,1,8,5,6,4,0,3,0,9,8,7,1,1,1,2,1,7,2,2,3,8,3,1,1,3,
    			6,2,2,2,9,8,9,3,4,2,3,3,8,0,3,0,8,1,3,5,3,3,6,2,7,6,6,1,4,2,8,2,8,0,6,4,4,4,4,8,6,6,4,5,2,3,8,7,4,9,
    			3,0,3,5,8,9,0,7,2,9,6,2,9,0,4,9,1,5,6,0,4,4,0,7,7,2,3,9,0,7,1,3,8,1,0,5,1,5,8,5,9,3,0,7,9,6,0,8,6,6,
    			7,0,1,7,2,4,2,7,1,2,1,8,8,3,9,9,8,7,9,7,9,0,8,7,9,2,2,7,4,9,2,1,9,0,1,6,9,9,7,2,0,8,8,8,0,9,3,7,7,6,
    			6,5,7,2,7,3,3,3,0,0,1,0,5,3,3,6,7,8,8,1,2,2,0,2,3,5,4,2,1,8,0,9,7,5,1,2,5,4,5,4,0,5,9,4,7,5,2,2,4,3,
    			5,2,5,8,4,9,0,7,7,1,1,6,7,0,5,5,6,0,1,3,6,0,4,8,3,9,5,8,6,4,4,6,7,0,6,3,2,4,4,1,5,7,2,2,1,5,5,3,9,7,
    			5,3,6,9,7,8,1,7,9,7,7,8,4,6,1,7,4,0,6,4,9,5,5,1,4,9,2,9,0,8,6,2,5,6,9,3,2,1,9,7,8,4,6,8,6,2,2,4,8,2,
    			8,3,9,7,2,2,4,1,3,7,5,6,5,7,0,5,6,0,5,7,4,9,0,2,6,1,4,0,7,9,7,2,9,6,8,6,5,2,4,1,4,5,3,5,1,0,0,4,7,4,
    			8,2,1,6,6,3,7,0,4,8,4,4,0,3,1,9,9,8,9,0,0,0,8,8,9,5,2,4,3,4,5,0,6,5,8,5,4,1,2,2,7,5,8,8,6,6,6,8,8,1,
    			1,6,4,2,7,1,7,1,4,7,9,9,2,4,4,4,2,9,2,8,2,3,0,8,6,3,4,6,5,6,7,4,8,1,3,9,1,9,1,2,3,1,6,2,8,2,4,5,8,6,
    			1,7,8,6,6,4,5,8,3,5,9,1,2,4,5,6,6,5,2,9,4,7,6,5,4,5,6,8,2,8,4,8,9,1,2,8,8,3,1,4,2,6,0,7,6,9,0,0,4,2,
    			2,4,2,1,9,0,2,2,6,7,1,0,5,5,6,2,6,3,2,1,1,1,1,1,0,9,3,7,0,5,4,4,2,1,7,5,0,6,9,4,1,6,5,8,9,6,0,4,0,8,
    			0,7,1,9,8,4,0,3,8,5,0,9,6,2,4,5,5,4,4,4,3,6,2,9,8,1,2,3,0,9,8,7,8,7,9,9,2,7,2,4,4,2,8,4,9,0,9,1,8,8,
    			8,4,5,8,0,1,5,6,1,6,6,0,9,7,9,1,9,1,3,3,8,7,5,4,9,9,2,0,0,5,2,4,0,6,3,6,8,9,9,1,2,5,6,0,7,1,7,6,0,6,
    			0,5,8,8,6,1,1,6,4,6,7,1,0,9,4,0,5,0,7,7,5,4,1,0,0,2,2,5,6,9,8,3,1,5,5,2,0,0,0,5,5,9,3,5,7,2,9,7,2,5,
    			7,1,6,3,6,2,6,9,5,6,1,8,8,2,6,7,0,4,2,8,2,5,2,4,8,3,6,0,0,8,2,3,2,5,7,5,3,0,4,2,0,7,5,2,9,6,3,4,5,0};
    	
    	double largest = 0;
    	for(int i = 0; i < 1000 - 13; i++) {
    		int[] supList = new int[13];
    		double product = 1; 
    		for(int j = 0; j < 13; j++)
    			supList[j] = list[i + j];
    		for(int j = 0; j < 13; j++)
    			product *= supList[j];
    		if(product > largest)
    			largest = product;
       	}
    	System.out.println(largest);	
    }
    
    public static void prob9() {
    	int a = 1;
    	int b = 1;
    	int c = 1;
    	
    	looptyloop:
    	for(c = 5; c < 500; c++)
	    	for(b = 4; b < c; b++) 
	    		for(a = 3; a < b; a++)
		    		if((a * a) + (b * b) == (c * c))
		    			if(a + b + c == 1000)
		    				break looptyloop;
    	
    	System.out.println(a + "^2 " + b + "^2" + " = " + c + "^2" + " = " + (c * c));
    	System.out.println(a + " + " + b + " + " + c + " = " + (a + b + c));
    	System.out.println(a + " * " + b + " * " + c + " = " + (a * b * c));
   
    }
//    prime numbers below inputed number
    public static void prob10() {
    	Scanner scanIt = new Scanner(System.in);
    	boolean prime;
    	double sum = 0;
    	System.out.println("Enter the number you want all primes below.");
    	int num = scanIt.nextInt();
    	for(int i = 2; i < num; i++) {
    		 prime = isPrime(i);
    		 if(prime == true) {
    			 sum += i;
    			 System.out.println(i);
    		 }
    		 if(i % 10 == 1 || i % 10 == 7 || i % 10 == 9)
 	        	i++;
    		 if(i > 3)
    			 if(i % 10 == 3)
    				 i += 3;
    	}
    	System.out.println(sum);
    	//scanIt.close();
    		
    }
    
    public static void prob11() {
    	int[][] series = new int[20][20];
//    	Entering the series
    	try {
    		int line = 0;
    		Scanner scanIt = new Scanner(new File("C:/Users/Soulc/OneDrive/Documents/Problem 11 grid.txt"));
    			while(scanIt.hasNext()) {
    				String[] newString = scanIt.nextLine().split(" ");
    				for(int index = 0; index < newString.length; index++) {
    					series[line][index] = Integer.parseInt(newString[index]);
    				}
    				line++;
    			}
    		////scanIt.close();
    	} catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	int largest = 0;
    	for(int i = 0; i < series.length; i++) {
    		for(int j = 0; j < series.length; j++) {
	    		int[] verList = new int[4];
	        	int[] horList = new int[4];
	        	int[] diagList = new int[4];
	        	int product = 1;
	        	
	        	// Vertical products
	        	if(i < series.length - 4) {
	        		product = 1;
		        	for(int next = 0; next < 4; next++) {
		        		verList[next] = series[i + next][j];
		        	}
		        	for(int next = 0; next < 4; next++) {
		        		product *= verList[next];
		        	}
		        	if(product > largest)
		        		largest = product;
	        	}
	        	
	        	// horizontal products
	        	if(j < series.length - 4) {
	        		product = 1;
		        	for(int next = 0; next < 4; next++) {
		        		horList[next] = series[i][j + next];
		        	}
		        	for(int next = 0; next < 4; next++) {
		        		product *= horList[next];
		        	}
		        	if(product > largest)
		        		largest = product;
	        	}
	        	
	        	// diagonal products
	        	if(i < series.length - 4 && j < series.length - 4) {
	        		product = 1;
		        	for(int next = 0; next < 4; next++) {
		        		diagList[next] = series[i + next][j + next];
		        	}
		        	for(int next = 0; next < 4; next++) {
		        		product *= diagList[next];
		        	}
		        	if(product > largest)
		        		largest = product;
		    	}
	        	
	        	// reverse diagonal products
	        	if(i < series.length - 4 && j > 2) {
	        		product = 1;
		        	for(int next = 0; next < 4; next++) {
		        		diagList[next] = series[i + next][j - next];
		        	}
		        	for(int next = 0; next < 4; next++) {
		        		product *= diagList[next];
		        	}
		        	if(product > largest)
		        		largest = product;
		    	}
    		}    		
    	}
    	System.out.println(largest);
    }
    
    //first triangular number with +500 divisors
    public static void prob12() {
    	int value = 1;
    	int oldValue = value;
    	for(int i = 2; i < 999999; i++) {
    		int divisors = numOfDivisors(value);
    		if(divisors <= 500) {
    			//System.out.println(oldValue + " + " + (i - 1) + " = " + value + "| Divisors: " + divisors);
    			oldValue = value;
    			value += i;
    		}
    		else {
    			System.out.println("Divisors: " + divisors + " at " + value);
    			break;
    		}
    	}
    	
    	System.out.println(value);
    }
    
    //Sum of 100 50-digit numbers 
    public static void prob13() {
    	BufferedReader reader = null;
    	int[] array = new int[100];
    	BigInteger sum = BigInteger.valueOf(0);
    	try {
    		reader = new BufferedReader(new FileReader("C:/Users/Soulc/OneDrive/Documents/Problem 13 numbers.txt"));
    		String text = null;
    		while((text = reader.readLine()) != null) {
//    			System.out.println("  " + sum + "\n+ " + text + " = ");
    			sum = sum.add(new BigInteger(text));
//    			System.out.println("  " + sum);
    		}
    	} catch(FileNotFoundException e) {
    		e.printStackTrace();    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(reader != null) {
    				reader.close();
    			} 
    		} catch(IOException e) {	
    		}
    	}
    	System.out.println("Sum = " + sum.toString());
    }
    
    //Largest Collatz chain <1,000,000
    public static void prob14() {
    	int current = 0;
    	double num = 1;
    	int largestChain = 0;
    	int largest = -1;
    	for(int i = 999999; i > 0; i--) {
    		num = i;
    		current = 0;
    		while(num != 1) {
    			current++;
    			num = collatzNum(num);
    		}
    		if(current > largestChain) {
				largestChain = current;
				largest = i;
    		}
    	}
    	System.out.println(largest + " goes on for: " + largestChain);
    }
    
     public static BigInteger latticePaths(int i, int j) {
    	if(i == 0 || j == 0)
    		return BigInteger.valueOf(1);
    	else return latticePaths(i - 1, j).add(latticePaths(i, j - 1));
    }
    
    //after I looked up the lattice paths
    public static BigInteger betterLatticePaths(int size) {
    	BigInteger x = BigInteger.valueOf(size);
    	BigInteger answer = factorial(x.multiply(BigInteger.valueOf(2))).divide(factorial(x).multiply(factorial(x)));
    	return answer;
    }
//    20 x 20 lattice path (How many paths?) pretty hard one
//    hints: 1 x 1 = 2 | 2 x 2 = 6 | 3 x 3 = 20 | 4 x 4 = 70 | 5 x 5 = 252
//    vertex_paths(i, j) = vertex_paths(i-1, j) + vertex_paths(i, j-1)
//    recursion???????
//    recursion!!!!!!!
    public static void prob15() {
    	int size = 20;
    	BigInteger answer = latticePaths(size, size); //represents an array of vertices
    	System.out.println(answer);
    }
}
