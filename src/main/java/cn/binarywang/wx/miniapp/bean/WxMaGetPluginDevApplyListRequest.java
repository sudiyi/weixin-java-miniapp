package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 获取当前所有插件使用方（供插件开发者调用）
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginDevApplyList.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaGetPluginDevApplyListRequest implements Serializable{

	private static final long serialVersionUID = -8085360662645622243L;

	/**
	 * 此接口下填写 "dev_apply_list"
	 */
	private String action;
	
	/**
	 * 拉取第几页的数据
	 */
	private Integer page;
	
	/**
	 * 每页多少条
	 */
	private Integer num;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
