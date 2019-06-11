package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WxMaCreateActivityIdResult implements Serializable{

	private static final long serialVersionUID = -7189947641636967371L;
	
	/**
	 * 动态消息的id
	 */
	@SerializedName("activity_id")
	private String activityId;
	
	/**
	 * activity_id 的过期时间戳。默认24小时后过期。
	 */
	@SerializedName("expirationTime")
	private String expiration_time;

	public static WxMaCreateActivityIdResult fromJson(String json) {
	    return WxMaGsonBuilder.create().fromJson(json, WxMaCreateActivityIdResult.class);
	}
	
	public String toJson() {
	    return WxMaGsonBuilder.create().toJson(this);
	}
}
