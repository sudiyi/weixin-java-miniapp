package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 预览面单模板。用于调试面单模板使用。
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.previewTemplate.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtPreviewTemplateRequest implements Serializable{

	private static final long serialVersionUID = 6623653357549009367L;

	/**
	 * 运单 ID
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	/**
	 * 面单数据。详情参考下单事件返回值中的 WaybillData
	 */
	@SerializedName("waybill_data")
	private String waybillData;
	
	/**
	 * 面单 HTML 模板内容（需经 Base64 编码）
	 */
	@SerializedName("waybill_template")
	private String waybillTemplate;
	
	/**
	 * 商户下单数据，格式是商户侧下单 API 中的请求体
	 */
	private WxMaLgtAddOrderRequest custom;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
