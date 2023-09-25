package net.crud.springartifact.repository;

import net.crud.springartifact.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all CRUD database methods

}
