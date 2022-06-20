package portfolio.application.service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import portfolio.application.service.dto.LastPriceDto;

/**
 * This class implements the service related to the Brazilian stock exchange
 * (B3), for example, fetching the data of a certain asset
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Service
public class B3Service {

    /**
     * Reference for the implementation of a Synchronous client to perform HTTP
     * requests
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Reference for the implementation of Json conversion service
     */
    @Autowired
    private JsonConverterService jsonConverterService;

    /**
     * URI to request B3's API resource, stored in the 'application.properties'
     * file. Need to update {ticker} parameter
     */
    @Value("${b3.api}")
    private String rawB3ApiUri;

    /**
     * Updates the {ticker} parameter with asset's Ticker and returns the URI to be
     * used in B3's API request
     * 
     * @param b3AssetTicker - Brazilian exchange symbol (Ticker), not null
     * @return B3's API URI
     */
    private String getB3AipUri(String b3AssetTicker) {
	Objects.nonNull(b3AssetTicker);
	return rawB3ApiUri.replace("{ticker}", b3AssetTicker.trim());
    }

    /**
     * Returns the complete data of a Brazilian exchange (B3) asset in String format
     * 
     * @param b3AssetTicker - Brazilian exchange symbol (Ticker), not null
     * @return Optional that may contain the queried data in String (Json) format or
     *         null if error or not found
     */
    public Optional<String> getFromExternalApiDataOf(String b3AssetTicker) {
	Objects.nonNull(b3AssetTicker);
	String resultJson = null;

	try {
	    resultJson = restTemplate.getForObject(getB3AipUri(b3AssetTicker), String.class);
	} catch (RestClientException e) {
	    e.printStackTrace();
	}

	return Optional.ofNullable(resultJson);
    }

    /**
     * Returns the last closing price of an asset. In case of error or asset not
     * found, the method returns zero in BigDecimal format
     * 
     * @param b3AssetTicker - Brazilian exchange symbol (Ticker), not null
     * @return last closing price in BigDecimal format
     */
    public BigDecimal getFromExternalApiLastPriceOf(String b3AssetTicker) {
	Objects.nonNull(b3AssetTicker);
	BigDecimal lastPrice = BigDecimal.ZERO;

	Optional<String> resultFromApi = getFromExternalApiDataOf(b3AssetTicker);

	if (resultFromApi.isPresent()) {
	    String json = resultFromApi.get();
	    try {
		LastPriceDto lastPriceDto = jsonConverterService.isArray(json)
			? jsonConverterService.readFirstValue(json, LastPriceDto[].class)
			: jsonConverterService.readValue(json, LastPriceDto.class);
		lastPrice = lastPriceDto != null ? lastPriceDto.getVl_fechamento() : BigDecimal.ZERO;
	    } catch (JsonProcessingException e) {
		e.printStackTrace();
	    }
	}

	return lastPrice;
    }

}
