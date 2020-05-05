
package ru.parsertest.application.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://parsetest.ru}serv"/>
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
    "serv"
})
@XmlRootElement(name = "services", namespace = "http://parsetest.ru")
public class Services {

    @XmlElement(namespace = "http://parsetest.ru", required = true)
    protected Serv serv;

    /**
     * Gets the value of the serv property.
     * 
     * @return
     *     possible object is
     *     {@link Serv }
     *     
     */
    public Serv getServ() {
        return serv;
    }

    /**
     * Sets the value of the serv property.
     * 
     * @param value
     *     allowed object is
     *     {@link Serv }
     *     
     */
    public void setServ(Serv value) {
        this.serv = value;
    }

}
