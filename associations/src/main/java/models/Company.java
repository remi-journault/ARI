/**
 * 
 */
package models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author journault
 *
 */
@Entity
public class Company {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy="company")
    private Collection<Employee> employees;
    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Company [name=" + name + "]";
	}

	/**
	 * @return the employees
	 */
	public Collection<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	
	/**
	 * @param employee the employee to add
	 */
	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

}
