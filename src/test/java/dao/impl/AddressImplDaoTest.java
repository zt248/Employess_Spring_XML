package dao.impl;

import model.Address;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class AddressImplDaoTest {


    @Autowired
    private AddressImplDao addressImplDao;

    @Autowired
    public void setAddressImplDao(AddressImplDao addressImplDao) {
        this.addressImplDao = addressImplDao;
    }

    @Test
    public void add() throws Exception {
        Address address = new Address(99L, "Test", "Test", "Test", "Test");
            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
    }

    @Test
    public void getAll() throws Exception {
        Address address = new Address(99L, "Test", "Test", "Test", "Test");
            addressImplDao.add(address);
            List<Address> list = addressImplDao.getAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
            addressImplDao.remove(address);
    }

    @Test
    public void getById() throws Exception {
        Address address = new Address(99L, "Test", "Test", "Test", "Test");

            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
    }

    @Test
    public void update() throws Exception {
        Address address = new Address(99L, "Test", "Test", "Test", "Test");

            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            address.setCity("New City");
            address.setCountry("New Country");
            address.setStreet("new Street");
            address.setPostCode("new PostCode");
            addressImplDao.update(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
    }

    @Test
    public void remove() throws Exception {
        Address address = new Address(99L, "Test", "Test", "Test", "Test");
        addressImplDao.add(address);
        Assert.assertNotNull(addressImplDao.getById(address.getId()).getId());
        addressImplDao.remove(address);
        try {
            Assert.assertNull(addressImplDao.getById(address.getId()).getId());
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }

    }

}