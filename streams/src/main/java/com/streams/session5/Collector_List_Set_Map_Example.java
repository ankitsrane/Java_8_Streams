package com.streams.session5;

import com.streams.commonUtil.CommonUtility;
import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Collector_List_Set_Map_Example {
    private static List<Person> personList = CommonUtility.personList;

    public static void main(String[] args) {
        System.out.println("reduce Example");
        // beforeStreamWay();

    }

    //toList : Get the persons whose age is more than 25
    private static List<Person> getPersonList_ageMoreThan_twentyFive_list(List<Person> personList){
        return personList.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toList());
    }

    //toSet : Get the persons whose age is more than 25
    private static Set<Person> getPersonSet_ageMoreThan_twentyFive_set(List<Person> personList){
        return personList.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toSet());
    }

    //toMap : Get the person map containing uniqueId as a key, personObject as a value as Key whose age is more than 25
    private static Map<Long, Person> getPersonMap_ageMoreThan_twentyFive_map(List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toMap(person -> person.getUniqueId(), person -> person));
    }

}
