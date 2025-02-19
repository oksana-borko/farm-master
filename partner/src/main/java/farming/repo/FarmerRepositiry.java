package farming.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farming.farmer.entity.Farmer;
@Repository
public interface FarmerRepositiry extends JpaRepository<Farmer, Long>{

}
