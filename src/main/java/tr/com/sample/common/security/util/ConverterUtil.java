package tr.com.sample.common.security.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author arif.erol
 */
public final class ConverterUtil {
    private ConverterUtil() {
    }

    public static String convertDateToStr(Date date) {
        return date != null ? new SimpleDateFormat("dd.MM.yyyy").format(date) : StringUtils.EMPTY;
    }

    public static String convertGender(String gender) {
        String result = "Cinsiyet Bos";
        if (StringUtils.isNotEmpty(gender)) {
            result = gender.equals("E") ? "Erkek" : "Kadın";
        }
        return result;
    }

    public static Date convertStrToDate(String dateStr) {
        try {
            return StringUtils.isNotEmpty(dateStr) ? new SimpleDateFormat("dd.MM.yyyy").parse(dateStr) : null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
