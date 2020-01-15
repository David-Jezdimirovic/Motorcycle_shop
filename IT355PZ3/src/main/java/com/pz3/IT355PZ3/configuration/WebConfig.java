/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.configuration;


import com.pz3.IT355PZ3.interceptor.MojePorudzbineInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Lenovo
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    private MojePorudzbineInterceptor restInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //kada se odkomentarise linija koda ispod, aktivira se interceptor
       // registry.addInterceptor(restInterceptor).addPathPatterns("/api/mojeporudzbine/**");
    }
}