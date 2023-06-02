//------------------------------------------------------------------------------
/* Application Name: Join atlas - Employee-Information-System.
 * Date Created: 08/02/2023
 * Compiler: Java
 *
 * Restrictions: None
 * Dependencies: See import statements
 *
 * Change History:
 * Date            Programmer      Description/Comments/DefectID
 */
//------------------------------------------------------------------------------
package org.atlas.employee.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.atlas.employee.model.Employee;
import org.atlas.employee.util.PhoneValidation;
import org.atlas.employee.util.TextUtil;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;


//------------------------------------------------------------------------------
/**
 * Employee repository.
 *
 * @author Habtamu Tesfie
 */
//------------------------------------------------------------------------------
@Transactional(SUPPORTS)
public class EmployeeRepository
{
  //------------------------------------------------------- Private data members
  @Inject
  private TextUtil textUtil;

  @Inject
  private PhoneValidation phoneValidation;
  
  @PersistenceContext(unitName = "Employee")
  private EntityManager em;

//----------------------------------------------------------------------------
/**
 * Find unique employee from database.
 *
 * @param id employee id
 * @return employee object
 */
//----------------------------------------------------------------------------
  public Employee find(@NotNull Long id)
  {
    return em.find(Employee.class, id);
  } // find


  //----------------------------------------------------------------------------
  /**
   * Persist employee to database.
   *
   * @param employee employee data
   * @return employee object
   */
  //----------------------------------------------------------------------------
  @Transactional(REQUIRED)
  public Employee create(@NotNull Employee employee)
  {
    employee.setFirstName(textUtil.sanitize(employee.getFirstName()));
    employee.setLastName(textUtil.sanitize(employee.getLastName()));

    em.persist(employee);

    return employee;
  } // create



  //----------------------------------------------------------------------------
  /**
   * Remove employee from database.
   *
   * @param id employee id
   */
  //----------------------------------------------------------------------------
  @Transactional(REQUIRED)
  public void delete(@NotNull Long id)
  {
    em.remove(em.getReference(Employee.class, id));
  } // delete



  //----------------------------------------------------------------------------
  /**
   * Get all employees from database.
   */
  //----------------------------------------------------------------------------
  public List<Employee> findAll()
  {
    TypedQuery<Employee> query =
      em.createQuery("SELECT e from Employee e order by e.firstName", Employee.class);

   return query.getResultList();
  } // findAll



  //----------------------------------------------------------------------------
  /**
   * Count number of employees from database.
   */
  //----------------------------------------------------------------------------
  public long countAll()
  {
    TypedQuery<Long> query =
      em.createQuery("select count(e) from Employee e", Long.class);

    return  query.getSingleResult();
  } // countAll

} //EmployeeRepository
