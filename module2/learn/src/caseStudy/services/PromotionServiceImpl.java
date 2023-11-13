package caseStudy.services;

import caseStudy.models.Booking;
import caseStudy.models.Promotion;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    static Scanner sc = new Scanner(System.in);
    private static final Set<Booking> promotionList = new TreeSet<>(new BookingComparator());
    private static final Stack<Promotion> promotionStack = new Stack<>();
    private static final BookingService bookingService = new BookingServiceImpl();
    static {
        List<Booking> arrayList = bookingService.getBooking();
        promotionList.addAll(arrayList);
    }
    public Set<Booking> customersEligible(){
        Set<Booking> customersEligible = new TreeSet<>(Collections.reverseOrder(new BookingComparator()));
        for (Booking b: promotionList){
            String[] arr = b.getServiceName().split("-");
            if (Objects.equals(arr[0], "SVVL") || Objects.equals(arr[0], "SVHO")){
                customersEligible.add(b);
            }
        }
        return customersEligible;
    }
    public void addVoucher() {
        Set<Booking> customerEligible = customersEligible();
        int quantityV = customerEligible.size();
        System.out.println("Enter voucher quantity: ");
        System.out.println("Enter the number of 10% vouchers in " + quantityV + " voucher : ");
        int ten = sc.nextInt();
        System.out.println("Enter the number of 20% vouchers in " + (quantityV - ten) + " voucher : ");
        int twenty = sc.nextInt();
        int fifty = quantityV - twenty - ten;
        System.out.println("50% voucher amount is " + fifty);
        for (Booking b: customerEligible){
            String[] arr = b.getServiceName().split("-");
            if (Objects.equals(arr[0], "SVVL") || Objects.equals(arr[0], "SVHO")){
                if (ten > 0){
                    promotionStack.push(new Promotion(b.getIdCustomer(), 10));
                    ten--;
                } else if (twenty > 0){
                    promotionStack.push(new Promotion(b.getIdCustomer(), 20));
                    twenty--;
                } else {
                    promotionStack.push(new Promotion(b.getIdCustomer(), 50));
                    fifty--;
                }
            }
        }
    }

    @Override
    public void displayCusUseService() {
        System.out.println("List of customers who have used the service: ");
        for (Booking b: promotionList){
            String date = b.getBeginDate();
            String[] arr = date.split("/");
            int year = Integer.parseInt(arr[2]);
            System.out.println("Id booking: " + b.getIdBooking() + ", Id Customer: " + b.getIdCustomer() +
                    ", Used Service: " + b.getServiceName() + ", Year of voucher use: " + year);
        }
    }

    @Override
    public void displayCusGetVoucher() {
        System.out.println("Customers who enjoy incentives are those who use villa and house services");
        addVoucher();
        System.out.println("List of customers who have got voucher: ");
        for (Promotion p: promotionStack){
            System.out.println(p + "\n");
        }
    }
}
