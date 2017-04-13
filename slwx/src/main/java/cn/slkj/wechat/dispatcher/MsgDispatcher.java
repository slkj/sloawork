package cn.slkj.wechat.dispatcher;

/**
 * Created by maxh on 2017-04-10.
 */

import cn.slkj.wechat.message.req.TextMessage;
import cn.slkj.wechat.util.MessageUtil;
import com.javen.course.message.resp.Article;
import com.javen.course.message.resp.NewsMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * ClassName: MsgDispatcher
 *
 * @author dapengniao
 * @Description: 消息业务处理分发器
 * @date 2016年3月7日 下午4:04:21
 */
public class MsgDispatcher {
    public static String processMessage(Map<String, String> map) {
        String openid = map.get("FromUserName"); //用户openid
        String mpid = map.get("ToUserName");   //公众号原始ID

        //普通文本消息
        TextMessage txtmsg = new TextMessage();
        txtmsg.setToUserName(openid);
        txtmsg.setFromUserName(mpid);
        txtmsg.setCreateTime(new Date().getTime());
        txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            txtmsg.setContent("你好，这里是崔用志个人账号！");
            return MessageUtil.textMessageToXml(txtmsg);
        }
        //对图文消息
        NewsMessage newmsg = new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
            Article article = new Article();
            article.setDescription("这是图文消息1"); //图文消息的描述
            article.setPicUrl("http://res.cuiyongzhi.com/2016/03/201603086749_6850.png"); //图文消息图片地址
            article.setTitle("图文消息1");  //图文消息标题
            article.setUrl("http://www.cuiyongzhi.com");  //图文url链接
            List<Article> list = new ArrayList<Article>();
            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
            newmsg.setArticleCount(list.size());
            newmsg.setArticles(list);
            return MessageUtil.newsMessageToXml(newmsg);
        }
        return  null;
    }
}
