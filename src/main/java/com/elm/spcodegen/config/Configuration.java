package com.elm.spcodegen.config;

import com.elm.spcodegen.beans.NameTypeBean;
import com.elm.spcodegen.beans.ResultSetColumnDescriptor;
import com.elm.spcodegen.beans.ResultSetDescriptor;
import com.elm.spcodegen.beans.SpDescriptor;
import com.elm.spcodegen.jaxb.Spmetadata;
import com.elm.spcodegen.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@org.springframework.context.annotation.Configuration
@PropertySource("classpath:application.properties")
public class Configuration {
    @Value("${sp.package.name}")
    private   String PACKAGE_NAME;

    @Value("${sp.class.name}")
    private   String CLASS_NAME;

    @Value("${contract.path}")
    private   String CONTRACT_PATH;

    @Value("${log.sql}")
    private String LOG_SQL;

    @Bean
    public SpDescriptor getSpDescriptor() throws IOException, SAXException, ParserConfigurationException {
        SpDescriptor spDescriptor = new SpDescriptor();
        spDescriptor.setLogSql(LOG_SQL.equalsIgnoreCase("yes"));
        File xmlFile = new File(CONTRACT_PATH+"/spmetadata.xml");
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Spmetadata.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Spmetadata spmetadata = (Spmetadata) jaxbUnmarshaller.unmarshal(xmlFile);

            spDescriptor.setSpName(spmetadata.getSpName());
            spDescriptor.setSpExecutorClassName(getClassName("Execute"));
            spDescriptor.setSpInputClassName(getClassName("Input"));
            spDescriptor.setSpResultClassName(getClassName("Result"));

            spDescriptor.setSpExecutorClassPackageName(getPackageName(spmetadata.getSpName()));
            spDescriptor.setSpInputClassPackageName(getPackageName(spmetadata.getSpName()));
            spDescriptor.setSpResultClassPackageName(getPackageName(spmetadata.getSpName()));

            Spmetadata.InputParameters ip = spmetadata.getInputParameters();
            Spmetadata.OutputParameters op = spmetadata.getOutputParameters();
            Spmetadata.ReturnResultSets resultSets = spmetadata.getReturnResultSets();

            if(ip != null){
                List<NameTypeBean> input = new ArrayList<NameTypeBean>();
                for(Spmetadata.InputParameters.Column param : ip.getColumn()){
                    input.add(new NameTypeBean(param.getName(), Util.getType(param.getType().toUpperCase())));
                }
                spDescriptor.setInputParameters(input);
            }

            if(op != null){
                List<NameTypeBean> output = new ArrayList<NameTypeBean>();
                for(Spmetadata.OutputParameters.Column param : op.getColumn()){
                    output.add(new NameTypeBean(param.getName(), Util.getType(param.getType().toUpperCase())));
                }
                spDescriptor.setOutputParameters(output);
            }

            if(resultSets != null){
                List<ResultSetDescriptor> resultSetDescriptors = new ArrayList<ResultSetDescriptor>();
                for(Spmetadata.ReturnResultSets.ResultSet resultSet :  resultSets.getResultSet()){
                    ResultSetDescriptor rd = new ResultSetDescriptor();
                    rd.setMappedEntityClassName(spDescriptor.getSpResultClassName()+ Util.getTitleCase(resultSet.getName()));
                    rd.setMappedEntityPackageName(spDescriptor.getSpResultClassPackageName());
                    rd.setResultSetName(resultSet.getName());
                    for(Spmetadata.ReturnResultSets.ResultSet.Column c : resultSet.getColumn()){
                        ResultSetColumnDescriptor rcd = new ResultSetColumnDescriptor();
                        rcd.setResultSetColumn(new NameTypeBean(c.getName(), Util.getType(c.getType().toUpperCase())));
                        rd.getColumnDescriptors().add(rcd);
                    }
                    resultSetDescriptors.add(rd);
                }
                spDescriptor.setResultSetDescriptors(resultSetDescriptors);
            }
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }

        return spDescriptor;
    }

    private String getPackageName(String spName) {
        return PACKAGE_NAME;
    }

    private String getClassName(String suffix) {
        return CLASS_NAME+suffix;
    }



}
