
package ru.parsertest.application.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
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
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://parsetest.ru}par_list"/>
 *       &lt;/sequence>
 *       &lt;attribute name="step" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fullname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isEditable" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isScanable" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isVisible" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isRequired" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isPrinted" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isValidateOnLine" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="min_length" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="max_length" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="double_input" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reg_exp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from_debt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "par", namespace = "http://parsetest.ru")
public class Par {

    @XmlElementRef(name = "par_list", namespace = "http://parsetest.ru", type = ParList.class, required = false)
    protected List<ParList> content;
    @XmlAttribute(name = "step")
    protected String step;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "fullname")
    protected String fullname;
    @XmlAttribute(name = "comment")
    protected String comment;
    @XmlAttribute(name = "isEditable")
    protected String isEditable;
    @XmlAttribute(name = "isScanable")
    protected String isScanable;
    @XmlAttribute(name = "isVisible")
    protected String isVisible;
    @XmlAttribute(name = "isRequired")
    protected String isRequired;
    @XmlAttribute(name = "isPrinted")
    protected String isPrinted;
    @XmlAttribute(name = "isValidateOnLine")
    protected String isValidateOnLine;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "min_length")
    protected String minLength;
    @XmlAttribute(name = "max_length")
    protected String maxLength;
    @XmlAttribute(name = "double_input")
    protected String doubleInput;
    @XmlAttribute(name = "value")
    protected String value;
    @XmlAttribute(name = "reg_exp")
    protected String regExp;
    @XmlAttribute(name = "from_debt")
    protected String fromDebt;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParList }
     * {@link String }
     * 
     * 
     */
    public List<ParList> getContent() {
        if (content == null) {
            content = new ArrayList<ParList>();
        }
        return this.content;
    }

    /**
     * Gets the value of the step property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStep(String value) {
        this.step = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the fullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the value of the fullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullname(String value) {
        this.fullname = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the isEditable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEditable() {
        return isEditable;
    }

    /**
     * Sets the value of the isEditable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEditable(String value) {
        this.isEditable = value;
    }

    /**
     * Gets the value of the isScanable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsScanable() {
        return isScanable;
    }

    /**
     * Sets the value of the isScanable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsScanable(String value) {
        this.isScanable = value;
    }

    /**
     * Gets the value of the isVisible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsVisible() {
        return isVisible;
    }

    /**
     * Sets the value of the isVisible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsVisible(String value) {
        this.isVisible = value;
    }

    /**
     * Gets the value of the isRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * Sets the value of the isRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRequired(String value) {
        this.isRequired = value;
    }

    /**
     * Gets the value of the isPrinted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsPrinted() {
        return isPrinted;
    }

    /**
     * Sets the value of the isPrinted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsPrinted(String value) {
        this.isPrinted = value;
    }

    /**
     * Gets the value of the isValidateOnLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsValidateOnLine() {
        return isValidateOnLine;
    }

    /**
     * Sets the value of the isValidateOnLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsValidateOnLine(String value) {
        this.isValidateOnLine = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the minLength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinLength(String value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxLength(String value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the doubleInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoubleInput() {
        return doubleInput;
    }

    /**
     * Sets the value of the doubleInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoubleInput(String value) {
        this.doubleInput = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the regExp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegExp() {
        return regExp;
    }

    /**
     * Sets the value of the regExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegExp(String value) {
        this.regExp = value;
    }

    /**
     * Gets the value of the fromDebt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromDebt() {
        return fromDebt;
    }

    /**
     * Sets the value of the fromDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDebt(String value) {
        this.fromDebt = value;
    }


    /**
     * converts fields to string
     *
     *     allowed object is
     *     {@link String }
     *
     */
    @Override
    public String toString() {
        return "Par{" +
                "content=" + content +
                ", step='" + step + '\'' +
                ", name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", comment='" + comment + '\'' +
                ", isEditable='" + isEditable + '\'' +
                ", isScanable='" + isScanable + '\'' +
                ", isVisible='" + isVisible + '\'' +
                ", isRequired='" + isRequired + '\'' +
                ", isPrinted='" + isPrinted + '\'' +
                ", isValidateOnLine='" + isValidateOnLine + '\'' +
                ", type='" + type + '\'' +
                ", minLength='" + minLength + '\'' +
                ", maxLength='" + maxLength + '\'' +
                ", doubleInput='" + doubleInput + '\'' +
                ", value='" + value + '\'' +
                ", regExp='" + regExp + '\'' +
                ", fromDebt='" + fromDebt + '\'' +
                '}';
    }

    /**
     * converts fields to map
     *
     * @return
     *     possible object is
     *     {@link Map }
     *
     */
    public Map<String, String> parToMap() {
        Map<String, String> parMap = new HashMap<>();
        parMap.put("step", step);
        parMap.put("name", name);
        parMap.put("fullname", fullname);
        parMap.put("comment", comment);
        parMap.put("isEditable", isEditable);
        parMap.put("isScanable", isScanable);
        parMap.put("isVisible", isVisible);
        parMap.put("isRequired", isRequired);
        parMap.put("isPrinted", isPrinted);
        parMap.put("isValidateOnLine", isValidateOnLine);
        parMap.put("type", type);
        parMap.put("minLength", minLength);
        parMap.put("maxLength", maxLength);
        parMap.put("doubleInput", doubleInput);
        parMap.put("value", value);
        parMap.put("regExp", regExp);
        parMap.put("fromDebt", fromDebt);
        return parMap;
    }
}
