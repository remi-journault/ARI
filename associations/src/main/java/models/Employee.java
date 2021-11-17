/**
 * 
 */
package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author journault
 *
 */
@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String age;
    
    @ManyToOne
    private Company company;
    
    public Employee() {}
    
	public Employee(String firstname, String lastname, String age, Company company) {
		firstname = this.firstname;
		lastname = this.lastname;
		age = this.age;
		company = this.company;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + "]";
	}
    
    

}
