package farming.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farming.products.entity.Product;
@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>{

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	Optional<Product> findByPriceBetweenAndId(double minPrice, double maxPrice, Long productId);

	Optional<Product> findSoldProductByFarmerId(Long farmerId);

	Optional<Product> findRemovedProductsByFarmerId(Long farmerId);

}
