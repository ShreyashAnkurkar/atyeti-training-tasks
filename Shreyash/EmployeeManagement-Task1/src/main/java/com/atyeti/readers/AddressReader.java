package com.atyeti.readers;

import com.atyeti.entity.Address;
import com.atyeti.exception.InvalidInputException;

import java.util.Scanner;

public class AddressReader {

    public static Address readAddress(Scanner sc) throws InvalidInputException {

        IO.println("Enter House Number:");
        String houseNo = sc.nextLine().trim();
        if (houseNo.isEmpty())
            throw new InvalidInputException("House Number cannot be empty");

        IO.println("Enter Street:");
        String street = sc.nextLine().trim();
        if (street.isEmpty())
            throw new InvalidInputException("Street cannot be empty");

        IO.println("Enter City:");
        String city = sc.nextLine().trim();
        if (city.isEmpty())
            throw new InvalidInputException("City cannot be empty");

        IO.println("Enter State:");
        String state = sc.nextLine().trim();
        if (state.isEmpty())
            throw new InvalidInputException("State cannot be empty");

        IO.println("Enter Country:");
        String country = sc.nextLine().trim();
        if (country.isEmpty())
            throw new InvalidInputException("Country cannot be empty");

        IO.println("Enter Pincode:");
        String pincode = sc.nextLine().trim();

        return new Address(houseNo, street, city, state, country, pincode);
    }
}