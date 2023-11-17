package algo.strings;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Convert {

    // " " ===> "%20"
    String convert(String input){

        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();

        int i=0;
        while(i<chars.length){

            if(chars[i]==' '){
                sb.append("%20");
                //escape spaces
                while(i<chars.length&&chars[i]==' ') {
                    i++;
                }
            }
            if(i<chars.length){
                sb.append(chars[i]);
            }
            i++;
        }
        return sb.toString();
    }


    boolean isPalindromeCharAt(int x){
if(x<0)
    return false;
            String sx = String.valueOf(x);
            int i=0;
            while(i<sx.length()/2&&sx.charAt(i)==sx.charAt(sx.length()-1-i)){
                i++;
            }
        System.out.println(i);
            return sx.length()/2==i;

    }

    boolean isPalindrome(String input){
        input = input.replaceAll("\s+","").toLowerCase();


        int[] chars = new int[26];
        char[] inputChars=input.toCharArray();
        for(int i=0;i<inputChars.length;i++){
            chars[inputChars[i]-96]++;
        }
        int count =0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]%2==1){
                count++;
            }
            if(count>1){
                return false;
            }
        }


        return true;
    }

    public boolean equalFrequency(String word) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){

            if(map.containsKey((word.charAt(i)-97)%26)) {
                map.put((word.charAt(i) - 97) % 26, map.get((word.charAt(i) - 97) % 26) + 1);
            }
            else{
                map.put((word.charAt(i) - 97) % 26, 1);
            }
        }
        int i=0;
        int outlier = -1;
        Object[] list = map.values().toArray();
        while(i<list.length-1){
            if(Math.abs((Integer)list[i]-(Integer)list[i+1])>1){
                return false;
            }
            int diff = (Integer)list[i+1]-(Integer)list[i];
            if(diff!=0){
                int currentMax = diff>0?i+1:i;
                if(outlier!=-1&&outlier<=currentMax)
                    return false;
                else{
                    if(currentMax>outlier)
                    outlier=currentMax;
                }
            }
            i++;
        }
        if(outlier==-1&&list.length!=1&&(Integer)list[0]>1)
            return false;
        return true;
    }

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>();
        List arr = new ArrayList();
        //basic
/*
        System.out.println("Mr John Smith   ".replaceAll("\s+","\\%20"));
*/

        //impl
        Convert con = new Convert();
        System.out.println(con.equalFrequency("aca"));

        //System.out.println(con.convert("Mr John Smith   "));

/*        System.out.println((char)('a'-32));
        System.out.println(con.isPalindrome("Tact Coa"));

        System.out.println("gg!!sdds.sdsd!".replaceAll("(!+)","$0!"));*/
    }
}
