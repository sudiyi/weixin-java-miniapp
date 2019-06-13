package cn.binarywang.wx.miniapp.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;

import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import cn.binarywang.wx.miniapp.util.xml.XStreamTransformer;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@XStreamAlias("xml")
@Data
public class WxMaMessage implements Serializable {
  private static final long serialVersionUID = -3586245291677274914L;

  @SerializedName("Encrypt")
  @XStreamAlias("Encrypt")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String encrypt;

  @SerializedName("ToUserName")
  @XStreamAlias("ToUserName")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String toUser;

  @SerializedName("FromUserName")
  @XStreamAlias("FromUserName")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String fromUser;

  @SerializedName("CreateTime")
  @XStreamAlias("CreateTime")
  private Integer createTime;

  @SerializedName("MsgType")
  @XStreamAlias("MsgType")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String msgType;

  @SerializedName("MsgDataFormat")
  @XStreamAlias("MsgDataFormat")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String msgDataFormat;

  @SerializedName("Content")
  @XStreamAlias("Content")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String content;

  @SerializedName("MsgId")
  @XStreamAlias("MsgId")
  private Long msgId;

  @SerializedName("PicUrl")
  @XStreamAlias("PicUrl")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String picUrl;

  @SerializedName("MediaId")
  @XStreamAlias("MediaId")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String mediaId;

  @SerializedName("Event")
  @XStreamAlias("Event")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String event;

  @SerializedName("Title")
  @XStreamAlias("Title")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String title;

  @SerializedName("AppId")
  @XStreamAlias("AppId")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String appId;

  @SerializedName("PagePath")
  @XStreamAlias("PagePath")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String pagePath;

  @SerializedName("ThumbUrl")
  @XStreamAlias("ThumbUrl")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String thumbUrl;

  @SerializedName("ThumbMediaId")
  @XStreamAlias("ThumbMediaId")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String thumbMediaId;

  @SerializedName("SessionFrom")
  @XStreamAlias("SessionFrom")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String sessionFrom;

  //附近的小程序add回调
  
  /**
   * 审核单id
   */
  @SerializedName("audit_id")
  @XStreamAlias("audit_id")
  private String auditId;
  
  /**
   * 审核状态
   */
  private String status;
  
  /**
   * 如果status为2，会返回审核失败的原因
   */
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String reason;
  
  @XStreamAlias("poi_id")
  @SerializedName("poi_id")
  private String poiId;
  
  //内容安全：媒体文件异步检测回调
  
  /**
   * 检测结果，0：暂未检测到风险，1：风险
   */
  private Integer isrisky;
  
  /**
   * 附加信息，默认为空
   */
  @XStreamAlias("extra_info_json")
  @SerializedName("extra_info_json")
  private String extraInfoJson;
  
  /**
   * 任务id
   */
  @XStreamAlias("trace_id")
  @SerializedName("trace_id")
  private String traceId;
  
  /**
   * 默认为：0，4294966288(-1008)为链接无法下载
   */
  @SerializedName("status_code")
  @XStreamAlias("status_code")
  private Integer statusCode;
  
  //物流助手回调信息
  
  /**
   * 快递公司ID
   */
  @SerializedName("DeliveryID")
  @XStreamAlias("DeliveryID")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String deliveryId;
  
  /**
   * 运单id
   */
  @SerializedName("WayBillID")
  @XStreamAlias("WayBillID")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String wayBillId;
  
  /**
   * 轨迹版本号（整型）
   */
  @SerializedName("Version")
  @XStreamAlias("Version")
  private Integer version;
  
  /**
   * 轨迹节点数（整型）
   */
  @SerializedName("Count")
  @XStreamAlias("Count")
  private Integer count;
  
  /**
   * 轨迹列表
   */
  @SerializedName("Actions")
  @XStreamAlias("Actions")
  private List<OnPathUpdateActions> actions;
  
  /**
   * 订单 Token。请保存该 Token，调用logistics.updatePath时需要传入
   */
  @SerializedName("Token")
  @XStreamAlias("Token")
  private String token;
  
  /**
   * 唯一标识订单的 ID，由商户生成。快递需要保证相同的 OrderID 生成相同的运单ID
   */
  @SerializedName("OrderID")
  @XStreamAlias("OrderID")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String orderID;
  
  /**
   * 商户 ID，即商户在快递注册的客户编码或月结账户名
   */
  @XStreamAlias("BizID")
  @SerializedName("BizID")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String bizId;
  
  /**
   * 商户的小程序 AppID
   */
  @XStreamAlias("ShopAppID")
  @SerializedName("ShopAppID")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String shopAppId;
  
