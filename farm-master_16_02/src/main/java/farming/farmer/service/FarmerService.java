package farming.farmer.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import farming.accounting.entity.UserAccount;
import farming.farmer.dto.FarmerDto;
import farming.farmer.entity.Farmer;
import farming.products.entity.Product;
import farming.repo.FarmerRepositiry;
import farming.repo.ProductsRepository;

@Service
public class FarmerService implements IFarmerService{
	
	@Autowired
	FarmerRepositiry farmerRepo;
	@Autowired
	ProductsRepository productRepo;

	@Override
	public FarmerDto getFarmer(Long farmerId) {
//		return farmerRepo.findById(farmerId).map(FarmerDto::).orElseThrow(() ->
//		new ResponseStatusException(HttpStatus.NOT_FOUND, "Farmer not found"));
		return null;
	}

	@Override
	public Set<FarmerDto> getFarmersByProduct(Long productId) {
//		Product product = productRepo.findById(productId).orElseThrow(() ->
//		new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
//		return product.getFarmers().stream().map(Farmer::build).collect(Collectors.toSet());
		return null;
	}

	@Override
	public List<FarmerDto> getAllFarmers() {
//		return farmerRepo.findAll().stream().map(Farmer::build).collect(Collectors.toList());
		return null;
	}

	public void createFarmerProfile(UserAccount user) {
		// TODO Auto-generated method stub
		
	}

}
