package com.lpg.pmappui.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public final class Util {

    private static final Logger logger = Logger.getLogger(Util.class.getName());
    /**
     * The time format to be used for creating timestamp objects
     */
    public static final String DATE_FORMAT = "dd-MM-yyyy HH:mm";
    /**
     * The time format to be used for creating timestamp objects
     */
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * The time format to be used for creating time stamp objects
     */
    public static final String TIMESTAMP_MONTH_FORMAT = "dd MMMMM yyyy";
    /**
     * The time format to be used for creating time objects
     */
    public static final String TIME_FORMAT = "HH:mm";
    /**
     * array containing strings that mark a getter method
     */
    private static final String[] GETTER_METHODS = {"get", "is"};
    /**
     * No. of MILLISECONDS in One Second
     */
    private static final Long MILLISEC = 1000L;
    /**
     * No. of HOURS in A DAY
     */
    private static final Long HOUR = 24L;
    /**
     * No. of MINUTES in A HOUR
     */
    private static final Long MIN = 60L;
    /**
     * No. of SECONDS in A MINUTE
     */
    private static final Long SEC = 60L;
    /**
     * Milliseconds to Minutes convertion factor
     */
    public static final Long MINUTE_CON_FACTOR = MILLISEC * SEC;
    /**
     * Scale for minute display
     */
    public static final int MINUTE_DECIMAL_SCALE = 3;
    /**
     * No. of MILLISECONDS IN A DAY
     */
    private static final Long TIME_CON_FACTOR = MILLISEC * HOUR * MIN * SEC;
    /**
     * No. of days in a week
     */
    private static final int NUM_DAYS_IN_A_WEEK = 7;
    /**
     * No. of months in a quarter
     */
    private static final int NUM_MONTHS_IN_A_QUARTER = 3;
    /**
     * No. of months in half a year
     */
    private static final int NUM_MONTHS_IN_HALF_YEAR = 6;
    /**
     * code for day
     */
    public static final String DAY = "D";
    /**
     * code for week
     */
    public static final String WEEK = "W";
    /**
     * code for month
     */
    public static final String MONTH = "M";
    /**
     * code for quarter
     */
    public static final String QUARTER = "Q";
    /**
     * code for half a year
     */
    public static final String HALF_YEAR = "H";
    /**
     * code for a year
     */
    public static final String YEAR = "Y";
    /**
     * code for maturity
     */
    public static final String MATURITY = "MTY";
    /**
     * code for end of month
     */
    public static final String END_OF_MONTH = "EOM";
    /**
     * code for end of quarter
     */
    public static final String END_OF_QUARTER = "EOQ";
    /**
     * code for end of year
     */
    public static final String END_OF_YEAR = "EOY";
    /**
     * code for calendar period date
     */
    public static final String CAL_PERIOD_DATE = "CPD";
    /**
     * code for day of week date
     */
    public static final String DAY_WEEK_DATE = "DOW";
    /**
     * code for day of month date
     */
    public static final String DAY_MONTH_DATE = "DOM";
    /**
     * code for end of calendar period date
     */
    public static final String END_OF_CAL_PERIOD_DATE = "ECPD";
    /**
     * code for end of calendar quarter
     */
    public static final String END_OF_CAL_QUARTER = "ECQD";
    /**
     * code for end of calendar year
     */
    public static final String END_OF_CAL_YEAR = "ECYD";
    /**
     * number of months in a quarter
     */
    public static final int MONTHS_IN_A_QUARTER = 3;
    /**
     * number of months in half year
     */
    public static final int MONTHS_IN_HALFYEAR = 6;
    /**
     * number of months in an year
     */
    public static final int MONTHS_IN_YEAR = 12;
    /**
     * number of days in a week
     */
    public static final int DAYS_IN_WEEK = 7;
    /**
     * No. of days in a month, to be used in places where it needs to be
     * considered as a constant.
     */
    public static final int NUM_DAYS_IN_MONTH_CONST = 30;
    /**
     * No. of days in an year, to be used in places where it needs to be
     * considered as a constant.
     */
    public static final int NUM_DAYS_IN_YEAR_CONST = 365;
    /**
     * No. of weeks in an year, to be used in places where it needs to be
     * considered as a constant.
     */
    public static final int NUM_WEEKS_IN_YEAR_CONST = 52;
    /**
     * Day of the month
     */
    public static final String DAY_OF_MONTH = "DOM";
    /**
     * the scale to use for calculations involving divisions.
     */
    public static final int SCALE = 10;
    /**
     * Delimiter 1
     */
    public static final String DELIMITER_1 = "|";
    /**
     * Delimiter 2
     */
    public static final String DELIMITER_2 = "^";
    /**
     * Delimiter 3
     */
    public static final String DELIMITER_3 = "~";
    /**
     * Yes
     */
    public static final String YES = "Y";
    /**
     * No
     */
    public static final String NO = "N";
    /**
     * The Date Format1
     */
    public static final String DATE_FORMAT1 = "CCYYMMDD";
    /**
     * The time format to be used for creating time objects
     */
    public static final String DATE_FORMAT2 = "CCYY/MM/DD";
    /**
     * The time format to be used for creating time objects
     */
    public static final String DATE_FORMAT3 = "YYMMDD";
    /**
     * The time format to be used for creating time objects
     */
    public static final String TIME_FORMAT1 = "HH:MM:SS";
    /**
     * Constant to indicate the day of month:29
     */
    public static final int DAY_OF_MONTH_29 = 29;
    /**
     * Constant to indicate the day of month:30
     */
    public static final int DAY_OF_MONTH_30 = 30;
    /**
     * Constant to indicate the day of month:31
     */
    public static final int DAY_OF_MONTH_31 = 31;
    /**
     * ONE
     */
    private static final int ONE = 1;
    /**
     * TWO
     */
    private static final int TWO = 2;
    /**
     * THREE
     */
    private static final int THREE = 3;
    /**
     * FOUR
     */
    private static final int FOUR = 4;
    /**
     * FIVE
     */
    private static final int FIVE = 5;
    /**
     * SIX
     */
    private static final int SIX = 6;
    /**
     * SEVEN
     */
    private static final int SEVEN = 7;
    /**
     * EIGHT
     */
    private static final int EIGHT = 8;
    /**
     * TEN
     */
    private static final int TEN = 10;
    /**
     * ELEVEN
     */
    private static final int ELEVEN = 11;
    /**
     * NINETEEN
     */
    private static final int NINETEEN = 19;
    /**
     * INTEGER
     */
    private static final String INTEGER = "INTEGER";
    /**
     * DECIMAL
     */
    private static final String DECIMAL = "DECIMAL";
    /**
     * ASSUMED_DECIMAL
     */
    private static final String ASSUMED_DECIMAL = "ASSUMED_DECIMAL";
    /**
     * LEFT
     */
    private static final String LEFT = "LEFT";
    /**
     * RIGHT
     */
    private static final String RIGHT = "RIGHT";
    /**
     * ZERO
     */
    private static final String ZERO = "ZERO";
    /**
     * BLANK
     */
    private static final String BLANK = "BLANK";
    private static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * This is a utility class and need not be instantiated to use. So the
     * constructor is private.
     */
    private Util() {
    }

    /**
     * Converts a string "Y" to true and false otherwise
     *
     * @param sValue - the string containing either "Y" or "N"
     * @return boolean - true if "Y", false otherwise
     */
    public static boolean convertStringToBoolean(final String sValue) {
        return "Y".equals(sValue);
    }

    /**
     * Converts a string "Y" to true and false otherwise
     *
     * @param sValue - the string containing either "Y" or "N"
     * @return String - true if "Y", false otherwise
     */
    public static String convertStringToBooleanChar(final String sValue) {
        String response = "";
        if (sValue.equals("Y")) {
            response = "Y";
        } else {
            response = "N";
        }
        return response;
    }

    /**
     * Converts true to "Y" and false to "N"
     *
     * @param bValue - the boolean value
     * @return String - "Y" if true, "N" if false
     */
    public static String convertBooleanToString(final boolean bValue) {
        if (bValue) {
            return "Y";
        } else {
            return "N";
        }
    }

    /**
     * @return true if the method name is a getter method to obtain an attribute
     * @param methodName the method name to be tested
     */
    private static boolean isGetter(final String methodName) {
        for (int i = 0; i < GETTER_METHODS.length; i++) {
            if (methodName.startsWith(GETTER_METHODS[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the property name
     * @param methodName the method name
     */
    private static String getAttribute(final String methodName) {
        int index = 0;
        for (int i = 0; i < GETTER_METHODS.length; i++) {
            if (methodName.startsWith(GETTER_METHODS[i])) {
                index = GETTER_METHODS[i].length();
                break;
            }
        }
        return methodName.substring(index);
    }

    /**
     * Method toString is used to obtain a string representation of an object
     * the method generates a string with each attribute of the object enclosed
     * within an XML like tag with the tag name set to the attribute name
     *
     * @param value the object whose string representation is required
     * @return String the string representation
     */
    public static String toString(final Serializable value) {
        Method[] methods = value.getClass().getMethods();
        String className = value.getClass().getName();
        StringBuilder buffer = new StringBuilder();
        // Check if the field modifier is static and final, then skip it
        String propertyName = null;
        String propertyValue = null;
        String methodName = null;

        buffer.append('<');
        buffer.append(className);
        buffer.append(">\n");
        for (int i = 0; i < methods.length; i++) {
            try {
                methodName = methods[i].getName();
                if (!isGetter(methodName)) {
                    continue;
                }
                // Check to see that the getter does not take any formal parameters
                if (methods[i].getParameterTypes().length == 0) {
                    propertyName = getAttribute(methodName);
                    propertyValue = "" + methods[i].invoke(value);
                    // Append all the other types fields
                    buffer.append('<');
                    buffer.append(propertyName);
                    buffer.append('>');
                    buffer.append(propertyValue);
                    buffer.append("</");
                    buffer.append(propertyName);
                    buffer.append(">\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        buffer.append("</");
        buffer.append(className);
        buffer.append(">\n");
        return buffer.toString();
    }

    /**
     * Used to obtain the timestamp using the calendar passed as an input
     * argument. It uses Util.TIMESTAMP_FORMAT to format the timestamp.
     *
     * @param cal - the calendar containing the time component
     * @return a Timestamp object representing the UTC time
     */
    public static java.sql.Timestamp getTimestamp(final Calendar cal) {
        SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_FORMAT);
        java.util.Date date = cal.getTime();
        String strTimestamp = formatter.format(date);
        return java.sql.Timestamp.valueOf(strTimestamp);
    }

    /**
     * Returns the timestamp as a String according to a format supplied by the
     * user
     *
     * @param ts - the timestamp passed by the client
     * @return A String representing the current UTC time
     */
    public static String getTimestampAsString(final Timestamp ts) {
        return getTimestampAsString(ts, TIMESTAMP_FORMAT);
    }

    /**
     * Returns the timestamp as a String according to a format supplied by the
     * user
     *
     * @param ts - the timestamp passed by the client
     * @param strFormat The format required by the user
     * @return A String representing the current UTC time
     */
    private static String getTimestampAsString(final Timestamp ts, final String strFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
        Date gmtTime = new Date(ts.getTime());
        String strUTCTimestamp = formatter.format(gmtTime);
        return (strUTCTimestamp);
    }

    /**
     * Used to obtain the current UTC time
     *
     * @return a Timestamp object representing the UTC time
     */
    public static String getCurrentDateAsString() {
        return getCurrentUTCTimestampAsString(DATE_FORMAT);
    }

    /**
     * Used to obtain the current UTC time
     *
     * @return a Timestamp object representing the UTC time
     */
    public static Timestamp getCurrentUTCTimestamp() {
        return Timestamp.valueOf(getCurrentUTCTimestampAsString(TIMESTAMP_FORMAT));
    }

    /**
     * Returns the current UTC time as a String according to a format supplied
     * by the user
     *
     * @param strFormat The format required by the user
     * @return A String representing the current UTC time
     */
    private static String getCurrentUTCTimestampAsString(final String strFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
        Date currentDate = new java.util.Date();
        Date gmtTime = new Date(currentDate.getTime());
        String strUTCTimestamp = formatter.format(gmtTime);
        return (strUTCTimestamp);
    }

    /**
     * This method converts a date in string format into a SQL Date using the
     * format passed to the method
     *
     * @param format format of the date
     * @param dateStr String representation of date
     * @return A sql date representation of the string
     */
    public static java.sql.Date getDate(final String format, final String dateStr) {
        java.sql.Date dateTo = null;

        try {
            SimpleDateFormat formatter = null;
            formatter = new SimpleDateFormat(format);
            Date date = (Date) formatter.parse(dateStr);
            dateTo = new java.sql.Date(date.getTime());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return dateTo;
    }

    /**
     * convertDateStringToLongString This method converts a date in string
     * format into long primitive in string format passed to the method
     *
     * @param format format of the date
     * @param dateStr String representation of date
     * @return A sql date representation of the string
     */
    public static String convertDateStringToLongString(final String format, final String dateStr) {
        long millis = 0;

        try {
            Calendar cal = getCalendar(format, dateStr);
            int daylightSavingTimeOffset = cal.get(Calendar.DST_OFFSET);
            int rawOffset = cal.get(Calendar.ZONE_OFFSET);
            int offSet = rawOffset + daylightSavingTimeOffset;
            millis = cal.getTimeInMillis() + offSet;
        } catch (Exception pe) {
            pe.printStackTrace();
        }
        return "" + millis;
    }

    /**
     * convertLongStringToDateString This method converts a date in string
     * format into long primitive in string format passed to the method
     *
     * @param format format of the date
     * @param dateLongStr String representation of date
     * @return A sql date representation of the string
     */
    public static String convertLongStringToDateString(final String format, final String dateLongStr) {

        String dataStr = null;

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.valueOf(dateLongStr));
            SimpleDateFormat formatter = null;
            formatter = new SimpleDateFormat(format);
            dataStr = formatter.format(cal.getTime());
        } catch (Exception pe) {
            pe.printStackTrace();
        }
        return dataStr;
    }

    /**
     * convertLongStringToDateString This method converts a date in string
     * format into long primitive in string format passed to the method
     *
     * @param format format of the date
     * @param dateLongStr String representation of date
     * @return A sql date representation of the string
     */
    public static java.sql.Date convertLongStringToDate(final String format,
                                                        final String dateLongStr) {
        Date date = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.valueOf(dateLongStr));
            date = cal.getTime();
        } catch (Exception pe) {
            pe.printStackTrace();
        }
        return convertJavaUtilDateToSQLDate(date);
    }

    /**
     * convertLongStringToDateString This method converts a date in string
     * format into long primitive in string format passed to the method
     *
     * @param format format of the date
     * @param dateLongStr String representation of date
     * @return A sql date representation of the string
     */
    public static Date convertDateStringToDate(final String format, final String dateLongStr) {
        Date date = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.valueOf(dateLongStr));

            SimpleDateFormat formatter = new SimpleDateFormat(format);
            formatter.setLenient(false);
            date = new Date(formatter.parse(dateLongStr).getTime());
        } catch (Exception pe) {
            pe.printStackTrace();
        }
        return date;
    }

    /**
     * This method converts a date in string format into a SQL Date using the
     * format passed to the method
     *
     * @param format format of the date
     * @param dateStr String representation of date
     * @return A sql date representation of the string
     */
    public static Calendar getCalendar(final String format, final String dateStr) {
        Calendar cal = null;
        try {
            SimpleDateFormat formatter = null;
            formatter = new SimpleDateFormat(format);
            cal = Calendar.getInstance();
            formatter.parse(dateStr);
            cal = formatter.getCalendar();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return cal;
    }

    /**
     * Finds the difference between two dates in terms of number of days It
     * returns a -ve number if the firstDate is before the secondDate. It
     * returns a +ve number if the firstDate is after the secondDate. It returns
     * zero if the firstDate is same as the secondDate. It doesn't take into
     * account the time component of dates.
     *
     * @param firstDate firstDate
     * @param secondDate secondDate
     * @return long the date difference
     * @throws IllegalArgumentException if either the first date or second date
     * parameters are null
     */
    public static long getDateDifference(final java.util.Date firstDate,
                                         final java.util.Date secondDate) throws IllegalArgumentException {
        if (firstDate == null) {
            throw new IllegalArgumentException("The parameter First Date is null");
        }
        if (secondDate == null) {
            throw new IllegalArgumentException("The parameter Second Date is null");
        }
        long numberOfDays = Long.MIN_VALUE;
        Calendar firstCal = Calendar.getInstance();
        firstCal.setTime(firstDate);
        Calendar secondCal = Calendar.getInstance();
        secondCal.setTime(secondDate);
        numberOfDays = getDateDifference(firstCal, secondCal);
        return numberOfDays;
    }

    /**
     * Method getDateDifference.finds the difference between two calendar dates
     * in terms of number of days
     *
     * @param firstCal the first calendar
     * @param secondCal the second calendar
     * @return long
     * @throws IllegalArgumentException if either the first calendar or second
     * calendar parameters are null
     */
    public static long getDateDifference(final Calendar firstCal, final Calendar secondCal)
            throws IllegalArgumentException {
        if (firstCal == null) {
            throw new IllegalArgumentException("The parameter First Calendar is null");
        }
        if (secondCal == null) {
            throw new IllegalArgumentException("The parameter Second Calendar is null");
        }

        long numberOfDays = Long.MIN_VALUE;
        resetTime(firstCal);
        resetTime(secondCal);
        long diffInMilliSecond = firstCal.getTimeInMillis() - secondCal.getTimeInMillis();
        numberOfDays = diffInMilliSecond / TIME_CON_FACTOR;

        return numberOfDays;
    }

    /**
     * Method isLeapYear. Check whether Leap Year or Not
     *
     * @param value - Input Value
     * @return boolean - true if leap year
     */
    public static boolean isLeapYear(java.sql.Date value) {
        if (value == null) {
            throw new IllegalArgumentException("The parameter First Calendar is null");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(value);
        GregorianCalendar gcal = new GregorianCalendar();

        return gcal.isLeapYear(cal.get(Calendar.YEAR));
    }

    /**
     * Method getDaysInYear.
     *
     * @param date the date
     * @return int the number of days in the year of given date
     */
    public static int getDaysInYear(final java.sql.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        int noOfDaysInYear = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        return noOfDaysInYear;
    }

    /**
     * Method getDaysInMonth.
     *
     * @param date the date
     * @return int the number of days in the month of given date
     */
    public static int getDaysInMonth(final java.sql.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        int noOfDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return noOfDaysInMonth;
    }

    /**
     * Method resetTime. It sets the time component of a date to zero.
     *
     * @param cal Calendar
     */
    public static void resetTime(final Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DST_OFFSET, 0);
    }

    /**
     * It adds two Long objects.
     *
     * @param o1 Long object
     * @param o2 Long object
     * @return Long the sum
     */
    public static Long add(final Long o1, final Long o2) {
        if (o1 == null || o2 == null) {
            return null;
        }
        return o1.longValue() + o2.longValue();
    }

    /**
     * Method add. It adds a Long object to a long.
     *
     * @param o1 Long object
     * @param l1 long
     * @return Long the sum
     */
    public static Long add(final Long o1, final long l1) {
        if (o1 == null) {
            return l1;
        }
        return o1.longValue() + l1;
    }

    /**
     * Finds the difference between two dates in terms of number of years It
     * returns a -ve number if the firstDate is before the secondDate. It
     * returns a +ve number if the firstDate is after the secondDate. It returns
     * zero if the firstDate is same as the secondDate.
     *
     * @param firstDate firstDate
     * @param secondDate secondDate
     * @return long the year difference
     * @throws IllegalArgumentException if either the first date or second date
     * parameters are null
     */
    public static long getYearDifference(java.sql.Date firstDate, java.sql.Date secondDate)
            throws IllegalArgumentException {
        long noOfYears = Long.MIN_VALUE;
        Calendar firstCal = Calendar.getInstance();
        firstCal.setTime(firstDate);
        Calendar secondCal = Calendar.getInstance();
        secondCal.setTime(secondDate);
        int firstYear = firstCal.get(Calendar.YEAR);
        int secondYear = secondCal.get(Calendar.YEAR);
        noOfYears = firstYear - secondYear;
        return noOfYears;
    }

    /**
     * Method noOfMonthsInDateRange. method to calculate the no of months given
     * the start and end dates
     *
     * @param start the start date
     * @param end the end date
     * @return long the no. months in the date range.
     */
    public static long noOfMonthsInDateRange(final java.sql.Date start, final java.sql.Date end) {
        int years = 0;
        int months = 0;
        BigDecimal monthsInYear = new BigDecimal(MONTHS_IN_YEAR);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(start);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(end);
        boolean sameDayPassed = false;
        int startYear = startCal.get(Calendar.YEAR);
        int endYear = endCal.get(Calendar.YEAR);
        int startMonth = startCal.get(Calendar.MONTH);
        int endMonth = endCal.get(Calendar.MONTH);
        int startDay = startCal.get(Calendar.DAY_OF_MONTH);
        int endDay = endCal.get(Calendar.DAY_OF_MONTH);

        years = endYear - startYear;
        if (startDay <= endDay) {
            sameDayPassed = true;
        }
        if (sameDayPassed) {
            months = endMonth - startMonth;
        } else {
            months = endMonth - startMonth - 1;
        }

        BigDecimal totalNoOfMonths
                = new BigDecimal(years).multiply(monthsInYear).add(new BigDecimal(months));
        return totalNoOfMonths.longValue();
    }

    /**
     * Method to calculate the number of months between two dates as a
     * fractional value
     *
     * @param start the start date
     * @param end the end date
     * @return the exact number of months between the two dates
     */
    public static BigDecimal exactNoOfMonthsInDateRange(final java.sql.Date start,
                                                        final java.sql.Date end) {
        Long wholeNoOfMonths = noOfMonthsInDateRange(start, end);
        BigDecimal exactNoOfMonths = new BigDecimal(String.valueOf(wholeNoOfMonths));
        java.sql.Date dateAfterWholeNoOfMonths
                = getNextCycleDate(start, MONTH, wholeNoOfMonths);
        long daysInLastPeriod = getDateDifference(end, dateAfterWholeNoOfMonths);
        if (daysInLastPeriod > 0) {
            int daysInLastMonth = getDaysInMonth(dateAfterWholeNoOfMonths);
            // daysInLastPeriod/daysInLastMonth;
            BigDecimal fractionalMonth
                    = new BigDecimal(String.valueOf(daysInLastPeriod)).divide(new BigDecimal(String.valueOf(daysInLastMonth)), SCALE, BigDecimal.ROUND_DOWN);
            exactNoOfMonths = exactNoOfMonths.add(fractionalMonth);
        }

        return exactNoOfMonths;
    }

    /**
     * method to calculate the no. of days, given the frequency value and code.
     *
     * @param frequencyValue the frequency value
     * @param frequencyCode the frequency code
     * @return the no. of days
     */
    public static Long getDaysInPeriod(final Long frequencyValue, final String frequencyCode) {
        Long daysInPeriod = 0L;
        BigDecimal daysInWeek = new BigDecimal(DAYS_IN_WEEK);
        // days in month is taken as 30 always.
        BigDecimal daysInMonth = new BigDecimal(NUM_DAYS_IN_MONTH_CONST);
        BigDecimal monthsInYear = new BigDecimal(MONTHS_IN_YEAR);
        BigDecimal monthsInHalfYear = new BigDecimal(MONTHS_IN_HALFYEAR);
        BigDecimal monthsInQuarter = new BigDecimal(MONTHS_IN_A_QUARTER);
        BigDecimal frequencyValueBd = new BigDecimal(frequencyValue);

        if (DAY.equals(frequencyCode) || CAL_PERIOD_DATE.equals(frequencyCode)
                || END_OF_CAL_PERIOD_DATE.equals(frequencyCode)) {
            daysInPeriod = frequencyValue;
        } else if (WEEK.equals(frequencyCode) || DAY_WEEK_DATE.equals(frequencyCode)) {
            daysInPeriod = frequencyValueBd.multiply(daysInWeek).longValue();
        } else if (MONTH.equals(frequencyCode) || DAY_MONTH_DATE.equals(frequencyCode)) {
            daysInPeriod = frequencyValueBd.multiply(daysInMonth).longValue();
        } else if (QUARTER.equals(frequencyCode)) {
            daysInPeriod
                    = frequencyValueBd.multiply(monthsInQuarter).multiply(daysInMonth).longValue();
        } else if (HALF_YEAR.equals(frequencyCode)) {
            daysInPeriod
                    = frequencyValueBd.multiply(monthsInHalfYear).multiply(daysInMonth).longValue();
        } else if (YEAR.equals(frequencyCode)) {
            daysInPeriod
                    = frequencyValueBd.multiply(monthsInYear).multiply(daysInMonth).longValue();
        } else if (END_OF_MONTH.equals(frequencyCode)) {
            // add 1 month to the given date
            daysInPeriod = frequencyValueBd.multiply(daysInMonth).longValue();
        } else if (END_OF_QUARTER.equals(frequencyCode) || END_OF_CAL_QUARTER.equals(frequencyCode)) {
            // add 3 months to the given date
            daysInPeriod
                    = frequencyValueBd.multiply(monthsInQuarter).multiply(daysInMonth).longValue();
        } else if (END_OF_YEAR.equals(frequencyCode) || END_OF_CAL_YEAR.equals(frequencyCode)) {
            // add 1 year to the given date
            daysInPeriod
                    = frequencyValueBd.multiply(monthsInYear).multiply(daysInMonth).longValue();
        } else {
            String reason = "Unknown frequency code " + frequencyCode;
            throw new IllegalArgumentException(reason);
        }
        return daysInPeriod;
    }

    /**
     * Method isBetween. Returns true if the value is between the low and high
     * value inclusively. i.e low <= value <= high
     *
     *
     *
     * @param low - low value
     * @param high - high value
     * @param value - value
     * @return boolean
     */
    public static boolean isBetween(BigDecimal low, BigDecimal high, BigDecimal value) {
        return ((low.compareTo(value) <= 0 && high.compareTo(value) >= 0));
    }

    /**
     * Method isDateBetween. Returns true if the value is between the low and
     * high value inclusively. i.e low <= value <= high
     *
     * @param low - low value
     * @param high - high value
     * @param value - value
     * @return boolean
     */
    public static boolean isDateBetween(Date low, Date high, Date value) {
        return ((low.compareTo(value) <= 0 && high.compareTo(value) >= 0));
    }

    /**
     * Method isTimestampBetween. Returns true if the value is between the low
     * and high value inclusively. i.e low <= value <= high
     *
     * @param low - low value
     * @param high - high value
     * @param value - value
     * @return boolean
     */
    public static boolean isTimestampBetween(Timestamp low, Timestamp high, Timestamp value) {
        return ((low.compareTo(value) <= 0 && high.compareTo(value) >= 0));
    }

    /**
     * Counts the occurences of a character in a string
     *
     * @param string -
     * @param character -
     * @return int
     */
    public static int charCount(String string, char character) {
        int charCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                charCount++;
            }
        }
        return charCount;
    }

    /**
     * checks if the string is null/blank
     *
     * @param value the string
     * @return true if the string is null/blank
     */
    public static boolean isNullOrBlank(final String value) {
        if (value == null || value.equals("null")) {
            return true;
        }
        if (value.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Converts an SQL Date to java.util.Date.
     *
     * @param sqlDate an SQL Date
     * @return Date Java Date
     */
    public static java.util.Date convertSQLDateToJavaUtilDate(final java.sql.Date sqlDate) {
        return null == sqlDate ? null : new java.util.Date(sqlDate.getTime());
    }

    /**
     * Converts a java.util.Date to java.sql.Date
     *
     * @param date date
     * @return sqlDate an SQL Date
     */
    public static java.sql.Date convertJavaUtilDateToSQLDate(final Date date) {
        return null == date ? null : new java.sql.Date(date.getTime());
    }

    /**
     * Method to calculate the next cycle date by adding cycle frequency to the
     * cycle start date
     *
     * @param startDate the start date
     * @param frequencyCode - frequency code e.g. D - Day(s), M - Month(s) etc.
     * @param value the number of units
     * @return the calculated next date
     */
    public static java.sql.Date getNextCycleDate(final java.sql.Date startDate,
                                                 final String frequencyCode, final Long value) {
        if (startDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTimeInMillis(startDate.getTime());
        java.sql.Date nextDate = null;
        int frequencyValue = 0;
        if (value != null) {
            frequencyValue = value.intValue();
        }
        if (DAY.equals(frequencyCode)) {
            cal.add(Calendar.DAY_OF_MONTH, frequencyValue);
        } else if (WEEK.equals(frequencyCode)) {
            cal.add(Calendar.DAY_OF_MONTH, frequencyValue * NUM_DAYS_IN_A_WEEK);
        } else if (MONTH.equals(frequencyCode)) {
            cal.add(Calendar.MONTH, frequencyValue);
        } else if (QUARTER.equals(frequencyCode)) {
            cal.add(Calendar.MONTH, NUM_MONTHS_IN_A_QUARTER * frequencyValue);
        } else if (HALF_YEAR.equals(frequencyCode)) {
            cal.add(Calendar.MONTH, NUM_MONTHS_IN_HALF_YEAR * frequencyValue);
        } else if (YEAR.equals(frequencyCode)) {
            cal.add(Calendar.YEAR, frequencyValue);
        } else if (END_OF_MONTH.equals(frequencyCode)) {
            cal.add(Calendar.MONTH, 1);
            cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        } else if (END_OF_YEAR.equals(frequencyCode)) {
            cal.add(Calendar.YEAR, 1);
            cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));

        } else if (END_OF_QUARTER.equals(frequencyCode)) {
            int quater
                    = (int) Math.ceil((((float) cal.get(Calendar.MONTH) + 1))
                    / ((float) MONTHS_IN_A_QUARTER));
            quater = quater + 1;
            int nomonths
                    = (quater * MONTHS_IN_A_QUARTER)
                    - (cal.get(Calendar.MONTH) + 1);
            cal.add(Calendar.MONTH, nomonths);
            cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));

        } else if (DAY_OF_MONTH.equals(frequencyCode)) {

            if (frequencyValue > cal.get(Calendar.DATE) && cal.getActualMaximum(Calendar.DATE) >= frequencyValue) {

                cal.set(Calendar.DAY_OF_MONTH, frequencyValue);
            } else {
                cal.add(Calendar.MONTH, 1);

                int lastDate = cal.getActualMaximum(Calendar.DATE);

                if (frequencyValue > lastDate) {
                    cal.add(Calendar.MONTH, 1);
                    cal.set(Calendar.DAY_OF_MONTH, frequencyValue);
                } else {
                    cal.set(Calendar.DAY_OF_MONTH, frequencyValue);
                }
            }

        }

        nextDate = new java.sql.Date(cal.getTimeInMillis());
        return nextDate;
    }

    /**
     * Method getNextDate adds a certain number of days to a date to return the
     * new date
     *
     * @param currentDate Current Date
     * @param noOfDays No Of Days to be added
     * @return Date
     */
    public static java.util.Date getNextDate(final java.util.Date currentDate, final int noOfDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, noOfDays);
        java.util.Date nextDate = new java.util.Date(cal.getTimeInMillis());
        return nextDate;
    }

    /**
     * Adds a number of years to a date to return the new date
     *
     * @param currentDate Current Date
     * @param noYears No Of years to be added
     * @return Date
     */
    public static java.sql.Date getNextYearDate(final java.sql.Date currentDate, final int noYears) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.YEAR, noYears);
        java.sql.Date nextDate = new java.sql.Date(cal.getTimeInMillis());
        return nextDate;
    }

    /**
     * Returns true if the given value is in the range starting at the given min
     * and ending at the given max (including min and max).
     *
     * @param value the value to check
     * @param min the start of the range
     * @param max the end of the range
     * @return whether the condition is true
     */
    public static boolean inRange(final BigDecimal value, final BigDecimal min, final BigDecimal max) {
        if (max == null) {
            // last range
            return true;
        }
        boolean notLessThanMin = value.compareTo(min) >= 0;
        boolean notMoreThanMax = value.compareTo(max) <= 0;
        return notLessThanMin && notMoreThanMax;
    }

    /**
     * Method to format an amount given the currency code and amount
     *
     * @param currencyCode the currency code
     * @param currencyPosition
     * @param amount the amount
     * @param userlocale
     * @return the formatted amount
     */
    public static String getFormattedAmount(String currencyCode, int currencyPosition,
                                            BigDecimal amount, Locale userlocale) {
        NumberFormat format = NumberFormat.getInstance(userlocale);
        format.setMinimumFractionDigits(currencyPosition);
        format.setMaximumFractionDigits(currencyPosition);
        String s = format.format(amount);
        return currencyCode + s;
    }

    /**
     * To deep clone any object which implements Cloneable interface
     *
     * @param Objectto be cloned
     * @return cloned object
     */
    public static synchronized Object deepClone(Object toClone) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(b);
            out.writeObject(toClone);
            ByteArrayInputStream c = new ByteArrayInputStream(b.toByteArray());
            ObjectInputStream in = new ObjectInputStream(c);
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * * To deep clone any object which implements Cloneable interface
     *
     * @param toClone - Object to be cloned
     * @return cloned object
     */
    public static synchronized byte[] serializeObject(final Serializable toClone) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(b);
            out.writeObject(toClone);
            return b.toByteArray();
        } catch (Exception e) {
            String[] params = {toClone.getClass().getName()};
        }
        return null;
    }

    /**
     * To deep clone any object which implements Cloneable interface
     *
     * @param toClone - Object to be cloned* @return cloned object
     */
    public static synchronized Object deSerializeObject(final byte[] bArrToDeSerialized) throws Exception {
        try {
            ByteArrayInputStream c = new ByteArrayInputStream(bArrToDeSerialized);
            ObjectInputStream in = new ObjectInputStream(c);
            return in.readObject();
        } catch (Exception e) {
            String[] params = {"" + bArrToDeSerialized};
        }
        return null;
    }

    /**
     * convertCalendarToDateString This method converts from calendar format to
     * String date
     *
     * @param format format of the date
     * @param cal represent calendar
     * @return A sql date representation of the string
     */
    public static String convertCalendarToDateString(final String format, final Calendar cal) {
        String dataStr = null;

        try {
            SimpleDateFormat formatter = null;
            formatter = new SimpleDateFormat(format);
            dataStr = formatter.format(cal.getTime());
        } catch (Exception pe) {
            pe.printStackTrace();
        }
        return dataStr;
    }

    /**
     * formulates a date string given the day, month, year and dateFormat.
     *
     * @param day
     * @param month
     * @param year
     * @param dateFormat - rubikon date format from ctrl_param table
     * @return
     */
    public static String getDateAsString(final int day, final int month, final int year,
                                         final String dateFormat) {
        int paramArg3 = Integer.parseInt("3");
        String slash = "/";
        String hypen = "-";

        String dateString = "";
        String dtSplitDelimeter = "";

        String[] dateFormatArr = null;
        int[] dateValueArr = new int[paramArg3];
        try {
            if (dateFormat != null && dateFormat.trim().length() > 0) {

                dateFormatArr = dateFormat.split(slash);
                if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                    dtSplitDelimeter = slash;
                } else {
                    dateFormatArr = dateFormat.split(hypen);
                    if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                        dtSplitDelimeter = hypen;
                    }
                }

                if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                    for (int i = 0; i < dateFormatArr.length; i++) {
                        if (dateFormatArr[i].trim().equalsIgnoreCase("dd")) {
                            dateValueArr[i] = day;
                        } else if (dateFormatArr[i].trim().equalsIgnoreCase("MM")) {
                            dateValueArr[i] = month;
                        } else if (dateFormatArr[i].trim().equalsIgnoreCase("yyyy")) {
                            dateValueArr[i] = year;
                        }
                    }

                    dateString
                            = dateValueArr[0] + dtSplitDelimeter + dateValueArr[1] + dtSplitDelimeter
                            + dateValueArr[2];
                }
            }
        } catch (Exception pe) {
            pe.printStackTrace();
        }

        return dateString;
    }

    /**
     * This method returns a date string in the output format
     *
     * @param dateString
     * @param inDateFormat
     * @param outDateFormat
     * @return
     */
    public static String getDateAsString(final String dateString, final String inDateFormat,
                                         final String outDateFormat) {
        int paramArg3 = Integer.parseInt("3");
        String slash = "/";
        String hypen = "-";
        String day = "";
        String month = "";
        String year = "";

        String inDtSplitDelimeter = "";
        String outDtSplitDelimeter = "";

        String[] dateFormatArr = null;
        String[] dateValueArr = new String[paramArg3];

        StringBuffer dateOutput = new StringBuffer();
        try {
            if (inDateFormat != null && inDateFormat.trim().length() > 0 && outDateFormat != null
                    && outDateFormat.trim().length() > 0) {
                dateFormatArr = inDateFormat.split(slash);
                if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                    inDtSplitDelimeter = slash;
                } else {
                    dateFormatArr = inDateFormat.split(hypen);
                    if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                        inDtSplitDelimeter = hypen;
                    }
                }
                if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                    dateValueArr = dateString.split(inDtSplitDelimeter);

                    for (int i = 0; i < dateFormatArr.length; i++) {
                        if (dateFormatArr[i].trim().equalsIgnoreCase("dd")) {
                            day = dateValueArr[i];
                        } else if (dateFormatArr[i].trim().equalsIgnoreCase("MM")) {
                            month = dateValueArr[i];
                        } else if (dateFormatArr[i].trim().equalsIgnoreCase("yyyy")) {
                            year = dateValueArr[i];
                        }
                    }
                }
                dateFormatArr = outDateFormat.split(slash);
                if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                    outDtSplitDelimeter = slash;
                } else {
                    dateFormatArr = outDateFormat.split(hypen);
                    if (dateFormatArr != null && dateFormatArr.length == paramArg3) {
                        outDtSplitDelimeter = hypen;
                    }
                }
                for (int i = 0; i < dateFormatArr.length; i++) {

                    if (dateFormatArr[i].trim().equalsIgnoreCase("dd")) {
                        dateOutput.append(day);
                        if (i < dateFormatArr.length - 1) {
                            dateOutput.append(outDtSplitDelimeter);
                        }
                    } else if (dateFormatArr[i].trim().equalsIgnoreCase("MM")) {
                        dateOutput.append(month);
                        if (i < dateFormatArr.length - 1) {
                            dateOutput.append(outDtSplitDelimeter);
                        }

                    } else if (dateFormatArr[i].trim().equalsIgnoreCase("yyyy")) {
                        dateOutput.append(year);
                        if (i < dateFormatArr.length - 1) {
                            dateOutput.append(outDtSplitDelimeter);
                        }
                    }
                }
            }
        } catch (Exception pe) {
            pe.printStackTrace();
        }

        return dateOutput.toString();
    }

    /**
     * converts null to blank
     *
     * @param value the string
     * @return value or blank
     */
    public static String nullToBlank(final String value) {
        if (value == null || value.trim().length() == 0) {
            return "";
        } else {
            return value.trim();
        }
    }

    /**
     * Returns true if the input date is first day of the month. Else returns
     * false.
     *
     * @param date the input date.
     * @return the boolean value.
     */
    public static boolean isFirstDayOfMonth(final java.sql.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (1 == cal.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Utility method to find whether two date ranges intersect.
     *
     * @param range1StartDate
     * @param range1EndDate
     * @param range2StartDate
     * @param range2EndDate
     * @return true if the date ranges intersect
     */
    public static boolean datesIntersect(final Date range1StartDate, final Date range1EndDate,
                                         final Date range2StartDate, final Date range2EndDate) {
        if (null == range1StartDate || null == range1EndDate || null == range2StartDate
                || null == range2EndDate) {
            throw new IllegalArgumentException("Null input parameter");
        }
        long range1Start = range1StartDate.getTime();
        long range2Start = range2StartDate.getTime();
        long range1End = range1EndDate.getTime();
        long range2End = range2EndDate.getTime();

        long maxStart = range1Start > range2Start ? range1Start : range2Start;
        long minEnd = range1End < range2End ? range1End : range2End;

        return maxStart <= minEnd;
    }

    /**
     * This method returns a Date string in the format -CCYYMMDD C-century,
     * Y-Year, M-Month, D-Date
     *
     * @param date - Date
     */
    public static String getDateAsCCYYMMDD(final Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_FORMAT);
        String forDate = formatter.format(date);
        StringBuffer formattedDate = new StringBuffer();

        formattedDate.append(forDate.substring(0, FOUR));
        formattedDate.append(forDate.substring(FIVE, SEVEN));
        formattedDate.append(forDate.substring(EIGHT, TEN));

        return formattedDate.toString();
    }

    /**
     * This method returns a Date string in the format -CCYY/MM/DD C-century,
     * Y-Year, M-Month, D-Date
     *
     * @param date - Date
     */
    public static String getDateWithSeperator(final Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_FORMAT);
        String forDate = formatter.format(date);
        StringBuffer formattedDate = new StringBuffer();
        String slash = "/";

        formattedDate.append(forDate.substring(0, FOUR));
        formattedDate.append(slash);
        formattedDate.append(forDate.substring(FIVE, SEVEN));
        formattedDate.append(slash);
        formattedDate.append(forDate.substring(EIGHT, TEN));

        return formattedDate.toString();
    }

    /**
     * This method returns a Date string in the format -YYMMDD Y-Year, M-Month,
     * D-Date
     *
     * @param date - Date
     */
    public static String getDateAsYYMMDD(final Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_FORMAT);
        String strDate = formatter.format(date);
        StringBuffer formattedDate = new StringBuffer();

        formattedDate.append(strDate.substring(TWO, FOUR));
        formattedDate.append(strDate.substring(FIVE, SEVEN));
        formattedDate.append(strDate.substring(EIGHT, TEN));

        return formattedDate.toString();
    }

    /**
     * This method returns a time string in the format -HH:MM:SS H-Hours,
     * M-Minute, S-Second
     *
     * @param ts - Timestamp
     */
    public static String getTimeWithSeperator(final Timestamp ts) {
        Date date = new Date(ts.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_FORMAT);
        String strDate = formatter.format(date);
        StringBuffer formattedDate = new StringBuffer();

        formattedDate.append(strDate.substring(ELEVEN, NINETEEN));

        return formattedDate.toString();
    }

    /**
     * This method returns a string number in the Integer format
     *
     * @param num - Number
     */
    public static String getIntegerFormat(final Number num) {
        Integer no = Integer.valueOf(num.intValue());
        return no.toString();
    }

    /**
     * This method returns a string number in the Decimal format. The no of
     * Decimal Places of output will be based on the input fieldDecimalPlaces.
     * Example Input Number = 1234.75 fieldDecimalPlaces = 3 - Output string
     * =1234.750
     *
     * @param num - Number to be formatted.
     * @param fieldDecimalPlaces - no of field decimal places.
     */
    public static String getDecimalformat(final Number num, int fieldDecimalPlaces) {
        int ptr = 0;
        int decimalDigits = 0;
        String decimalSection = NO;
        String result = num.toString();
        int resultSize = result.length();

        while (ptr < resultSize) {
            String temp = result.substring(ptr, ptr + 1);
            if (decimalSection.equals(YES)) {
                decimalDigits = decimalDigits + 1;
            }
            if (temp.equals(".")) {
                decimalSection = YES;
            }
            ptr = ptr + 1;
        }
        if (fieldDecimalPlaces > decimalDigits) {
            int paddingSize = fieldDecimalPlaces - decimalDigits;
            if (decimalDigits == 0) {
                result = result + ".";
            }
            for (int i = 0; i <= paddingSize; i++) {
                result = result + "0";
            }
        } else if (fieldDecimalPlaces < decimalDigits) {
            int size = resultSize - (decimalDigits - fieldDecimalPlaces);
            result = result.substring(0, size);
        }
        return result;
    }

    /**
     * This method returns a string number in the Assumed Decimal format. The no
     * of Decimal Places of output will be based on the input
     * fieldDecimalPlaces. Example Input Number = 1234.75 fieldDecimalPlaces = 3
     * - Output string =1234750
     *
     * @param num - Number to be formatted.
     * @param fieldDecimalPlaces - no of field decimal places.
     */
    public static String getAssumedDecimalPointFormat(final Number num, int fieldDecimalPlaces) {
        int ptr = 0;
        int decimalDigits = 0;
        String decimalSection = NO;
        String tempResult = num.toString();
        int resultSize = tempResult.length();
        String result = "";

        while (ptr < resultSize) {
            if (decimalSection.equals(YES)) {
                decimalDigits = decimalDigits + 1;
            }

            String temp = tempResult.substring(ptr, ptr + 1);

            if (!temp.equals(".")) {
                result = result + temp;
            } else if (temp.equals(".")) {
                decimalSection = YES;
            }
            ptr = ptr + 1;
        }
        if (fieldDecimalPlaces > decimalDigits) {
            long paddingSize = fieldDecimalPlaces - decimalDigits;
            for (int i = 0; i < paddingSize; i++) {
                result = result + "0";
            }
        } else if (fieldDecimalPlaces < decimalDigits) {
            int size = resultSize - (decimalDigits - fieldDecimalPlaces);
            result = result.substring(0, size - 1);
        }
        return result;
    }

    /**
     * This method returns a output string. Output string length will be based
     * on the input fieldLength. size of the output will be adjusted with input
     * paddingChar(Default blank).The padding will happen based on the input
     * padding Option. input = 123.45, filedLength = 7, padChar = 0, padOption =
     * left - Output = 00123.45
     *
     * @param input - String
     * @param fieldLength - Long
     * @param padChar - String
     * @param padOption - String
     */
    public static String getPaddingResult(final String input, Long fieldLength, String padChar,
                                          String padOption) {
        String fillChar = "";
        String result = input;
        int resultSize = result.length();
        int padSize = 0;
        int fieldSize = fieldLength.intValue();
        if (fieldSize >= resultSize) {
            padSize = fieldSize - resultSize;

            if (padChar.trim().length() == 0 || padChar.equals(BLANK)) {
                fillChar = " ";
            } else if (padChar.equals(ZERO)) {
                fillChar = "0";
            } else if (padChar.length() == 1) {
                fillChar = padChar;
            } else {
                fillChar = padChar.substring(0, 1);
            }

            if (padSize > 0 && padOption.equals(LEFT)) {
                for (int i = 0; i < padSize; i++) {
                    result = fillChar + result;
                }
            } else if (padSize > 0 && padOption.equals(RIGHT)) {
                for (int i = 0; i < padSize; i++) {
                    result = result + fillChar;
                }
            }
        } else if (resultSize > fieldSize) {
            result = result.substring(1, fieldSize);
        }
        return result;
    }

    /**
     * This method returns a formatted output string based on the input. Date
     * Format - date,dataFormat Time Format - ts,dataFormat Number Format - num,
     * dataFormat,fieldDecimalPlaces Padding - inputString, fieldSize, padChar,
     * padOption
     *
     * @param date - Date
     * @param num - Number
     * @param inputString - AlphaNumeric.
     * @param dataFormat - String
     * @param fieldSize - Long
     * @param fieldDecimalPlaces - int
     * @param padOption - String
     * @param padChar - String
     */
    public static String getFormat(final Date date, final Number num, final Timestamp ts,
                                   final String inputString, final String dataFormat, final Long fieldSize,
                                   final int fieldDecimalPlaces, final String padOption, final String padChar)
            throws IllegalArgumentException {
        if (Util.isNullOrBlank(dataFormat)) {
            throw new IllegalArgumentException("The parameter DataFormat is null");
        }
        if (padOption != null && (padOption.equals(LEFT) || padOption.equals(RIGHT))) {
            if (fieldSize == null) {
                throw new IllegalArgumentException("The parameter FieldSize is null");
            }
            if (Util.isNullOrBlank(padChar)) {
                throw new IllegalArgumentException("The parameter PaddingCharacter is null");
            }
        }

        String result = "";
        if (date != null) {
            result = getFormatedDate(date, dataFormat);
        } else if (num != null) {
            result = getFormattedNumber(num, dataFormat, fieldDecimalPlaces);
        } else if (ts != null) {
            result = getTimeWithSeperator(ts);
        } else if (Util.isNullOrBlank(inputString)) {
            result = inputString;
        }

        if (padOption.equals(LEFT) || padOption.equals(RIGHT)) {
            result = getPaddingResult(result, fieldSize, padChar, padOption);
        }
        return result;
    }

    /**
     * This method returns a formatted string Date.
     *
     * @param date - Date
     * @param dataFormat - String
     */
    public static String getFormatedDate(Date date, String dataFormat) {
        String formattedDate = "";
        if (dataFormat.equals(DATE_FORMAT1)) {
            formattedDate = getDateAsCCYYMMDD(date);
        } else if (dataFormat.equals(DATE_FORMAT2)) {
            formattedDate = getDateWithSeperator(date);
        } else if (dataFormat.equals(DATE_FORMAT3)) {
            formattedDate = getDateAsYYMMDD(date);
        }
        return formattedDate;
    }

    /**
     * This method returns a formatted string number.
     *
     * @param num - Number
     * @param dataFormat - String
     * @param fieldDecimalPlaces - int
     */
    public static String getFormattedNumber(Number num, String dataFormat, int fieldDecimalPlaces) {
        String formattedNumber = "";
        if (dataFormat.equals(INTEGER)) {
            formattedNumber = getIntegerFormat(num);
        } else if (dataFormat.equals(DECIMAL)) {
            formattedNumber = getDecimalformat(num, fieldDecimalPlaces);
        } else if (dataFormat.equals(ASSUMED_DECIMAL)) {
            formattedNumber = getAssumedDecimalPointFormat(num, fieldDecimalPlaces);
        }
        return formattedNumber;
    }

    /**
     * Returns an array of integers parsed from a value string which has numeric
     * substrings seperated by delimiters.Non integer string values are read as
     * null.
     *
     * @param valueString - the value string
     * @delimiter - the delimiter
     * @return Integer[] - the array of integers
     */
    public static Integer[] getIntegerValues(final String valueString, final String delimiter) {
        String[] tokens = valueString.split(delimiter);
        Integer[] result = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                result[i] = Integer.valueOf(tokens[i].trim());
            } catch (Exception e) {
            }
        }
        return result;
    }

    /**
     * Returns an array of longs parsed from a value string which has numeric
     * substrings seperated by delimiters.Non long string values are read as
     * null.
     *
     * @param valueString - the value string
     * @delimiter - the delimiter
     * @return Long[] - the array of longs
     */
    public static Long[] getLongValues(final String valueString, final String delimiter) {
        String[] tokens = valueString.split(delimiter);
        Long[] result = new Long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                result[i] = Long.valueOf(tokens[i].trim());
            } catch (Exception e) {
            }
        }
        return result;
    }

    /**
     * Returns an array of Big Decimals parsed from a value string which has
     * numeric substrings seperated by delimiters.Non decimal string values are
     * read as null.
     *
     * @param valueString - the value string
     * @delimiter - the delimiter
     * @return BigDecimal[] - the array of decimals
     */
    public static BigDecimal[] getBigDecimalValues(final String valueString, final String delimiter) {
        String[] tokens = valueString.split(delimiter);
        BigDecimal[] result = new BigDecimal[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                Double doubleValue = Double.valueOf(tokens[i].trim());
                result[i] = BigDecimal.valueOf(doubleValue.doubleValue());
            } catch (Exception e) {
            }
        }
        return result;
    }

    /**
     * This method returns a day from time stamp.
     *
     * @param weekday - int
     */
    public static String findDayFromTimeStamp(int weekday) {
        String day = null;
        if (weekday == ONE) {
            day = "Sunday";
        }
        if (weekday == TWO) {
            day = "Monday";
        }
        if (weekday == THREE) {
            day = "Tuesday";
        }
        if (weekday == FOUR) {
            day = "Wednesday";
        }
        if (weekday == FIVE) {
            day = "Thursday";
        }
        if (weekday == SIX) {
            day = "Friday";
        }
        if (weekday == SEVEN) {
            day = "Saturday";
        }
        return day;
    }

    /**
     * Used to obtain the current system time in hour/minute format
     *
     * @return a time as string
     */
    public static String getSystemTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        return dateFormat.format(cal.getTimeInMillis());
    }

    /**
     * Used to obtain the month from the time stamp using the date passed as an
     * input argument. It uses getMonthFromTimestamp
     *
     * @param date - Date
     */
    public static String getMonthFromTimestamp(final Date date) {
        SimpleDateFormat monthDayYearformatter = new SimpleDateFormat(TIMESTAMP_MONTH_FORMAT);
        String month = monthDayYearformatter.format(date);
        return month;
    }

    /**
     * Used to obtain the time from the time stamp using the date passed as an
     * input argument. It uses getTimeFromTimestamp
     *
     * @param date - Date
     */
    public static String getTimeFromTimestamp(final Date date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
        String time = timeFormat.format(date);
        return time;
    }

    /**
     * Used to obtain the weekday from the time stamp
     *
     * @param ts -Timestamp
     */
    public static int getWeekDayFromTimestamp(Timestamp ts) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ts);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }

    /**
     * <code>getWATdatetimeAsString</code>Derive West African Date/Time Zone
     *
     * @param date - Current Date
     * @return String representation of current date
     */
    public static String getWATdatetimeAsString(final Date date) {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("WAT"));
        final String utcTime = sdf.format(new Date());
        return utcTime;
    }

    /**
     *
     *
     * @param msisdn
     * @return
     */
    public static String stripMsisdn(String msisdn) {
        if (msisdn.startsWith("+234")) {
            msisdn = msisdn.substring(4);
        } else if (msisdn.startsWith("234")) {
            msisdn = msisdn.substring(3);
        } else if (msisdn.startsWith("0")) {
            msisdn = msisdn.substring(1);
        }
        return msisdn;
    }

    /**
     * Gets the textual description of the next N days
     *
     * @param numDays
     * @param separator
     * @return String
     */
    public static String getNextNDaysAsString(int numDays, String separator) {
        if (separator == null || separator.trim().isEmpty()) {
            separator = "/";
        }
        DateFormat dateFormat = new SimpleDateFormat("dd" + separator + "MM" + separator + "yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, numDays);
        return dateFormat.format(cal.getTime());
    }

    /**
     *
     * @param value
     * @return
     */
    public static String formatAmount(String value) {
        if (value != null && !value.isEmpty()) {
            double amount = Double.parseDouble(value);
            try {
                BigDecimal amt = new BigDecimal(amount / 100).setScale(2, RoundingMode.HALF_UP);
                amount = amt.doubleValue();
            } catch (Exception ex) {
            }
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "NG"));
            //DecimalFormat formatter = new DecimalFormat("#,###,###,###.##");
            return "" + nf.format(amount);
        }
        return value;
    }

    /**
     *
     * @param value
     * @return
     */
    public static String formatAmount2(final String value) {
        if (value != null && !value.isEmpty()) {
            double amount = Double.parseDouble(value);
            DecimalFormat formatter = new DecimalFormat("#,###,###,###.00");
            return "" + formatter.format(amount);
        }
        return value;
    }

    /**
     *
     * @param value
     * @return
     */
    public static String formatDisplay(final String value) {
        if (value != null && !value.isEmpty()) {
            double amount = Double.parseDouble(value);
            DecimalFormat formatter = new DecimalFormat("#,###,###,###");
            return "" + formatter.format(amount);
        }
        return value;
    }

    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getTomorrowDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    public static Date[] getMonthSearchDates() {
        Calendar cal = Calendar.getInstance();
        Date endDt = cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDt = cal.getTime();
        return new Date[]{startDt, endDt};
    }

    public static Date[] getWeekSearchDates() {
        Calendar cal = Calendar.getInstance();
        Date endDt = cal.getTime();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        Date startDt = cal.getTime();
        if (startDt.after(endDt)) {
            cal.add(Calendar.DAY_OF_MONTH, -7);
            startDt = cal.getTime();
        }
        return new Date[]{startDt, endDt};
    }

    public static Date[] getTodaySearchDates() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date today = cal.getTime();
        return new Date[]{today, Util.getTomorrowDate(today)};
    }

    public static String[] getTimeSearch(int interval) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT1);
        String now = dateFormat.format(cal.getTimeInMillis());
        cal.add(Calendar.MINUTE, (-interval));
        cal.set(Calendar.SECOND, 0);
        return new String[]{dateFormat.format(cal.getTimeInMillis()), now};
    }

    public static String getDisplayDateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            return sdf.format(date);
        }catch(Exception e){
            return "N/A";
        }
    }
}

