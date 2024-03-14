package Storia_Main;

public class Methods {
    public static void main(String[] args) {
        System.out.println(disemvowel("wordEDur"));



    }
    public static int vocals(String word){
        int c = 0;
        for(int i=0; i<word.length();i++)
            if(Character.toString(word.charAt(i)).matches("[aeiou]"))
                c++;
        System.out.println(c);
        return c;
    }

    public static String disemvowel(String str) {
        str.replace
        String cons="";
        for(char a:str.toCharArray()){
            if(!Character.toString(a).matches("[aeiouAEIOU]"))
                cons = cons + a;
        }
        return cons;
    }
}
