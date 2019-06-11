package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 查询运单轨迹
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getPath.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtGetPathRequest implements Serializable{

	private static final long serialVersionUID = 2039173361860431497L;

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
	 * 运单ID
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
