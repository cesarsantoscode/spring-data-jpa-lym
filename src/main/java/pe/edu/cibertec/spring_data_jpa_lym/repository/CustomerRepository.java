package pe.edu.cibertec.spring_data_jpa_lym.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.spring_data_jpa_lym.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
