package com.erkinceylan;

import java.util.Scanner;

public class TestCode {
	public static void main (String [] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("day : ");
		int day = Integer.parseInt(kb.nextLine());
		
		System.out.println("month : ");
		int mon = Integer.parseInt(kb.nextLine());
		
		System.out.println("year : ");
		int year = Integer.parseInt(kb.nextLine());
		
		DateUtil.displayDateTR(day, mon, year);
		
		kb.close();
	}
}
