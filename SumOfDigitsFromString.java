package week2.day2.assignments;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declare a String text with the following value
				String text = "Tes12Le79af65";
				// Declare a int variable sum
				int sum = 0;

				// a) using replaceAll(), replace all the non-digits into ""
				String nwStrng = text.replaceAll("\\D", "");
				System.out.println(nwStrng);

				// Now, convert the String into array
				char[] nwCharStrng = nwStrng.toCharArray();

				// Iterate over the array and get each character
				for (int i = 0; i < nwCharStrng.length; i++) {
					// Using Character.getNumericValue(), Change the char into int
					int charNmValue = Character.getNumericValue(nwCharStrng[i]);

					// Add the values to sum
					sum = sum + charNmValue;

				}

				// Print the total sum
				System.out.println("The Sum of Digits from String : " + sum);
	}

}
