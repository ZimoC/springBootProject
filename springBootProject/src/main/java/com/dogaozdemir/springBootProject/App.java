package com.dogaozdemir.springBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Doga Ozdemir
 *
 */
@SpringBootApplication  //that means this is a spring boot app.
public class App 
{
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
    
}
