package ParkingLot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomInfo {
    Random random = new Random();

    String[] states = {"MH", "GJ","RJ","DL","MP","UP","KA","JK","LA"};
    String[] dist = {"02","27","12","19","22","08","05","26","30"};
    String[] alpha = {"AB","CV","RT","ZX","WE","JK","RL","AQ","PO","DH"};
    String[] color = {"Red","Yellow","Green","White","Brown","violet","Pink"};
    String[] type = {"Sedan","Van","Minivan","Bus","Pickup-truck","Hatchback"};

    public String numberPlate(){
        int st = random.nextInt(states.length);
        int di = random.nextInt(dist.length);
        int al = random.nextInt(alpha.length);

        return states[st] + "-" + dist[di] + " " + alpha[al] + " " + random.nextInt((99-10) + 1) +10;
    }

    public String carColor(){
        int res = random.nextInt(color.length);
        return color[res];
    }

    public String carType(){
        int typ = random.nextInt(type.length);
        return type[typ];
    }

    //Information for Parkingtickecks

    public String Time(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String enterTime = localTime.format(dateTimeFormatter);
        return enterTime;
    }

    public String exitTime(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String exitTime = localTime.format(dateTimeFormatter);
        return exitTime;
    }
    public String Date(){
        LocalDate mydate = LocalDate.now();
        return mydate.toString();
    }
    public String exitDate(){
        LocalDate date = LocalDate.now();
        return date.toString();
    }
     String[] cardtype = {"Debit","Credit"};
    public String cardtype(){
        int card = random.nextInt(cardtype.length);
        return cardtype[card];
    }

    public long cardNumber(){
        return((random.nextLong() % 100000000000000L) + 5200000000000000L);
    }


}
