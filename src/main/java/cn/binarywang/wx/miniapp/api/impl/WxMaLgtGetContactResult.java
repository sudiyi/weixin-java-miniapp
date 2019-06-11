package cn.binarywang.wx.miniapp.api.impl;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 获取面单联系人信息
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtGetContactResult implements Serializable{

	private static final long serialVersionUID = -8931087823809152884L;
	
	/**
	 * 运单id
	 */
	@SerializedName("waybill_id")
	private String waybillId;
	
	/**
	 * 
	 */
	private String errcode;
	
	/**
	 * 
	 */
	private String errmsg;
	
	/**
	 * 发件人信息
	 */
	private LgtGetContactInfo sender;
	
	/**
	 * 收件人信息
	 */
	private LgtGetContactInfo receiver;
	
	@Data
	public class LgtGetContactInfo implements Serializable{

		private static final long serialVersionUID = 4894957930266999721L;
		
		/**
		 * 地址，已经将省市区信息合并
		 */
		private String address;
		
		/**
		 * 用户姓名
		 */
		private String name;
		
		/**
		 * 座机号码
		 */
		private String tel;
		
		/**
		 * 手机号码
		 */
		private String mobile;
	}
	
	public static WxMaLgtGetContactResult fromJson(String json){
		return WxMaGsonBuilder.create().fromJson(json, WxMaLgtGetContactResult.class);
	}
}
