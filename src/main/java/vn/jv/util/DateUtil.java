package vn.jv.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateUtil{
	
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	public static final String EXPORT_DATE_FORMAT = "MMddyyyy";
	public static final String SMART_KEY_DATE_FORMAT = "yyyy/MM/dd";
	public static final SimpleDateFormat TIMESTAMP_FORMATER = new SimpleDateFormat(DATE_FORMAT_NOW);
	
	public static boolean isValidDateFormat(String dateStr, String dateFormatStr) {
		try {
			if(dateStr == null) {
				return false;
			}
			DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
			return dateFormat.parse(dateStr) != null;
		} catch (Exception e) {
			return false;
		}
	}

	public static long timeDiff(String startDateStr, String startDateFormatStr, String endDateStr, String endDateFormatStr) {
		try {
			DateFormat startDateFormat = new SimpleDateFormat(startDateFormatStr);
			Date startDate = startDateFormat.parse(startDateStr);
			DateFormat endDateFormat = new SimpleDateFormat(endDateFormatStr);
			Date endDate = endDateFormat.parse(endDateStr);
			return endDate.getTime() - startDate.getTime();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static int dateDiff(String startDateStr, String startDateFormatStr, String endDateStr, String endDateFormatStr, String templateData) {
		try {
			if(startDateStr==null || endDateStr==null){
				if("P".equals(templateData) && endDateStr==null) return 0;
				return (startDateStr==endDateStr)?0:1;
			}
			if (isValidDateFormat(startDateStr, startDateFormatStr) && isValidDateFormat(endDateStr, endDateFormatStr)){
				return dateDiff(startDateStr, startDateFormatStr, endDateStr, endDateFormatStr);
			}else {
				return 1;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static int dateDiff1(String startDateStr, String startDateFormatStr, String endDateStr, String endDateFormatStr, String templateData) {
		try {
			if(startDateStr==null || endDateStr==null){
				if("P".equals(templateData) && endDateStr==null) return 1;
				return 0;
			}
			if (isValidDateFormat(startDateStr, startDateFormatStr) && isValidDateFormat(endDateStr, endDateFormatStr)){
				return dateDiff(startDateStr, startDateFormatStr, endDateStr, endDateFormatStr);
			}else {
				return 0;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static int dateDiff(String startDateStr, String startDateFormatStr, String endDateStr, String endDateFormatStr) {
		try {
			DateFormat startDateFormat = new SimpleDateFormat(startDateFormatStr);
			Date startDate = startDateFormat.parse(startDateStr);
			DateFormat endDateFormat = new SimpleDateFormat(endDateFormatStr);
			Date endDate = endDateFormat.parse(endDateStr);
			Calendar cStart = Calendar.getInstance();
			cStart.setTime(startDate);
			Calendar cEnd = Calendar.getInstance();
			cEnd.setTime(endDate);
			return(cEnd.get(Calendar.YEAR) - cStart.get(Calendar.YEAR)) * 365 + cEnd.get(Calendar.DAY_OF_YEAR) - cStart.get(Calendar.DAY_OF_YEAR);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static int yearDiff(String startDateStr, String startDateFormatStr, String endDateStr, String endDateFormatStr) {
		try {
			DateFormat startDateFormat = new SimpleDateFormat(startDateFormatStr);
			Date startDate = startDateFormat.parse(startDateStr);
			Calendar cStart = Calendar.getInstance();
			cStart.setTime(startDate);
			
			DateFormat endDateFormat = new SimpleDateFormat(endDateFormatStr);
			Date endDate = endDateFormat.parse(endDateStr);
			Calendar cEnd = Calendar.getInstance();
			cEnd.setTime(endDate);
			return cEnd.get(Calendar.YEAR) - cStart.get(Calendar.YEAR); 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Date convertStringToDate(String strDate, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			Date date = df.parse(strDate);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}

	public static String currentDateToString(String format) {
		Calendar calendar = GregorianCalendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		String currentDate = fmt.format(calendar.getTime());

		return currentDate;
	}
	
	/**
	 * Get current day time by string
	 * @return String
	 */
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());

	}

	/**
	 * Convert Date Time to String 
	 * @param dateTime
	 * @return
	 */
	public static String convertDateTimeToString(long dateTime){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(dateTime);
	}
	
	/**
	 * This utility method returns a past date before number of days.
	 * 
	 * @param days
	 * @return Date object
	 */
	public static Date getDateBeforeDays(int days) {
		long backDateMS = System.currentTimeMillis() - ((long) days) * 24 * 60
				* 60 * 1000;
		Date backDate =  new Date();
		backDate.setTime(backDateMS);
		return backDate;
	}

	/**
	 * This utility method returns a past date before number of days.
	 * Method based on date time SQL
	 * @param days
	 * @return String
	 */
	public static String getDateBeforeDaysFormatString(long currentTimeSQL, int days) {
		long backDateMS = currentTimeSQL - ((long) days) * 24 * 60
				* 60 * 1000;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(backDateMS);
	}
	
	/**
	 * This utility method returns a past hours before number of hours.
	 * method will base on datetime SQL
	 * @param hours
	 * @return String
	 */
	public static String getHoursBeforeDaysFormatString(long currentTimeSQL, int hours) {
		long backDateMS = currentTimeSQL -  hours * 60
				* 60 * 1000;
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(backDateMS);
	}
	
	/**
	 * This utility method returns age (minutes) beetween current time and a date for given.
	 * 
	 * @param Date
	 * @return int
	 */
	public static int getAgeMinutes(long currentTimeSQL,Date date) {
		long miliseconds = currentTimeSQL -  date.getTime();
		int minutes = (int) (miliseconds/1000)/60;
		return minutes;
	}
	
	/**
	 * This utility method returns age (dd:mm:hh) beetween current time and a date for given.
	 * 
	 * @param Date
	 * @return String
	 */
	public static String getAge(long currentTimeSQL,Date date){
		long miliseconds = currentTimeSQL -  date.getTime();
		long days = TimeUnit.MILLISECONDS.toDays(miliseconds);
		long hours = TimeUnit.MILLISECONDS.toHours(miliseconds) - TimeUnit.DAYS.toHours(days);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(miliseconds) - TimeUnit.DAYS.toMinutes(days) - TimeUnit.HOURS.toMinutes(hours);

		String age = String.format("%02d:%02d:%02d", days,hours,minutes);
		
		return age;
	}
	
	public static Timestamp currentTime(){
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		return currentTime;
	}
	
	public static String convertFormatOfDateString(String strDate, String currentFormat, String newFormat) {
		Date date = convertStringToDate(strDate, currentFormat);
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
			return sdf.format(date);
		}
		
		return null;
	}
	
	public static String getDateBeforeDaysWithFormatString(long currentTimeSQL, int days, String dateFormat) {
		long backDateMS = currentTimeSQL - ((long) days) * 24 * 60
				* 60 * 1000;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(backDateMS);
	}
	
	public static String changeTimeOfDateString(String strDate, String currentFormat, int hours, int minutes, int seconds) {
		Date date = convertStringToDate(strDate, currentFormat);
		if (date != null) {
			Calendar cal = Calendar.getInstance(); 
		    cal.setTime(date); 
		    cal.set(Calendar.HOUR, hours);
		    cal.set(Calendar.MINUTE, minutes);
		    cal.set(Calendar.SECOND, seconds);
			SimpleDateFormat sdf = new SimpleDateFormat(currentFormat);
			return sdf.format(cal.getTime());
		}		
		return null;
	}
	
	/**
	 * Convert Date Time to String 
	 * @param dateTime
	 * @return
	 */
	public static String convertTimestampToString(Timestamp dateTime){
		return TIMESTAMP_FORMATER.format(dateTime);
	}
	
	public static void main(String args[]) throws ParseException {
		//System.out.println(convertStringToDate("2010-04-14", "yyyy-MM-dd"));
		System.out.println(currentTime().toString());
	}
}
