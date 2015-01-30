/**
 * 24/February/2010 Persistence Completed.
 * 26/January/2010 Class Created.
 */

package employees;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@MappedSuperclass
public abstract class Employee implements Serializable {
	
	//Declare Variables
	private static final long serialVersionUID = 1L;
	private long ID;
	private String employeeName;
	private double hourlyRate, hoursWorked, wage;
	
	//Default Constructor
	public Employee() {}
	
	//Constructor that takes arguments
	public Employee (String fname, String sname, double hrr) {
		
		this.setEmployeeName(fname + " " + sname);
		this.setHourlyRate(hrr);
	}

	//Set Employee ID method
	public void setID (long ID) {
		
		this.ID = ID;
	}

	//Get Employee ID method
	@Id
	@GeneratedValue
	public long getID() {
		
		return ID;
	}

	//Set Employee Name method
	public void setEmployeeName (String employeeName) {
		
		this.employeeName = employeeName;
	}

	//Get Employee Name method
	@Column
	public String getEmployeeName() {
		
		return employeeName;
	}
	
	//Set Hourly Rate method
	public void setHourlyRate (double hourlyRate) {
		
		this.hourlyRate = hourlyRate;
	}
	
	//Get Hourly Rate method
	@Column
	public double getHourlyRate() {
		
		return hourlyRate;
	}

	//Set Hours Worked method
	public void setHoursWorked (double hoursWorked) {
		
		this.hoursWorked = hoursWorked;
	}

	//Get Hours Worked method
	@Transient
	public double getHoursWorked() {
		
		return hoursWorked;
	}

	//Get Wage method
	@Transient
	public double getWage() {
		
		return wage;
	}
	
	//Calculate Wage method
	public double calculateWage() {
		
		return hourlyRate * hoursWorked;
	}
	
	//To String method
        @Override
	public String toString() {
		
		return ID + " " + employeeName;
	}
}
