
package _0._0._0._0._9030.personservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ParamTypeException", targetNamespace = "http://0.0.0.0:9030/PersonService")
public class ParamTypeException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ParamTypeFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ParamTypeException(String message, ParamTypeFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ParamTypeException(String message, ParamTypeFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: _0._0._0._0._9030.personservice.ParamTypeFault
     */
    public ParamTypeFault getFaultInfo() {
        return faultInfo;
    }

}