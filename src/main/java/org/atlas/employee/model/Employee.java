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
package org.atlas.employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


//------------------------------------------------------------------------------
/**
 * Create employee entity object model.
 *
 * @author  Habtamu Tesfie
 */
//------------------------------------------------------------------------------
@Entity
@Table(name = "employee")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "birthDate")
    private String birthDate;
    @Column(name = "expectedSalary")
   // @Min(1)
    private  String expectedSalary;
    @Column(name = "phone")
    private  String phone;

    // ----------------------------------------------------------------- Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName)   { this.lastName = lastName;   }
    public void setEmail(String email)         { this.email = email;         }
    public void setGender(Gender gender)       { this.gender = gender;       }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public void setPhone(String phone)         { this.phone = phone;         }

    public void setExpectedSalary(String expectedSalary)
    {
        this.expectedSalary = expectedSalary;
    }


    // ----------------------------------------------------------------- Getters
    public String getFirstName()      { return firstName;      }
    public String getLastName()       { return lastName;       }
    public String getEmail()          { return email;          }
    public Gender getGender()         { return gender;         }
    public String getBirthDate()      { return birthDate;      }
    public String getExpectedSalary() { return expectedSalary; }
    public String getPhone()          { return phone;          }
    public Long getId()               { return id;             }
    public void setId(Long id)        { this.id = id;          }


    @Override
    public String toString()
    {
        return "Employee{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", gender=" + gender +
            ", birthDate=" + birthDate +
            ", expectedSalary='" + expectedSalary + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    } // toString

} // Employee
