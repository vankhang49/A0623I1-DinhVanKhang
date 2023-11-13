package caseStudy.services;

import caseStudy.models.Booking;

import java.util.List;

public interface BookingService extends Service<Booking>{
    @Override
    void addNew(Booking b);
    void addNewBooking();
    List<Booking> getBooking();
    @Override
    void displayList();
    double getRentalFee(String serviceName);
}
