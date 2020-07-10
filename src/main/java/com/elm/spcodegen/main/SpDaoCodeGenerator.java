package com.elm.spcodegen.main;

import com.elm.spcodegen.beans.*;
import com.elm.spcodegen.util.Util;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpDaoCodeGenerator {
	private VelocityEngine ve;

	@Autowired
	private SpDescriptor spDescriptor;
	public List<String> generateCode() throws IOException{
		init();
		return generateClasses(spDescriptor);
	}
	private void init()  {
		  ve = new VelocityEngine();
	      ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	      ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	      ve.init();
	  }
	
	private  List<String> generateClasses(SpDescriptor spDescriptor) throws IOException {
		 List<String> result = new ArrayList<String>();
		  Util utility = new Util();
	      VelocityContext context = new VelocityContext();
	      context.put("SpDescriptor", spDescriptor);
	      context.put("utility", utility);
	      Template template = ve.getTemplate("templates/input.vm");
	
	      BufferedWriter writer =
	        new BufferedWriter(new FileWriter(spDescriptor.getSpInputClassName()+".java"));
	
	      template.merge(context, writer);
	      writer.flush();
	      writer.close();
	
	      result.add("Class " + spDescriptor.getSpInputClassName() + " generated!");
	      
	      template = ve.getTemplate("templates/output.vm");
	  	
	      writer =
	        new BufferedWriter(new FileWriter(spDescriptor.getSpResultClassName()+".java"));
	
	      template.merge(context, writer);
	      writer.flush();
	      writer.close();
	
	      result.add("Class " + spDescriptor.getSpResultClassName() + " generated!");

	      result.addAll(generateMappedBeans(spDescriptor,context));

	      template = ve.getTemplate("templates/sp_executor.vm");
	  	
	      writer =
	        new BufferedWriter(new FileWriter(spDescriptor.getSpExecutorClassName()+".java"));
	
	      template.merge(context, writer);
	      writer.flush();
	      writer.close();
	
	      result.add("Class " + spDescriptor.getSpExecutorClassName() + " generated!");
            System.out.println("SP PACKAGE NAME : "+Util.getSmallCase(spDescriptor.getSpName()));


		return result;
	  }
	private List<String> generateMappedBeans(SpDescriptor spDescriptor, VelocityContext context) throws IOException {
		List<String> strList = new ArrayList<String>(spDescriptor.getResultSetDescriptors().size());
		for( ResultSetDescriptor rd : spDescriptor.getResultSetDescriptors()) {
			Template template = this.ve.getTemplate("templates/mapped_bean.vm");
			TableDescriptor tableDescriptor = new TableDescriptor();
			tableDescriptor.setMappedBeanClassName(rd.getMappedEntityClassName());
			tableDescriptor.setMappedBeanPackageName(rd.getMappedEntityPackageName());
			for(ResultSetColumnDescriptor rcd :rd.getColumnDescriptors()){
				TableColumnDescriptor tcd = new TableColumnDescriptor();
				tcd.setColumn(rcd.getResultSetColumn());

				String columnName = rcd.getResultSetColumn().getName();
				rcd.setSetterMethodName("set" + Util.toCamelCaseForAccessors(columnName));

				tcd.setSetterMethodName(rcd.getSetterMethodName());
				tableDescriptor.getColumnDescriptors().add(tcd);
			}

			context.put("TableDescriptor", tableDescriptor);
			BufferedWriter writer = new BufferedWriter(new FileWriter(tableDescriptor.getMappedBeanClassName() + ".java"));
			template.merge(context, writer);
			writer.flush();
			writer.close();
			strList.add("Class " + tableDescriptor.getMappedBeanClassName() + " generated!");


		}

		return strList;
	}

}
