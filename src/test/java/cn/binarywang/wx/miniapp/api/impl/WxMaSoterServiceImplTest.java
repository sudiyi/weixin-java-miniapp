package cn.binarywang.wx.miniapp.api.impl;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.google.inject.Inject;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaSoterService;
import cn.binarywang.wx.miniapp.bean.WxMaSoterVerifySignature;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 生物认证模块测试
 * @author yangtao
 * @date 2019/06/12
 */
@Guice(modules = ApiTestModule.class)
public class WxMaSoterServiceImplTest {

	@Inject
	private WxMaService wxMaService;
	
	@Test
	public void testVerifySignature() throws WxErrorException{
		WxMaSoterService soterService = wxMaService.getSoterService();
		WxMaSoterVerifySignature verifySingature = new WxMaSoterVerifySignature();
		System.out.println(soterService.verifySignature(verifySingature));
	}
}
