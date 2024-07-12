package com.randodata.email;

import com.randodata.Utils;

public final class EmailUtils implements Utils {
    public static void isDelimiterValid(String delimiter) {
        if (delimiter == null || delimiter.length() != 1) {
            throw new UnsupportedOperationException("Delimiter can't be null or empty");
        }
    }
}
