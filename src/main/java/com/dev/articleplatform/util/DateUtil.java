package com.dev.articleplatform.util;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private DateUtil() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    private static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    public static String date2String(Date date){
        try {
            return new SimpleDateFormat(ISO_8601_PATTERN).format(date);
        }catch (Exception ex){
            LOGGER.error("date2StringExp: ", ex);
            return Strings.EMPTY;
        }
    }
}
