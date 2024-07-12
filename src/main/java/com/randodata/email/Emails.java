package com.randodata.email;

import com.randodata.*;

import static com.randodata.utils.GeneralUtils.*;


public final class Emails implements Service<Emails, Email> {
    private String delimiter = "@";
    private int limit = 1;

    private EmailsStorage emailsStorage = EmailsStorage.create().includeDefaults();

    private Emails() {

    }

    public static Emails create() {
        return new Emails();
    }

    @Override
    public Emails customStorage(Storage storage) {
        nullCheck(emailsStorage);
        this.emailsStorage = (EmailsStorage) storage;
        return this;
    }

    @Override
    public Emails limit(int limit) {
        isLimitValid(limit);
        this.limit = limit;
        return this;
    }

    public Emails delimiter(String delimiter) {
        EmailUtils.isDelimiterValid(delimiter);
        this.delimiter = delimiter;
        return this;
    }

    @Override
    public ResultWrapper<Email> wrapper() {
        return () -> emailsStorage.generate(limit, delimiter);
    }

    @Override
    public ResultWrapper<String> string() {
        return () -> emailsStorage.generateAsString(limit, delimiter);
    }
}
