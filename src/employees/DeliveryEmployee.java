/**
 * 26/January/2009 Class Created.
 */

package employees;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "DELIVERYEMPLOYEE")
public class DeliveryEmployee extends Employee implements Serializable {

	//Declare Variables
	private static final long serialVersionUID = 1L;
	private String carRegistrationNumber;
	private int fuelCardNumber;
	
	//Default Constructor
	public DeliveryEmployee() {}
	
	//Constructor that takes arguments
	public DeliveryEmployee (String fname, String sname, double hrr, String carRegNum, int fcn) {
		
		super(fname, sname, hrr);
		this.setCarRegistrationNumber(carRegNum);
		this.setFuelCardNumber(fcn);
	}

	//Set Employee ID method
	@Override
	public void setID (long ID) {
		
		super.setID(ID);
	}

	//Get Employee ID method
	@Id
	@GeneratedValue
	@Override
	public long getID() {
		
		return super.getID();
	}

	//Set Employee Name method
	@Override
	public void setEmployeeName (String employeeName) {
		
		super.setEmployeeName(employeeName);
	}

	//Get Employee Name method
	@Column
	@Override
	public String getEmployeeName() {
		
		return super.getEmployeeName();
	}
	
	//Set Hourly Rate method
	@Override
	public void setHourlyRate (double hourlyRate) {
		
		super.setHourlyRate(hourlyRate);
	}
	
	//Get Hourly Rate method
	@Column
	@Override
	public double getHourlyRate() {
		
		return super.getHourlyRate();
	}
	
	//Set Car Registration Number method
	public void setCarRegistrationNumber (String carRegistrationNumber) {
		
		this.carRegistrationNumber = carRegistrationNumber;
	}

	//Get Car Registration Number method
	@Column
	public String getCarRegistrationNumber() {
		
		return carRegistrationNumber;
	}

	//Set Fuel Card Number method
	public void setFuelCardNumber (int fuelCardNumber) {
		
		this.fuelCardNumber = fuelCardNumber;
	}

	//Get Fuel Card Number
	@Column
	public int getFuelCardNumber() {
		
		return fuelCardNumber;
	}

        //To String Override method
        @Override
	public String toString() {

		return super.toString() + " " + carRegistrationNumber + " " + fuelCardNumber;
	}
}
