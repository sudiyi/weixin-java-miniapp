package cn.binarywang.wx.miniapp.api.impl;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.google.inject.Inject;

import cn.binarywang.wx.miniapp.api.WxMaNearbyPoiService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaAddNearbyRequest;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 附近的小程序测试
 * TODO 个人类型小程序无权限调用，该模块接口还未测试 yangao 20190612
 * @author yangtao
 * @date 2019/06/12
 */
@Guice(modules = ApiTestModule.class)
@Slf4j
public class WxMaNearbyPoiServiceImplTest {

	@Inject
	private WxMaService wxService;
	
	@Test
	void testAdd() throws WxErrorException{
		WxMaNearbyPoiService nearbyPoi = wxService.getNearbyPoiService();
		WxMaAddNearbyRequest addNearby = new WxMaAddNearbyRequest();
		addNearby.setAddress("新疆维吾尔自治区克拉玛依市克拉玛依区碧水路15-1-8号(碧水云天广场)");
		addNearby.setCompanyName("深圳市腾讯计算机系统有限公司");
		addNearby.setCredential("156718193518281");
		addNearby.setPicList("{\"list\":[\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITqmP914zSwhajIEJzUPpx40P7R8fRe1QmicneQMhFzpZNhSLjrvU1pIA/0?wx_fmt=jpeg\",\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITRneE5FS9uYruXGMmrtmhsBySwddEWUGOibG8Ze2NT5E3Dyt79I0htNg/0?wx_fmt=jpeg\"]}");
		addNearby.setHour("00:00-11:11");
		addNearby.setIsCommNearby("1");
		addNearby.setKfInfo("{\"open_kf\":true,\"kf_headimg\":\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITqmP914zSwhajIEJzUPpx40P7R8fRe1QmicneQMhFzpZNhSLjrvU1pIA/0?wx_fmt=jpeg\",\"kf_name\":\"Harden\"}");
		addNearby.setPoiId("");
		addNearby.setQualificationList("3LaLzqiTrQcD20DlX_o-OV1-nlYMu7sdVAL7SV2PrxVyjZFZZmB3O6LPGaYXlZWq");
		addNearby.setServiceInfos("{\"service_infos\":[{\"id\":2,\"type\":1,\"name\":\"快递\",\"appid\":\"wx1373169e494e0c39\",\"path\":\"index\"},{\"id\":0,\"type\":2,\"name\":\"自定义\",\"appid\":\"wx1373169e494e0c39\",\"path\":\"index\"}]}");
		addNearby.setStoreName("羊村小马烧烤");
		log.info(WxMaGsonBuilder.create().toJson(nearbyPoi.add(addNearby)));
		//【请求地址】: https://api.weixin.qq.com/wxa/addnearbypoi?access_token=22_jLfihv0hg9YC8Rrv5ASjUKpw23ex0rewCipuU8hk8vLmz-NdC-HsWsGTZ8A8y1ysPX4EwGO_huYNIvpCiMi3fndOGS423gPxwjIB8OptbhMlGOdmfr_WWHdvGFif-vP2gHUI1M83IXp0ZOoCZPLcAIAKAW
		//【请求参数】：{"is_comm_nearby":"1","pic_list":"{\"list\":[\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITqmP914zSwhajIEJzUPpx40P7R8fRe1QmicneQMhFzpZNhSLjrvU1pIA/0?wx_fmt=jpeg\",\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITRneE5FS9uYruXGMmrtmhsBySwddEWUGOibG8Ze2NT5E3Dyt79I0htNg/0?wx_fmt=jpeg\"]}","service_infos":"{\"service_infos\":[{\"id\":2,\"type\":1,\"name\":\"快递\",\"appid\":\"wx1373169e494e0c39\",\"path\":\"index\"},{\"id\":0,\"type\":2,\"name\":\"自定义\",\"appid\":\"wx1373169e494e0c39\",\"path\":\"index\"}]}","store_name":"羊村小马烧烤","hour":"00:00-11:11","credential":"156718193518281","address":"新疆维吾尔自治区克拉玛依市克拉玛依区碧水路15-1-8号(碧水云天广场)","company_name":"深圳市腾讯计算机系统有限公司","qualification_list":"3LaLzqiTrQcD20DlX_o-OV1-nlYMu7sdVAL7SV2PrxVyjZFZZmB3O6LPGaYXlZWq","kf_info":"{\"open_kf\":true,\"kf_headimg\":\"http://mmbiz.qpic.cn/mmbiz_jpg/kKMgNtnEfQzDKpLXYhgo3W3Gndl34gITqmP914zSwhajIEJzUPpx40P7R8fRe1QmicneQMhFzpZNhSLjrvU1pIA/0?wx_fmt=jpeg\",\"kf_name\":\"Harden\"}","poi_id":""}
		//【错误信息】：{"errcode":93011,"errmsg":"个人类型小程序不可用 hint: [CH45la0602c393]"}
	}
	
	@Test
	void testDelete() throws WxErrorException{
		WxMaNearbyPoiService nearbyPoi = wxService.getNearbyPoiService();
		nearbyPoi.delete("poiId");
	}
	
	@Test
	void testGetList() throws WxErrorException{
		WxMaNearbyPoiService nearbyPoi = wxService.getNearbyPoiService();
		log.info(WxMaGsonBuilder.create().toJson(nearbyPoi.getList(1, 1000)));
		//【请求地址】: https://api.weixin.qq.com/wxa/getnearbypoilist?page=1&page_rows=1000&access_token=22_nPiUJiNwVxnQWpDGzJ-Vy1Pc8hqGmkuAMrGemKCVYH7Y0CR0BwwJ6LECZYRe0YLDQkyEQgKd4YVTC_b3wW0rwxobJs1VajvQh6AtQwc2xeJGM7gBtshGC5ObDOgUHVfAFANAO
		//【请求参数】：null
		//【错误信息】：{"errcode":93011,"errmsg":"个人类型小程序不可用 hint: [pvYega09344711]"}
	}
	
	@Test
	void testSetShowStatus() throws WxErrorException{
		WxMaNearbyPoiService nearbyPoi = wxService.getNearbyPoiService();
		nearbyPoi.setShowStatus("poiId", 1);
	}
}
