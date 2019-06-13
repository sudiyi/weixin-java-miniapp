package cn.binarywang.wx.miniapp.constant;

/**
 * <pre>
 *  小程序常量.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaConstants {
  /**
   * 微信接口返回的参数errcode.
   */
  public static final String ERRCODE = "errcode";

  /**
   * 素材类型.
   */
  public static class MediaType {
    /**
     * 图片.
     */
    public static final String IMAGE = "image";
  }

  /**
   * 消息格式.
   */
  public static class MsgDataFormat {
    public static final String XML = "XML";
    public static final String JSON = "JSON";
  }

  /**
   * 客服消息的消息类型.
   */
  public static class KefuMsgType {
    /**
     * 文本消息.
     */
    public static final String TEXT = "text";
    /**
     * 图片消息.
     */
    public static final String IMAGE = "image";
    /**
     * 图文链接.
     */
    public static final String LINK = "link";
    /**
     * 小程序卡片消息.
     */
    public static final String MA_PAGE = "miniprogrampage";
  }

  public static final class ErrorCode {
    /**
     * 40001 获取access_token时AppSecret错误，或者access_token无效.
     */
    public static final int ERR_40001 = 40001;

    /**
     * 42001 access_token超时.
     */
    public static final int ERR_42001 = 42001;

    /**
     * 40014 不合法的access_token，请开发者认真比对access_token的有效性（如是否过期）.
     */
    public static final int ERR_40014 = 40014;
  }
  
  /**
   * 微信小程序回调事件类型常量
   * @author yangtao
   * @date 2019/06/13
   */
  public static class WxMaEventType{
	  
	  /**
	   * 审核状态通过事件推送通知，推送数据格式为 XML
	   */
	  public static final String ADD_NEARBY_POI_AUDIT_INFO = "add_nearby_poi_audit_info";
  
	  /**
	   * 异步校验图片/音频通知结果，json数据包
	   */
	  public static final String WXA_DEDIA_CHECK = "wxa_media_check";
  
	  /**
	   * 运单轨迹更新事件
	   */
	  public static final String ADD_EXPRESS_PATH = "add_express_path";
  
	  /**
	   * 请求下单事件
	   */
	  public static final String ADD_WAYBILL = "add_waybill";
  
	  /**
	   * 取消订单事件
	   */
	  public static final String CANCEL_WAYBILL = "cancel_waybill";
  
	  /**
	   * 审核商户事件
	   */
	  public static final String CHECK_BIZ = "check_biz";
	  
	  /**
	   * 查询商户余额事件
	   */
	  public static final String GET_QUOTA = "get_quota";
  }
}
