package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 生成运单
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.addOrder.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtAddOrderResult implements Serializable{

	private static final long serialVersionUID = -4413917673998398885L;

	/**
	 * 订单ID，下单成功时返回
	 */
	@SerializedName("order_id")
	private String orderId;
	
	/**
	 * 运单ID，下单成功时返回
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	/**
	 * 运单信息，下单成功时返回
	 */
	@SerializedName("waybill_data")
	private String waybillData;
	
	/**
	 * 微信侧错误码，下单失败时返回
	 */
	private String errcode;
	
	/**
	 * 微信侧错误信息，下单失败时返回
	 */
	private String errmsg;
	
	/**
	 * 快递侧错误码，下单失败时返回
	 */
	@SerializedName("delivery_resultcode")
	private String deliveryResultcode;
	
	/**
	 * 快递侧错误信息，下单失败时返回
	 */
	@SerializedName("delivery_resultmsg")
	private String deliveryResultmsg;
	
	@Data
	public class LgtAddOrderWaybillData implements Serializable{

		private static final long serialVersionUID = 1206970574695721541L;
		
		/**
		 * 运单信息 key
		 */
		private String key;
		
		/**
		 * 运单信息 value
		 */
		private String value;
	}
	
	public static WxMaLgtAddOrderResult fromJson(String json){
		return WxMaGsonBuilder.create().fromJson(json, WxMaLgtAddOrderResult.class);
	}
}
