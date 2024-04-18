package com.qa.opencart.utils;

public class TimeUtil {
	
	public final static int DEFAULT_TIME=500;
	public final static int DEFAULT_SHORT_TIME=2;
	public final static int DEFAULT_MEDIUM_TIME=5;
	public final static int DEFAULT_LONG_TIME=10;
	public final static int MAX_TIME=15;
	
	public static void defaulttime()
	{
		try {
			Thread.sleep(DEFAULT_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void shorttime()
	{
		try {
			Thread.sleep(DEFAULT_SHORT_TIME*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void mediumtime()
	{
		try {
			Thread.sleep(DEFAULT_MEDIUM_TIME*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void longtime()
	{
		try {
			Thread.sleep(DEFAULT_LONG_TIME*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void maxtime()
	{
		try {
			Thread.sleep(MAX_TIME*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
