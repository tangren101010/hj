package com.example.test.controller;

import com.example.test.bean.HjBean;
import com.example.test.service.HjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HjController {
    @Autowired
    HjService hjService;

    @RequestMapping("/tohj")
    public String tohj() {
        return "hj/hjcx";
    }

    //通过户籍ID进行户籍的查询，显示户籍的信息
    @RequestMapping("/findHjBysfz")
    public String hj(String id, Model model) {
        HjBean hjBeans = hjService.findByid(id);
        System.out.println(hjBeans);
        if (hjBeans != null) {
            model.addAttribute("hjBeans", hjBeans);
            return "hj/hjcxjg";
        } else {
            model.addAttribute("msg", "查询失败");
            return "hj/hjcx";
        }
    }

    @RequestMapping(value = "/zxhj")
    public String show() {
        return "hj/hjzx";
    }

    //删除户籍表里的户籍信息，并且将删除记录以及删除户籍的原因存入户籍注销表中
    @RequestMapping(value = "/hjzx", method = RequestMethod.POST)
    public String hjzx(String id, String zxyy, String sfz, Model model) {
        HjBean hjBean = hjService.findByid(id);
        //判断户籍存在并且户籍注销信息不存在才可以进行删除户籍的操作
        if (hjBean != null && hjService.findzx(id) == null) {
            hjService.delete(id);
            hjService.InsertDeleteHj(id, zxyy, sfz);
            model.addAttribute("msg", "删除成功");
            return "login";
        } else {
            System.out.println("删除失败");
            model.addAttribute("msg", "删除失败");
            return "hj/hjzx";
        }
    }

    //插入户籍
    @RequestMapping(value = "/toInsertHj")
    public String toInsertHj() {
        return "hj/inserthj";
    }

    @RequestMapping(value = "/InsertHj", method = RequestMethod.POST)
    public String InsertHj(String id, String hj, String sfz, Model model) {
        //在插入户籍之前，需要判断要插入的户籍id和身份证都不存在,否则报错
        if (hjService.findByid(id) == null && hjService.findHjBysfz(sfz) == null) {
            hjService.InsertHj(id, hj, sfz);
            return "hj/inserthj";
        } else {
            System.out.println("插入失败");
            model.addAttribute("msg", "插入失败");
            return "hj/inserthj";
        }
    }

    @RequestMapping(value = "/toallzx")
    public String findallzx(Model model) {
        List<HjBean> zxBeans = hjService.findallzx();
        if (zxBeans.size() < 1) {
            model.addAttribute("msg", "错误");
        } else {
            model.addAttribute("zxBeans", zxBeans);
        }
        System.out.println(zxBeans);
        return "hj/hjzxyy";
    }

    @RequestMapping(value = "/toallhj")
    public String findallhj(Model model) {
        List<HjBean> hjBeans = hjService.findallhj();
        if (hjBeans.size() < 1) {
            model.addAttribute("msg", "错误");
        } else {
            model.addAttribute("hjBeans", hjBeans);
        }
        System.out.println(hjBeans);
        return "hj/findallhj";
    }
}
