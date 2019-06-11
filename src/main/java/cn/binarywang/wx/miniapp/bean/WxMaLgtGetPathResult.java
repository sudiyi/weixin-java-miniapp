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
public class WxMaLgtGetPathResult implements Serializable{

	private static final long serialVersionUID = 4045632785503403878L;

	/**
	 * 用户openid
	 */
	private String openid;
	
	/**
	 * 快递公司 ID
	 */
	@SerializedName("delivery_id")
	private String deliveryId;
	
	/**
	 * 运单 ID
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	/**
	 * 轨迹节点数量
	 */
	@SerializedName("path_item_num")
	private String pathItemNum;

	@Data
	public class GetPathIetmList implements Serializable{
		
		private static final long serialVersionUID = -1831144237400978608L;

		/**
		 * 轨迹节点 Unix 时间戳
		 */
		@SerializedName("action_time")
		private String actionTime;
		
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
		@SerializedName("action_type")
		private String actionType;
		
		/**
		 * 轨迹节点详情
		 */
		@SerializedName("action_msg")
		private String actionMsg;
	}
	
	public static WxMaLgtGetPathResult fromJson(String json){
		return WxMaGsonBuilder.create().fromJson(json, WxMaLgtGetPathResult.class);
	}
}
