package com.erkinceylan;

public class DateUtil {
	public static void displayDateTR(int day, int mon, int year)
	{
		int dayOfWeek = getDayOfWeek(day, mon, year);
		
		if (dayOfWeek == -1) {
			System.out.println("Invalid date");
			return;
		}
		System.out.printf("%02d/%02d/%04d ", day, mon, year);
		
		
		switch (dayOfWeek) {
		case 0:
			System.out.println("Sunday");
			break;
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		}
			
	}
	
	public static int getDayOfWeek(int day, int mon, int year)
	{	
		int totalDays = getDayOfYear(day, mon, year);
		
		if (totalDays == -1)
			return -1;
		
		for (int y = 1900; y < year; ++y) {
			totalDays += 365;
			if (isLeapYear(y))
				++totalDays;
		}
		
		return totalDays % 7;			
	}
	
	public static int getDayOfYear(int day, int mon, int year)
	{
		if (!isValidDate(day, mon, year))
			return -1;
		
		int dayOfYear = day;
		
		switch (mon - 1) {
		case 11:
			dayOfYear += 30;
		case 10:
			dayOfYear += 31;
		case 9:
			dayOfYear += 30;
		case 8:
			dayOfYear += 31;
		case 7:
			dayOfYear += 31;
		case 6:
			dayOfYear += 30;
		case 5:
			dayOfYear += 31;
		case 4:
			dayOfYear += 30;
		case 3:
			dayOfYear += 31;
		case 2:
			dayOfYear += 28;
			if (isLeapYear(year))
				++dayOfYear;
		case 1:
			dayOfYear += 31;
		}		
		
		return dayOfYear;
	}
	
	public static boolean isValidDate(int day, int mon, int year)
	{
		if (day < 1 || day > 31 || mon < 1 || mon > 12)
			return false;
		
		int days = 31;
		
		switch (mon) {
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			days = 28;
			if (isLeapYear(year))
				++days;
			break;
		}
		
		return day <= days;
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}