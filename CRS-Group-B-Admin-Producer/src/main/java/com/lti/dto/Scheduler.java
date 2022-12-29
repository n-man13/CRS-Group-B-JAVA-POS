package com.lti.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Scheduled(cron = "0 0 8 * * ?")
    public void cronJob(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curr = new Date();
        String date = format.format(curr);
        System.out.println(date);
    }
    
}
