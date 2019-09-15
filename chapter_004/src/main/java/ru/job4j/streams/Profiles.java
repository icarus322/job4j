package ru.job4j.streams;


import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> sorting(List<Profile> profiles) {
        List<Address> result = collect(profiles).stream().distinct().collect(Collectors.toList());
        result = result.stream()
                .sorted(Address::compareTo)
                .collect(Collectors.toList());
        return result;
    }
}
