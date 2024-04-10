package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class P3_CountOccurencesOfAnagrams {
    public static void main(String[] args) {

        String txt = "forxxorfxdofr";
        String pat = "for";

        System.out.println(search1(txt,pat));
    }

    private static int search1(String txt, String pat) {

        int ansCount=0;

        for(int i=0;i<txt.length()-pat.length()+1;i++){
            String temp="";
            for(int j=i;j<i+pat.length()+1;j++){
                char ch=txt.charAt(j);
                temp+=ch;
            }
            if(temp.equals(pat)) ansCount++;
        }


        return ansCount;


    }

    private static int search2(String txt, String pat) {

        Map<Character,Integer> pattern=new HashMap<>();

        for(int i=0;i<pat.length();i++){

            char ch=pat.charAt(i);

            if(pattern.containsKey(ch)) pattern.put(ch,pattern.get(ch)+1);
            else pattern.put(ch,1);
        }

        int k=pat.length();
        Map<Character,Integer> text=new HashMap<>();

        int i=0,j=0,ansCount=0;
        while (j<txt.length()){

            char ch=txt.charAt(j);

            if(text.containsKey(ch)) text.put(ch,text.get(ch)+1);
            else text.put(ch,1);

            if(j-i+1<k) j++;
            else if(j-i+1 == k){

                if(pattern.equals(text)){
                    ansCount++;
                }

                char removeChar=txt.charAt(i);


                text.put(removeChar,text.get(removeChar)-1);

                if(text.get(removeChar)==0) text.remove(removeChar);


                i++;
                j++;


            }


        }

        return ansCount;


    }
}
