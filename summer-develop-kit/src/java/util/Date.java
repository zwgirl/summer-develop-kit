package java.util;

import java.lang.String;

public class Date {
	
	public native Date();
	public native Date(int milliseconds);
	public native Date(String dateVal);
	public native Date(int year, int month, int date);
	public native Date(int year, int month, int date, int hours);
	public native Date(int year, int month, int date, int hours, int minutes);
	public native Date(int year, int month, int date, int hours, int minutes, int seconds);
	public native Date(int year, int month, int date, int hours, int minutes, int seconds, int ms);
	
	/**
	 * 	Returns the day-of-the-month value using local time.
	 */
	public native int getDate();

	/**
	 * 	Returns the day-of-the-week value using local time.
	 */
	public native int getDay();

	/**
	 * 	Returns the year value using local time.
	 */
	public native int getFullYear();

	/**
	 * 	Returns the hours value using local time.
	 */
	public native int getHours();

	/**
	 * 	Returns the milliseconds value using local time.
	 */
	public native int getMilliseconds();

	/**
	 * 	Returns the minutes value using local time.
	 */
	public native int getMinutes();

	/**
	 * 	Returns the month value using local time.
	 */
	public native int getMonth();

	/**
	 * 	Returns seconds value using local time.
	 */
	public native int getSeconds();

	/**
	 * 	Returns the time value in a Date Object as the number of milliseconds since midnight January 1, 1970.
	 */
	public native int getTime();

	/**
	 * 	Returns the difference in minutes between the time on the host computer and Universal Coordinated Time (UTC).
	 */
	public native int getTimezoneOffset();

	/**
	 * 	Returns the day-of-the-month value using UTC.
	 */
	public native int getUTCDate();

	/**
	 * 	Returns the day-of-the-week value using UTC.
	 */
	public native int getUTCDay();

	/**
	 * 	Returns the year value using UTC.
	 */
	public native int getUTCFullYear();

	/**
	 * 	Returns the hours value using UTC.
	 */
	public native int getUTCHours();

	/**
	 * 	Returns the milliseconds value using UTC.
	 */
	public native int getUTCMilliseconds();

	/**
	 * 	Returns the minutes value using UTC.
	 */
	public native int getUTCMinutes();
/**
 * 	Returns the month value using UTC.
 */
	public native int getUTCMonth();

	/**
	 * 	Returns the seconds value using UTC.
	 */
	public native int getUTCSeconds();

	/**
	 * 	Returns the VT_DATE value in a Date object.
	 */
	public native String getVarDate();

	/**
	 * 	Returns the year value .
	 */
	public native int getYear();

	/**
	 * 	Sets the numeric day of the month using local time.
	 */
	public native void setDate(int date);

	/**
	 * 	Sets the year value using local time.
	 */
	public native void setFullYear(int fullyear);

	/**
	 * 	Sets the hours value using local time.
	 */
	public native void setHours(int hours);

	/**
	 * 	Sets the milliseconds value using local time.
	 */
	public native void setMilliseconds(int milliseconds);

	/**
	 * 	Sets the minutes value using local time.
	 */
	public native void setMinutes(int minutes);

	/**
	 * 	Sets the month value using local time.
	 */
	public native void setMonth(int month);

	/**
	 * 	Sets the seconds value using local time.
	 */
	public native void setSeconds(int seconds);

	/**
	 * 	Sets the date and time value in the Date object.
	 */
	public native void setTime();

	/**
	 * 	Sets the numeric day of the month using UTC.
	 */
	public native void setUTCDate(int date);

	/**
	 * 	Sets the year value using UTC.
	 */
	public native void setUTCFullYear(int fullyear);

	/**
	 * 	Sets the hours value using UTC.
	 */
	public native void setUTCHours(int hours);

	/**
	 * 	Sets the milliseconds value using UTC.
	 */
	public native void setUTCMilliseconds(int milliseconds);

	/**
	 * 	Sets the minutes value using UTC.
	 */
	public native void setUTCMinutes(int minutes);

	/**
	 * 	Sets the month value using UTC.
	 */
	public native void setUTCMonth(int month);

	/**
	 * 	Sets the seconds value using UTC.
	 */
	public native void setUTCSeconds(int seconds);

	/**
	 * 	Sets the year value using local time.
	 */
	public native void setYear(int year);

	/**
	 * 	Returns a date as a string value.
	 */
	public native String toDateString();

	/**
	 * 	Returns a date converted to a string using Greenwich Mean Time (GMT).
	 */
	public native String toGMTString();

	/**
	 * 	Returns a date as a string value in ISO format.
	 */
	public native String toISOString();
/**
 * 	Used to transform data of an object type before the JSON serialization.
 */
	public native String toJSON();
/**
 * 	Returns a date as a string value appropriate to the host environment's current locale.
 */
	public native String toLocaleDateString();
/**
 * 	Returns an object converted to a string using the current locale.
 */
	public native String toLocaleString();
/**
 * 	Returns a time as a string value appropriate to the host environment's current locale.
 */
	public native String toLocaleTimeString();
/**
 * 	Returns a time as a string value.
 */
	public native String toTimeString();
/**
 * 	Returns a date converted to a string using UTC.
 */
	public native String toUTCString();

	/**
	 * 	Returns the primitive value of the specified object.
	 */
	public native Date valueOf();

}
