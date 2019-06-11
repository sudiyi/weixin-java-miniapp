package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 向插件开发者发起使用插件的申请-请求实体
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.applyPlugin.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaApplyPluginRequest implements Serializable{

	private static final long serialVersionUID = -8293715446264329656L;

	/**
	 * 此接口下填写 "apply"
	 */
	private String action;
	
	/**
	 * 插件appid
	 */
	private String pluginAppid;
	
	/**
	 * 使用理由
	 */
	private String reason;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
