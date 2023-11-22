package caseStudy.services;

import caseStudy.models.Employee;

public interface EmployeeService extends Service<Employee>{
    @Override
    void addNew(Employee employee);

    void editEmployee(String id);

    @Override
    void displayList();
}
