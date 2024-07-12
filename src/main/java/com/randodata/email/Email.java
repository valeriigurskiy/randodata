package com.randodata.email;

public class Email {
    private final String username;

    private final String domain;

    private final String delimiter;

    public Email(String username, String domain, String delimiter) {
        this.username = username;
        this.domain = domain;
        this.delimiter = delimiter;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public String toString() {
        return username.concat(delimiter).concat(domain);
    }
}
