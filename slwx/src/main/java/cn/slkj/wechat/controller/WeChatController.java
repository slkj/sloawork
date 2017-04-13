package cn.slkj.wechat.controller;

import cn.slkj.wechat.dispatcher.EventDispatcher;
import cn.slkj.wechat.dispatcher.MsgDispatcher;
import cn.slkj.wechat.util.MessageUtil;
import cn.slkj.wechat.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 微信核心 web 入口
 * Created by maxh on 2017-04-10.
 */

@Controller
@RequestMapping("/wechat")
public class WeChatController {
    private Logger logger = Logger.getLogger(WeChatController.class);

    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("hello world");
        return "success";
    }

    @RequestMapping(value = {"/coreJoin"}, method = RequestMethod.GET)
    public void coreJoinGet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                logger.info("这里存在非法请求！");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }




    @RequestMapping(value = "coreJoin", method = RequestMethod.POST)
    // post方法用于接收微信服务端消息
    public void coreJoinPost(HttpServletRequest request,HttpServletResponse response) {
        try{
            Map<String, String> map=MessageUtil.parseXml(request);
            String msgtype=map.get("MsgType");
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
                EventDispatcher.processEvent(map); //进入事件处理
            }else{
                MsgDispatcher.processMessage(map); //进入消息处理
            }
        }catch(Exception e){
            logger.error(e,e);
        }
    }
}