package com.callcenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateConverter {

    public Calendar getCallTime(byte[] recordingTime) {
        long timeInSecond = parseCallRecordingTimeInSecond(recordingTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(callRecordingTimeInMilliSeconds(timeInSecond) - numberOfMilliSecondsBetweenDotNetAndJavaEpochTime());
        return calendar;
    }

    private long callRecordingTimeInMilliSeconds(long timeInSecond) {
        return timeInSecond * 1000;
    }

    private long numberOfMilliSecondsBetweenDotNetAndJavaEpochTime() {
        String dotNetEpochTime = "01/01/1901 00:00:00";
        Date time = null;

        try {
            time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dotNetEpochTime);
        } catch (ParseException e) {
        }
        return Math.abs(time.getTime());
    }

    private long parseCallRecordingTimeInSecond(byte[] timeBytes) {
        long timeInSecond = byteToLong(timeBytes[0]);
        timeInSecond += byteToLong(timeBytes[1]) << 8;
        timeInSecond += byteToLong(timeBytes[2]) << 16;
        timeInSecond += byteToLong(timeBytes[3]) << 24;
        return timeInSecond;
    }

    private long byteToLong(byte timeByte) {
        return (long) (timeByte & 0xff);
    }


}
