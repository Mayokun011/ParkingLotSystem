package ParkingLot;

public class ParkingSpot {

    int[] arr = new int[100];

    public int spotNum() {
        int spot = 0;
        for (int i = 0; i < 100; i++) {
            if (arr[i] == 0) {
                spot = i + 1;
                arr[i] = i + 1;
                break;

            }
        }
        return spot;
    }
    public int si(){
        int checkspot = 0;
        for(int i = 0; i < 100; i++){
            if(arr[i] != 0) {
                return 1;
            } else if (arr[i] == 0) {

            checkspot ++;
            }
        } return checkspot;
    }

    public void sipe() {
        System.out.println("\nSpot status : ");
        for (int i = 0; i < 100; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
        public void freeSpot (int num){
            arr[num - 1] = 0;
        }
    }

