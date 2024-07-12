package com.randodata.email;

import com.randodata.Storage;
import com.randodata.utils.GeneralUtils;

import java.util.ArrayList;
import java.util.List;

import static com.randodata.utils.GeneralUtils.generateInRange;
import static com.randodata.utils.GeneralUtils.nullCheck;

public final class EmailsStorage implements Storage {
    private final List<String> usernames = new ArrayList<>();

    private final List<String> domains = new ArrayList<>();

    private EmailsStorage() {

    }

    public static EmailsStorage create() {
        return new EmailsStorage();
    }

    @Override
    public void init() {
        initUsernames();
        initDomains();
    }

    private void initDomains() {
        domains.add("gmail.com");
        domains.add("yahoo.com");
        domains.add("hotmail.com");
        domains.add("aol.com");
        domains.add("hotmail.co.uk");
        domains.add("hotmail.fr");
        domains.add("msn.com");
        domains.add("yahoo.fr");
        domains.add("wanadoo.fr");
        domains.add("orange.fr");
        domains.add("comcast.net");
        domains.add("yahoo.co.uk");
        domains.add("yahoo.com.br");
        domains.add("yahoo.co.in");
        domains.add("live.com");
        domains.add("rediffmail.com");
        domains.add("free.fr");
        domains.add("gmx.de");
        domains.add("web.de");
        domains.add("ymail.com");
    }

    private void initUsernames() {
        usernames.add("Damien");
        usernames.add("Keziah");
        usernames.add("Alisa");
        usernames.add("Morgan");
        usernames.add("Romeo");
        usernames.add("Leanne");
        usernames.add("Dafydd");
        usernames.add("Darcie");
        usernames.add("Nicole");
        usernames.add("Phoebe");
        usernames.add("Awais");
        usernames.add("Ayden");
        usernames.add("Casey");
        usernames.add("Liberty");
        usernames.add("Victor");
        usernames.add("Rahim");
        usernames.add("Emilie");
        usernames.add("Ruqayyah");
        usernames.add("Maddison");
        usernames.add("Libbie");
        usernames.add("Ellie-Mae");
        usernames.add("Lois");
        usernames.add("Safaa");
        usernames.add("Frazer");
        usernames.add("Dawid");
        usernames.add("Andrea");
        usernames.add("Greta");
        usernames.add("Savannah");
        usernames.add("Maisy");
        usernames.add("Wade");
        usernames.add("Callum");
        usernames.add("Julie");
        usernames.add("Homer");
        usernames.add("Rhys");
        usernames.add("Cruz");
        usernames.add("Elisha");
        usernames.add("Kyan");
        usernames.add("Halle");
        usernames.add("Lily-Rose");
        usernames.add("Jasmin");
        usernames.add("Alyssa");
        usernames.add("Brendon");
        usernames.add("Anjali");
        usernames.add("Margaret");
        usernames.add("Ada");
        usernames.add("Faisal");
        usernames.add("Stephen");
        usernames.add("Abbas");
        usernames.add("Vivian");
        usernames.add("Jaime");
        usernames.add("Wilbur");
        usernames.add("Arthur");
        usernames.add("Celeste");
        usernames.add("Marvin");
        usernames.add("Annie");
        usernames.add("Lucille");
        usernames.add("Abu");
        usernames.add("Farhan");
        usernames.add("Adele");
        usernames.add("Alan");
        usernames.add("Anne");
        usernames.add("Lila");
        usernames.add("Wendy");
        usernames.add("Frankie");
        usernames.add("Ryan");
        usernames.add("Barnaby");
        usernames.add("Eoin");
        usernames.add("Raja");
        usernames.add("Larry");
        usernames.add("Miriam");
        usernames.add("Crystal");
        usernames.add("Louie");
        usernames.add("Madeline");
        usernames.add("Issac");
        usernames.add("Sadia");
        usernames.add("Hashim");
        usernames.add("Regan");
        usernames.add("Azaan");
        usernames.add("Yash");
        usernames.add("Ayah");
        usernames.add("Leila");
        usernames.add("Kristina");
        usernames.add("Hafsa");
        usernames.add("Jack");
        usernames.add("Demi");
        usernames.add("Damian");
        usernames.add("Keaton");
        usernames.add("Reuben");
        usernames.add("Alesha");
        usernames.add("Usman");
        usernames.add("Rosalie");
        usernames.add("Zak");
        usernames.add("Anna");
        usernames.add("Simon");
        usernames.add("Ruby");
        usernames.add("Tommy");
        usernames.add("Aayan");
        usernames.add("Elinor");
        usernames.add("Thea");
        usernames.add("Rebecca");
    }

    public EmailsStorage includeDefaults() {
        init();
        return this;
    }

    public EmailsStorage addUserNames(List<String> usernames) {
        nullCheck(usernames);
        usernames.forEach(GeneralUtils::nullCheck);
        this.usernames.addAll(usernames);

        return this;
    }

    public EmailsStorage addUserNames(String... usernames) {
        nullCheck(usernames);

        for (String username : usernames) {
            nullCheck(username);
        }

        this.usernames.addAll(List.of(usernames));

        return this;
    }

    public EmailsStorage addDomains(List<String> domains) {
        nullCheck(domains);
        domains.forEach(GeneralUtils::nullCheck);
        this.domains.addAll(domains);

        return this;
    }

    public EmailsStorage addDomains(String... domains) {
        nullCheck(domains);

        for (String domain : domains) {
            nullCheck(domain);
        }

        this.domains.addAll(List.of(domains));

        return this;
    }

    public List<String> generateAsString(int limit, String delimiter) {
        List<String> generated = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            String username = generateUsername();
            String domain = generateDomain();

            generated.add(username.concat(delimiter).concat(domain));
        }

        return generated;
    }

    public List<Email> generate(int limit, String delimiter) {
        List<Email> generated = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            String username = generateUsername();
            String domain = generateDomain();

            Email email = new Email(username, domain, delimiter);

            generated.add(email);
        }

        return generated;
    }

    private String generateUsername() {
        int randomIndex = generateInRange(usernames.size());
        return usernames.get(randomIndex);
    }

    private String generateDomain() {
        int randomIndex = generateInRange(domains.size());
        return domains.get(randomIndex);
    }
}
