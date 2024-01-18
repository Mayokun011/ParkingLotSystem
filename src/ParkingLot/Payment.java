package ParkingLot;

public class Payment {

    float hourAmount = 30;
    float totalAmountForHour = 0;
    float totalAmountForMinute = 0;

    public float totalAmount (int Hour, int Minute){
        totalAmountForHour = Hour * hourAmount;
        if(Minute < 60 && Minute >= 30) {
            totalAmountForMinute = 20;
        } else if (Minute < 30 && Minute >= 15) {
            totalAmountForMinute = 15;

        } else if (Minute < 15 && Minute >= 1) {
            totalAmountForMinute = 10;
        }
        return (totalAmountForHour + totalAmountForMinute);
    }
}
