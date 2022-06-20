package portfolio.application.controller.request;

import javax.validation.constraints.NotBlank;

import portfolio.domain.entity.b3.B3Asset;
import portfolio.domain.entity.b3.B3AssetType;

public class B3AssetCreateRequest {

	@NotBlank
	private String ticker;
	@NotBlank
	private String type;

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public B3Asset toB3Asset() {
		return B3AssetType.valueOf(type.toUpperCase()).getInstance(this.ticker);
	}

}
