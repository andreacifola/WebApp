package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by andreacifola on 23/12/16.
 */
public class Utils {
    static final String validationCardNumberRegex = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    static final String validationNameRegex = "([A-Z][a-zA-Z]*)";
    static final String validationIBANRegex = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}";

    static boolean validateField(String toValidate, String regex) {
        return Pattern.compile(regex).matcher(toValidate).matches();
    }

    static Date parseDate(String date) throws ParseException {
        if (date.length() != 5 || ((Integer.valueOf(date.substring(0, 2)) > 12)) || ((Integer.valueOf(date.substring(0, 2)) < 1)))
            throw new ParseException(date, 0);
        return new SimpleDateFormat("MM/yy").parse(date);
    }
}
