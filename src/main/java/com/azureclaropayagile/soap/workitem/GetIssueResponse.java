//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.05.10 a las 02:07:55 PM CDT 
//


package com.azureclaropayagile.soap.workitem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="issueWorkItem" type="{http://www.azureClaroPayAgile.com/soap/workItem}issueWorkItem"/>
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
    "issueWorkItem"
})
@XmlRootElement(name = "getIssueResponse")
public class GetIssueResponse {

    @XmlElement(required = true)
    protected IssueWorkItem issueWorkItem;

    /**
     * Obtiene el valor de la propiedad issueWorkItem.
     * 
     * @return
     *     possible object is
     *     {@link IssueWorkItem }
     *     
     */
    public IssueWorkItem getIssueWorkItem() {
        return issueWorkItem;
    }

    /**
     * Define el valor de la propiedad issueWorkItem.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueWorkItem }
     *     
     */
    public void setIssueWorkItem(IssueWorkItem value) {
        this.issueWorkItem = value;
    }

}
