package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DataAccessobject.CustomerDAO;
import Entity.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return customerDao.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		  
		customerDao.deleteCustomer(id);
		
	}

	@Override
	@Transactional
	public List<Customer> searchList(String search) {
		return customerDao.search(search);
	}




	
}
