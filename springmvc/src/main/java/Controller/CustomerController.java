package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DataAccessobject.CustomerDAO;
import Entity.Customer;
import Service.CustomerService;
import Validator.CustomValidator;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomValidator customvalidator;

	@RequestMapping("/list")
	public String listCustomers(Model themodel) {

		List<Customer> customers = customerService.getCustomers();

		themodel.addAttribute("customers", customers);

		return "list-customers";

	}

	@RequestMapping(value = "/ShowFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {

		Customer customer = new Customer();

		theModel.addAttribute("customer", customer);
		return "customer-form";

	}

	@RequestMapping(value = "savecustomer", method = RequestMethod.POST)
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult br) {

		customvalidator.validate(customer, br);
		if (br.hasErrors()) {
			return "customer-form";
		}
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";

	}

	@RequestMapping(value = "showformForUpdate", method = RequestMethod.GET)
	public String showformForUpdate(@RequestParam("customerId") int id, Model model) {

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		return "customer-form";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String showFormForDelete(@RequestParam("customerId") int id, Model model) {

		customerService.deleteCustomer(id);

		return "redirect:/customer/list";

	}

	@RequestMapping(value = "ShowFormForSearch", method = RequestMethod.GET)
	public String showFormForSearch(@RequestParam("freetext") String search, Model m) {

		List<Customer> allFound = customerService.searchList(search);
		List<Customer> Found = new ArrayList<>();

		for (Customer c : allFound) {
			Customer cust = new Customer();
			cust.setId(c.getId());
			cust.setFirstname(c.getFirstname());
			cust.setLastname(c.getLastname());
			cust.setEmail(c.getEmail());

			Found.add(cust);

		}
		m.addAttribute("found", Found);
		
		return "list-customersOne";
	}

}
