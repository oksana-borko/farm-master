package telran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import farming.entity.Farmer;

public interface FarmerRepositiry extends JpaRepository<Farmer, Long>{

}
