package Tutorato;

public class Stringhe {
    public static void main(String[] args) {
        char c = '9';
        boolean b = Character.isLetter(c);
        System.out.println(b ? "Lettera" : "Numero");
        System.out.println(countUppercase(new char[]{'C', 'a', 's', 'a'}));
    }

    private static int countUppercase(char[] string){
        int count = 0;
        for(int i = 0; i < string.length; i++){
            if(Character.isUpperCase(string[i])) count++;
        }
        return count;
    }

    private static String concatena(String first, String second){
        return first.concat(second);
    }
    private static int lunghezza(String first, String second){
        return first.length() + second.length();
    }
    private static int count(String s, char c){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c) count++;
        }
        return count;
    }
    private static boolean contains(String first, String second){
        return first.contains(second);
    }
    private static boolean contains(String s, String[] check){
        for(int i = 0; i < check.length; i++){
            if(!s.contains(check[i])) return false;
        }
        return true;
    }
    private static String acronym(String s){
        String acronym = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))) acronym += s.charAt(i);
        }
        return acronym;
    }
}
