package caseStudy.services;

import caseStudy.models.Facility;

import java.util.List;

public interface FacilityService extends Service<Facility> {
    @Override
    void addNew(Facility f);
    void increaseTurns(String serviceName);
    @Override
    void displayList();
    void addFacilityMenu();
    void displayFacilityMaintenance();
    boolean checkFacility(String serviceName);
    List<Facility> getFacilityList();
}
