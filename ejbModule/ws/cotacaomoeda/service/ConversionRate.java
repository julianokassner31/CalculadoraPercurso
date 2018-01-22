
package ws.cotacaomoeda.service;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="FromCurrency" type="{http://www.webserviceX.NET/}Currency"/>
 *         &lt;element name="ToCurrency" type="{http://www.webserviceX.NET/}Currency"/>
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
    "fromCurrency",
    "toCurrency"
})
@XmlRootElement(name = "ConversionRate")
public class ConversionRate {

    @XmlElement(name = "FromCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected Currency fromCurrency;
    @XmlElement(name = "ToCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected Currency toCurrency;

    /**
     * Obtém o valor da propriedade fromCurrency.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getFromCurrency() {
        return fromCurrency;
    }

    /**
     * Define o valor da propriedade fromCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setFromCurrency(Currency value) {
        this.fromCurrency = value;
    }

    /**
     * Obtém o valor da propriedade toCurrency.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getToCurrency() {
        return toCurrency;
    }

    /**
     * Define o valor da propriedade toCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setToCurrency(Currency value) {
        this.toCurrency = value;
    }

}
