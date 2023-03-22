/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static controllers.Config.*;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author binla
 */
public class PaymentFacade {
    public boolean checkPaymentCard(String cardname, String cardnumber, int expmonth, int expyear, String cvv) throws SQLException {
        cardname = cardname.toUpperCase();
        Date d = new Date();
        if (cardnumber.matches(VISA_CARD_PATTERN)
                || cardnumber.matches(AMEX_CARD_PATTERN)
                || cardnumber.matches(DISCOVER_CARD_PATTERN)
                || cardnumber.matches(MASTERCARD_CARD_PATTERN)) {
            if (cvv.matches(CVV_PATTERN)) {
                if (expyear < d.getYear()) {
                    return false;
                } else {
                    if (expmonth < 0 && expmonth > 12) {
                        return false;
                    } else {
                        if (expmonth < d.getMonth()) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
}
