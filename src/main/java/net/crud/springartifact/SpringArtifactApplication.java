package net.crud.springartifact;

import net.crud.springartifact.model.Employee;
import net.crud.springartifact.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringArtifactApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringArtifactApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception{
		/*Employee emp = new Employee();
		emp.setFirstName("tarun");
		emp.setLastname("varma");
		emp.setEmailId("tarun@gmail.com");
		employeeRepository.save(emp);

		Employee emp1 = new Employee();
		emp1.setFirstName("arun");
		emp1.setLastname("varma");
		emp1.setEmailId("arun@gmail.com");
		employeeRepository.save(emp1);*/
	}
}
