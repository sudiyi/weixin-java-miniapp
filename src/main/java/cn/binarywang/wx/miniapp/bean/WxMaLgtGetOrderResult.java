package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 获取运单数据
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getOrder.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtGetOrderResult implements Serializable{

	private static final long serialVersionUID = 1018382379313896319L;

	@SerializedName("print_html")
	private String printHtml;
	
	@SerializedName("waybill_data")
	private List<LgtGetOrderWaybillData> waybillData;
	
	@Data
	public class LgtGetOrderWaybillData implements Serializable{

		private static final long serialVersionUID = -3208772425983595172L;
		
		/**
		 * 运单信息 key
		 */
		private String key;
		
		/**
		 * 运单信息 value
		 */
		private String value;
	}
	
	public static WxMaLgtGetOrderResult fromJson(String json){
		return WxMaGsonBuilder.create().fromJson(json, WxMaLgtGetOrderResult.class);
	}
}
