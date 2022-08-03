/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai;

import java.lang.reflect.Field;

/**
 *
 * @author Swaroopcomp
 */
public class TesClass {
    
    public static void main(String... args) {
	try {
	    Class c = Class.forName("com.sai.model.SSTaskGen");
                                Field[] arrf =c.getDeclaredFields();
                                 System.out.format("{--"+arrf[0].getName());
	           Field f = c.getDeclaredField("contacted");
                  
	    System.out.format("Type: %s%n", f.getType());
	    System.out.format("GenericType: %s%n", f.getGenericType());
            System.out.format("Type: %s%n", f.getType().getTypeName());
                     Class c1 = Class.forName( f.getType().getTypeName());
             c.getMethod("setContacted", c1);

        // production code should handle these exceptions more gracefully
	} catch (Exception x) {
	    x.printStackTrace();
	}
    }
}
