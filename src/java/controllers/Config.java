/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author VU HONG ANH
 */
public class Config {
    public static final String LAYOUT = "/WEB-INF/layouts/main.jsp";
    public static final String VISA_CARD_PATTERN = "^4[0-9]{12}(?:[0-9]{3})?$";
    public static final String AMEX_CARD_PATTERN = "^3[47][0-9]{13}$";
    public static final String MASTERCARD_CARD_PATTERN = "^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$";
    public static final String DISCOVER_CARD_PATTERN = "^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$";
    public static final String CVV_PATTERN = "/^[0-9]{3}$/";
}
