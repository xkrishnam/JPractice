package codechallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * check string for palindrome and anagram of palindrome
 *
 */
public class PalindromeAndAnagramOfPalindrome {
    public static void main(String[] args) {
        List<String> wordsPPLD = Arrays.asList("kayak", "sagas", "solos", "eve", "anna","foo", "bar", "buzz", "fizz", "cloud");
        List<String> wordsPANA = Arrays.asList("foo", "kkppd", "buxzbu", "pizizp", "gggoo","abcd", "five", "eleven", "pizza", "eved");

        for(String str:wordsPPLD)
            System.out.println(isPldrm(str));
        System.out.println("-------------------------");
        for(String str:wordsPANA)
            System.out.println(str+"--"+isAnaOfPld(str));
    }

    public static boolean isPldrm(String str){
        for(int i=0,j=str.length()-1;i!=j && i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return  true;
    }

    public static boolean isAnaOfPld(String str){
        Map<Character,Integer> tmp=new HashMap();
        int i;
        for (char a:str.toCharArray()) {
            if(tmp.containsKey(a)){
              i=tmp.get(a);
              tmp.put(a,i+1);
            }else{
                tmp.put(a,1);
            }
        }

        if(str.length()%2==0){
            for (Map.Entry<Character,Integer> e:tmp.entrySet()) {
                if(e.getValue()%2!=0)
                    return false;
            }
        }else{
            int oddCount=0;
            for (Map.Entry<Character,Integer> e:tmp.entrySet()) {
                if(e.getValue()%2!=0)
                    oddCount++;
            }
            return oddCount==1;
        }
        return true;
    }
}
