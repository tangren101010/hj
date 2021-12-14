package com.example.test.serviceImpl;

import com.example.test.bean.HjBean;
import com.example.test.mapper.HjMapper;
import com.example.test.service.HjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HjServiceImpl implements HjService {

    @Autowired
    private HjMapper hjMapper;

    @Override
    public HjBean findHjBysfz(String sfz) {
        return hjMapper.findBysfz(sfz);
    }

    @Override
    public boolean InsertDeleteHj(String id, String zxyy, String sfz) {
        if (hjMapper.InsertDeleteHj(id, zxyy, sfz)) {
            return true;
        } else return false;
    }

    @Override
    public boolean delete(String id) {
        hjMapper.delete(id);
        return true;
    }

    @Override
    public HjBean findByid(String id) {
        return hjMapper.findByid(id);
    }

    @Override
    public HjBean findzx(String id) {
        return hjMapper.findzx(id);
    }

    @Override
    public boolean InsertHj(String id, String hj, String sfz) {
        return hjMapper.InsertHj(id, hj, sfz);
    }

    @Override
    public List<HjBean> findallzx() {
        return hjMapper.findallzx();
    }

    @Override
    public List<HjBean> findallhj() {
        return hjMapper.findallhj();
    }
}
