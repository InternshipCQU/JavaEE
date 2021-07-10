package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {

    private final String currentTime;

    public GetTime(){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        currentTime = ft.format(dNow);
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
