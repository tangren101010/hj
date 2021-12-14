package com.example.test.mapper;

import com.example.test.bean.PersonBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    PersonBean select(String sfz);

    PersonBean SelectPersonByid(String id);

    int InsertPerson(String sfz, String name, String sex, int age, int hjid);

    int DeletePerson(String sfz, String name);

    List<PersonBean> FindAllPersonByHj(String id);

    List<PersonBean> FindAllPerson();
}
