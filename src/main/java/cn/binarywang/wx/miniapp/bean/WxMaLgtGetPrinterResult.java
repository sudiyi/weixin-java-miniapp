package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 获取打印员。若需要使用微信打单 PC 软件，才需要调用
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getPrinter.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaLgtGetPrinterResult implements Serializable{

	private static final long serialVersionUID = -5704258667888222782L;

	/**
	 * 已经绑定的打印员数量
	 */
	private Integer count;
	
	/**
	 * 打印员 openid 列表
	 */
	private String[] openid;
	
	public static WxMaLgtGetPrinterResult fromJson(String json){
		return WxMaGsonBuilder.create().fromJson(json, WxMaLgtGetPrinterResult.class);
	}
}
