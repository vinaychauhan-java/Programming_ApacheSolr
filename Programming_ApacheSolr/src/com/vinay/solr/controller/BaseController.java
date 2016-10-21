package com.vinay.solr.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinay.solr.config.AppConfig;

public class BaseController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

}
