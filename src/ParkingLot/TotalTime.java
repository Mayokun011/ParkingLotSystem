package ParkingLot;

public class TotalTime {

    public static int[] CalculateTime(String enterdate, String exitdate, String entertime, String exittime) {

        int firstDay = Integer.parseInt(enterdate.substring(8, 10));
        int lastDay = Integer.parseInt(exitdate.substring(8, 10));
        int firstMonth = Integer.parseInt(enterdate.substring(5, 7), 10);
        int lastMonth = Integer.parseInt(exitdate.substring(5, 7));
        int firstYear = Integer.parseInt(enterdate.substring(0, 4));

        //Time Calculation for different month days
        if (firstMonth != lastMonth) {
            int daysInMonth;
            if (firstMonth == 1 || firstMonth == 3 || firstMonth == 5 || firstMonth == 7 || firstMonth == 8
                    || firstMonth == 10 || firstMonth == 12) {
                daysInMonth = 31;
            } else {
                if (firstMonth == 2) {
                    daysInMonth = (firstYear % 4 == 0) ? 29 : 28;
                } else {
                    daysInMonth = 30;
                }
            }

            int Days = daysInMonth - firstDay;
            Days = Days + (lastDay - 1);
            int hourInTotalDays = Days * 24;

            // Total Hour in First day

            int hoursInFirstDay = 0;
            int minutesInFirstDay = 0;

            if (entertime.substring(6, 8).equals("AM")) {
                if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                    hoursInFirstDay = 11 + 12;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                } else {
                    hoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0, 2)) + 1)) + 12;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }
            } else if (entertime.substring(6, 8).equals("PM")) {
                if (Integer.parseInt(entertime.substring(0, 2)) == 12) {
                    hoursInFirstDay = 11;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3, 5));
                }
            } else {
                hoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0, 2)) + 1);
                minutesInFirstDay = 60 - (Integer.parseInt(entertime.substring(3, 5)));
            }
        }
        // Total Hour and Minute in Last Day
        int hoursInLastDay = 0;
        int minutesInLastDay = 0;

        if (exittime.substring(6, 8).equals("AM")) {
            if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                hoursInLastDay = 0;
                minutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
            } else {
                hoursInLastDay = Integer.parseInt(exittime.substring(0, 2));
                minutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
            }
        } else if (exittime.substring(6, 8).equals("PM")) {
            if (Integer.parseInt(exittime.substring(0, 2)) == 12) {
                hoursInLastDay = 12;
                minutesInLastDay = Integer.parseInt(exittime.substring(3, 5));
            } else {
                hoursInLastDay = 12 + Integer.parseInt(exittime.substring(0, 2));
                minutesInLastDay = Integer.parseInt(entertime.substring(3, 5));
            }


        // Total Hours and Minutes


            int hoursInTotalDays = 0;
            int hoursInFirstDay = 0;
            int minutesInFirstDay = 0;

            int hour = hoursInTotalDays + hoursInFirstDay + hoursInLastDay;
            int minute = minutesInFirstDay + minutesInLastDay;

        if (minute >= 60) {
            minute = minute - 60;
            hour = hour + 1;
        }
        return new int[]{hour, minute};
    }
    //Time Calculation for Same Months and Day
    else{
            if ((lastDay - firstDay) >= 2) {
                //Total Hour in Days
                int Days = (lastDay - (firstDay - 1)) - 2;
                int hourInTotalDays = Days * 24;

            //Total hour in Firstday
            int hoursInFirstDay = 0;
            int minutesInFirstDay = 0;

            if (entertime.substring(6, 8).equals("AM")) {
                if (Integer.parseInt(entertime.substring(0,2)) == 12){
                    hoursInFirstDay = 11 +12;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                }else{
                    hoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0,2)) + 1)) + 12;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                }
            } else if (entertime.substring(6,8).equals("PM")) {
                if(Integer.parseInt(entertime.substring(0,2)) == 12){
                    hoursInFirstDay = 11;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                }else {
                    hoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0,2)) + 1);
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                }
            }

            //Total Hour and Minutes in last Day
                hoursInLastDay = 0;
                minutesInLastDay = 0;

            if(exittime.substring(6,8).equals("AM")){
                if(Integer.parseInt(exittime.substring(0,2)) == 12){
                    hoursInLastDay = 0;
                    minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                }else{
                    hoursInLastDay = Integer.parseInt(exittime.substring(0,2));
                    minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                }
            }else if(exittime.substring(6,8).equals("PM")){
                if(Integer.parseInt(exittime.substring(0,2)) == 12){
                    hoursInLastDay = 12;
                    minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                }else {
                    hoursInLastDay = 12 + Integer.parseInt(exittime.substring(0,2));
                    minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                }
            }
            //Total Hours and Minutes

            int hour = hourInTotalDays + hoursInFirstDay + hoursInLastDay;
            int minute = minutesInFirstDay + minutesInLastDay;

            if (minute >= 60) {
                minute = minute - 60;
                hour = hour + 1;
            }

            return new int[] {hour,minute};
        }

        // For One day Difference Only

        else if((lastDay - firstDay) == 1){
            int hoursInFirstDay = 0;
            int minutesInFirstDay = 0;

            if(entertime.substring(6,8).equals("AM")){
                if(Integer.parseInt(entertime.substring(0,2)) == 12){
                    hoursInFirstDay = 11 +12;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                }else {
                    hoursInFirstDay = (12 - (Integer.parseInt(entertime.substring(0,2)) +1)) + 12;
                    minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                }
            } else if (entertime.substring(6,8).equals("PM")) {
                if (Integer.parseInt(entertime.substring(0,2)) == 12) {
                        hoursInFirstDay = 11;
                        minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                    }else{
                        hoursInFirstDay = 12 - (Integer.parseInt(entertime.substring(0,2)) + 1);
                        minutesInFirstDay = 60 - Integer.parseInt(entertime.substring(3,5));
                    }
                }

                //Hour and Minute in First and Last Day
                hoursInLastDay = 0;
                minutesInLastDay = 0;

                if(exittime.substring(6,8).equals("AM")){
                    if(Integer.parseInt(exittime.substring(0,2)) == 12) {
                        hoursInLastDay = 0;
                        minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                    } else {
                        hoursInLastDay = Integer.parseInt(exittime.substring(0,2));
                        minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                    }
                } else if (exittime.substring(6,8).equals("PM")) {
                    if(Integer.parseInt(exittime.substring(0,2)) == 12){
                        hoursInLastDay = 12;
                        minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                    } else{
                        hoursInLastDay = 12 + Integer.parseInt(exittime.substring(0,2));
                        minutesInLastDay = Integer.parseInt(exittime.substring(3,5));
                    }

                }

                int hour = hoursInFirstDay + hoursInLastDay;
                int minute = minutesInFirstDay + minutesInLastDay;
                if(minute >= 60){
                    minute = minute - 60;
                    hour = hour + 1;
                }
                return new int[] {hour,minute};

            }

            //for one Single day

            else if((lastDay - firstDay) == 0) {
                int parkedHour = 0;
                int parkedMinute = 0;
                int exitHour = 0;
                int exitMinute = 0;
                int hour = 0;
                int minute = 0;

                if(entertime.substring(6,8).equals("AM") && exittime.substring(6,8).equals("AM")){
                    if(Integer.parseInt(entertime.substring(0,2)) == 12){
                        hour = Integer.parseInt(exittime.substring(0,2));
                        minute = (60 - Integer.parseInt(entertime.substring(3,5))) + Integer.parseInt(exittime.substring(3,5));
                    }else{
                        hour = Integer.parseInt(exittime.substring(0,2)) - (Integer.parseInt(entertime.substring(0,2)) + 1);
                        minute = (60 - Integer.parseInt(entertime.substring(3,5))) + Integer.parseInt(exittime.substring(3,5));
                    }
                } else if (entertime.substring(6,8).equals("PM") && exittime.substring(6,8).equals("PM")) {
                    if(Integer.parseInt(entertime.substring(0,2)) == 12){
                        hour = Integer.parseInt(exittime.substring(0,2));
                        minute = (60 - Integer.parseInt(entertime.substring(3,5))) + Integer.parseInt(exittime.substring(3,5));
                    }else{
                        hour = Integer.parseInt(exittime.substring(0,2)) - (Integer.parseInt(entertime.substring(0,2)) + 1);
                        minute = (60 - Integer.parseInt(entertime.substring(3,5))) + Integer.parseInt(exittime.substring(3,5));
                    }

                } else if (entertime.substring(6,8).equals("AM") && exittime.substring(6,8).equals("PM")) {

                    if(Integer.parseInt(entertime.substring(0,2)) == 12){
                        parkedHour = 12;
                        parkedMinute = 60 - Integer.parseInt(entertime.substring(3,5));
                    }else{
                        parkedHour = 12 - (Integer.parseInt(entertime.substring(0,2)) + 1);
                        parkedMinute = 60 - Integer.parseInt(entertime.substring(3,5));
                    }

                    if(Integer.parseInt(exittime.substring(0,2)) == 12){
                        exitHour = Integer.parseInt(exittime.substring(0,2));
                        exitMinute = Integer.parseInt(exittime.substring(3,5));
                    }else{
                        exitHour = Integer.parseInt(exittime.substring(0,2));
                        exitMinute = Integer.parseInt(exittime.substring(3,5));
                    }

                    hour = parkedHour + exitHour;
                    minute = parkedMinute + exitMinute;

                }

                if(minute >= 60){
                    minute = minute - 60;
                    hour = hour + 1;
                }

                return new int[] {hour,minute};
        }
    }
        return new int[] {};
}

}