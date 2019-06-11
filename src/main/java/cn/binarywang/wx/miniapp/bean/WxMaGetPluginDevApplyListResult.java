package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 获取当前所有插件使用方（供插件开发者调用）-返回实体
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginDevApplyList.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaGetPluginDevApplyListResult implements Serializable{

	private static final long serialVersionUID = -7898077479701575684L;

	/**
	 * 插件使用方列表
	 */
	@SerializedName("apply_list")
	private List<DevApplyListInfo> applyList;
	
	@Data
	public class DevApplyListInfo implements Serializable{

		private static final long serialVersionUID = -2230541021815576241L;
		
		/**
		 * 使用者的appid
		 */
		private String appid;
		
		/**
		 * 使用者的昵称
		 */
		private String nickname;
		
		/**
		 * 插件状态
		 * 1	申请中	
		 * 2	申请通过	
		 * 3	已拒绝	
		 * 4	已超时
		 */
		private Integer status;
		
		/**
		 * 使用者的头像
		 */
		private String headimgurl;
		
		/**
		 * 使用者的申请说明
		 */
		private String reason;
		
		/**
		 * 使用者的小程序码
		 */
		@SerializedName("apply_url")
		private String applyUrl;
		
		/**
		 * 使用者的申请时间
		 */
		@SerializedName("create_time")
		private String createTime;
		
		/**
		 * 使用者的类目
		 */
		private List<DevApplyCategories> categories;
	}
	
	@Data
	public class DevApplyCategories implements Serializable{

		private static final long serialVersionUID = 648711320993344801L;
		
		private String first;
		
		private String second;
	}
	
	public static WxMaGetPluginDevApplyListResult fromJson(String json) {
	    return WxMaGsonBuilder.create().fromJson(json, WxMaGetPluginDevApplyListResult.class);
	}
}
