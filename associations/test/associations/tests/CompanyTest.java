/**
 * 
 */
package associations.tests;

import models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import models.Company;

/**
 * @author journault
 *
 */
public class CompanyTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "company";
	private EntityManagerFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		em.getTransaction().begin();

		// read the existing entries
		Query q = em.createQuery("select aGoodCompany FROM Company aGoodCompany");
		// Company should be empty

		// do we have entries?
		boolean createNewCompany = (q.getResultList().size() == 0);

		// No, so lets create new entries
		if (createNewCompany) {
			assertTrue(q.getResultList().size() == 0);
			Company aGoodCompany = new Company();
			aGoodCompany.setName("The Shamrock");
			//We add an employee on it
			Employee micka = new Employee("Michakel", "Carcelopez", "21", aGoodCompany);
			aGoodCompany.addEmployee(micka);
			em.persist(aGoodCompany);
			em.persist(micka);

		}

		// Commit the transaction, which will cause the entity to
		// be stored in the database
		em.getTransaction().commit();

		// It is always good practice to close the EntityManager so that
		// resources are conserved.
		em.close();

	}

	@Test
	public void checkBeforeOk() {
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select aGoodCompany from Company aGoodCompany");
		assertTrue(q.getResultList().size() == 1);
		em.close();
	}

	@Test
	public void checkAddEmployee() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query q1 = em.createQuery("select aGoodCompany from Company aGoodCompany where aGoodCompany.name = :name").setParameter("name", "The Shamrock");
		Company aGoodCompany = ((Company) q1.getSingleResult());
		Employee brice = new Employee("Brice", "LeWeeb", "42", aGoodCompany );
		aGoodCompany.addEmployee(brice);
		em.persist(brice);
		em.persist(aGoodCompany);
		em.getTransaction().commit();

		Query q2 = em.createQuery("select aGoodCompany from Company aGoodCompany where aGoodCompany.name = :name").setParameter("name", "The Shamrock");
		assertTrue(((Company) q2.getSingleResult()).getEmployees().size() == 2);
		em.close();
	}

}
