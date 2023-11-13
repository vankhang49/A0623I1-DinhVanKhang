package caseStudy.services;

import caseStudy.models.Employee;

public interface EmployeeService extends Service<Employee>{
    void editEmployee(String id);

    @Override
    void addNew(Employee employee);

    @Override
    void displayList();
}
