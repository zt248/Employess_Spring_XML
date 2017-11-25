package dao;


import model.EmplDepa;

import java.util.List;

public interface EmplDepaDao {

    //create
    void add(EmplDepa emplDepa);

    //read
    List<EmplDepa> getAll();

    EmplDepa getByEmployeeIdAndDepartmentId(Long employeeId, Long departmentId);

    //update
    void update(EmplDepa emplDepa);

    //delete

    void remove(EmplDepa emplDepa);
}
