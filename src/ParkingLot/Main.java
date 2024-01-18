package ParkingLot;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <ParkingTicket> assingedspotlist = new ArrayList<>();

        ParkingSpot parkingSpot = new ParkingSpot();
        RandomInfo randomInfo = new RandomInfo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("You Want to Park your Vehicle: ");
            String userinput = scanner.nextLine();
            int size = userinput.length();

            ParkingTicket parkingTickect = new ParkingTicket();
            Car car = new Car();

            if (size == 5){
                System.out.println("\033\143");
                //Get Car Information from Car Class
                String carcolor = randomInfo.carColor();
                String numberplate = randomInfo.numberPlate();
                String cartype = randomInfo.carType();

                parkingTickect.setAssignedCar(car);
                parkingTickect.getAssignedCar().setNumberPlate(numberplate);
                parkingTickect.getAssignedCar().setCarColor(carcolor);
                parkingTickect.getAssignedCar().setCarType(cartype);

                //Get Spot from parkingSpot Class
                int spotnum = parkingSpot.spotNum();
                if(spotnum == 0){
                    System.out.println("Sorry, spot is not available.");
                    continue;
                }
                parkingTickect.setSpotNumber(spotnum);

                //Get Parking Tickect from parkingTickect Class
                String cardType = randomInfo.cardtype();
                String time = randomInfo.Time();
                String date = randomInfo.Date();
                long cardNumber = randomInfo.cardNumber();

                parkingTickect.setCardType(cardType);
                parkingTickect.setTime(time);
                parkingTickect.setDate(date);
                parkingTickect.setCardNumber(cardNumber);


                System.out.println("\t\t== Parking Ticket ==\n" +
                        "Car Number : " + numberplate + "   Car Color : " + carcolor + "   Car Type : " + cartype +
                        "\nParking Time : " + time + "  Date : " + date +
                        "\nSpot Number : " + spotnum + "\n");

                assingedspotlist.add(parkingTickect);
                System.out.println(assingedspotlist.size());
            } else if (size == 4) {
               // System.out.println("\033\143");
                int checkspot = parkingSpot.si();
                if(checkspot == 10 ){
                    System.out.println("There is no Car .");
                    continue;
                }else{
                    System.out.println("Enter your Car Number : ");
                    String number = scanner.nextLine();
                    ScanTicket scanTicket = new ScanTicket();
                    TotalTime totalTime = new TotalTime();
                    Payment payment = new Payment();
                    for (ParkingTicket cp : assingedspotlist){
                        String carnumber = cp.getAssignedCar().getNumberPlate();
                        int item = scanTicket.checkNumber(number,carnumber);
                        if (item == 0){
                            continue;
                        } else if (item == 1) {
                            int spot = assingedspotlist.indexOf(cp);
                           // System.out.println("\n" + spot + "\n");
                            String exitdate = randomInfo.exitDate();
                            String exittime = randomInfo.exitTime();

                            String enterdate = assingedspotlist.get(spot).getDate();
                            String entetime = assingedspotlist.get(spot).getTime();

                            int time[] = totalTime.CalculateTime(enterdate,exitdate,entetime,exittime);
                            float amount = payment.totalAmount(time[0],time[1]);

                            System.out.println("\n\t\t === Your Parking Information ===\n " +
                                    "Car Number : " + assingedspotlist.get(spot).getAssignedCar().getNumberPlate() +
                                    "  Car Color : " + assingedspotlist.get(spot).getAssignedCar().getCarColor() +
                                    "  Car Type : " + assingedspotlist.get(spot).getAssignedCar().getCarType() +
                                    "\nParking Time : " + assingedspotlist.get(spot).getTime() +
                                    "   Exit Time : " + exittime +
                                    "\nParking Date : " + assingedspotlist.get(spot).getDate() +
                                    "   Exit Date : "+ exitdate +
                                    "   Spot Number : " + assingedspotlist.get(spot).getSpotNumber() +
                                    "\nTotal Time : " + time[0] + " Hour " + time[1] + " Minute " +
                                    "\nTotal Amount : " + amount + " rupees\n");
                            parkingSpot.freeSpot(assingedspotlist.get(spot).getSpotNumber());
                            assingedspotlist.remove(spot);

                            break;
                        }
                    }
                }

            } else if (size == 6) {
                System.out.println("All Car Information : \n");
                for(ParkingTicket pt : assingedspotlist){
                    System.out.println("\n\nCar Number : " + pt.getAssignedCar().getNumberPlate() +
                                       "     Car Color : " + pt.getAssignedCar().getCarColor() +
                                       "     Car Type : " + pt .getAssignedCar().getCarType() +
                                       "\nParking Time : " + pt.getTime() + "   date : " + pt.getDate() +
                                       "      Spot Number : " + pt.getSpotNumber());
                }
                parkingSpot.sipe();
                System.out.println();
            }

        }
    }
}
