package ParkingLot;

public class ParkingTicket {

    public String enterDate;
    public String enterTime;
    private long cardNumber;
    public String cardType;
    public int spotNumber;

    public Car car;

    public Car getAssignedCar(){
        return car;
    }

    public void setAssignedCar(Car car) {
        this.car = car;
    }

    public String getDate(){
        return enterDate;
    }

    public void setDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getTime() {
        return enterTime;
    }

    public void setTime(String enterTime) {
        this.enterTime = enterTime;
    }

    private long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long carNumber) {
        this.cardNumber = carNumber;
    }

    private String getCardType() {
        return cardType;
    }

    public void setCardType(String carType) {
        this.cardType = carType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}
