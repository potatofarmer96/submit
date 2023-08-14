package main;

public class Solution {
	
	private String shift;
	
	//shift table
	private String[] check = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",
			"Q","R","S","T","U","V","W","X","Y","Z",
			"0","1","2","3","4","5","6","7","8","9",
			"(",")","*","+",",","-",".","/"};
	
	//constructor 
	public Solution ( String shift) {
		this.shift = shift;
	}
	
	//encode method
	public String encode ( String plainText) {
		//initialize result
		String result = "";
		
		//looping through input array
		for ( int i = 0; i < plainText.length(); i++) {
			
			//Naming each alphabet Part
			String part = plainText.substring(i,i+1);

			//Handling space
			if ( part.equals(" ")) {
				result += " ";
			}
			
			//logic
			else {
				//obtaining index of part
				int index = checkIndex(part);
				
				//obtaining index of the new sentence
				int encrypted = index - checkIndex(shift);
				
				//handling overflowing
				if (encrypted < 0) {
					encrypted += 44;
				}
				//summing up all the alphabets into a sentence
				result += check[encrypted];
			}
		}
		
		return shift+result;
	}
	
	//decode method
	public String decode( String encodedText) {
		//initialize result
		String result = "";
		
		//extracting the key that it was encrypted with
		String st = encodedText.substring(0,1);
		
		//looping through input array
		//start from 1 because at 0 its the key
		for ( int i = 1; i<encodedText.length(); i++ ) {
			
			//Naming each alphabet Part
			String part =encodedText.substring(i, i+1);
			
			//Handling space
			if ( part.equals(" ")) {
				result += " ";
			}
			
			//logic
			else {
				//obtaining index of part
				int index = checkIndex(part);
				//obtaining the index of original sentence 
				int decrypt = index + checkIndex(st);
				
				//handling overflowing
				if ( decrypt > 43) {
					decrypt -= 44;
				}
				//summing up all the alphabets into a sentence
				result += check[decrypt];
				
			}
		}
		return result;
	}
	
	//method for other method to call
	public int checkIndex (String s) {
		for (int i = 0; i < check.length; i++) {
			if ( check[i].equals(s)) {
				return i;
			}
		}
		return 0;
	}
	
	//running program 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution test = new Solution("B");
		
		String plainText = "HELLO WORLD";
		
		String encodedText = test.encode(plainText);
		
		String decodedText = test.decode(encodedText);
		
		System.out.println("Original: " + plainText);
		System.out.println("Encoded Text: " + encodedText);
		System.out.println("Decoded Text: " + decodedText);
		

	}

}
