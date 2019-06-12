package cn.binarywang.wx.miniapp.api.impl;

import java.util.Map;

import cn.binarywang.wx.miniapp.api.WxMaSoterService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaSoterVerifySignature;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 生物认证接口
 * @author yangtao
 * @date 2019/06/11
 */
public class WxMaSoterServiceImpl implements WxMaSoterService{

	private WxMaService wxMaService;
	
	public WxMaSoterServiceImpl(WxMaService wxMaService){
		this.wxMaService = wxMaService;
	}
	
	@Override
	public boolean verifySignature(WxMaSoterVerifySignature verifySignature) throws WxErrorException {
		String responseContent = this.wxMaService.post(VERIFY_SIGNATURE, verifySignature.toJson());
		@SuppressWarnings("unchecked")
		Map<String, Object> result = WxMaGsonBuilder.create().fromJson(responseContent, Map.class);
		return Boolean.parseBoolean(String.valueOf(result.get("is_ok")));
	}

}
