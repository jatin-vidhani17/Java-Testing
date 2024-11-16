package PayslipGenerator;
import java.io.*;


public class Payslip {
    public void generatePayslip(Employee emp) {
        double basic = emp.getBasicSalary();
        double hra = 0;
        double da = 0;

        
        if (basic <= 5000) {
            hra = 0.05 * basic;
            da = 0.03 * basic;
        } else if (basic >= 15000) {
            hra = 0.075 * basic;
            da = 0.05 * basic;
        } else {
            hra = 0.10 * basic;
            da = 0.08 * basic;
        }

        double netPay = basic + hra + da;

        
        String payslip = "Payslip for Employee: " + emp.getEmpName() + "\n";
        payslip += "Employee No: " + emp.getEmpNo() + "\n";
        payslip += "Designation: " + emp.getEmpDes() + "\n";
        payslip += "Basic Salary: " + basic + "\n";
        payslip += "HRA: " + hra + "\n";
        payslip += "DA: " + da + "\n";
        payslip += "Net Pay: " + netPay + "\n";

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(emp.getEmpNo() + "_payslip.txt"))) {
            writer.write(payslip);
            System.out.println("Payslip generated for " + emp.getEmpName() + " in file " + emp.getEmpNo() + "_payslip.txt");
        } catch (IOException e) {
            System.out.println("Error writing payslip to file.");
        }
    }
}

