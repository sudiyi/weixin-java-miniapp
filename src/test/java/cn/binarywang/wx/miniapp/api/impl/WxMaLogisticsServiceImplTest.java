package cn.binarywang.wx.miniapp.api.impl;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.google.inject.Inject;
import cn.binarywang.wx.miniapp.api.WxMaLogisticsService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaLgtAddOrderRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtCancelOrderRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtGetPathRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtPreviewTemplateRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtUpdateBusinessRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtUpdatePathRequest;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 物流助手模块测试
 * TODO 物流模块需要签约物流公司（或使用现付码，四家公司支持），但都需要openid;该模块接口未测试
 * TODO 部分查询接口返回无接口权限（猜测是小程序未经过认证），还未确认原因
 * @author yangtao
 * @date 2019/06/12
 */
@Guice(modules = ApiTestModule.class)
@Slf4j
public class WxMaLogisticsServiceImplTest {

	@Inject
	private WxMaService wxMaService;
	
	void testGetPath() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		WxMaLgtGetPathRequest getPath = new WxMaLgtGetPathRequest("", "", "", "");
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.getPath(getPath)));
	}
	
	void testAddOrder() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		WxMaLgtAddOrderRequest addOrderRequest = new WxMaLgtAddOrderRequest();
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.addOrder(addOrderRequest)));
	}
	
	void testCancelOrder() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		WxMaLgtCancelOrderRequest cancelOrderRequest = new WxMaLgtCancelOrderRequest();
		logisticsService.cancelOrder(cancelOrderRequest);
	}
	
	@Test
	void testGetAllDelivery() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.getAllDelivery()));
	}
	
	void testGetOrder() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		WxMaLgtCancelOrderRequest getOrder = new WxMaLgtCancelOrderRequest();
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.getOrder(getOrder)));
	}
	
	void testGetPrinter() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.getPrinter()));
	}
	
	void testGetQuota() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.getQuota("deliveryId", "bizId")));
	}
	
	void testUpdatePrinter() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		logisticsService.updatePrinter("openId", "bind");
	}
	
	void testGetContact() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.getContact("token", "waybillid")));
	}
	
	void testPreviewTemplate() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		WxMaLgtPreviewTemplateRequest previewTemplate = new WxMaLgtPreviewTemplateRequest();
		log.info(WxMaGsonBuilder.create().toJson(logisticsService.previewTemplate(previewTemplate)));
	}
	
	void testUpdateBusiness() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		WxMaLgtUpdateBusinessRequest updateBusiness = new WxMaLgtUpdateBusinessRequest();
		logisticsService.updateBusiness(updateBusiness);
	}
	
	void testUpdatePath() throws WxErrorException{
		WxMaLogisticsService logisticsService = wxMaService.getLogisticsService();
		WxMaLgtUpdatePathRequest updatePath = new WxMaLgtUpdatePathRequest();
		logisticsService.updatePath(updatePath);
	}
}