  /**
   * BizID 对应的密码
   */
  @XStreamAlias("BizPwd")
  @SerializedName("BizPwd")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String bizPwd;
  
  /**
   * 快递备注，会打印到面单上，比如"易碎物品"
   */
  @XStreamAlias("Remark")
  @SerializedName("Remark")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String remark;
  
  /**
   * 寄件人信息
   */
  @XStreamAlias("Sender")
  @SerializedName("Sender")
  private List<OnAddOrderUser> sender;
  
  /**
   * 收件人信息
   */
  @XStreamAlias("Receiver")
  @SerializedName("Receiver")
  private List<OnAddOrderUser> receiver;
  
  /**
   * 包裹信息
   */
  @XStreamAlias("Cargo")
  @SerializedName("Cargo")
  private List<OnAddOrderCargo> cargo;
  
  /**
   * 保价信息
   */
  @SerializedName("Insured")
  @XStreamAlias("Insured")
  private List<OnAddOrderInsured> insured;
  
  /**
   * 服务类型
   */
  @SerializedName("Service")
  @XStreamAlias("Service")
  private List<OnAddOrderService> service;
  
  /**
   * 商户名称，即小程序昵称（仅EMS可用）
   */
  @SerializedName("ShopName")
  @XStreamAlias("ShopName")
  private String shopName;
  
  /**
   * 商户联系电话（仅EMS可用）
   */
  @SerializedName("ShopTelphone")
  @XStreamAlias("ShopTelphone")
  private String shopTelphone;
  
  /**
   * 商户联系人姓名（仅EMS可用）
   */
  @SerializedName("ShopContact")
  @XStreamAlias("ShopContact")
  private String shopContact;
  
  /**
   * 预开通的服务类型名称（仅EMS可用）
   */
  @SerializedName("ServiceName")
  @XStreamAlias("ServiceName")
  private String serviceName;
  
  /**
   * 商户发货地址（仅EMS可用）
   */
  @SerializedName("SenderAddress")
  @XStreamAlias("SenderAddress")
  private String senderAddress;
  
  public static WxMaMessage fromXml(String xml) {
    return XStreamTransformer.fromXml(WxMaMessage.class, xml);
  }

  public static WxMaMessage fromXml(InputStream is) {
    return XStreamTransformer.fromXml(WxMaMessage.class, is);
  }

  /**
   * 从加密字符串转换.
   *
   * @param encryptedXml 密文
   * @param wxMaConfig   配置存储器对象
   * @param timestamp    时间戳
   * @param nonce        随机串
   * @param msgSignature 签名串
   */
  public static WxMaMessage fromEncryptedXml(String encryptedXml,
                                             WxMaConfig wxMaConfig, String timestamp, String nonce,
                                             String msgSignature) {
    String plainText = new WxMaCryptUtils(wxMaConfig).decrypt(msgSignature, timestamp, nonce, encryptedXml);
    return fromXml(plainText);
  }

