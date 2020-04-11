package codechallenge.cadburydist;


import java.util.*;
public class CandidateCode {
    static int m,n,p,q;
    public static void main(String args[] ) throws Exception {

    	Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        p=scanner.nextInt();
        q=scanner.nextInt();
        CandidateCode cc=new CandidateCode();
        int totalPossibleDistributions=0;
        for(int i=1;i<=cc.getNumberOfBars();i++){
            totalPossibleDistributions+=cc.getNumberOfDistForBar(i);
        }
        System.out.println(totalPossibleDistributions);
   }

   int getNumberOfBars(){
        return (n-m+1)*(q-p+1);
   }

   int getNthBarLength(int i){
        if(i<1 || i>this.getNumberOfBars()){
            return -1;
        }else{
            double tmp=Math.ceil((double) i/(double)(q-p+1));
            return m+(int)tmp-1;
        }
    }

     int getNthBarWidth(int i){
        if(i<1 || i>this.getNumberOfBars()){
            return -1;
        }else{
            int tmp=i%(q-p+1);
            return tmp>0?p+tmp-1:q;
        }
    }

     int getNumberOfDistForBar(int idx){
        int tmpl=this.getNthBarLength(idx);
        int tmpw=this.getNthBarWidth(idx);
        int dist=0;
        while(tmpl>0){
            if(tmpl>tmpw){
                tmpl=tmpl-tmpw;
                dist++;
            }else if(tmpw>tmpl){
                tmpw=tmpw-tmpl;
                dist++;
            }else{
                tmpl=0;
                dist++;
            }
        }
        return dist;
    }
}