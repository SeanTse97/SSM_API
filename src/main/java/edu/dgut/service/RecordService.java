package edu.dgut.service;

import edu.dgut.domain.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordService {
    //获取申请记录信息
    public List<Record> getRecordList(int start, int limit, String aid,String uid,String status);

    public Integer getRecordCount(String aid,String uid,String status);

    public Record getRecordById(String aid);

    public int updateRecord(Record record);

    public int deleteRecord(String aid);
}
