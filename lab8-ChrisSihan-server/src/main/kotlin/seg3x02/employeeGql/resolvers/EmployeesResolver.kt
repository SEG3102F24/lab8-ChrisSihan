package seg3x02.employeeGql.resolvers

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.MutationMapping
import seg3x02.employeeGql.models.Employee
import seg3x02.employeeGql.services.EmployeeService

@Controller
class EmployeesResolver @Autowired constructor(
    private val employeeService: EmployeeService
) {

    @QueryMapping
    fun employees(): List<Employee> {
        return employeeService.getAllEmployees()
    }

    @QueryMapping
    fun employee(id: String): Employee? {
        return employeeService.getEmployeeById(id)
    }

    @MutationMapping
    fun addEmployee(name: String, dateOfBirth: String, city: String, salary: Double, gender: String, email: String): Employee {
        return employeeService.addEmployee(name, dateOfBirth, city, salary, gender, email)
    }
}
