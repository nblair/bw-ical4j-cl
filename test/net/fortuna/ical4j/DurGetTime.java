package net.fortuna.ical4j;

import java.util.Calendar;

import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;

public class DurGetTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, 2011);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 11);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Date d = new Date(cal.getTime());
		DateTime dt = new DateTime(cal.getTime());
		Dur dur = new Dur("P1D");
		
		for (int i = 0;i < 4;i++) {
			System.out.println("before d = " + d);
			System.out.println("before dt = " + dt);
			
			java.util.Date newd = dur.getTime(d);
			System.out.println("Java date newd = " + newd);
			d = new Date(newd);
			
			java.util.Date newdt = dur.getTime(dt);
			System.out.println("Java date newdt = " + newdt);
			dt = new DateTime(newdt);
			
			System.out.println("after d = " + d);
			System.out.println("after dt = " + dt);
			
			Date dd = new Date(dt);
			
			System.out.println("dd = " + dd);
			
			System.out.println("---------------------");
		}
	}

}
