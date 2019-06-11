package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 取消运单
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.cancelOrder.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtCancelOrderRequest implements Serializable{

	private static final long serialVersionUID = 2892218012439049958L;

	/**
	 * 订单 ID，需保证全局唯一
	 */
	@SerializedName("order_id")
	private String orderId;
	
	/**
	 * 用户 openid
	 */
	private String openid;
	
	/**
	 * 快递公司ID，参见getAllDelivery
	 */
	@SerializedName("delivery_id")
	private String deliveryId;
	
	/**
	 * 运单id
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
