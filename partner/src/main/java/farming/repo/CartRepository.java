package farming.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import farming.cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
