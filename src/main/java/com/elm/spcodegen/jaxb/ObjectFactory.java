
package com.elm.spcodegen.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.elm.spcodegen.jaxb package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.elm.spcodegen.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Spmetadata }
     * 
     */
    public Spmetadata createSpmetadata() {
        return new Spmetadata();
    }

    /**
     * Create an instance of {@link Spmetadata.ReturnResultSets }
     * 
     */
    public Spmetadata.ReturnResultSets createSpmetadataReturnResultSets() {
        return new Spmetadata.ReturnResultSets();
    }

    /**
     * Create an instance of {@link Spmetadata.ReturnResultSets.ResultSet }
     * 
     */
    public Spmetadata.ReturnResultSets.ResultSet createSpmetadataReturnResultSetsResultSet() {
        return new Spmetadata.ReturnResultSets.ResultSet();
    }

    /**
     * Create an instance of {@link Spmetadata.OutputParameters }
     * 
     */
    public Spmetadata.OutputParameters createSpmetadataOutputParameters() {
        return new Spmetadata.OutputParameters();
    }

    /**
     * Create an instance of {@link Spmetadata.InputParameters }
     * 
     */
    public Spmetadata.InputParameters createSpmetadataInputParameters() {
        return new Spmetadata.InputParameters();
    }

    /**
     * Create an instance of {@link Spmetadata.ReturnResultSets.ResultSet.Column }
     * 
     */
    public Spmetadata.ReturnResultSets.ResultSet.Column createSpmetadataReturnResultSetsResultSetColumn() {
        return new Spmetadata.ReturnResultSets.ResultSet.Column();
    }

    /**
     * Create an instance of {@link Spmetadata.OutputParameters.Column }
     * 
     */
    public Spmetadata.OutputParameters.Column createSpmetadataOutputParametersColumn() {
        return new Spmetadata.OutputParameters.Column();
    }

    /**
     * Create an instance of {@link Spmetadata.InputParameters.Column }
     * 
     */
    public Spmetadata.InputParameters.Column createSpmetadataInputParametersColumn() {
        return new Spmetadata.InputParameters.Column();
    }

}
