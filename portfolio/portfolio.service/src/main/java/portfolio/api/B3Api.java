package portfolio.api;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import portfolio.service.B3Service;

/**
 * Class marked as a RestController to serve as an API that handles and responds
 * to JSON-type requests
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@RestController
@RequestMapping(value = "/api/b3")
public class B3Api {

	@Autowired
	private B3Service b3PriceService;

	/**
	 * Returns the complete data of a Brazilian exchange (B3) asset in Json format
	 * 
	 * @param ticker - Brazilian exchange symbol (Ticker), not blank
	 * @return complete data of an asset in Json format or HTTP not found
	 */
	@GetMapping(value = "/data/{ticker}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getFromExternalApiDataOf(@PathVariable String ticker) {
		Optional<String> result = b3PriceService.getFromExternalApiDataOf(ticker);
		if (!result.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result.get());
	}

	/**
	 * Returns the last closing price of an asset
	 * 
	 * @param ticker - Brazilian exchange symbol (Ticker), not blank
	 * @return last closing price in BigDecimal format
	 */
	@GetMapping(value = "/last/{ticker}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BigDecimal getFromExternalApiLastPriceOf(@PathVariable String ticker) {
		return b3PriceService.getFromExternalApiLastPriceOf(ticker);
	}

}
