package Sesson2.bai_tap;

public class PrimeNumberLessThan100 {
    public static void main(String[] args) {
        for(int prime = 2; prime <= 100; prime++){
            boolean flag = true;
            for(int i = 2; i<= Math.sqrt(prime); i++){
                if (prime % i == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.print(prime + ", ");
            }
        }
    }
}
