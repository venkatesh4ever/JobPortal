
package com.vidur.news.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vidur.news.model package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vidur.news.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FaultDetail }
     * 
     */
    public FaultDetail createFaultDetail() {
        return new FaultDetail();
    }

    /**
     * Create an instance of {@link CollectNewsResponse }
     * 
     */
    public CollectNewsResponse createCollectNewsResponse() {
        return new CollectNewsResponse();
    }

    /**
     * Create an instance of {@link SaveNewsResponse }
     * 
     */
    public SaveNewsResponse createSaveNewsResponse() {
        return new SaveNewsResponse();
    }

    /**
     * Create an instance of {@link CollectNews }
     * 
     */
    public CollectNews createCollectNews() {
        return new CollectNews();
    }

    /**
     * Create an instance of {@link SaveNews }
     * 
     */
    public SaveNews createSaveNews() {
        return new SaveNews();
    }

}
