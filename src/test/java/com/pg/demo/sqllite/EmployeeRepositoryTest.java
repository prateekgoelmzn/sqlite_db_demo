package com.pg.demo.sqllite;

import com.pg.demo.sqllite.dao.EmployeeDao;
import com.pg.demo.sqllite.dao.EmployeeDaoImpl;
import com.pg.demo.sqllite.entity.Employee;
import com.pg.demo.sqllite.repository.EmployeeRepo;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({EmployeeDaoImpl.class})
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepo empRepo;

    @Autowired
    EmployeeDao empDao;

    @Test
    public void testEmployeeSave(){
        Employee emp = new Employee("Hritik",23,"coforge");
        Employee persistedEmp =  empRepo.save(emp);
        assertThat(persistedEmp.getId()).isNotNull();
    }

    @Test
    public void testSaveEmplDao(){
        Employee emp = new Employee("Pratiksha",23,"coforge");
        Employee persistedEmployee = empDao.saveEmployee(emp);
        assertThat(persistedEmployee).isNotNull();
    }

    @Test
    public void testFindEmplDao(){
        Employee fetchedEmployee = empDao.findEmpById(4L);
        assertThat(fetchedEmployee).isNotNull();
        assertThat(fetchedEmployee.getId()).isNotNull();
    }
}
