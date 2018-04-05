package com.hull.mapper;

import com.hull.common.BaseMapper;
import com.hull.entity.MessageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageInfoMapper extends BaseMapper<Integer,MessageInfo> {

    List<MessageInfo> select(MessageInfo messageInfo);
}