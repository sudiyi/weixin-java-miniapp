package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 更新运单轨迹
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.updatePath.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtUpdatePathRequest implements Serializable{

	private static final long serialVersionUID = -6099229829130797808L;
	
	/**
	 * 商户侧下单事件中推送的 Token 字段
	 */
	private String token;
	
	/**
	 * 运单 ID
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	/**
	 * 轨迹变化 Unix 时间戳
	 */
	@SerializedName("action_time")
	private String actionTime;
	
	/**
	 * 轨迹变化类型
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
	 * 轨迹变化具体信息说明，展示在快递轨迹详情页中。若有手机号码，则直接写11位手机号码。使用UTF-8编码。
	 */
	@SerializedName("action_msg")
	private String actionMsg;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
