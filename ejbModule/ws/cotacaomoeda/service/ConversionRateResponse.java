
package ws.cotacaomoeda.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConversionRateResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "conversionRateResult"
})
@XmlRootElement(name = "ConversionRateResponse")
public class ConversionRateResponse {

    @XmlElement(name = "ConversionRateResult")
    protected double conversionRateResult;

    /**
     * Obtém o valor da propriedade conversionRateResult.
     * 
     */
    public double getConversionRateResult() {
        return conversionRateResult;
    }

    /**
     * Define o valor da propriedade conversionRateResult.
     * 
     */
    public void setConversionRateResult(double value) {
        this.conversionRateResult = value;
    }

}
