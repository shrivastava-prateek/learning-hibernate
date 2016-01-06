package com.psl.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> numbers=new ArrayList<String>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		System.out.println(numbers);
		
		Set<String> Snumbers=new HashSet<String>();
		Snumbers.add("1");
		Snumbers.add("2");
		Snumbers.add("3");
		System.out.println(Snumbers);
	}

}
