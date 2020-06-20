package edu.dgut.service.impl;

import edu.dgut.domain.Record;
import edu.dgut.mapper.RecordMapper;
import edu.dgut.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;
    @Override
    public List<Record> getRecordList(int start, int limit, String aid, String uid, String status) {
        return recordMapper.getRecordList(start,limit,aid,uid,status);
    }

    @Override
    public Integer getRecordCount(String aid, String uid, String status) {
        return recordMapper.getRecordCount(aid,uid,status);
    }

    @Override
    public Record getRecordById(String aid) {
        return recordMapper.getRecordById(aid);
    }

    @Override
    public int updateRecord(Record record) {
        return recordMapper.updateRecord(record);
    }

    @Override
    public int deleteRecord(String aid) {
        return recordMapper.deleteRecord(aid);
    }
}
