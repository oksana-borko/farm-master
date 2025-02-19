package farming.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farming.products.entity.Product;
import farming.products.entity.SaleRecords;

@Repository
public interface SaleRecordsRepository extends JpaRepository<SaleRecords, Long>{

	List<SaleRecords> findByProduct(Product product);

}
