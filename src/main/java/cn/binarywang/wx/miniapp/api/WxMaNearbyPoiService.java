package cn.binarywang.wx.miniapp.api;

import cn.binarywang.wx.miniapp.bean.WxMaAddNearbyRequest;
import cn.binarywang.wx.miniapp.bean.WxMaAddNearbyResult;
import cn.binarywang.wx.miniapp.bean.WxMaGetNearbyListResult;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 附近的小程序模块
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.add.html
 * @author yangtao
 * @date 2019/06/11
 */
public interface WxMaNearbyPoiService {

	/**
	 * 添加地点
	 */
	String NEARBYPOI_ADD = "https://api.weixin.qq.com/wxa/addnearbypoi";
	
	/**
	 * 删除地点
	 */
	String NEARBYPOI_DELETE = "https://api.weixin.qq.com/wxa/delnearbypoi";
	
	/**
	 * 查看地点列表
	 */
	String NEARBYPOI_GETLIST = "https://api.weixin.qq.com/wxa/getnearbypoilist";
	
	/**
	 * 展示/取消展示附近小程序
	 */
	String NEARBYPOI_SETSHOW_STATUS = "https://api.weixin.qq.com/wxa/setnearbypoishowstatus";

	/**
	 * <pre>
	 * 添加地点
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.add.html
	 * </pre>
	 * @param nearbyRequest
	 * @return
	 * @throws WxErrorException
	 */
	WxMaAddNearbyResult add(WxMaAddNearbyRequest nearbyRequest) throws WxErrorException;

	/**
	 * <pre>
	 * 删除地点
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.delete.html
	 * </pre>
	 * @param poiId 附近地点 ID
	 * @throws WxErrorException
	 */
	void delete(String poiId) throws WxErrorException;

	/**
	 * <pre>
	 * 查看地点列表
	 * methods:GET
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.getList.html
	 * </pre>
	 * @param page 起始页id（从1开始计数）
	 * @param pageRows 每页展示个数（最多1000个）
	 * @return
	 * @throws WxErrorException
	 */
	WxMaGetNearbyListResult getList(Integer page, Integer pageRows) throws WxErrorException;

	/**
	 * <pre>
	 * 展示/取消展示附近小程序
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.setShowStatus.html
	 * </pre>
	 * @param poiId 附近地点 ID
	 * @param status 是否展示(1展示，0不展示)
	 * @throws WxErrorException
	 */
	void setShowStatus(String poiId, Integer status) throws WxErrorException;
}
