package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 附近的小程序，添加地点
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.add.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaAddNearbyResult implements Serializable{

	private static final long serialVersionUID = 77233737463352376L;

	/**
	 * 返回数据
	 */
	private NearbyData data;
	
	@Data
	public class NearbyData implements Serializable{

		private static final long serialVersionUID = -6631333175416399723L;
		
		/**
		 * 审核单 ID
		 */
		@SerializedName("audit_id")
		private String auditId;
		
		/**
		 * 附近地点 ID
		 */
		@SerializedName("poi_id")
		private String poiId;
		
		/**
		 * 经营资质证件号
		 */
		@SerializedName("related_credential")
		private String relatedCredential;
	}
	
	
	public static WxMaAddNearbyResult fromJson(String json) {
	    return WxMaGsonBuilder.create().fromJson(json, WxMaAddNearbyResult.class);
	}
}
