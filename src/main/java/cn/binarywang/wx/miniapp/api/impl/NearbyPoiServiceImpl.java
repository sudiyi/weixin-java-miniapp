package cn.binarywang.wx.miniapp.api.impl;

import com.google.gson.JsonObject;
import cn.binarywang.wx.miniapp.api.NearbyPoiService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaAddNearbyRequest;
import cn.binarywang.wx.miniapp.bean.WxMaAddNearbyResult;
import cn.binarywang.wx.miniapp.bean.WxMaGetNearbyListResult;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 附近小程序接口实现
 * @author yangtao
 * @date 2019/06/11
 */
public class NearbyPoiServiceImpl implements NearbyPoiService{

	private WxMaService wxMaService;
	
	public NearbyPoiServiceImpl(WxMaService wxMaService){
		this.wxMaService = wxMaService;
	}
	
	@Override
	public WxMaAddNearbyResult add(WxMaAddNearbyRequest nearbyRequest) throws WxErrorException {
		String responseContent = this.wxMaService.post(NEARBYPOI_ADD, nearbyRequest.toJson());
		return WxMaAddNearbyResult.fromJson(responseContent);
	}

	@Override
	public void delete(String poiId) throws WxErrorException {
		JsonObject param = new JsonObject();
		param.addProperty("poi_id", poiId);
		this.wxMaService.post(NEARBYPOI_DELETE, param.toString());
		//TODO 返回值 deleteNearbyPoiResponse	返回的 JSON 数据包
		//因官方文档没有明确说明返回内容，此处待测试
	}

	@Override
	public WxMaGetNearbyListResult getList(Integer page, Integer pageRows) throws WxErrorException {
		String url = NEARBYPOI_GETLIST +"?page="+page+"&page_rows="+pageRows;
		String responseContent = this.wxMaService.get(url, null);
		return WxMaGetNearbyListResult.fromJson(responseContent);
	}

	@Override
	public void setShowStatus(String poiId, Integer status) throws WxErrorException {
		JsonObject params = new JsonObject();
		params.addProperty("poi_id", poiId);
		params.addProperty("status", status);
		this.wxMaService.post(NEARBYPOI_SETSHOW_STATUS, params.toString());
	}

}
