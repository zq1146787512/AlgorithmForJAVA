package com.zhang.string;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepetitionArray {
	
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        s.nextLine();
        String k = s.nextLine();
        int[] a =new int[N];
        String[] ks = k.split(" ");
        for(int i=0;i<N;i++){
            a[i]=Integer.parseInt(ks[i]);
        }
        
        for(int i=0;i<deSame(a).size()-1;i++){
            System.out.print(deSame(a).get(i)+" ");
        }
         System.out.print(deSame(a).get(deSame(a).size()-1));
        
    }
    
    public static List<Integer> deSame(int[] a){
        List<Integer> s = new ArrayList<>();
        
        for(int i=0;i<a.length-1;i++){
             s.add(a[i]);
             if(s.contains(a[i+1])){
                s.remove((Integer)a[i+1]);
                 
                
            }
            
        }
        s.add(a[a.length-1]);
        
        
        return s;
    }
	
	

}
