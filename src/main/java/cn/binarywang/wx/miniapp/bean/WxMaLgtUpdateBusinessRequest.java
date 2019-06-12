package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新商户审核结果
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.updateBusiness.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaLgtUpdateBusinessRequest implements Serializable{

	private static final long serialVersionUID = 3084061185336401431L;

	/**
	 * 商户的小程序AppID，即审核商户事件中的 ShopAppID
	 */
	@SerializedName("shop_app_id")
	private String ShopAppId;
	
	/**
	 * 商户账户
	 */
	@SerializedName("biz_id")
	private String bizId;
	
	/**
	 * 审核结果，0 表示审核通过，其他表示审核失败
	 */
	@SerializedName("result_code")
	private String resultCode;
	
	/**
	 * 审核错误原因，仅 result_code 不等于 0 时需要设置
	 */
	@SerializedName("result_msg")
	private String resultMsg;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
