package com.javen.course.message.req;

/**
 * 请求消息之文本消息
 * Created by maxh on 2017-04-09.
 */

public class TextMessage extends BaseMessage {

    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}