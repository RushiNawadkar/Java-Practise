package com.Functional;

import java.util.stream.IntStream;

public class test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Displya Sum of Square of the even nos between= 1=100
		int result=IntStream.rangeClosed(1, 100)
		.filter(i-> i%2==0) //
		.map(i->i*i) //intStream: sq of even
		.sum();//Returns the sum of elements in this stream. This is a special caseof a reduction 
		System.out.println("sum"+" "+result+" ");
	}

}
