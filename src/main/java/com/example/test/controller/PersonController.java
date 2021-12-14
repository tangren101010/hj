package com.example.test.controller;

import com.example.test.bean.HjBean;
import com.example.test.bean.PersonBean;
import com.example.test.service.HjService;
import com.example.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {


    @Autowired
    PersonService personService;

    @Autowired
    HjService hjService;

    //查询个人信息
    @RequestMapping("/toSelectPerson")
    public String toSelectPerson() {
        return "Person/selectPerson";
    }

    @RequestMapping("/SelectPerson")
    public String select(String sfz, Model model) {
        PersonBean personBeans = personService.select(sfz);
        System.out.println(personBeans);
        if (personBeans != null) {
            model.addAttribute("person", personBeans);
            return "Person/selectPersonjg";
        } else {
            model.addAttribute("msg", "查询失败");
            return "Person/selectPerson";
        }
    }

    //添加个人信息
    @RequestMapping("/toInsertPerson")
    public String toInsertPerson() {
        return "Person/insertPerson";
    }

    @RequestMapping("/InsertPerson")
    public String Insert(String sfz, String name, String sex, int age, int hjid) {
        personService.InsertPerson(sfz, name, sex, age, hjid);
        return "login";
    }

    @RequestMapping("/todeletePerson")
    public String todeletePerson() {
        return "Person/deletePerson";
    }

    @RequestMapping("/deletePerson")
    public String DeletePerson(String sfz, String name, Model model) {
        if (personService.select(sfz) != null) {
            PersonBean p1 = personService.select(sfz);
            if (p1.getName().equals(name) && p1.getSfz().equals(sfz)) {
                personService.DeletePerson(sfz, name);
                model.addAttribute("msg", "删除成功");
            } else {
                model.addAttribute("msg", "删除失败");
            }
        } else {
            model.addAttribute("msg", "个人信息不存在");
        }

        return "Person/deletePerson";
    }

    @RequestMapping("/tofindallpersonbyhj")
    public String tofindallpersonbyhj() {
        return "hj/findallpersonbyhj";
    }

    @RequestMapping(value = "/findallperson", method = RequestMethod.POST)
    public String finallperson(String id, Model model) {
        List<PersonBean> persons = personService.FindAllPersonByHj(id);
        HjBean p2 = hjService.findByid(id);
        if (persons.size() > 0 && p2 != null) {
            model.addAttribute("hj", p2);
            for (PersonBean p1 : persons) {
                System.out.println(p1);
                if (p1.getSfz().equals(p2.getSfz())) {
                    model.addAttribute("hzname", p1.getName());
                    System.out.println(p1.getName());
                }
            }
            model.addAttribute("persons", persons);
            return "hj/findallpersonjg";
        } else {
            model.addAttribute("msg", "错误");
            System.out.println("不存在此户籍的人");
            return "hj/findallpersonbyhj";
        }
    }

    @RequestMapping(value = "/toAllPerson")
    public String findperson(Model model) {
        List<PersonBean> personBeans = personService.FindAllPerson();
        model.addAttribute("personBeans", personBeans);
        return "Person/AllPerson";
    }
}
