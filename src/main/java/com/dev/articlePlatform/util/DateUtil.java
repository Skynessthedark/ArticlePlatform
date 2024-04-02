package com.dev.articlePlatform.util;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static String date2String(Date date){
        try {
            return DATE_FORMAT.format(date);
        }catch (Exception ex){
            LOGGER.error("date2StringExp: ", ex);
            return Strings.EMPTY;
        }
    }
}
