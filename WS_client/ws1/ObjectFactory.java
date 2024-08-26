
package ws1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws1 package. 
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

    private final static QName _GreatestNumberResponse_QNAME = new QName("http://WS_Number/", "greatestNumberResponse");
    private final static QName _GetNumberResponse_QNAME = new QName("http://WS_Number/", "getNumberResponse");
    private final static QName _GetNumber_QNAME = new QName("http://WS_Number/", "getNumber");
    private final static QName _GreatestNumber_QNAME = new QName("http://WS_Number/", "greatestNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNumber }
     * 
     */
    public GetNumber createGetNumber() {
        return new GetNumber();
    }

    /**
     * Create an instance of {@link GreatestNumber }
     * 
     */
    public GreatestNumber createGreatestNumber() {
        return new GreatestNumber();
    }

    /**
     * Create an instance of {@link GetNumberResponse }
     * 
     */
    public GetNumberResponse createGetNumberResponse() {
        return new GetNumberResponse();
    }

    /**
     * Create an instance of {@link GreatestNumberResponse }
     * 
     */
    public GreatestNumberResponse createGreatestNumberResponse() {
        return new GreatestNumberResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreatestNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS_Number/", name = "greatestNumberResponse")
    public JAXBElement<GreatestNumberResponse> createGreatestNumberResponse(GreatestNumberResponse value) {
        return new JAXBElement<GreatestNumberResponse>(_GreatestNumberResponse_QNAME, GreatestNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS_Number/", name = "getNumberResponse")
    public JAXBElement<GetNumberResponse> createGetNumberResponse(GetNumberResponse value) {
        return new JAXBElement<GetNumberResponse>(_GetNumberResponse_QNAME, GetNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS_Number/", name = "getNumber")
    public JAXBElement<GetNumber> createGetNumber(GetNumber value) {
        return new JAXBElement<GetNumber>(_GetNumber_QNAME, GetNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreatestNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS_Number/", name = "greatestNumber")
    public JAXBElement<GreatestNumber> createGreatestNumber(GreatestNumber value) {
        return new JAXBElement<GreatestNumber>(_GreatestNumber_QNAME, GreatestNumber.class, null, value);
    }

}
