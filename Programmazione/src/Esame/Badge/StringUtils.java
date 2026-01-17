package Esame.Badge;

public class StringUtils {
	private StringUtils(){}

	public static int countUppercaseWord(String s){
		int uppercaseWords = 0;
		String[] words = s.split(" ");
		for(int i = 0; i < words.length; i++){
			boolean isUppercase = true;
			for(int j = 0; j < words[i].length(); j++){
				if(!Character.isUpperCase(words[i].charAt(j))){
					isUppercase = false;
					break;
				}
			}
			if(isUppercase) uppercaseWords++;
		}
		return uppercaseWords;
	}
	public static boolean isOnlyLetter(String s){
		for(int i = 0; i < s.length(); i++){
			if(Character.isDigit(s.charAt(i))) return false;
		}
		return true;
	}
}
