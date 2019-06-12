package cn.binarywang.wx.miniapp.api;

import cn.binarywang.wx.miniapp.bean.WxMaKefuMessage;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import cn.binarywang.wx.miniapp.bean.WxMaUniformMessage;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * <pre>
 * 消息发送接口
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public interface WxMaMsgService {
  String KEFU_MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
  String TEMPLATE_MSG_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send";
  String UNIFORM_MSG_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send";
  
  /**
   * 下发客服当前输入状态给用户
   */
  String CUSTOM_TYPING  = "https://api.weixin.qq.com/cgi-bin/message/custom/typing";

  /**
   * <pre>
   * 发送客服消息
   * 详情请见: <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/customerServiceMessage.send.html">发送客服消息</a>
   * 接口url格式：https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
   * </pre>
   */
  boolean sendKefuMsg(WxMaKefuMessage message) throws WxErrorException;

  /**
   * <pre>
   * 发送模板消息
   * 详情请见: <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/templateMessage.send.html">发送模板消息</a>
   * 接口url格式：https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN
   * </pre>
   */
  void sendTemplateMsg(WxMaTemplateMessage templateMessage) throws WxErrorException;


  /**
   * <pre>
   * 下发小程序和公众号统一的服务消息
   * 详情请见: <a href="https://developers.weixin.qq.com/miniprogram/dev/api/open-api/uniform-message/sendUniformMessage.html">下发小程序和公众号统一的服务消息</a>
   * 接口url格式：https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send?access_token=ACCESS_TOKEN
   * </pre>
   */
  void sendUniformMsg(WxMaUniformMessage uniformMessage) throws WxErrorException;
  
  /**
   * <pre>
   * 下发客服当前输入状态给用户
   * methods:POST
   * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/customer-message/customerServiceMessage.setTyping.html
   * </pre>
   * @param touser 用户openid
   * @param command 命令（Typing	：对用户下发"正在输入"状态；CancelTyping：取消对用户的"正在输入"状态）
   * @throws WxErrorException
   */
  void customTyping(String touser, String command) throws WxErrorException;
  
  
}
