package com.example.test.mapper;

import com.example.test.bean.HjBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HjMapper {
    HjBean findBysfz(String sfz);

    boolean InsertDeleteHj(String id, String zxyy, String sfz);

    boolean delete(String id);

    HjBean findByid(String id);

    HjBean findzx(String id);

    boolean InsertHj(String id, String hj, String sfz);

    List<HjBean> findallzx();

    List<HjBean> findallhj();
}
