package com.callcenter.util;

import java.text.ParseException;
import java.util.Calendar;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DateConverterTest {

    @Test
    public void shouldConvertTheTimeFromCPlusPlusUnsignedLongFormat() throws ParseException {
        byte[] dateAndTimeInSeconds = {(byte) 0xc9, (byte) 0xbf, 0x59, (byte) 0xce};
        com.callcenter.util.DateConverter dateConverter = new com.callcenter.util.DateConverter();
        Calendar callTime = dateConverter.getCallTime(dateAndTimeInSeconds);

        Calendar expectedDate = Calendar.getInstance();

        //Wed Sep 15 07:01:37 2010
        expectedDate.setTimeInMillis(1284514297000l);

        assertThat(callTime.equals(expectedDate), is(true));
    }

}
