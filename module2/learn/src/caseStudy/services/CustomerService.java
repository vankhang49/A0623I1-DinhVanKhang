package caseStudy.services;

import caseStudy.models.Customer;

public interface CustomerService extends Service<Customer>{
    void editCustomer(String id);

    @Override
    void addNew(Customer c);

    @Override
    void displayList();
}
