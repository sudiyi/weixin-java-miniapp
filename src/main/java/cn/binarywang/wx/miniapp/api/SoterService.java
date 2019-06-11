package cn.binarywang.wx.miniapp.api;

import cn.binarywang.wx.miniapp.bean.WxMaSoterVerifySignature;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 生物认证
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/soter/soter.verifySignature.html
 * @author yangtao
 * @date 2019/06/11
 */
public interface SoterService {

	/**
	 * SOTER 生物认证秘钥签名验证
	 */
	String VERIFY_SIGNATURE = "https://api.weixin.qq.com/cgi-bin/soter/verify_signature";

	/**
	 * <pre>
	 * SOTER 生物认证秘钥签名验证
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/soter/soter.verifySignature.html
	 * </pre>
	 * @param verifySignature 
	 * @return
	 * @throws WxErrorException
	 */
	boolean verifySignature(WxMaSoterVerifySignature verifySignature) throws WxErrorException;
}
