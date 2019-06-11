package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * SOTER 生物认证秘钥签名验证-请求参数
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/soter/soter.verifySignature.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaSoterVerifySignature implements Serializable{

	private static final long serialVersionUID = -5844705081494850744L;

	/**
	 * 用户 openid
	 */
	private String openid;
	
	/**
	 * 通过 wx.startSoterAuthentication 成功回调获得的 resultJSON 字段
	 */
	@SerializedName("json_string")
	private String jsonStrng;
	
	/**
	 * 通过 wx.startSoterAuthentication 成功回调获得的 resultJSONSignature 字段
	 */
	@SerializedName("json_signature")
	private String jsonSignature;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
