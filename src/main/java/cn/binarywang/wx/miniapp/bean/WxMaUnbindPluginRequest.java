package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除已添加的插件
 * 接口地址：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.unbindPlugin.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaUnbindPluginRequest implements Serializable{

	private static final long serialVersionUID = 7031810234901577955L;

	/**
	 * 此接口下填写 "unbind"
	 */
	private String action;
	
	/**
	 * 插件appid
	 */
	@SerializedName("plugin_appid")
	private String pluginAppid;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
