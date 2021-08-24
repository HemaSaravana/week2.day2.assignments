package week2.day2.assignments;

public class removeDuolicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// a) Use the declared String text as input
				String text = "We learn java basics as part of java sessions in java week1";

				// Initialize an integer variable as count
				int count = 0;

				// c) Split the String into array and iterate over it
				String[] splitString = text.split(" ");

				for (int i = 0; i < splitString.length; i++) {

					for (int j = i + 1; j < splitString.length; j++) {

						if (splitString[i].equals(splitString[j])) {
							count = count + 1;

							if (count > 0) {
								splitString[j]="";

							}

						}

					}
					System.out.print(splitString[i] + " ");
				}
	}

}
