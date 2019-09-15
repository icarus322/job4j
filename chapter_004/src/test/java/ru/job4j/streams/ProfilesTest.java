package ru.job4j.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void WhenProfilesConvertToAddress() {
        Profiles profiles = new Profiles();
        List<Profile> test = new ArrayList<>();
        test.add(new Profile(new Address("city1", "street1", 1, 11)));
        test.add(new Profile(new Address("city2", "street2", 2, 22)));
        test.add(new Profile(new Address("city3", "street3", 3, 33)));
        List<Address> result = profiles.collect(test);
        List<Address> expect = new ArrayList<>();
        expect.add(new Address("city1", "street1", 1, 11));
        expect.add(new Address("city2", "street2", 2, 22));
        expect.add(new Address("city3", "street3", 3, 33));
        assertThat(result, is(expect));
    }

    @Test
    public void WhenSortingProfilesThenSorted() {
        Profiles profiles = new Profiles();
        List<Profile> test = new ArrayList<>();
        test.add(new Profile(new Address("city1", "street1", 99, 123)));
        test.add(new Profile(new Address("city3", "street54", 15, 92)));
        test.add(new Profile(new Address("city2", "street3454", 78, 83)));
        List<Address> result = profiles.sorting(test);
        List<Address> expect = new ArrayList<>();
        expect.add(new Address("city1", "street1", 99, 123));
        expect.add(new Address("city2", "street3454", 78, 83));
        expect.add(new Address("city3", "street54", 15, 92));
        assertThat(result, is(expect));
    }


}