  public static WxMaMessage fromEncryptedXml(InputStream is, WxMaConfig wxMaConfig, String timestamp,
                                             String nonce, String msgSignature) {
    try {
      return fromEncryptedXml(IOUtils.toString(is, StandardCharsets.UTF_8), wxMaConfig,
        timestamp, nonce, msgSignature);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static WxMaMessage fromJson(String json) {
    return WxMaGsonBuilder.create().fromJson(json, WxMaMessage.class);
  }

  public static WxMaMessage fromEncryptedJson(String encryptedJson, WxMaConfig config) {
    try {
      WxMaMessage encryptedMessage = fromJson(encryptedJson);
      String plainText = new WxMaCryptUtils(config).decrypt(encryptedMessage.getEncrypt());
      return fromJson(plainText);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static WxMaMessage fromEncryptedJson(InputStream inputStream, WxMaConfig config) {
    try {
      return fromEncryptedJson(IOUtils.toString(inputStream, StandardCharsets.UTF_8), config);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return this.toJson();
  }

  public String toJson() {
    return WxMaGsonBuilder.create().toJson(this);
  }

  public class OnPathUpdateActions{
	  
	  /**
	   * 轨迹节点 Unix 时间戳
	   */
	  @SerializedName("ActionTime")
	  @XStreamAlias("ActionTime")
	  private Integer actionTime;
	  
	  /**
	   * 轨迹节点类型
	   * 100001	揽件阶段-揽件成功	
	   * 100002	揽件阶段-揽件失败	
	   * 100003	揽件阶段-分配业务员	
	   * 200001	运输阶段-更新运输轨迹	
	   * 300002	派送阶段-开始派送	
	   * 300003	派送阶段-签收成功	
	   * 300004	派送阶段-签收失败	
	   * 400001	异常阶段-订单取消	
	   * 400002	异常阶段-订单滞留
	   */
	  @SerializedName("ActionType")
	  @XStreamAlias("ActionType")
	  private Integer actionType;
	  
	  /**
	   * 轨迹节点详情
	   */
	  @XStreamAlias("ActionMsg")
	  @SerializedName("ActionMsg")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String actionMsg;
  }
  
  /**
   * 收寄件人信息
   * @author yangtao
   * @date 2019/06/13
   */
  @Data
  public class OnAddOrderUser{
	  
	  /**
	   * 收件人姓名
	   */
	  @XStreamAlias("Name")
	  @SerializedName("Name")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String name;
	  
	  /**
	   * 收件人座机号码
	   */
	  @XStreamAlias("Tel")
	  @SerializedName("Tel")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String tel;
	  
	  /**
	   * 收件人手机号码
	   */
	  @XStreamAlias("Mobile")
	  @SerializedName("Mobile")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String mobile;
	  
	  /**
	   * 收件人公司名
	   */
	  @XStreamAlias("Company")
	  @SerializedName("Company")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String company;
	  
	  /**
	   * 收件人邮编
	   */
	  @XStreamAlias("PostCode")
	  @SerializedName("PostCode")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String postCode;
	  
	  /**
	   * 收件人所在国家，默认为"中国"
	   */
	  @XStreamAlias("Country")
	  @SerializedName("Country")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String country;
	  
	  /**
	   * 收件人省份，比如"广东省"
	   */
	  @XStreamAlias("Province")
	  @SerializedName("Province")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String province;
	  
	  /**
	   * 收件人地区/市，比如"广州市"
	   */
	  @XStreamAlias("City")
	  @SerializedName("City")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String city;
	  
	  /**
	   * 收件人区/县，比如"海珠区"
	   */
	  @XStreamAlias("Area")
	  @SerializedName("Area")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String area;
	  
	  /**
	   * 收件人详细地址，比如"XX路XX号XX大厦XX"
	   */
	  @XStreamAlias("Address")
	  @SerializedName("Address")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String address;
  }
  
  @Data
  public class OnAddOrderCargo{
	  
	  /**
	   * 货物总重量，比如1.2，单位是千克(kg)
	   */
	  @SerializedName("Weight")
	  @XStreamAlias("Weight")
	  private Integer weight;
	  
	  /**
	   * 货物长度，比如20.5，单位是厘米(cm)
	   */
	  @SerializedName("Space_X")
	  @XStreamAlias("Space_X")
	  private Integer spaceX;
	  
	  /**
	   * 货物宽度，比如15.0，单位是厘米(cm)
	   */
	  @SerializedName("Space_Y")
	  @XStreamAlias("Space_Y")
	  private Integer spaceY;
	  
	  /**
	   * 货物高度，比如10.0，单位是厘米(cm)
	   */
	  @SerializedName("Space_Z")
	  @XStreamAlias("Space_Z")
	  private Integer spaceZ;
	  
	  /**
	   * 货物数量，一般为1
	   */
	  @SerializedName("Count")
	  @XStreamAlias("Count")
	  private Integer count;
	  
	  /**
	   * 商品信息
	   */
	  @SerializedName("DetailList")
	  @XStreamAlias("DetailList")
	  private List<OnAddOrderCargoDetail> detailList;
  }
  
  @Data
  public class OnAddOrderInsured{
	  
	  /**
	   * 是否保价，0 表示不保价，1 表示保价
	   */
	  @SerializedName("UseInsured")
	  @XStreamAlias("UseInsured")
	  private Integer useInsured;
	  
	  /**
	   * 保价金额，单位是分，比如: 10000 表示 100 元
	   */
	  @SerializedName("InsuredValue")
	  @XStreamAlias("InsuredValue")
	  private Integer insuredValue;
  }
  
  @Data
  public class OnAddOrderService{
	  
	  /**
	   * 服务类型ID，详见已经支持的快递公司基本信息
	   */
	  @SerializedName("ServiceType")
	  @XStreamAlias("ServiceType")
	  private Integer serviceType;
	  
	  /**
	   * 服务名称，详见已经支持的快递公司基本信息
	   */
	  @SerializedName("ServiceName")
	  @XStreamAlias("ServiceName")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String serviceName;
  }
  
  @Data
  public class OnAddOrderCargoDetail{
	  
	  /**
	   * 商品名称
	   */
	  @SerializedName("Name")
	  @XStreamAlias("Name")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  private String name;
	  
	  /**
	   * 商品数量
	   */
	  @SerializedName("Count")
	  @XStreamAlias("Count")
	  private Integer count;
  }
}
