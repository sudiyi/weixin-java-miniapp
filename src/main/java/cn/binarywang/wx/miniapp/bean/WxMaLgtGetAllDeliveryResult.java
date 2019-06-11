package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 获取支持的快递公司列表
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getAllDelivery.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtGetAllDeliveryResult implements Serializable{

	private static final long serialVersionUID = -4754671095969160461L;

	/**
	 * 快递公司数量
	 */
	private Integer count;
	
	/**
	 * 快递公司信息列表
	 */
	private List<LgtGetAllDeliveryInfo> data;
	
	@Data
	public class LgtGetAllDeliveryInfo implements Serializable{

		private static final long serialVersionUID = -3081223642209940961L;
		
		/**
		 * 快递公司 ID
		 */
		@SerializedName("delivery_id")
		private String deliveryId;
		
		/**
		 * 快递公司名称
		 */
		@SerializedName("delivery_name")
		private String deliveryName;
	}
	
	public static WxMaLgtGetAllDeliveryResult fromJson(String json){
		return WxMaGsonBuilder.create().fromJson(json, WxMaLgtGetAllDeliveryResult.class);
	}
}
