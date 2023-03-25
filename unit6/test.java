import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //remember to import!
        System.out.print("Please type a string: ");
        String s = in.nextLine();
        System.out.println("#1: "+s.charAt(2));
        System.out.println("#2: "+s.charAt(4));
        System.out.println("#3: "+s.length());
        System.out.println("#4: "+s.charAt(0));
        System.out.println("#5: "+s.charAt(s.length()-1));
        System.out.println("#6: "+s.charAt(s.length()-2));
        System.out.println("#7: "+s.substring(3,8));
        System.out.println("#8: "+s.substring(s.length()-5));
        System.out.println("#9: "+s.substring(3));
        System.out.println("#10: "+s.toLowerCase());
        System.out.println("#11: "+s.toUpperCase());
        char[] twelve=new char[s.length()];
        int eCount=0;
        int ECount=0;
        int vowelCount=0;
        for (int i=0;i<s.length();i++) {
            twelve[i]=s.charAt(i);
            if (s.substring(i,i+1).equals("e")) eCount++;
            if (s.substring(i,i+1).toLowerCase().equals("e")) ECount++;
            if( s.substring(i,i+1).toLowerCase().equals("e") || s.substring(i,i+1).toLowerCase().equals("o") || s.substring(i,i+1).toLowerCase().equals("u") || s.substring(i,i+1).toLowerCase().equals("a") || s.substring(i,i+1).toLowerCase().equals("i")) vowelCount++;
        }
        char[] vowels=new char[vowelCount];
        int j=0;
        for (int i=0;i<s.length();i++) {
            if( s.substring(i,i+1).toLowerCase().equals("e") || s.substring(i,i+1).toLowerCase().equals("o") || s.substring(i,i+1).toLowerCase().equals("u") || s.substring(i,i+1).toLowerCase().equals("a") || s.substring(i,i+1).toLowerCase().equals("i")) vowels[j++]=s.charAt(i);
        }
        System.out.println("#12: "+Arrays.toString(twelve));
        System.out.println("#13: "+s.substring(1));
        System.out.println("#14: "+s.substring(0,s.length()-1));
        System.out.println("#15: "+eCount);
        System.out.println("#16: "+ECount);
        System.out.println("#17: "+vowelCount);
    
        System.out.println("#18: "+Arrays.toString(vowels));
        
        String newS="";
        String otherS="";
        for (var i=0;i<s.length();i++) {
            if (i%2==0) newS+=s.charAt(i);
            else  otherS+=s.charAt(i);
        }
        System.out.println("#19: "+newS);
        System.out.println("#20: "+otherS);
        String[] thing=new String[s.length()-1];
        for (int i=0;i<s.length()-1;i++) {
            thing[i]=s.substring(i,i+2);
        }
        System.out.println("#21: "+Arrays.toString(thing));
        String ah="";
        for (var i=0;i<s.length();i++) {
            if (i%3==0) ah+='!';
            else ah+=s.charAt(i);
        }
        System.out.println("#22: "+ah);
        ah="";
        for (var i=0;i<s.length();i++) {
            if ((i-2)%3==0 && i>=2) ah+='!';
            else ah+=s.charAt(i);
        }
        System.out.println("#23: "+ah);
    }
}