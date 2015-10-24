
package ru.t_task.java_web_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stringProcessing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stringProcessing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="text1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="text2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="text3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="text4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="text5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stringProcessing", propOrder = {
    "text1",
    "text2",
    "text3",
    "text4",
    "text5"
})
public class StringProcessing {

    protected String text1;
    protected String text2;
    protected String text3;
    protected String text4;
    protected String text5;

    /**
     * Gets the value of the text1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText1() {
        return text1;
    }

    /**
     * Sets the value of the text1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText1(String value) {
        this.text1 = value;
    }

    /**
     * Gets the value of the text2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText2() {
        return text2;
    }

    /**
     * Sets the value of the text2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText2(String value) {
        this.text2 = value;
    }

    /**
     * Gets the value of the text3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText3() {
        return text3;
    }

    /**
     * Sets the value of the text3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText3(String value) {
        this.text3 = value;
    }

    /**
     * Gets the value of the text4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText4() {
        return text4;
    }

    /**
     * Sets the value of the text4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText4(String value) {
        this.text4 = value;
    }

    /**
     * Gets the value of the text5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText5() {
        return text5;
    }

    /**
     * Sets the value of the text5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText5(String value) {
        this.text5 = value;
    }

}
