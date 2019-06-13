package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

/**
 * 请求下单事件回调消息返回信息
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.onAddOrder.html
 * @author yangtao
 * @date 2019/06/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaOnAddOrderResponse implements Serializable{

	private static final long serialVersionUID = 6595474401049078099L;

	@SerializedName("ToUserName")
	@XStreamAlias("ToUserName")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String toUserName;
	
	@SerializedName("FromUserName")
	@XStreamAlias("FromUserName")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String fromUserName;
	
	@SerializedName("CreateTime")
	@XStreamAlias("CreateTime")
	private Integer createTime;
	
	@SerializedName("MsgType")
	@XStreamAlias("MsgType")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String msgType;
	
	@SerializedName("Event")
	@XStreamAlias("Event")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String event;
	
	@SerializedName("Token")
	@XStreamAlias("Token")
	private String token;
	
	@SerializedName("OrderID")
	@XStreamAlias("OrderID")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String orderID;
	
	@SerializedName("BizID")
	@XStreamAlias("BizID")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String bizID;
	
	@SerializedName("WayBillID")
	@XStreamAlias("WayBillID")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String wayBillID;
	
	@SerializedName("ResultCode")
	@XStreamAlias("ResultCode")
	private Integer resultCode;
	
	@SerializedName("ResultMsg")
	@XStreamAlias("ResultMsg")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String resultMsg;
	
	@SerializedName("WaybillData")
	@XStreamAlias("WaybillData")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String waybillData;
}
