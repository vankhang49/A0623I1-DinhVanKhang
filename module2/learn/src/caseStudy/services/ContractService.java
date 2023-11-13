package caseStudy.services;

import caseStudy.models.Contract;

public interface ContractService extends Service<Contract> {
    @Override
    void addNew(Contract c);
    void addNewContract();

    @Override
    void displayList();
    void editContract(int contractNumber);
}
