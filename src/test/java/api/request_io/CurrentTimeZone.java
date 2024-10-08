package api.request_io;

import java.util.Date;

public class CurrentTimeZone {

        public Integer year;
        public Integer month;
        public Integer day;
        public Integer hour;
        public Integer minute;
        public Integer seconds;
        public Integer milliSeconds;
        public String dateTime;
        public String date;
        public String time;
        public String timeZone;
        public String dayOfWeek;
        public boolean dstActive;

    public CurrentTimeZone() {
    }

    public CurrentTimeZone(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer seconds,
                           Integer milliSeconds, String dateTime, String date, String time, String timeZone, String dayOfWeek, boolean dstActive) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
        this.milliSeconds = milliSeconds;
        this.dateTime = dateTime;
        this.date = date;
        this.time = time;
        this.timeZone = timeZone;
        this.dayOfWeek = dayOfWeek;
        this.dstActive = dstActive;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public Integer getMilliSeconds() {
        return milliSeconds;
    }

    public void setMilliSeconds(Integer milliSeconds) {
        this.milliSeconds = milliSeconds;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isDstActive() {
        return dstActive;
    }

    public void setDstActive(boolean dstActive) {
        this.dstActive = dstActive;
    }
}
