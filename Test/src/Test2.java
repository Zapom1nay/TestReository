import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Test2 {
	
  public static void main(String[] args) throws FileNotFoundException { 
		  
	  Scanner input = new Scanner(new File("input.txt"));
	  String str = input.nextLine();
	  String[] letters = new String[str.length()];
	  for (int i = 0; i < str.length(); i++) {
		  letters[i] = str.substring(i, i + 1);
	  }
	  
	  Arrays.sort(letters);
	  
	  int count = 1;
	  int place = 0;
	  String[][] frequency = new String[letters.length][2];
	  
	  for (int i = 0; i < letters.length; i++) {
	      if(i == letters.length - 1) {
			  frequency[place][0] = letters[i];
			  frequency[place][1] = String.valueOf(count);
			  break;
		  }
		  if(letters[i].equals(letters[i + 1])) {
			  count++;
		  }
		  else {
			  frequency[place][0] = letters[i];
			  frequency[place][1] = String.valueOf(count);
			  place++;
			  count = 1;
		  }
	  }
	  
	  for (int i = 0; i < frequency.length; i++) {
		  if (frequency[i][0] == null) {
			  frequency = Arrays.copyOfRange(frequency, 0, i);
		  }
	  }
	  	  
	  Arrays.sort(frequency, new Comparator<String[]>() {

		@Override
		public int compare(String[] o1, String[] o2) {		
			return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
		}
	});
	  
	  for (int i = 0; i < frequency.length; i++) {
		  System.out.print(frequency[i][0]);
		  System.out.println(frequency[i][1]);
	  }
	  
  }
	 
}