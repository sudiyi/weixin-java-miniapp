package cn.binarywang.wx.miniapp.api.impl;

import com.google.gson.JsonObject;
import cn.binarywang.wx.miniapp.api.WxMaPluginService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaApplyPluginRequest;
import cn.binarywang.wx.miniapp.bean.WxMaGetPluginDevApplyListRequest;
import cn.binarywang.wx.miniapp.bean.WxMaGetPluginDevApplyListResult;
import cn.binarywang.wx.miniapp.bean.WxMaGetPluginListResult;
import cn.binarywang.wx.miniapp.bean.WxMaSetPluginStatusRequest;
import cn.binarywang.wx.miniapp.bean.WxMaUnbindPluginRequest;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 插件管理接口实现
 * @author yangtao
 * @date 2019/06/11
 */
public class WxMaPluginServiceImpl implements WxMaPluginService{

	private WxMaService wxMaService;
	
	public WxMaPluginServiceImpl(WxMaService wxMaService){
		this.wxMaService = wxMaService;
	}
	
	@Override
	public void applyPlugin(WxMaApplyPluginRequest applyRequest) throws WxErrorException {
		this.wxMaService.post(APPLY_PLUGIN, applyRequest.toJson());
	}

	@Override
	public WxMaGetPluginDevApplyListResult getPluginDevApplyList(WxMaGetPluginDevApplyListRequest devListRequest)
			throws WxErrorException {
		String responseContent = this.wxMaService.post(GET_PLUGIN_DEV_APPLY_LIST, devListRequest.toJson());
		return WxMaGetPluginDevApplyListResult.fromJson(responseContent);
	}

	@Override
	public WxMaGetPluginListResult getPluginList(String action) throws WxErrorException {
		JsonObject param = new JsonObject();
		param.addProperty("action", action);
		String responseContent = this.wxMaService.post(GET_PLUGIN_LIST, param.toString());
		return WxMaGetPluginListResult.fromJson(responseContent);
	}

	@Override
	public void setPluginStatus(WxMaSetPluginStatusRequest setStatusRequest) throws WxErrorException {
		this.wxMaService.post(SET_PLUGIN_STATUS, setStatusRequest.toJson());
	}

	@Override
	public void unbindPlugin(WxMaUnbindPluginRequest unbindRequest) throws WxErrorException {
		this.wxMaService.post(UNBIND_PLUGIN, unbindRequest.toJson());
	}

}
