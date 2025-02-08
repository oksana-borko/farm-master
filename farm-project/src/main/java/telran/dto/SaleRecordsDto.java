package telran.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SaleRecordsDto {

	private Long customerId;
	private Long farmerId;
	private LocalDateTime saleDate;
	int saleQuantity;
	double cost;
}
