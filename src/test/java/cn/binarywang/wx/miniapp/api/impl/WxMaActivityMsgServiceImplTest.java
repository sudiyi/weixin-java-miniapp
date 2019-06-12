package cn.binarywang.wx.miniapp.api.impl;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.google.inject.Inject;
import cn.binarywang.wx.miniapp.api.WxMaActivityMsgService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaCreateActivityIdResult;
import cn.binarywang.wx.miniapp.bean.WxMaSetUpdatableMsgRequest;
import cn.binarywang.wx.miniapp.bean.WxMaSetUpdatableMsgRequest.UpdateMsgParameterList;
import cn.binarywang.wx.miniapp.bean.WxMaSetUpdatableMsgRequest.UpdateMsgTemplateInfo;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 动态消息测试类
 * @author yangtao
 * @date 2019/06/12
 */
@Guice(modules = ApiTestModule.class)
@Slf4j
public class WxMaActivityMsgServiceImplTest {

	@Inject
	private WxMaService wxMaService;
	
	public void testCreateActivityId() throws WxErrorException{
		WxMaActivityMsgService activityMsgService = wxMaService.getActivityMsgService();
		WxMaCreateActivityIdResult result = activityMsgService.createActivityId();
		log.info(WxMaGsonBuilder.create().toJson(result));
		//【请求地址】: https://api.weixin.qq.com/cgi-bin/message/wxopen/activityid/create?access_token=22_EypkVptmBh6bTLlX8Pm-VoW5AfBNznp0V6Nxu4hxbfaKltTw1VD5OQ6fa27ed2aLklg8nqXoZU5GiYRQgbvsmKraouXG0mwFdWPywMEEoixmH7fl5HPwgeXq3u4uXXEaHSfsZ-eZ_0dK1xRXXXKaAAAOOB
		//【请求参数】：null
		//【响应数据】：{"activity_id":"1012_uIhHMNA28W1V8ABdhtxED402U2Nv5U5i8rPeLNSxxFv1aDeNwVwDkjrM2o8~","expiration_time":1560404586,"errcode":0,"errmsg":"ok"}
	}
	
	@Test
	public void testSetUpdatableMsg() throws WxErrorException{
		WxMaActivityMsgService activityMsgService = wxMaService.getActivityMsgService();
		WxMaSetUpdatableMsgRequest setUpdatable = new WxMaSetUpdatableMsgRequest();
		setUpdatable.setActivityId("1012_uIhHMNA28W1V8ABdhtxED402U2Nv5U5i8rPeLNSxxFv1aDeNwVwDkjrM2o8~");
		setUpdatable.setTargetState(0);
		UpdateMsgTemplateInfo templateInfo = setUpdatable.new UpdateMsgTemplateInfo();
		List<UpdateMsgParameterList> parammeterList = new ArrayList<UpdateMsgParameterList>();
		UpdateMsgParameterList parameter1 = setUpdatable.new UpdateMsgParameterList();
		parameter1.setName("member_count");
		parameter1.setValue("2");
		UpdateMsgParameterList parameter2 = setUpdatable.new UpdateMsgParameterList();
		parameter2.setName("room_limit");
		parameter2.setValue("5");
		parammeterList.add(parameter1);
		parammeterList.add(parameter2);
		templateInfo.setParameterList(parammeterList);
		setUpdatable.setTemplateInfo(templateInfo);
		activityMsgService.setUpdatableMsg(setUpdatable);
		//【请求地址】: https://api.weixin.qq.com/cgi-bin/message/wxopen/updatablemsg/send?access_token=22_pajR7l9bwdl2uhlm0d-7_PqoXrpjJyLbuIYWkBIME4_GBCDxxlM0Ahp79-7KYtGzXYsG11zZkP1-6mFVctDy_1Bg4ZNnk-Dz--jZVg7Lnh_XLpg3rYRjIXJRC8tk3KTTJgqiZIvmW7yvQeWuNEIfAAAARV
		//【请求参数】：{"activity_id":"1012_uIhHMNA28W1V8ABdhtxED402U2Nv5U5i8rPeLNSxxFv1aDeNwVwDkjrM2o8~","targe_state":0,"template_info":{"parameter_list":[{"name":"member_count","value":"2"},{"name":"room_limit","value":"5"}]}}
		//【响应数据】：{"errcode":0,"errmsg":"ok"}
	}
}
