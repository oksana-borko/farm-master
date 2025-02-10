package telran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import farming.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
