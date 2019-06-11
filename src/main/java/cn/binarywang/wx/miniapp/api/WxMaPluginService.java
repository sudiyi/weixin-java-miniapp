package cn.binarywang.wx.miniapp.api;

import cn.binarywang.wx.miniapp.bean.WxMaApplyPluginRequest;
import cn.binarywang.wx.miniapp.bean.WxMaGetPluginDevApplyListRequest;
import cn.binarywang.wx.miniapp.bean.WxMaGetPluginDevApplyListResult;
import cn.binarywang.wx.miniapp.bean.WxMaGetPluginListResult;
import cn.binarywang.wx.miniapp.bean.WxMaSetPluginStatusRequest;
import cn.binarywang.wx.miniapp.bean.WxMaUnbindPluginRequest;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 插件管理模块接口
 * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.applyPlugin.html
 * @author yangtao
 * @date 2019/06/11
 */
public interface WxMaPluginService {

	/**
	 * 向插件开发者发起使用插件的申请
	 */
	String APPLY_PLUGIN = "https://api.weixin.qq.com/wxa/plugin";
	
	/**
	 * 获取当前所有插件使用方（供插件开发者调用）
	 */
	String GET_PLUGIN_DEV_APPLY_LIST = "https://api.weixin.qq.com/wxa/devplugin";

	/**
	 * 查询已添加的插件
	 */
	String GET_PLUGIN_LIST = "https://api.weixin.qq.com/wxa/plugin";
	
	/**
	 * 修改插件使用申请的状态（供插件开发者调用）
	 */
	String SET_PLUGIN_STATUS = "https://api.weixin.qq.com/wxa/devplugin";
	
	/**
	 * 删除已添加的插件
	 */
	String UNBIND_PLUGIN = "https://api.weixin.qq.com/wxa/plugin";
	
	/**
	 * <pre>
	 * 向插件开发者发起使用插件的申请
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.applyPlugin.html
	 * </pre>
	 * @param applyRequest
	 * @throws WxErrorException
	 */
	void applyPlugin(WxMaApplyPluginRequest applyRequest) throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取当前所有插件使用方（供插件开发者调用）
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginDevApplyList.html
	 * </pre>
	 * @param devListRequest
	 * @return
	 * @throws WxErrorException
	 */
	WxMaGetPluginDevApplyListResult getPluginDevApplyList(WxMaGetPluginDevApplyListRequest devListRequest) throws WxErrorException;

	/**
	 * <pre>
	 * 查询已添加的插件
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.getPluginList.html
	 * </pre>
	 * @param action 此接口下填写 "list"
	 * @return
	 * @throws WxErrorException
	 */
	WxMaGetPluginListResult getPluginList(String action) throws WxErrorException;

	/**
	 * <pre>
	 * 修改插件使用申请的状态（供插件开发者调用）
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.setDevPluginApplyStatus.html
	 * </pre>
	 * @param setStatusRequest
	 * @throws WxErrorException
	 */
	void setPluginStatus(WxMaSetPluginStatusRequest setStatusRequest) throws WxErrorException;

	/**
	 * <pre>
	 * 删除已添加的插件
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/plugin-management/pluginManager.unbindPlugin.html
	 * </pre>
	 * @param unbindRequest
	 * @throws WxErrorException
	 */
	void unbindPlugin(WxMaUnbindPluginRequest unbindRequest) throws WxErrorException;
}
