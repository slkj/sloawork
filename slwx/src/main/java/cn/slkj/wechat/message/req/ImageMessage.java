package cn.slkj.wechat.message.req;

/**
 * Created by maxh on 2017-04-10.
 */
/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 * @author dapengniao
 * @date 2016年3月7日 下午3:04:52
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}