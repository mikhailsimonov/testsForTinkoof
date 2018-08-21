package ru.tinkoff.qa.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * util for gen test data etc.
 */
public class ValueGenerator {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    static final Integer id = new Random(System.currentTimeMillis()).nextInt(8888- 1400)+1800;

    public static Long genRandomId(){
        return Long.valueOf(id);
    }

    public static Long timeMilliseconds(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
}
