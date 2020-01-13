package com.hellofresh.challenge.utilities;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.github.javafaker.Faker;

import java.util.Date;

public class FakeUserUtil {
    Faker faker = new Faker();

    public void createUser() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        Date birthday = faker.date().birthday(18, 90);
        String company = faker.company().name();
        String address = faker.address().fullAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipcode = faker.address().zipCode();
        String homePhone = faker.phoneNumber().phoneNumber();
        String mobilePhone = faker.phoneNumber().cellPhone();
        String alias = faker.name().title();


        System.out.println(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                firstName,
                lastName,
                email,
                password,
                birthday,
                company,
                address,
                city,
                state,
                zipcode,
                homePhone,
                mobilePhone,
                alias));
    }

}
