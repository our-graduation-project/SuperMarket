package com.mxz.supermarket.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mxz.supermarket.utils.LogUtils;
import com.mxz.supermarket.utils.SendMail;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author whg
 * @date 2019/12/12 20:13
 **/
@Component
public class HandlerRegisterCodeQueue {

    @RabbitHandler
    @RabbitListener(queues = "supermarket_sent_email")
    public void handle(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        JSONObject jsonObject = JSON.parseObject(s);
        StringBuffer sb = new StringBuffer();
        System.out.println("发送验证码！！");
        sb.append("这是超市管理系统发送的验证码：" + jsonObject.get("code") + "</br>5分钟后到期");
        SendMail.sendMail("验证码", sb.toString(),jsonObject.get("mailbox").toString());
        System.out.println("发送验证码22！！");
        LogUtils.getTimeOutTaskLogger().info("对" + jsonObject.get("name") + "发送了注册码");
    }
}
