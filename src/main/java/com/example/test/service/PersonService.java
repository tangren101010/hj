package com.example.test.service;

import com.example.test.bean.PersonBean;

import java.util.List;

public interface PersonService {
    PersonBean select(String sfz);

    PersonBean SelectPersonByid(String id);

    int InsertPerson(String sfz, String name, String sex, int age, int hjid);

    int DeletePerson(String sfz, String name);

    List<PersonBean> FindAllPersonByHj(String id);

    List<PersonBean> FindAllPerson();
}
