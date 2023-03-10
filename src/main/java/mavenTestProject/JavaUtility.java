package mavenTestProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * its used to generate the random number with in 
	 * @return
	 */
	public static int getRanDomNumber() {
		Random ranDom=new Random();
		int ranDomNum=ranDom.nextInt(1000);
		return ranDomNum;
	}
	/**
	 * its used to get the current system date based on yyyy-mm-dd formate
	 * @return
	 */

	public String getSystemDate() {
		Date date =new Date();
		String currentDate=date.toString();
		System.out.println(currentDate);
		String[] arr=currentDate.split(" ");
		
		String yyyy=arr[5];
		String dd=arr[2];
		int mm=date.getMonth()+1;
		String formate=yyyy+"-"+mm+"-"+dd;
		return formate;
		
	}
	
	/**
	 * This method is used to get System date
	 * @return
	 */
	public String getSystemDate1() throws Throwable
	{
		Date date = new Date();
		String SystemDate =date.toString();
		return SystemDate;
	}
	public String getSystemDateInIST() {
		
		Date date=new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String [] arr=currentDate.split(" ");
		
		String yyyy=arr[5];
		String dd=arr[2];
		int mm=date.getMonth()+1;
		String formate=dd+"-"+mm+"-"+yyyy;
		return formate;
			
		
	}
	
	
	public String getSystemDateAndTimeInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date systemdate =new Date();
		String getDateAndTime = dateformat.format(systemdate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":","-");
				
				
	}
	
	
	
	
	
}
