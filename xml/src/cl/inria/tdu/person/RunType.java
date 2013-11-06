/*
 * XML Type:  runType
 * Namespace: http://tdu.inria.cl/person
 * Java type: cl.inria.tdu.person.RunType
 *
 * Automatically generated - do not modify.
 */
package cl.inria.tdu.person;


/**
 * An XML runType(@http://tdu.inria.cl/person).
 *
 * This is a complex type.
 */
public interface RunType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RunType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s530FEE6E946AC22DBFC9F35B839B9D10").resolveHandle("runtype3c7btype");
    
    /**
     * Gets the "Number" element
     */
    int getNumber();
    
    /**
     * Gets (as xml) the "Number" element
     */
    cl.inria.tdu.person.RunType.Number xgetNumber();
    
    /**
     * Sets the "Number" element
     */
    void setNumber(int number);
    
    /**
     * Sets (as xml) the "Number" element
     */
    void xsetNumber(cl.inria.tdu.person.RunType.Number number);
    
    /**
     * Gets the "Dv" element
     */
    java.lang.String getDv();
    
    /**
     * Gets (as xml) the "Dv" element
     */
    cl.inria.tdu.person.RunType.Dv xgetDv();
    
    /**
     * Sets the "Dv" element
     */
    void setDv(java.lang.String dv);
    
    /**
     * Sets (as xml) the "Dv" element
     */
    void xsetDv(cl.inria.tdu.person.RunType.Dv dv);
    
    /**
     * An XML Number(@http://tdu.inria.cl/person).
     *
     * This is an atomic type that is a restriction of cl.inria.tdu.person.RunType$Number.
     */
    public interface Number extends org.apache.xmlbeans.XmlPositiveInteger
    {
        int getIntValue();
        void setIntValue(int i);
        /** @deprecated */
        int intValue();
        /** @deprecated */
        void set(int i);
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Number.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s530FEE6E946AC22DBFC9F35B839B9D10").resolveHandle("number0d96elemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.inria.tdu.person.RunType.Number newValue(java.lang.Object obj) {
              return (cl.inria.tdu.person.RunType.Number) type.newValue( obj ); }
            
            public static cl.inria.tdu.person.RunType.Number newInstance() {
              return (cl.inria.tdu.person.RunType.Number) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.inria.tdu.person.RunType.Number newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.inria.tdu.person.RunType.Number) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * An XML Dv(@http://tdu.inria.cl/person).
     *
     * This is an atomic type that is a restriction of cl.inria.tdu.person.RunType$Dv.
     */
    public interface Dv extends org.apache.xmlbeans.XmlToken
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Dv.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s530FEE6E946AC22DBFC9F35B839B9D10").resolveHandle("dv89edelemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.inria.tdu.person.RunType.Dv newValue(java.lang.Object obj) {
              return (cl.inria.tdu.person.RunType.Dv) type.newValue( obj ); }
            
            public static cl.inria.tdu.person.RunType.Dv newInstance() {
              return (cl.inria.tdu.person.RunType.Dv) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.inria.tdu.person.RunType.Dv newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.inria.tdu.person.RunType.Dv) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.inria.tdu.person.RunType newInstance() {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.inria.tdu.person.RunType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.inria.tdu.person.RunType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.inria.tdu.person.RunType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.inria.tdu.person.RunType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.inria.tdu.person.RunType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.inria.tdu.person.RunType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.inria.tdu.person.RunType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.inria.tdu.person.RunType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.inria.tdu.person.RunType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.inria.tdu.person.RunType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.inria.tdu.person.RunType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.inria.tdu.person.RunType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.inria.tdu.person.RunType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.inria.tdu.person.RunType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.inria.tdu.person.RunType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.inria.tdu.person.RunType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.inria.tdu.person.RunType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.inria.tdu.person.RunType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
