package regex1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegularExpressions
{
	
	public static void main (String[]args) 
	{
		String name;
		String birthday;
		String email;
		String website;
		ArrayList<String> websiteList = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);
		
		Pattern nameRegex = Pattern.compile("(([A-Z]\\. ){1,2}|[A-Z]\\w+ ([A-Z]\\. )?)[A-Z]\\w{2,}");
		/*allows 12 months per year, 31 days per month; year either 2 numbers, 
		 or 4 numbers beginning 19 or 20, with either a forward slash or dash between numbers.
		 It is probably a bad practice to allow multiple formats, but this is the assignment.*/
		Pattern birthRegex = Pattern.compile("(0[1-9]|1[0-2])[-/](0[1-9]|[1-2][0-9]|3[0-1])[-/]((19|20)\\d\\d|\\d\\d)");
		//allows dot in name, multiple dots after @
		Pattern emailRegex = Pattern.compile("\\w{2,}(\\.\\w+)?@\\w+(\\.\\w+)?.(com|edu|co\\.il)");
		String websiteRegex = ("https?:\\/\\/www\\.[\\w\\d_]+\\.(com|edu|co.il)(\\/(\\w+\\.)*\\w{3,4})*");
		
		Matcher nameMatcher;
		Matcher birthMatcher;
		Matcher emailMatcher;
		
		
		System.out.println("All input must be valid to proceed.");
		
		do {
			System.out.println("Enter your name:");
			name = keyboard.nextLine();
			nameMatcher = nameRegex.matcher(name);
	    }while(!nameMatcher.matches());
	    	
		do{
			System.out.println("Enter your birthday:");
			birthday = keyboard.nextLine();
			birthMatcher = birthRegex.matcher(birthday);
		}while(!birthMatcher.matches());
		
		do{
			System.out.println("Enter your email:");
			email = keyboard.nextLine();
			emailMatcher = emailRegex.matcher(email);
		}while(!emailMatcher.matches());
		
		
		for(int w = 0; w < 10; w++) {
			System.out.println("Enter your 10 favorite websites: now up to number "+(w+1));
			website = keyboard.nextLine();
			websiteList.add(website);
		}
		
		
		
		Stream<String> urls = websiteList.stream().filter(w -> w.matches(websiteRegex));
			
        urls.forEach(System.out::println);
		
	}
}
