package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改插件使用申请的状态（供插件开发者调用）
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.setDevPluginApplyStatus.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaSetPluginStatusRequest implements Serializable{

	private static final long serialVersionUID = -561945357541950148L;

	/**
	 * 修改操作
	 * dev_agree	同意申请	
	 * dev_refuse	拒绝申请	
	 * dev_delete	删除已拒绝的申请者
	 */
	private String action;
	
	/**
	 * 使用者的 appid。同意申请时填写
	 */
	private String appid;
	
	/**
	 * 拒绝理由。拒绝申请时填写
	 */
	private String reason;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
