package solutions;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;

public class SolutionFor19 implements Solution {

	@Override
	public void solve() {
		/*
		 * You are given the following information, but you may prefer to do
		 * some research for yourself.
		 * 
		 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and
		 * November. All the rest have thirty-one, Saving February alone, Which
		 * has twenty-eight, rain or shine. And on leap years, twenty-nine. A
		 * leap year occurs on any year evenly divisible by 4, but not on a
		 * century unless it is divisible by 400. How many Sundays fell on the
		 * first of the month during the twentieth century (1 Jan 1901 to 31 Dec
		 * 2000)?
		 */		
		
		int startYear = 1901;
//		Year endYear = Year.of(2000);
		
		int ansCount = 0;
		for(int i = 0; i < 100; i++){
			Year y = Year.of(startYear + i);
			for(Month m: Month.values()){
				ansCount += y.atMonth(m).atDay(1).getDayOfWeek().compareTo(DayOfWeek.SUNDAY) == 0 ? 1: 0 ;
			}
		}
		System.out.println("Number of Sundays in 20th Century is " + ansCount);
	}

}
