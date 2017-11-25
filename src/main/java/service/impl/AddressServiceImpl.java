package service.impl;

import dao.AddressDao;
import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AddressService;

import java.util.List;

@Service(value = "employeeServiceImpl")
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void add(Address address) {
        this.addressDao.add(address);
    }

    @Override
    public List<Address> getAll() {
        return this.addressDao.getAll();
    }

    @Override
    public Address getById(Long id) {
        return this.addressDao.getById(id);
    }

    @Override
    public void update(Address address) {
        this.addressDao.update(address);
    }

    @Override
    public void remove(Address address) {
        this.addressDao.remove(address);
    }
}
