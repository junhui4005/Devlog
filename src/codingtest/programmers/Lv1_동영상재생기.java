package src.codingtest.programmers;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Lv1_동영상재생기 {
    public static void main(String[] args) {
        String video_len = "50:00";
        String pos = "29:50";
        String op_start = "30:00";
        String op_end = "31:00";
        String[] commands = {"next", "prev"}; // 기대값: 31:00
        LocalDate localDate = LocalDate.now();
        LocalDateTime startTime = localDate.atTime(0, 0, 0);
        LocalDateTime endTime = localDate.atTime(0, Integer.parseInt(video_len.substring(0,2)) , Integer.parseInt(video_len.substring(3,5)));
        LocalDateTime posTime = localDate.atTime(0, Integer.parseInt(pos.substring(0,2)) , Integer.parseInt(pos.substring(3,5)));
        LocalDateTime op_startTime = localDate.atTime(0, Integer.parseInt(op_start.substring(0,2)) , Integer.parseInt(op_start.substring(3,5)));
        LocalDateTime op_endTime = localDate.atTime(0, Integer.parseInt(op_end.substring(0,2)) , Integer.parseInt(op_end.substring(3,5)));

        if(posTime.isAfter(op_startTime) && posTime.isBefore(op_endTime)) {
            posTime = op_endTime;
        }
        for (String command : commands) {
            if(command.equals("next")) {
                if(posTime.plusSeconds(10).isBefore(endTime) ) {
                    posTime = posTime.plusSeconds(10);
                }else{
                    posTime = endTime;
                }
            }
            else if(command.equals("prev")) {
                if(posTime.minusSeconds(10).isAfter(startTime)) {
                    posTime = posTime.minusSeconds(10);
                }else {
                    posTime = startTime;
                }
            }
            if((posTime.isAfter(op_startTime) || posTime.isEqual(op_startTime))
                    && (posTime.isBefore(op_endTime) || posTime.isEqual(op_endTime))) {
                posTime = op_endTime;
            }
        }
        System.out.println(posTime.format(DateTimeFormatter.ofPattern("mm:ss")));
    }
}
