package caseStudy.services;

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
            Date date1 = dateFormat.parse(o1.getBeginDate());
            Date date2 = dateFormat.parse(o2.getBeginDate());

            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}