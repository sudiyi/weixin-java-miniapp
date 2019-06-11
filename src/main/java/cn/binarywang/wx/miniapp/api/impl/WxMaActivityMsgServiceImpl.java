package cn.binarywang.wx.miniapp.api.impl;

import cn.binarywang.wx.miniapp.api.WxMaActivityMsgService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaSetUpdatableMsgRequest;
import cn.binarywang.wx.miniapp.bean.WxMaCreateActivityIdResult;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 动态消息接口实现
 * @author yangtao
 * @date 2019/06/11
 */
public class WxMaActivityMsgServiceImpl implements WxMaActivityMsgService{

	private WxMaService wxMaService;
	
	public WxMaActivityMsgServiceImpl(WxMaService wxMaService){
		this.wxMaService = wxMaService;
	}
	
	@Override
	public WxMaCreateActivityIdResult createActivityId() throws WxErrorException {
		String responseContent = this.wxMaService.get(CREATE_ACTIVITYID, null);
		return WxMaCreateActivityIdResult.fromJson(responseContent);
	}

	@Override
	public void setUpdatableMsg(WxMaSetUpdatableMsgRequest updatableRequest) throws WxErrorException {
		this.wxMaService.post(SET_UPDATE_MSG, updatableRequest.toJson());
	}

}
