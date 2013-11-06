/*
 * XML Type:  personXMLType
 * Namespace: http://tdu.inria.cl/person
 * Java type: cl.inria.tdu.person.PersonXMLType
 *
 * Automatically generated - do not modify.
 */
package cl.inria.tdu.person;


/**
 * An XML personXMLType(@http://tdu.inria.cl/person).
 *
 * This is a complex type.
 */
public interface PersonXMLType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PersonXMLType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s530FEE6E946AC22DBFC9F35B839B9D10").resolveHandle("personxmltype78e4type");
    
    /**
     * Gets the "id" element
     */
    long getId();
    
    /**
     * Gets (as xml) the "id" element
     */
    org.apache.xmlbeans.XmlLong xgetId();
    
    /**
     * Sets the "id" element
     */
    void setId(long id);
    
    /**
     * Sets (as xml) the "id" element
     */
    void xsetId(org.apache.xmlbeans.XmlLong id);
    
    /**
     * Gets the "firstname" element
     */
    java.lang.String getFirstname();
    
    /**
     * Gets (as xml) the "firstname" element
     */
    org.apache.xmlbeans.XmlString xgetFirstname();
    
    /**
     * Sets the "firstname" element
     */
    void setFirstname(java.lang.String firstname);
    
    /**
     * Sets (as xml) the "firstname" element
     */
    void xsetFirstname(org.apache.xmlbeans.XmlString firstname);
    
    /**
     * Gets the "primarylastname" element
     */
    java.lang.String getPrimarylastname();
    
    /**
     * Gets (as xml) the "primarylastname" element
     */
    org.apache.xmlbeans.XmlString xgetPrimarylastname();
    
    /**
     * Sets the "primarylastname" element
     */
    void setPrimarylastname(java.lang.String primarylastname);
    
    /**
     * Sets (as xml) the "primarylastname" element
     */
    void xsetPrimarylastname(org.apache.xmlbeans.XmlString primarylastname);
    
    /**
     * Gets the "secondlastname" element
     */
    java.lang.String getSecondlastname();
    
    /**
     * Gets (as xml) the "secondlastname" element
     */
    org.apache.xmlbeans.XmlString xgetSecondlastname();
    
    /**
     * Sets the "secondlastname" element
     */
    void setSecondlastname(java.lang.String secondlastname);
    
    /**
     * Sets (as xml) the "secondlastname" element
     */
    void xsetSecondlastname(org.apache.xmlbeans.XmlString secondlastname);
    
    /**
     * Gets the "run" element
     */
    cl.inria.tdu.person.RunType getRun();
    
    /**
     * Sets the "run" element
     */
    void setRun(cl.inria.tdu.person.RunType run);
    
    /**
     * Appends and returns a new empty "run" element
     */
    cl.inria.tdu.person.RunType addNewRun();
    
    /**
     * Gets the "genre" element
     */
    java.lang.String getGenre();
    
    /**
     * Gets (as xml) the "genre" element
     */
    org.apache.xmlbeans.XmlString xgetGenre();
    
    /**
     * Sets the "genre" element
     */
    void setGenre(java.lang.String genre);
    
    /**
     * Sets (as xml) the "genre" element
     */
    void xsetGenre(org.apache.xmlbeans.XmlString genre);
    
    /**
     * Gets the "birth" element
     */
    java.util.Calendar getBirth();
    
    /**
     * Gets (as xml) the "birth" element
     */
    org.apache.xmlbeans.XmlDate xgetBirth();
    
    /**
     * Sets the "birth" element
     */
    void setBirth(java.util.Calendar birth);
    
    /**
     * Sets (as xml) the "birth" element
     */
    void xsetBirth(org.apache.xmlbeans.XmlDate birth);
    
    /**
     * Gets the "nationality" element
     */
    java.lang.String getNationality();
    
    /**
     * Gets (as xml) the "nationality" element
     */
    org.apache.xmlbeans.XmlString xgetNationality();
    
    /**
     * Sets the "nationality" element
     */
    void setNationality(java.lang.String nationality);
    
    /**
     * Sets (as xml) the "nationality" element
     */
    void xsetNationality(org.apache.xmlbeans.XmlString nationality);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.inria.tdu.person.PersonXMLType newInstance() {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.inria.tdu.person.PersonXMLType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.inria.tdu.person.PersonXMLType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.inria.tdu.person.PersonXMLType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.inria.tdu.person.PersonXMLType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.inria.tdu.person.PersonXMLType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.inria.tdu.person.PersonXMLType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
