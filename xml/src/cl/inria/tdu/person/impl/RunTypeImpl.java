/*
 * XML Type:  runType
 * Namespace: http://tdu.inria.cl/person
 * Java type: cl.inria.tdu.person.RunType
 *
 * Automatically generated - do not modify.
 */
package cl.inria.tdu.person.impl;
/**
 * An XML runType(@http://tdu.inria.cl/person).
 *
 * This is a complex type.
 */
public class RunTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.inria.tdu.person.RunType
{
    private static final long serialVersionUID = 1L;
    
    public RunTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NUMBER$0 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "Number");
    private static final javax.xml.namespace.QName DV$2 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "Dv");
    
    
    /**
     * Gets the "Number" element
     */
    public int getNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMBER$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "Number" element
     */
    public cl.inria.tdu.person.RunType.Number xgetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.RunType.Number target = null;
            target = (cl.inria.tdu.person.RunType.Number)get_store().find_element_user(NUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Number" element
     */
    public void setNumber(int number)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NUMBER$0);
            }
            target.setIntValue(number);
        }
    }
    
    /**
     * Sets (as xml) the "Number" element
     */
    public void xsetNumber(cl.inria.tdu.person.RunType.Number number)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.RunType.Number target = null;
            target = (cl.inria.tdu.person.RunType.Number)get_store().find_element_user(NUMBER$0, 0);
            if (target == null)
            {
                target = (cl.inria.tdu.person.RunType.Number)get_store().add_element_user(NUMBER$0);
            }
            target.set(number);
        }
    }
    
    /**
     * Gets the "Dv" element
     */
    public java.lang.String getDv()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DV$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Dv" element
     */
    public cl.inria.tdu.person.RunType.Dv xgetDv()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.RunType.Dv target = null;
            target = (cl.inria.tdu.person.RunType.Dv)get_store().find_element_user(DV$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Dv" element
     */
    public void setDv(java.lang.String dv)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DV$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DV$2);
            }
            target.setStringValue(dv);
        }
    }
    
    /**
     * Sets (as xml) the "Dv" element
     */
    public void xsetDv(cl.inria.tdu.person.RunType.Dv dv)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.RunType.Dv target = null;
            target = (cl.inria.tdu.person.RunType.Dv)get_store().find_element_user(DV$2, 0);
            if (target == null)
            {
                target = (cl.inria.tdu.person.RunType.Dv)get_store().add_element_user(DV$2);
            }
            target.set(dv);
        }
    }
    /**
     * An XML Number(@http://tdu.inria.cl/person).
     *
     * This is an atomic type that is a restriction of cl.inria.tdu.person.RunType$Number.
     */
    public static class NumberImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements cl.inria.tdu.person.RunType.Number
    {
        private static final long serialVersionUID = 1L;
        
        public NumberImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected NumberImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML Dv(@http://tdu.inria.cl/person).
     *
     * This is an atomic type that is a restriction of cl.inria.tdu.person.RunType$Dv.
     */
    public static class DvImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements cl.inria.tdu.person.RunType.Dv
    {
        private static final long serialVersionUID = 1L;
        
        public DvImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected DvImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
