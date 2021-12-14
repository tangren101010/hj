package com.example.test.service;

import com.example.test.bean.HjBean;

import java.util.List;

public interface HjService {
    HjBean findHjBysfz(String sfz);

    boolean InsertDeleteHj(String id, String zxyy, String sfz);

    boolean delete(String id);

    HjBean findByid(String id);

    HjBean findzx(String id);

    boolean InsertHj(String id, String hj, String sfz);

    List<HjBean> findallzx();

    List<HjBean> findallhj();
}
