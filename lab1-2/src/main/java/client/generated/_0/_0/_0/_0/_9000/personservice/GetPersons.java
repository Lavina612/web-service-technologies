
package _0._0._0._0._9000.personservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPersons complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPersons">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maleParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ageParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positionParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersons", propOrder = {
    "idParam",
    "nameParam",
    "maleParam",
    "ageParam",
    "positionParam"
})
public class GetPersons {

    protected String idParam;
    protected String nameParam;
    protected String maleParam;
    protected String ageParam;
    protected String positionParam;

    /**
     * Gets the value of the idParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdParam() {
        return idParam;
    }

    /**
     * Sets the value of the idParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdParam(String value) {
        this.idParam = value;
    }

    /**
     * Gets the value of the nameParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameParam() {
        return nameParam;
    }

    /**
     * Sets the value of the nameParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameParam(String value) {
        this.nameParam = value;
    }

    /**
     * Gets the value of the maleParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaleParam() {
        return maleParam;
    }

    /**
     * Sets the value of the maleParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaleParam(String value) {
        this.maleParam = value;
    }

    /**
     * Gets the value of the ageParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeParam() {
        return ageParam;
    }

    /**
     * Sets the value of the ageParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeParam(String value) {
        this.ageParam = value;
    }

    /**
     * Gets the value of the positionParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositionParam() {
        return positionParam;
    }

    /**
     * Sets the value of the positionParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositionParam(String value) {
        this.positionParam = value;
    }

}
