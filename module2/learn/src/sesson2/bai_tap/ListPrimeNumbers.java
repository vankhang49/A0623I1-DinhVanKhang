package sesson2.bai_tap;
public class ListPrimeNumbers {
    public static void main(String[] args) {
        int quantity = 20;
        int count = 0;
        for(int prime = 2; count <= quantity; prime++){
            boolean flag = true;
            for(int i = 2; i<= Math.sqrt(prime); i++){
                if (prime % i == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.print(prime + ", ");
                count++;
            }
        }
    }
}
