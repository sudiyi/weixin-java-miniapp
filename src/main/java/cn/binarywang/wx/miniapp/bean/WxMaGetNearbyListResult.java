package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 附近的小程序，查看地点列表
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.getList.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaGetNearbyListResult implements Serializable{

	private static final long serialVersionUID = 3766858427545159361L;

	public class NearbyListData implements Serializable{

		private static final long serialVersionUID = -9095652531745190503L;
		
		/**
		 * 剩余可添加地点个数
		 */
		@SerializedName("left_apply_num")
		private Integer leftApplyNum;
		
		/**
		 * 最大可添加地点个数
		 */
		@SerializedName("max_apply_num")
		private Integer maxApplyNum;
	}
	
	@Data
	public class NearbyListDataDetail implements Serializable{

		private static final long serialVersionUID = -4269110686966927280L;
		
		/**
		 * 附近地点 ID
		 */
		@SerializedName("poi_id")
		private String poiId;
		
		/**
		 * 资质证件地址
		 */
		@SerializedName("qualification_address")
		private String qualificationAddress;
		
		/**
		 * 资质证件证件号
		 */
		@SerializedName("qualification_num")
		private String qualificationNum;
		
		/**
		 * 地点审核状态
		 */
		@SerializedName("audit_status")
		private String auditStatus;
		
		/**
		 * 地点展示在附近状态
		 */
		@SerializedName("display_status")
		private String displayStatus;
		
		/**
		 * 审核失败原因，audit_status=4 时返回
		 */
		@SerializedName("refuse_reason")
		private String refuseReason;
	}
	
	public static WxMaGetNearbyListResult fromJson(String json) {
	    return WxMaGsonBuilder.create().fromJson(json, WxMaGetNearbyListResult.class);
	}
}
