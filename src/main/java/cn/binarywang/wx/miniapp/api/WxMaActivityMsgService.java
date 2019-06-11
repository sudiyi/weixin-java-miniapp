package cn.binarywang.wx.miniapp.api;

import cn.binarywang.wx.miniapp.bean.WxMaSetUpdatableMsgRequest;
import cn.binarywang.wx.miniapp.bean.WxMaCreateActivityIdResult;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * <pre>
 * 动态消息接口
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.createActivityId.html
 * </pre>
 * @author yangtao
 * @date 2019/06/10
 */
public interface WxMaActivityMsgService {
	
	/**
	 * 创建被分享动态消息的 activity_id
	 */
	String CREATE_ACTIVITYID = "https://api.weixin.qq.com/cgi-bin/message/wxopen/activityid/create";
	
	/**
	 * 修改被分享的动态消息
	 */
	String SET_UPDATE_MSG = "https://api.weixin.qq.com/cgi-bin/message/wxopen/updatablemsg/send";
	
	/**
	 * <pre>
	 * 创建被分享动态消息的 activity_id
	 * methods:GET
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.createActivityId.html
	 * </pre>
	 * @return
	 * @throws WxErrorException
	 */
	WxMaCreateActivityIdResult createActivityId() throws WxErrorException;

	/**
	 * <pre>
	 * 修改被分享的动态消息
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.setUpdatableMsg.html
	 * </pre>
	 * @param updatableRequest
	 * @throws WxErrorException
	 */
	void setUpdatableMsg(WxMaSetUpdatableMsgRequest updatableRequest) throws WxErrorException;
}
