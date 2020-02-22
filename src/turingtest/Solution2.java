package turingtest;

import java.util.*;
import java.lang.*;
class Solution2
{
    static List<String> subSeqInit=new ArrayList<>();
    static int count=0;
    public static int minimumConcat(String initial, String goal) {
        int idx =-1;
        String tmp="";
        getSubSeq (initial,idx,tmp);
        Collections.sort(subSeqInit, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length()>t1.length()?-1:(s.length()==t1.length())?0:1;
            }
        });

        String[] tmp1=null;
        for(int i=0;i<goal.length();i++){
            if(!initial.contains(String.valueOf(goal.charAt(i)))){
                return 0;
            }
        }
        setCount(goal);
        return count;
    }

    static void setCount(String goal){
        for(String str:subSeqInit) {
            if (!str.equals("") && goal.contains(str)) {
                count++;
                if (goal.split(str).length > 0 && goal.split(str)[0].length()>0) {
                    for (String str1 : goal.split(str)) {
                        setCount(str1);
                    }
                }
                break;
            }
        }
    }

    static void getSubSeq(String str , int index,String tmp){
        if(index == str.length())
            return;

        subSeqInit.add(tmp);
        for(int i=index+1;i<str.length();i++){
            tmp += str.charAt(i);
            getSubSeq(str,i,tmp);
            tmp=tmp.substring(0,tmp.length()-1);
        }

    }

}

class Rextester
{
    public static void main(String args[])
    {
//        Scanner sc = new Scanner(System.in);
//
//        String initial = sc.next();
//        String goal = sc.next();

        int res = Solution2.minimumConcat("abc", "babcdacab");
        System.out.println(res);
    }
}