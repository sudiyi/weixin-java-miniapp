package cn.binarywang.wx.miniapp.api.impl;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.google.inject.Inject;
import cn.binarywang.wx.miniapp.api.WxMaPluginService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaApplyPluginRequest;
import cn.binarywang.wx.miniapp.bean.WxMaGetPluginDevApplyListRequest;
import cn.binarywang.wx.miniapp.bean.WxMaSetPluginStatusRequest;
import cn.binarywang.wx.miniapp.bean.WxMaUnbindPluginRequest;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 插件管理模块测试
 * @author yangtao
 * @date 2019/06/12
 */
@Guice(modules = ApiTestModule.class)
@Slf4j
public class WxMaPluginServiceImplTest {

	@Inject
	private WxMaService wxMaService;
	
	@Test
	void testApplyPlugin() throws WxErrorException{
		WxMaPluginService pluginService = wxMaService.getPluginService();
		WxMaApplyPluginRequest applyPlugin = new WxMaApplyPluginRequest();
		applyPlugin.setAction("apply");
		applyPlugin.setPluginAppid("wxd3dc4206c76f14fc");
		applyPlugin.setReason("测试调用");
		pluginService.applyPlugin(applyPlugin);
	}
	
	//@Test
	void testGetPluginDevApplyList() throws WxErrorException{
		WxMaPluginService pluginService = wxMaService.getPluginService();
		WxMaGetPluginDevApplyListRequest getPluginDev = new WxMaGetPluginDevApplyListRequest();
		getPluginDev.setAction("dev_apply_list");
		getPluginDev.setNum(1);
		getPluginDev.setPage(1);
		log.info(WxMaGsonBuilder.create().toJson(pluginService.getPluginDevApplyList(getPluginDev)));
	}
	
	//@Test
	void testGetPluginList() throws WxErrorException{
		WxMaPluginService pluginService = wxMaService.getPluginService();
		log.info(WxMaGsonBuilder.create().toJson(pluginService.getPluginList("list")));
	}
	
	//@Test
	void testSetPluginStatus() throws WxErrorException{
		WxMaPluginService pluginService = wxMaService.getPluginService();
		WxMaSetPluginStatusRequest setPluginStatus = new WxMaSetPluginStatusRequest();
		pluginService.setPluginStatus(setPluginStatus);
	}
	
	//@Test
	void testUnbindPlugin() throws WxErrorException{
		WxMaPluginService pluginService = wxMaService.getPluginService();
		WxMaUnbindPluginRequest unbingPlugin = new WxMaUnbindPluginRequest();
		unbingPlugin.setPluginAppid("wxd3dc4206c76f14fc");
		unbingPlugin.setAction("unbind");
		pluginService.unbindPlugin(unbingPlugin);
	}
}
