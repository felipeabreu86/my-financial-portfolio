package portfolio.application.service.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) class to handle the conversion of data received
 * via Json and extract only the last closing price
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
public class LastPriceDto {

    /**
     * Last closing price of the asset
     */
    private BigDecimal vl_fechamento;

    /**
     * Getter for the last closing price of the asset
     * 
     * @return last closing price in BigDecimal format
     */
    public BigDecimal getVl_fechamento() {
	return vl_fechamento;
    }

    /**
     * Setter for the last closing price of the asset
     * 
     * @param vl_fechamento - last closing price in BigDecimal format
     */
    public void setVl_fechamento(BigDecimal vl_fechamento) {
	this.vl_fechamento = vl_fechamento;
    }

}
