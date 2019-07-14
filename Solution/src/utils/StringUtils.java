package utils;

public class StringUtils {

	public static boolean isPalindrome(String s){
		
		s.length();
		
		for(int i=0, j=s.length()-1; i<j; i++, j--)
		{
			if(s.charAt(i)!=s.charAt(j)) return false;
		}
		return true;
		
	}
}
