package service;

import model.Address;

import javax.sql.DataSource;
import java.util.List;

public interface AddressService {

    //create
    void add(Address address);

    //read
    List<Address> getAll();

    Address getById(Long id);

    //update
    void update(Address address);

    //delete

    void remove(Address address);
}
