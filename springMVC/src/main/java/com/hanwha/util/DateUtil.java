package com.hanwha.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class DateUtil {
	
	public static Date transDate(String sdate) {
		
		Date sql_date = null;
		SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-DD");
		try {
			java.util.Date d = sd.parse(sdate);
			sql_date = new Date(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sql_date;
		
		
		/*
		//날짜를 문자열로 입력 받았을 때
		String sdate = "2019-08-01";
		SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-DD");
		try {
			Date d = sd.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//오늘 날짜를 바꾸는거
		java.util.Date d1 = new java.util.Date();
		Date d2 = new Date (d1.getTime());
		System.out.println(d2);
		*/
	}
	
}
