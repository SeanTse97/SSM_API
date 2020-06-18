package edu.dgut.service;

import edu.dgut.domain.Mask;
import edu.dgut.domain.Mask2;

import java.util.List;


public interface MaskService {

    //获取口罩入库信息
    public List<Mask> getMaskRecordList( int start, int limit, String maskName);

    //保存口罩信息
    public int saveMask(Mask mk);

    //更新口罩信息
    public int updateMaskInfo(Mask mk);

    //删除口罩信息
    public int deleteMaskInfo(String id);

    //获取口罩库存信息
    public List<Mask2> getMaskStore(String name);

    //修改口罩库存
    public int updateMaskStore(String maskName, long editTime,int maskNo,String imageUrl);

    //插入库存信息
    public int saveMaskStockInfo(Mask2 mk);

    //获取入库信息数量
    public int getMRCount(String name);


}
