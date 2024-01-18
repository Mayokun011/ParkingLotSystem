package ParkingLot;

public class ScanTicket {

    public int checkNumber(String inputnumber, String savenumber){

        int size1 = inputnumber.length();
        int size2 = savenumber.length();
        if(size1 != size2){
            return 0;
        } else if (inputnumber.equals(savenumber)) {
            return 1;
        }
        return 0;
    }
}
