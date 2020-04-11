package codechallenge.cadburydist;

import java.util.*;
public class BrillioCandidateCode {
//    public static void main(String args[] ) throws Exception {
//        Scanner scanner=new Scanner(System.in);
//        int nOfStudents=scanner.nextInt();
//         //int[] attendance=new int[nOfStudents];g
//        StringBuilder res=new StringBuilder();
//        for(int i=1;i<=nOfStudents;i++){
//            if(scanner.nextInt()!=i) {
//                res.append(i);
//                res.append(" ");
//            }
//    }
//        System.out.println(res.toString().trim());
//}

    static int fact[];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nOfHunters=scanner.nextInt();
        int nOfPairs=scanner.nextInt();
        fact=new int[nOfHunters+1];

        int teamCount=preloadFactorialCache(nOfHunters)/(2*preloadFactorialCache(nOfHunters-2))-nOfPairs;
        int[][] pair=new int[nOfPairs][2];
        for(int i=0;i<nOfPairs;i++){
            pair[0][0]=scanner.nextInt();
            pair[0][1]=scanner.nextInt();
        }
        System.out.println(teamCount);
    }


    static int preloadFactorialCache(int num)
    {
        if(num==0){
            fact[num]=1;
            return fact[num];
        }
        else
            fact[num]=(num)*preloadFactorialCache(num-1);

        return fact[num];
    }
}
