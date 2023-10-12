package algo.strings;

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


    public static void main(String[] args) {
        //basic
        System.out.println("Mr John Smith   ".replaceAll("\s+","\\%20"));

        //impl
        Convert con = new Convert();
        System.out.println(con.convert("Mr John Smith   "));

        System.out.println((char)('a'-32));
        System.out.println(con.isPalindrome("Tact Coa"));
    }
}
