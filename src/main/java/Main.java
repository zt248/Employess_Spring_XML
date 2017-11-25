import dao.impl.AddressImplDao;
import model.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.AddressServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        AddressImplDao addressImplDao = (AddressImplDao) context.getBean("addressImplDao");
//        AddressServiceImpl addressService = (AddressServiceImpl) context.getBean("employeeServiceImpl");

        Address address = new Address();
        address.setCountry("Belarus");
        address.setCity("Minsk");
        address.setStreet("Fogela 1E");
        address.setPostCode("222417");



//        addressImplDao.add(address);

//        System.out.println(addressImplDao.getById(1L));

//        addressImplDao.update(new Address(2L,"Russia","Moskow","Pushkina","567000"));

        List<Address> addressList = addressImplDao.getAll();
//        List<Address> addressList = addressService.getAll();

        for (Address address1:addressList) {
            System.out.println(address1);
        }
    }
}
