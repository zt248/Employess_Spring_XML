package controller.adrress;

import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import service.AddressService;

@Controller
public class AddressController {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    //Чтение записей

    @RequestMapping(value = "/address/getListAddress", method = RequestMethod.GET)
    public String listAddress(Model model) {
        model.addAttribute("listAddress", this.addressService.getAll());
        return "views/address/addressListDisplay";
    }


    @RequestMapping(value = "/address/byIdAddress", method = RequestMethod.GET)
    public ModelAndView byIdAddress() {
        return new ModelAndView("views/address/byIdAddress", "command", new Address());
    }

    @RequestMapping(value = "/address/getByIdAddress", method = RequestMethod.POST)
    public String getByIdAddress(@ModelAttribute("address") Address address, Model model) {
        model.addAttribute("id", this.addressService.getById(address.getId()).getId());
        model.addAttribute("country", this.addressService.getById(address.getId()).getCountry());
        model.addAttribute("city", this.addressService.getById(address.getId()).getCity());
        model.addAttribute("street", this.addressService.getById(address.getId()).getStreet());
        model.addAttribute("postCode", this.addressService.getById(address.getId()).getPostCode());
        return "views/address/getByIdAddress";
    }

    //Добавление записи
    @RequestMapping(value = "/address/newAddress", method = RequestMethod.GET)
    public ModelAndView newAddress() {
        return new ModelAndView("views/address/newAddress", "command", new Address());
    }

    @RequestMapping(value = "/address/addAddress", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute("address") Address address, Model model) {
        model.addAttribute("country", address.getCountry());
        model.addAttribute("city", address.getCity());
        model.addAttribute("street", address.getStreet());
        model.addAttribute("postCode", address.getPostCode());
        this.addressService.add(address);
        return "redirect:/address/getListAddress";
    }

    //Редактирование записи
    @RequestMapping(value = "/address/updateAddress", method = RequestMethod.GET)
    public ModelAndView updateAddress(){
        return new ModelAndView("/views/address/updateAddress","command", new Address());
    }

    @RequestMapping(value = "/address/getUpdateAddress", method = RequestMethod.POST)
    public String getUpdateAddress(@ModelAttribute("address") Address address, Model model){
        model.addAttribute("id",address.getId());
        model.addAttribute("country", address.getCountry());
        model.addAttribute("city", address.getCity());
        model.addAttribute("street", address.getStreet());
        model.addAttribute("postCode", address.getPostCode());
        this.addressService.update(address);
        return "redirect:/address/getListAddress";
    }

    //Удаление записи
    @RequestMapping(value = "/address/deleteByIdAddress", method = RequestMethod.GET)
    public ModelAndView deleteByIdAddress() {
        return new ModelAndView("views/address/deleteByIdAddress", "command", new Address());
    }

    @RequestMapping(value = "/address/removeByIdAddress", method = RequestMethod.POST)
    public String removeByIdAddress(@ModelAttribute("address") Address address, Model model) {
        model.addAttribute("id", address.getId());
        this.addressService.remove(address);
        return "redirect:/address/getListAddress";
    }


    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        Address address = new Address();
        address.setId(id);
        this.addressService.remove(address);
        return "redirect:/address/getListAddress";
    }
}
