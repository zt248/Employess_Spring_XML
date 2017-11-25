package dao;


import model.Address;
import model.Employee;
import java.util.List;

public interface EmployeeDao {

    //create
    void add(Employee employee);

    //read
    List<Employee> getAll();

    Employee getById(Long id);

    //update
    void update(Employee employee);

    //delete

    void remove(Employee employee);

}
