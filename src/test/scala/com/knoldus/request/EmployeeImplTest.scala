package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Shubham:Employee = new Employee("Shubham","sharma",22,15000,"Intern","Knoldus","Shubham.sharma@gmail.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Shubham)) thenReturn(true)
    val result = userImpl.createEmployee(Shubham)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Shubham)) thenReturn(false)
    val result = userImpl.createEmployee(Shubham)
    assert(result.isEmpty)
  }
}