package cn.binarywang.wx.miniapp.api.impl;

import java.util.Map;
import com.google.gson.JsonObject;
import cn.binarywang.wx.miniapp.api.LogisticsService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaLgtAddOrderRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtAddOrderResult;
import cn.binarywang.wx.miniapp.bean.WxMaLgtCancelOrderRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtGetAllDeliveryResult;
import cn.binarywang.wx.miniapp.bean.WxMaLgtGetOrderResult;
import cn.binarywang.wx.miniapp.bean.WxMaLgtGetPathRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtGetPathResult;
import cn.binarywang.wx.miniapp.bean.WxMaLgtGetPrinterResult;
import cn.binarywang.wx.miniapp.bean.WxMaLgtUpdateBusinessRequest;
import cn.binarywang.wx.miniapp.bean.WxMaLgtUpdatePathRequest;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 物流助手接口实现
 * @author yangtao
 * @date 2019/06/11
 */
public class LogisticsServiceImpl implements LogisticsService{

	private WxMaService wxMaService;
	
	public LogisticsServiceImpl(WxMaService wxMaService){
		this.wxMaService = wxMaService;
	}
	
	@Override
	public WxMaLgtGetPathResult getPath(WxMaLgtGetPathRequest getPath) throws WxErrorException {
		String responseContent = this.wxMaService.post(GET_PATH, getPath.toJson());
		return WxMaLgtGetPathResult.fromJson(responseContent);
	}

	@Override
	public WxMaLgtAddOrderResult addOrder(WxMaLgtAddOrderRequest addOrder) throws WxErrorException {
		String responseContent = this.wxMaService.post(ADD_ORDER, addOrder.toJson());
		return WxMaLgtAddOrderResult.fromJson(responseContent);
		//TODO 正常返回时，我errcode字段，推测目前公共执行器的基础执行方法不支持不带“errcode”的返回值，需要修改
	}

	@Override
	public void cancelOrder(WxMaLgtCancelOrderRequest cancelRequest) throws WxErrorException {
		this.wxMaService.post(CANCEL_ORDER, cancelRequest.toJson());
	}

	@Override
	public WxMaLgtGetAllDeliveryResult getAllDelivery() throws WxErrorException {
		String responseContent = this.wxMaService.get(GET_ALL_DELIVERY, null);
		return WxMaLgtGetAllDeliveryResult.fromJson(responseContent);
	}

	@Override
	public WxMaLgtGetOrderResult getOrder(WxMaLgtCancelOrderRequest getOrder) throws WxErrorException {
		String responseContent = this.wxMaService.post(GET_ORDER, getOrder.toJson());
		return WxMaLgtGetOrderResult.fromJson(responseContent);
	}

	@Override
	public WxMaLgtGetPrinterResult getPrinter() throws WxErrorException {
		String responseContent = this.wxMaService.get(GET_PRINTER, "null");
		return WxMaLgtGetPrinterResult.fromJson(responseContent);
	}

	@Override
	public Float getQuota(String deliveryId, String bizId) throws WxErrorException {
		JsonObject params = new JsonObject();
		params.addProperty("delivery_id", deliveryId);
		params.addProperty("biz_id", bizId);
		String responseContent = this.wxMaService.post(GET_QUOTA, params.toString());
		@SuppressWarnings("unchecked")
		Map<String, Object> result = WxMaGsonBuilder.create().fromJson(responseContent, Map.class);
		return (Float) result.get("quota_num");
	}

	@Override
	public void updatePrinter(String openid, String updateType) throws WxErrorException {
		JsonObject params = new JsonObject();
		params.addProperty("openid", openid);
		params.addProperty("update_type", updateType);
		this.wxMaService.post(UPDATE_PRINTER, params.toString());
	}

	@Override
	public WxMaLgtGetContactResult getContact(String token, String waybillId) throws WxErrorException {
		JsonObject params = new JsonObject();
		params.addProperty("token", token);
		params.addProperty("waybill_id", waybillId);
		String responseContent = this.wxMaService.post(GET_CONTACT, params.toString());
		return WxMaLgtGetContactResult.fromJson(responseContent);
	}

	@Override
	public void updateBusiness(WxMaLgtUpdateBusinessRequest updateBusiness) throws WxErrorException {
		this.wxMaService.post(UPDATE_BUSINESS, updateBusiness.toJson());
	}

	@Override
	public void updatePath(WxMaLgtUpdatePathRequest updatePath) throws WxErrorException {
		this.wxMaService.post(UPDATE_PATH, updatePath.toJson());
	}

}
