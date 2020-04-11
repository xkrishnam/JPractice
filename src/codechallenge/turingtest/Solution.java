package codechallenge.turingtest;

import java.util.*;
import java.lang.*;

class Solution
{
    public static int numOffices(String[][] grid) {
        int result = 0;
        String[][] tmp=grid;
        for(int k=0;k<tmp.length;k++){
            for(int l=0;l<tmp[0].length;l++){
                if(tmp[k][l].equals("1")){
                   result++;
                   tmp[k][l]="f";
                   findAndMarkNeighbours(k,l,tmp);
                }
            }
        }
        return result;
    }

    public static void findAndMarkNeighbours(int row,int col,String[][] grid){
        if(row+1<grid.length && grid[row+1][col].equals("1")){
            grid[row+1][col]="f";
            findAndMarkNeighbours(row+1,col,grid);
        }

        if(col+1<grid[0].length && grid[row][col+1].equals("1")){
            grid[row][col+1]="f";
            findAndMarkNeighbours(row,col+1,grid);
        }
    }

    public static int biggestTable(String[][] grid) {
        int res = 0;
        for(int k=0;k<grid.length;k++){
            for(int l=0;l<grid[0].length;l++){
                if(grid[k][l].equals("1")){
                    res++;
                    grid[k][l]="f";
                    findAndMarkNeighbours(k,l,grid);
                }
            }
        }
        return res;
    }

    public static int getPossibleLength(int initRow,int initCol,String[][] grid){
        int row=initRow,col=initCol+1,length=1;
        while(grid[row][col].equals("1")){
            length++;
        }
        return length;
    }

    public static int getPossibleWidth(int initRow,int initCol,String[][] grid){
        int row=initRow+1,col=initCol,width=1;
        while(grid[row][col].equals("1")){
            width++;
        }
        return width;
    }

    public static int getBiggestTableSpace(int initRow,int initCol,String[][] grid){
        int l=getPossibleLength(initRow,initCol,grid);
        int w=getPossibleWidth(initRow,initCol,grid);
        String[][] tmp=new String[l][w];
        for(int k=0;k<tmp.length;k++){
            for(int l1=0;l1<tmp[0].length;l1++){
                tmp[k][l]=grid[initRow+k][initCol+l1];
            }
        }
        int tableSpace=l>w?l:w;
        if(l>1 && w>1 && getBiggestTableSpace(initRow+1,initCol+1,tmp)>0){
            //1-4,2-6,3-8,4-9,5-
        }

//        for(int i=+1;i<initRow+w-1;i++){
//            for(int j=initCol+1;j<initCol+l-1;j++){
//
//            }
//        }
        return 0;
    }


}


class Rextester1
{  
    public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
               matrix[i][j] = String.valueOf(line.charAt(j));  
            }
        }
        return matrix;
    }
    
    public static void main(String args[])
    {
        int result = Solution.numOffices(getMatrix()); 
        System.out.println(result);
    }
}