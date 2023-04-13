package ru.wintuar.notebook.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Utils {

    //  метод, переводящий в строку текущее время. (в базе данных время хранится в виде строки)
    public static String conbertTimetoStrimg(){
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp);
    }
}
