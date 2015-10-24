
package ru.t_task.java_web_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itemWord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemWord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="textBlockCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="word" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemWord", propOrder = {
    "textBlockCount",
    "word"
})
public class ItemWord {

    protected int textBlockCount;
    protected String word;

    /**
     * Gets the value of the textBlockCount property.
     * 
     */
    public int getTextBlockCount() {
        return textBlockCount;
    }

    /**
     * Sets the value of the textBlockCount property.
     * 
     */
    public void setTextBlockCount(int value) {
        this.textBlockCount = value;
    }

    /**
     * Gets the value of the word property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the value of the word property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWord(String value) {
        this.word = value;
    }

}
