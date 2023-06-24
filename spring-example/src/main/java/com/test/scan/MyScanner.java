package com.test.scan;

import lombok.Data;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class MyScanner {

	File f = new File(this.getClass().getResource("/").getPath());

	private List<String> listName = new ArrayList<>();

	private Map<String, AbstractBeanDefinition> beanDefinitionMap = new HashMap<>();

	public void scanPackages(String packageName) throws ClassNotFoundException {

		String scanPath = "";

		String rootPath = f.getPath();

		scanPath = packageName.replaceAll("\\.", "\\\\");
		rootPath = rootPath +"\\"+ scanPath;
		File rootDir = new File(rootPath);
		File[] fileList = rootDir.listFiles();
		for (File s : fileList) {
			String fileName = s.getName();
			fileName = fileName.replace(".class", "");
			String beanName = fileName.toLowerCase();
			fileName = packageName + "." + fileName;
			Class<?> clazz = Class.forName(fileName);
			if (clazz.isAnnotationPresent(Component.class)) {
				GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
				genericBeanDefinition.setBeanClass(clazz);
				if (clazz.isAnnotationPresent(Scope.class)) {
					genericBeanDefinition.setScope(clazz.getAnnotation(Scope.class).scopeName());
				}
				beanDefinitionMap.put(beanName, genericBeanDefinition);
				listName.add(beanName);
			}
		}
	}
}
