package org.atlas.employee;

import jakarta.inject.Inject;
import org.atlas.employee.model.Employee;
import org.atlas.employee.repository.EmployeeRepository;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;


@RunWith(Arquillian.class)
public class EmployeeRepositoryTest
{
    @Inject
    private EmployeeRepository repository;

//    @Deployment
//    public static Archive<?> createDeployementPackage()
//    {
//        return ShrinkWrap.create(JavaArchive.class)
//            .addClass(Employee.class)
//            .addClass(Gender.class)
//            .addClass(EmployeeRepository.class)
//            .addAsManifestResource("persistence.xml");
//    }

    @Ignore
    @Test
    public  void shouldTestCreateEmployee() throws NullPointerException
    {
        Employee emp = new Employee();

        emp.setId(1l);
        emp.setFirstName("habtamu");

        emp = repository.create(emp);

        assertNull(emp);
    }
}
