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
 * 查询商户余额事件返回消息
 * @author yangtao
 * @date 2019/06/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaOnGetQuotaResponse implements Serializable{

	private static final long serialVersionUID = 3223816411944330329L;

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
	
	@SerializedName("BizID")
	@XStreamAlias("BizID")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String bizID;
	
	@SerializedName("ResultCode")
	@XStreamAlias("ResultCode")
	private Integer resultCode;
	
	@SerializedName("ResultMsg")
	@XStreamAlias("ResultMsg")
	@XStreamConverter(value = XStreamCDataConverter.class)
	private String resultMsg;
	
	@SerializedName("Quota")
	@XStreamAlias("Quota")
	private Float quota;
}
