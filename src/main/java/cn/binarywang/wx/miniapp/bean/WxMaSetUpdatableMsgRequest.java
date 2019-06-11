package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 修改被分享的动态消息，请求实体
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/updatable-message/updatableMessage.setUpdatableMsg.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaSetUpdatableMsgRequest implements Serializable{

	private static final long serialVersionUID = 6658794961262934719L;

	/**
	 * 动态消息的 ID，通过 updatableMessage.createActivityId 接口获取
	 */
	private String activityId;
	
	/**
	 * 动态消息修改后的状态（具体含义见后文）
	 */
	private Integer targetState;
	
	/**
	 * 动态消息对应的模板信息
	 */
	@SerializedName("template_info")
	private UpdateMsgTemplateInfo templateInfo;  
	
	@Data
	public class UpdateMsgTemplateInfo implements Serializable{

		private static final long serialVersionUID = -5171149473557207305L;

		@SerializedName("parameter_list")
		private List<UpdateMsgParameterList> parameterList;
	}
	
	@Data
	public class UpdateMsgParameterList implements Serializable{
		
		private static final long serialVersionUID = -8515012225020370077L;

		/**
		 * member_count	target_state = 0 时必填，文字内容模板中 member_count 的值	
		 * room_limit	target_state = 0 时必填，文字内容模板中 room_limit 的值	
		 * path	target_state = 1 时必填，点击「进入」启动小程序时使用的路径。对于小游戏，没有页面的概念，可以用于传递查询字符串（query），如 "?foo=bar"	
		 * version_type	target_state = 1 时必填，点击「进入」启动小程序时使用的版本。有效参数值为：develop（开发版），trial（体验版），release（正式版）
		 */
		private String name;
		
		private String value;
	}
	
	public String toJson() {
	    return WxMaGsonBuilder.create().toJson(this);
	}
}
