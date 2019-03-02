package com.smart.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
//import org.testng.annotations.*;
//import static org.testng.Assert.*;

public class PatternResolverTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource resources[] =  resolver.getResources("classpath*:com/smart/**/*.xml");

        System.out.println("resources=" + resources.length);
        for (Resource resource:resources
                ) {
            System.out.println(resource.getDescription());
        }
    }
//    public void getResources() throws Throwable
//    {
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//        Resource resources[] = ((PathMatchingResourcePatternResolver) resolver).getResources("classpath*:com/smart/**/*.xml");
//
//        assertNotNull(resources);
//        for (Resource resource:resources
//             ) {
//            System.out.println(resource.getDescription());
//        }
//
//    }
}
