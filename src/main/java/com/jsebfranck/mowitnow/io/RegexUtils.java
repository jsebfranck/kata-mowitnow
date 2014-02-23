package com.jsebfranck.mowitnow.io;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for regular expressions.
 * @author jsebfranck
 */
class RegexUtils {

    static List<String> findByPattern(String line, String regex, String exceptionMessageIfNotFound) throws IOMowerBatteryException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (! matcher.find()) {
            throw new IOMowerBatteryException(exceptionMessageIfNotFound);
        }

        List<String> results = new ArrayList<>(matcher.groupCount());
        for (int i = 1; i < matcher.groupCount() + 1 ; i++) {
            results.add(matcher.group(i));
        }
        return results;
    }
}
