/**
 * 24/February/2010 Persistence Completed.
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
@Table (name = "SHOPEMPLOYEE")
public class ShopEmployee extends Employee implements Serializable {
	
	//Declare Variables
	private static final long serialVersionUID = 1L;
	private String loginPassword;
	
	//Default Constructor
	public ShopEmployee() {}
	
	//Constructor that takes arguments
	public ShopEmployee(String fname, String sname, double hrr, String password) {
		
		super(fname, sname, hrr);
		this.loginPassword = password;
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
	
	//Set Login Password method
	public void setLoginPassword (String loginPassword) {
		
		this.loginPassword = loginPassword;
	}

	//Get Login Password method
	@Column
	public String getLoginPassword() {
		
		return loginPassword;
	}

        //To String Override method
        @Override
	public String toString() {

		return super.toString() + " " + loginPassword;
	}
}
