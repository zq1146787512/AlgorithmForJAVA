package com.zhang.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
//
public class Test {
	

	public static void test(int[] b) {
		int a=( min(b).get("pos"));
		int k=( min(b).get("pos"));
		int asum=min(b).get("all");
		int ksum=min(b).get("all");
		
		for(int i=a;i<=k;i++){
			int[] ss=Arrays.copyOfRange(b, i, b.length);
		}

	}
	
	public static Map<String , Integer> min(int[] b){
		Map<String , Integer> map=new HashMap<>();
		int[] c = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			c[i] = b[i];
		}
		int k=0;
		int sum = 0;
		int length = b.length;
		Arrays.sort(c);
		for (int i = 0; i < b.length; i++) {
			sum = sum + b[i];
		}
		int MinA = (sum - c[0] - c[1] - c[2]) / 4;
//		int MaxA = (sum - c[length - 1] - c[length - 2] - c[length - 3]) / 4;
		
		for(int i=0;i<length;i++){
			k=k+b[i];
			if(k>=MinA){
				map.put("pos", i);
				map.put("all", k);
				return map;
				
			}
			
		}
		return null;
		
		
	}
	
	public static String max(int[] b){
		
		JSONObject ob=new JSONObject();
		int[] c = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			c[i] = b[i];
		}
		int k=0;
		int sum = 0;
		int length = b.length;
		Arrays.sort(c);
		for (int i = 0; i < b.length; i++) {
			sum = sum + b[i];
		}
//		int MinA = (sum - c[0] - c[1] - c[2]) / 4;
		int MaxA = (sum - c[length - 1] - c[length - 2] - c[length - 3]) / 4;
		
		for(int i=0;i<length;i++){
			k=k+b[i];
			if(k<=MaxA){
				ob.put("pos", i);
				ob.put("all", k);
				return ob.toString();
			}
			
		}
		return null;
		
		
	}
	
	
		
	
	

}
