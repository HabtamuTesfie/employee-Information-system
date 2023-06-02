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
package org.atlas.employee.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.atlas.employee.model.Employee;
import org.atlas.employee.repository.EmployeeRepository;

import java.net.URI;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;


//------------------------------------------------------------------------------
/**
 * Employee endpoint.
 *
 * @author Habtamu Tesfie
 */
//------------------------------------------------------------------------------
@Path("/data")
public class EmployeeEndPoint
{
  //------------------------------------------------------- Private data members
  @Inject
  private EmployeeRepository employeeRepository;

  //----------------------------------------------------------------------------
  /**
   * Expose single employee data.
   *
   * @param id employee id
   * @return employee data
   */
  //----------------------------------------------------------------------------
  @GET
  @Produces(APPLICATION_JSON)
  @Path("/employee/{id : \\d+}")
  public Response getEmployee(@PathParam("id") Long id)
  {
    Employee employee = employeeRepository.find(id);

    if (employee == null)
     return Response.status(Response.Status.NOT_FOUND).build();

    return Response.ok(employee).build();
  } // getEmployee


  //----------------------------------------------------------------------------
  /**
   * Expose single employee data.
   *
   * @param id employee id
   * @return employee data
   */
  //----------------------------------------------------------------------------
  @GET
  @Produces(APPLICATION_JSON)
  @Path("/employee")
  public Response getEmployeeFromQueryParam(@QueryParam("id") Long id)
  {
    Employee employee = employeeRepository.find(id);
    if (employee == null)
        return Response.status(Response.Status.NOT_FOUND).build();

    return Response.ok(employee).build();
  } // getEmployeeFromQueryParam



  //----------------------------------------------------------------------------
  /**
   * Post employee data.
   *
   * @param employee employee data
   * @return uri
   */
  //----------------------------------------------------------------------------
  @POST
  @Produces(APPLICATION_JSON)
  @Path("/employee")
  public Response createEmployee(Employee employee, @Context UriInfo uriInfo)
  {
    employee = employeeRepository.create(employee);
    URI uri = uriInfo.getBaseUriBuilder().path(employee.getId().toString()).build();

    return Response.created(uri).build();
  } // createEmployee


  //----------------------------------------------------------------------------
  /**
   * Delete employee data.
   *
   * @param id employee id
   *
   * @return no content found message
   */
  //----------------------------------------------------------------------------
  @DELETE
  @Path("/employee/{id : \\d+}")
  public Response deleteEmployee(@PathParam("id") Long id)
  {
    employeeRepository.delete(id);

    return Response.noContent().build();
  } // deleteEmployee


  //----------------------------------------------------------------------------
  /**
   * Delete employee data.
   *
   * @param id employee id
   *
   * @return no content found message
   */
  //----------------------------------------------------------------------------
  @DELETE
  @Path("/employee")
  public Response deleteEmployeeFromQueryParam(@QueryParam("id") Long id)
  {
      employeeRepository.delete(id);
      return Response.noContent().build();
  } // deleteEmployeeFromQueryParam


  //----------------------------------------------------------------------------
  /**
   * Expose all employees data.
   *
   * @return list of all employees
   */
  //----------------------------------------------------------------------------
  @GET
  @Produces(APPLICATION_JSON)
  @Path("/employees")
  public Response getEmployees()
  {
    List<Employee> employees =  employeeRepository.findAll();
    if (employees.size() == 0)
      return Response.noContent().build();

    return Response.ok(employees).build();
  } // getEmployees


  //----------------------------------------------------------------------------
  /**
   * Expose total number of employees.
   *
   * @return number of employees
   */
  //----------------------------------------------------------------------------
  @GET
  @Produces(APPLICATION_JSON)
  @Path("/count")
  public Response countEmployees()
  {
    Long noOfEmployees = employeeRepository.countAll();
    if (noOfEmployees == 0)
      return  Response.noContent().build();

    return Response.ok(noOfEmployees).build();
  } // countEmployees

} // EmployeeEndPoint
