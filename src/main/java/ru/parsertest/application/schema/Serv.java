
package ru.parsertest.application.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serv_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bic" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="schet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="corr_schet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://parsetest.ru}pars"/>
 *         &lt;element name="sys_message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isClosed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "servId",
    "bic",
    "schet",
    "corrSchet",
    "pars",
    "sysMessage"
})
@XmlRootElement(name = "serv", namespace = "http://parsetest.ru")
public class Serv {

    @XmlElement(name = "serv_id", namespace = "http://parsetest.ru", required = true)
    protected String servId;
    @XmlElement(namespace = "http://parsetest.ru")
    protected long bic;
    @XmlElement(namespace = "http://parsetest.ru", required = true)
    protected String schet;
    @XmlElement(name = "corr_schet", namespace = "http://parsetest.ru", required = true)
    protected String corrSchet;
    @XmlElement(namespace = "http://parsetest.ru", required = true)
    protected Pars pars;
    @XmlElement(name = "sys_message", namespace = "http://parsetest.ru", required = true)
    protected String sysMessage;
    @XmlAttribute(name = "isClosed", required = true)
    protected boolean isClosed;

    /**
     * Gets the value of the servId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServId() {
        return servId;
    }

    /**
     * Sets the value of the servId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServId(String value) {
        this.servId = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     */
    public long getBic() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     */
    public void setBic(long value) {
        this.bic = value;
    }

    /**
     * Gets the value of the schet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchet() {
        return schet;
    }

    /**
     * Sets the value of the schet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchet(String value) {
        this.schet = value;
    }

    /**
     * Gets the value of the corrSchet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrSchet() {
        return corrSchet;
    }

    /**
     * Sets the value of the corrSchet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrSchet(String value) {
        this.corrSchet = value;
    }

    /**
     * Gets the value of the pars property.
     * 
     * @return
     *     possible object is
     *     {@link Pars }
     *     
     */
    public Pars getPars() {
        return pars;
    }

    /**
     * Sets the value of the pars property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pars }
     *     
     */
    public void setPars(Pars value) {
        this.pars = value;
    }

    /**
     * Gets the value of the sysMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysMessage() {
        return sysMessage;
    }

    /**
     * Sets the value of the sysMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysMessage(String value) {
        this.sysMessage = value;
    }

    /**
     * Gets the value of the isClosed property.
     * 
     */
    public boolean isIsClosed() {
        return isClosed;
    }

    /**
     * Sets the value of the isClosed property.
     * 
     */
    public void setIsClosed(boolean value) {
        this.isClosed = value;
    }

}
