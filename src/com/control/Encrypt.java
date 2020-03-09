package com.control;

public class Encrypt {
	public String encrypt(String pw){
		//x*1128
		int len=pw.length();
		String ans=new String();
		for(int i=0;i<len;i++){
			ans=ans+String.valueOf(pw.charAt(i)*1128);
		}
		return ans;
	}
}
