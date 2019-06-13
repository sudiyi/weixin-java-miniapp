package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 预览面单模板。用于调试面单模板使用。
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.previewTemplate.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaLgtPreviewTemplateResult implements Serializable{

	private static final long serialVersionUID = 817538838211661148L;

	/**
	 * 运单id
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	/**
	 * 渲染后的面单 HTML 文件（已经过 Base64 编码）
	 */
	@SerializedName("rendered_waybill_template")
	private String rendered_waybill_template;
	
	private String errcode;
	
	private String errmsg;
	
	public static WxMaLgtPreviewTemplateResult fromJson(String json){
		return WxMaGsonBuilder.create().fromJson(json, WxMaLgtPreviewTemplateResult.class);
	}
}
