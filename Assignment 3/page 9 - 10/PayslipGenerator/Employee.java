package PayslipGenerator;

public class Employee {
    private String emp_no;
    private String emp_name;
    private double basic;
    private String des;

    
    public Employee(String emp_name, double basic, String des) throws InvalidBasicException {
        this.emp_no = "EMP" + (int)(Math.random() * 10000);  
        this.emp_name = emp_name;
        setBasicSalary(basic);  
        this.des = des;
    }

    
    public void setBasicSalary(double basic) throws InvalidBasicException {
        if (basic < 0) {
            throw new InvalidBasicException("Basic salary cannot be negative.");
        }
        this.basic = basic;
    }

    
    public double getBasicSalary() {
        return basic;
    }

   
    public String getEmpName() {
        return emp_name;
    }

  
    public String getEmpDes() {
        return des;
    }

  
    public String getEmpNo() {
        return emp_no;
    }
}
