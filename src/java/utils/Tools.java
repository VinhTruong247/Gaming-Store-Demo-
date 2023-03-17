/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author binla
 */
public class Tools {
    private static String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    
    public static boolean verifyEmail(String input){
        if(input.matches(regexPattern)) return true;
        else return false;
    }
    
    public static boolean verifyPassword(String input){
        if(!input.equals(input.trim())) {
            System.out.println("false");
            return false;
        }
        if(input.matches("[0-9a-zA-Z]*")) {
            System.out.println("true");
            return true;
        }
        else {
            System.out.println("false");return false;
        }
    }
}
