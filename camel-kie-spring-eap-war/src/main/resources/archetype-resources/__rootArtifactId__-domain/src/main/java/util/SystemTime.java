#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import static org.joda.time.DateTimeZone.forID;
import static org.joda.time.format.DateTimeFormat.forPattern;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class SystemTime {

	private static DateTime		mockedDateTime;
	private static final String	DATE_TIME_PATTERN	= "yyyyMMdd HH:mm:ss";

	public static DateTime getCurrentSystemDate() {
		if ( mockedDateTime != null ) {
			return mockedDateTime;
		}
		else {
			return new DateTime();
		}
	}

	public static DateTime getCurrentDateInEst() {
		return getCurrentSystemDate().withZone( getEstZone() );
	}

	public static String getEstDateTimeInString() {
		return forPattern( DATE_TIME_PATTERN ).print( getCurrentDateInEst() );
	}

	public static final DateTimeZone getEstZone() {
		return forID( "America/New_York" );
	}

	public static void setMockedDateTime( DateTime dateTime ) {
		mockedDateTime = dateTime;
	}

}
