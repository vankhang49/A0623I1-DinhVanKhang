package caseStudy.serviceImpl;

import caseStudy.models.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class BookingComparator implements Comparator<Booking> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public int compare(Booking o1, Booking o2) {
        try {
            Date bDate1 = dateFormat.parse(o1.getBeginDate());
            Date eDate1 = dateFormat.parse(o1.getEndDate());
            Date bDate2 = dateFormat.parse(o2.getBeginDate());
            Date eDate2 = dateFormat.parse(o2.getEndDate());

            if(bDate1.compareTo(bDate2) == 0){
                return eDate1.compareTo(eDate2);
            };
            return bDate1.compareTo(bDate2);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

}