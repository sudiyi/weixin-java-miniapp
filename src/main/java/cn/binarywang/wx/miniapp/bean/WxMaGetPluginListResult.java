package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 查询已添加的插件-返回结果
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginList.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaGetPluginListResult implements Serializable{

	private static final long serialVersionUID = 3129403752926546511L;

	/**
	 * 申请或使用中的插件列表
	 */
	@SerializedName("plugin_list")
	private List<PluginListInfo> pluginList;
	
	@Data
	public class PluginListInfo implements Serializable{

		private static final long serialVersionUID = 8328161415657546328L;
		
		/**
		 * 插件 appId
		 */
		private String appid;
		
		/**
		 * 插件状态
		 * 1	申请中	
		 * 2	申请通过	
		 * 3	已拒绝	
		 * 4	已超时
		 */
		private Integer status;
		
		/**
		 * 插件昵称
		 */
		private String nickname;
		
		/**
		 * 插件头像
		 */
		private String headimgurl;
	}
	
	public static WxMaGetPluginListResult fromJson(String json) {
	    return WxMaGsonBuilder.create().fromJson(json, WxMaGetPluginListResult.class);
	}
}
