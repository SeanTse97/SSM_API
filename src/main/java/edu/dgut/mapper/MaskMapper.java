package edu.dgut.mapper;

import edu.dgut.domain.Mask;
import edu.dgut.domain.Mask2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaskMapper {

    //获取口罩入库信息
    public List<Mask> getMaskRecordList(@Param("start") int start, @Param("limit")int limit, @Param("maskName")String maskName);


    //保存口罩信息
    public int saveMask(Mask mk);

    //更新口罩信息
    public int updateMaskInfo(Mask mk);

    //删除口罩信息
    public int deleteMaskInfo(String id);

    //获取口罩库存信息
    public List<Mask2> getMaskStore(String name);

    //修改口罩库存
    public int updateMaskStore(@Param("maskName")String maskName,@Param("editTime") long editTime,@Param("maskNo") int maskNo,@Param("imageUrl") String imageUrl);

    //插入库存信息
    public int saveMaskStockInfo(Mask2 mk);

    //获取入库信息数量
    public int getMRCount(String name);

}
