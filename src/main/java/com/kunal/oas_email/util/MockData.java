package com.kunal.oas_email.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MockData {


    public List<Map<String, Object>> getEmailMockData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1001);
        map.put("name", "John Doe");
        map.put("date_of_joining", "2014-03-21");
        map.put("date_of_leave", "2019-01-18");
        map.put("total_experience", 0);
        map.put("location", "Hyderabad");
        map.put("status", "Active");
        map.put("employee_type", "Full Time");
        map.put("skills", "Java, Spring");


        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 1002);
        map2.put("name", "Jane Doe");
        map2.put("date_of_joining", "2019-02-05");
        map2.put("date_of_leave", "2019-08-12");
        map2.put("total_experience", 0);
        map2.put("location", "Bangalore");
        map2.put("status", "Active");
        map2.put("employee_type", "Contractor");
        map2.put("skills", "Python");


        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", 1003);
        map3.put("name", "John Smith");
        map3.put("date_of_joining", "2022-08-26");
        map3.put("date_of_leave", "2022-06-11");
        map3.put("total_experience", 5.4);
        map3.put("location", "Pune");
        map3.put("status", "InActive");
        map3.put("employee_type", "Full Time");
        map3.put("skills", "React, Node JS");


        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", 1004);
        map4.put("name", "Jane Smith");
        map4.put("date_of_joining", "2022-06-20");
        map4.put("date_of_leave", "");
        map4.put("total_experience", 2.3);
        map4.put("location", "Noida");
        map4.put("status", "Active");
        map4.put("employee_type", "Full Time");
        map4.put("skills", "C#, .Net");


        list.add(map);
        list.add(map2);
        list.add(map3);
        list.add(map4);


        return list;
    }


}