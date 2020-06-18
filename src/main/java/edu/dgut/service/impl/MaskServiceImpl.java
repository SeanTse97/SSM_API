package edu.dgut.service.impl;

import edu.dgut.domain.Mask;
import edu.dgut.domain.Mask2;
import edu.dgut.mapper.MaskMapper;
import edu.dgut.service.MaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaskServiceImpl implements MaskService {

    @Autowired
    MaskMapper maskMapper;


    @Override
    public List<Mask> getMaskRecordList(int start, int limit, String maskName) {
        return maskMapper.getMaskRecordList(start,limit,maskName);
    }

    @Override
    public int saveMask(Mask mk) {
        return maskMapper.saveMask(mk);
    }

    @Override
    public int updateMaskInfo(Mask mk) {
        return maskMapper.updateMaskInfo(mk);
    }

    @Override
    public int deleteMaskInfo(String id) {
        return maskMapper.deleteMaskInfo(id);
    }

    @Override
    public List<Mask2> getMaskStore(String name) {
        return maskMapper.getMaskStore(name);
    }

    @Override
    public int updateMaskStore(String maskName, long editTime,int maskNo,String imageUrl) {
        return maskMapper.updateMaskStore(maskName,editTime,maskNo,imageUrl);
    }

    @Override
    public int saveMaskStockInfo(Mask2 mk) {
        return maskMapper.saveMaskStockInfo(mk);
    }

    @Override
    public int getMRCount(String name) {
        return maskMapper.getMRCount(name);
    }
}
