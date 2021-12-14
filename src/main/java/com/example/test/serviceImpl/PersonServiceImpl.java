package com.example.test.serviceImpl;

import com.example.test.bean.PersonBean;
import com.example.test.mapper.PersonMapper;
import com.example.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonMapper personMapper;

    @Override
    public PersonBean select(String sfz) {
        return personMapper.select(sfz);
    }

    @Override
    public int InsertPerson(String sfz, String name, String sex, int age, int hjid) {
        return personMapper.InsertPerson(sfz, name, sex, age, hjid);
    }

    @Override
    public PersonBean SelectPersonByid(String id) {
        return personMapper.SelectPersonByid(id);
    }

    @Override
    public int DeletePerson(String sfz, String name) {
        return personMapper.DeletePerson(sfz, name);
    }

    @Override
    public List<PersonBean> FindAllPersonByHj(String id) {
        return personMapper.FindAllPersonByHj(id);
    }

    @Override
    public List<PersonBean> FindAllPerson() {
        return personMapper.FindAllPerson();
    }
}
