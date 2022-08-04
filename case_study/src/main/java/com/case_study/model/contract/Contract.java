package com.case_study.model.contract;

import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private String startDate;
    private String endDate;
    private double deposit;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetail;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "facilityId")
    private Facility facility;

    public Contract() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
