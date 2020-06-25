package edu.dgut.mapper;

import edu.dgut.domain.Mask;
import edu.dgut.domain.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {
    public List<Record> getRecordList(@Param("start") int start, @Param("limit")int limit,
                                      @Param("applyId") String aid,@Param("userId") String uid,@Param("applyStatus") String status);

    public Integer getRecordCount(@Param("applyId") String aid,@Param("userId") String uid,@Param("applyStatus") String status);

    public Record getRecordById(@Param("applyId") String aid);

    public int updateRecord(Record record);

    public int deleteRecord(String aid);

    public int saveRecord(Record record);
}
