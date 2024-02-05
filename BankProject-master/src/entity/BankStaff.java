package entity;

public class BankStaff extends Person {
    private String employeeId;

    public BankStaff(String name, String address, String employeeId) {
        super(name, address);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
