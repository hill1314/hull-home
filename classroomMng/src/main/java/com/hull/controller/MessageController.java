package com.hull.controller;

import com.hull.dto.RespDto;
import com.hull.entity.MessageInfo;
import com.hull.service.MessageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 消息通知
 *
 * @author
 * @create 2018-04-05 上午5:42
 **/

@RestController
@RequestMapping("message")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 创建消息
     * @param messageInfo
     * @return
     */
    @RequestMapping("createMsg")
    public RespDto<MessageInfo> create(@RequestBody MessageInfo messageInfo){
        int n = messageService.createMessage(messageInfo);
        if(n==0){
            return RespDto.error("创建消息失败");
        }
        return RespDto.success(messageInfo);
    }

    /**
     * 发送消息
     * @param messageId
     * @return
     */
    @RequestMapping("/sendMsg/{messageId}")
    public RespDto<Map<String,Object>> approve(@PathVariable Integer messageId){
        if(messageId==null){
            return RespDto.error("主键为空");
        }
        int n = messageService.sendMessage(messageId);
        if(n==0){
            return RespDto.error("发送失败");
        }
        return RespDto.success();
    }

    /**
     * 查询消息明细
     * @param messageInfo
     * @return
     */
    @RequestMapping("queryList")
    public RespDto<List<MessageInfo>> query(@RequestBody MessageInfo messageInfo){
        List<MessageInfo> list = messageService.query(messageInfo);
        return RespDto.success(list);
    }
}
