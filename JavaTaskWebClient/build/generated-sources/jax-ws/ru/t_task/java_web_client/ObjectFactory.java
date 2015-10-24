
package ru.t_task.java_web_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.t_task.java_web_client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StringProcessing_QNAME = new QName("http://java_web_services.t_task.ru/", "stringProcessing");
    private final static QName _StringProcessingResponse_QNAME = new QName("http://java_web_services.t_task.ru/", "stringProcessingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.t_task.java_web_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StringProcessingResponse }
     * 
     */
    public StringProcessingResponse createStringProcessingResponse() {
        return new StringProcessingResponse();
    }

    /**
     * Create an instance of {@link StringProcessing }
     * 
     */
    public StringProcessing createStringProcessing() {
        return new StringProcessing();
    }

    /**
     * Create an instance of {@link ItemWord }
     * 
     */
    public ItemWord createItemWord() {
        return new ItemWord();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringProcessing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://java_web_services.t_task.ru/", name = "stringProcessing")
    public JAXBElement<StringProcessing> createStringProcessing(StringProcessing value) {
        return new JAXBElement<StringProcessing>(_StringProcessing_QNAME, StringProcessing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringProcessingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://java_web_services.t_task.ru/", name = "stringProcessingResponse")
    public JAXBElement<StringProcessingResponse> createStringProcessingResponse(StringProcessingResponse value) {
        return new JAXBElement<StringProcessingResponse>(_StringProcessingResponse_QNAME, StringProcessingResponse.class, null, value);
    }

}
