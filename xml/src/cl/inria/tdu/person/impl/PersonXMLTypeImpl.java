/*
 * XML Type:  personXMLType
 * Namespace: http://tdu.inria.cl/person
 * Java type: cl.inria.tdu.person.PersonXMLType
 *
 * Automatically generated - do not modify.
 */
package cl.inria.tdu.person.impl;
/**
 * An XML personXMLType(@http://tdu.inria.cl/person).
 *
 * This is a complex type.
 */
public class PersonXMLTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.inria.tdu.person.PersonXMLType
{
    private static final long serialVersionUID = 1L;
    
    public PersonXMLTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ID$0 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "id");
    private static final javax.xml.namespace.QName FIRSTNAME$2 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "firstname");
    private static final javax.xml.namespace.QName PRIMARYLASTNAME$4 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "primarylastname");
    private static final javax.xml.namespace.QName SECONDLASTNAME$6 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "secondlastname");
    private static final javax.xml.namespace.QName RUN$8 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "run");
    private static final javax.xml.namespace.QName GENRE$10 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "genre");
    private static final javax.xml.namespace.QName BIRTH$12 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "birth");
    private static final javax.xml.namespace.QName NATIONALITY$14 = 
        new javax.xml.namespace.QName("http://tdu.inria.cl/person", "nationality");
    
    
    /**
     * Gets the "id" element
     */
    public long getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" element
     */
    public org.apache.xmlbeans.XmlLong xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(ID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "id" element
     */
    public void setId(long id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID$0);
            }
            target.setLongValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" element
     */
    public void xsetId(org.apache.xmlbeans.XmlLong id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLong target = null;
            target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLong)get_store().add_element_user(ID$0);
            }
            target.set(id);
        }
    }
    
    /**
     * Gets the "firstname" element
     */
    public java.lang.String getFirstname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "firstname" element
     */
    public org.apache.xmlbeans.XmlString xgetFirstname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRSTNAME$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "firstname" element
     */
    public void setFirstname(java.lang.String firstname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FIRSTNAME$2);
            }
            target.setStringValue(firstname);
        }
    }
    
    /**
     * Sets (as xml) the "firstname" element
     */
    public void xsetFirstname(org.apache.xmlbeans.XmlString firstname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRSTNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FIRSTNAME$2);
            }
            target.set(firstname);
        }
    }
    
    /**
     * Gets the "primarylastname" element
     */
    public java.lang.String getPrimarylastname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIMARYLASTNAME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "primarylastname" element
     */
    public org.apache.xmlbeans.XmlString xgetPrimarylastname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIMARYLASTNAME$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "primarylastname" element
     */
    public void setPrimarylastname(java.lang.String primarylastname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIMARYLASTNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PRIMARYLASTNAME$4);
            }
            target.setStringValue(primarylastname);
        }
    }
    
    /**
     * Sets (as xml) the "primarylastname" element
     */
    public void xsetPrimarylastname(org.apache.xmlbeans.XmlString primarylastname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIMARYLASTNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PRIMARYLASTNAME$4);
            }
            target.set(primarylastname);
        }
    }
    
    /**
     * Gets the "secondlastname" element
     */
    public java.lang.String getSecondlastname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECONDLASTNAME$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "secondlastname" element
     */
    public org.apache.xmlbeans.XmlString xgetSecondlastname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SECONDLASTNAME$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "secondlastname" element
     */
    public void setSecondlastname(java.lang.String secondlastname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECONDLASTNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SECONDLASTNAME$6);
            }
            target.setStringValue(secondlastname);
        }
    }
    
    /**
     * Sets (as xml) the "secondlastname" element
     */
    public void xsetSecondlastname(org.apache.xmlbeans.XmlString secondlastname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SECONDLASTNAME$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SECONDLASTNAME$6);
            }
            target.set(secondlastname);
        }
    }
    
    /**
     * Gets the "run" element
     */
    public cl.inria.tdu.person.RunType getRun()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.RunType target = null;
            target = (cl.inria.tdu.person.RunType)get_store().find_element_user(RUN$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "run" element
     */
    public void setRun(cl.inria.tdu.person.RunType run)
    {
        generatedSetterHelperImpl(run, RUN$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "run" element
     */
    public cl.inria.tdu.person.RunType addNewRun()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.inria.tdu.person.RunType target = null;
            target = (cl.inria.tdu.person.RunType)get_store().add_element_user(RUN$8);
            return target;
        }
    }
    
    /**
     * Gets the "genre" element
     */
    public java.lang.String getGenre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENRE$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "genre" element
     */
    public org.apache.xmlbeans.XmlString xgetGenre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GENRE$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "genre" element
     */
    public void setGenre(java.lang.String genre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENRE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GENRE$10);
            }
            target.setStringValue(genre);
        }
    }
    
    /**
     * Sets (as xml) the "genre" element
     */
    public void xsetGenre(org.apache.xmlbeans.XmlString genre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GENRE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(GENRE$10);
            }
            target.set(genre);
        }
    }
    
    /**
     * Gets the "birth" element
     */
    public java.util.Calendar getBirth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BIRTH$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "birth" element
     */
    public org.apache.xmlbeans.XmlDate xgetBirth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(BIRTH$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "birth" element
     */
    public void setBirth(java.util.Calendar birth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BIRTH$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BIRTH$12);
            }
            target.setCalendarValue(birth);
        }
    }
    
    /**
     * Sets (as xml) the "birth" element
     */
    public void xsetBirth(org.apache.xmlbeans.XmlDate birth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(BIRTH$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(BIRTH$12);
            }
            target.set(birth);
        }
    }
    
    /**
     * Gets the "nationality" element
     */
    public java.lang.String getNationality()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NATIONALITY$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nationality" element
     */
    public org.apache.xmlbeans.XmlString xgetNationality()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NATIONALITY$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "nationality" element
     */
    public void setNationality(java.lang.String nationality)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NATIONALITY$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NATIONALITY$14);
            }
            target.setStringValue(nationality);
        }
    }
    
    /**
     * Sets (as xml) the "nationality" element
     */
    public void xsetNationality(org.apache.xmlbeans.XmlString nationality)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NATIONALITY$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NATIONALITY$14);
            }
            target.set(nationality);
        }
    }
}
