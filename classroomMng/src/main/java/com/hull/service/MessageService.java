package com.hull.service;

import com.hull.entity.MessageInfo;
import com.hull.mapper.MessageInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息相关服务
 *
 * @author
 * @create 2018-04-05 上午6:26
 **/

@Service
public class MessageService {

    @Resource
    private MessageInfoMapper messageInfoMapper;

    public int createMessage(MessageInfo messageInfo) {
        return messageInfoMapper.add(messageInfo);
    }

    public int sendMessage(Integer messageId) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setId(messageId);
        messageInfo.setStatus("1");
        return messageInfoMapper.updateIgnoreNull(messageInfo);
    }

    public List<MessageInfo> query(MessageInfo messageInfo) {
        return messageInfoMapper.select(messageInfo);
    }
}
