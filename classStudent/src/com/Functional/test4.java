package com.Functional;

import java.util.stream.IntStream;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.range(1, 51).forEach(i->System.out.print(i));//termianl opertaion 
		// diplay odd number in the range 1-50
		IntStream.rangeClosed(1, 50)
		.filter(i-> i%2!=0)// intStream --odd no 1234....50
		.forEach(i->System.out.print(i+" "));// terminal operation
	}

}
