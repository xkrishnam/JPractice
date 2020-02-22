package techGig.codewar;

import java.util.*;

public class MagmaNum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nOfTest=scanner.nextInt();
        Integer[] tests=new Integer[nOfTest];
        int prev=0,curr=0,prevCount=0;
        for(int i=0;i<nOfTest;i++){
            tests[i]=scanner.nextInt();
        }
        Arrays.sort(tests);
        int count=0;
        int idx=0;
        for(int i=8;i<=tests[nOfTest-1];i++){
            if(isMagma(i))
                count++;

            if(tests[idx]<8) {
                System.out.println(0);
                idx++;
            }
            if(tests[idx]==i){
                System.out.println(count);
                idx++;
            }
        }
    }

    public static boolean isMagma(int num) {
        int j = 0;
        for (int i = 2; i <= num; ) {
            if (num % i == 0) {
                j++;
                if (j == 3) {
                    return true;
                }
                num=num/i;
            } else {
                i++;
                j=0;
            }
        }
        return false;
    }
}
