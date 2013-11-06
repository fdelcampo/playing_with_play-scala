/*
 * An XML document type.
 * Localname: PersonXML
 * Namespace: http://tdu.inria.cl/person
 * Java type: cl.inria.tdu.person.PersonXMLDocument
 *
 * Automatically generated - do not modify.
 */
package cl.inria.tdu.person.impl;
/**
 * A document containing one PersonXML(@http://tdu.inria.cl/person) element.
 *
 * This is a complex type.
 */
public class PersonXMLDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.inria.tdu.person.PersonXMLDocument
{
    private static final long serialVersionUID = 1L;
    
    public PersonXMLDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PERSONXML$0 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "PersonXML");
    
    
    /**
     * Gets the "PersonXML" element
     */
    public cl.inria.tdu.person.PersonXMLType getPersonXML()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.PersonXMLType target = null;
            target = (cl.inria.tdu.person.PersonXMLType)get_store().find_element_user(PERSONXML$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "PersonXML" element
     */
    public void setPersonXML(cl.inria.tdu.person.PersonXMLType personXML)
    {
        generatedSetterHelperImpl(personXML, PERSONXML$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "PersonXML" element
     */
    public cl.inria.tdu.person.PersonXMLType addNewPersonXML()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.PersonXMLType target = null;
            target = (cl.inria.tdu.person.PersonXMLType)get_store().add_element_user(PERSONXML$0);
            return target;
        }
    }
}
