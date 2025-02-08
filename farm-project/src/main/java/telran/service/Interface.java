package telran.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import telran.dto.CustomerDto;
import telran.dto.FarmerDto;
import telran.dto.ProductDto;
import telran.dto.RemoveProductDataDto;
import telran.dto.SaleRecordsDto;

public interface Interface {


    Optional<CustomerDto> register(CustomerDto user);

    Optional<CustomerDto> login(String login, String hash);

    Optional<String> updatePassword(String hash, String newPassword);

    Optional<CustomerDto> updateAccount(CustomerDto userDto);
    
    CustomerDto updateUserRole(int userId, String role);
    
    CustomerDto blockAccount(int userId);


    boolean addProduct(ProductDto product);
	boolean updateProduct(ProductDto product);
	RemoveProductDataDto removeProduct(String productName);
	
	ProductDto getProduct(String productName);
	FarmerDto getFarmer(Long farmerId);
	Set<ProductDto> getProductsByFarmer(Long farmerId);
	Set<FarmerDto> getFarmersByProduct(String productName);
	Set<ProductDto> getProductsByPriceRange(double minPrice, double maxPrice, String productName);
	List<FarmerDto> getAllFarmers();
	List<ProductDto> getAllProducts();
	
	List<SaleRecordsDto> buyProduct(Long customerId, String productName, int quantity);
	List<SaleRecordsDto> getSoldProducts(Long farmerId);
	List<SaleRecordsDto> getPurchasedProducts(Long customerId);
	List<RemoveProductDataDto> getHistoryOfRemovedProducts(Long farmerId);

}

