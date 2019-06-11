package cn.binarywang.wx.miniapp.api;

import cn.binarywang.wx.miniapp.api.impl.WxMaLgtGetContactResult;
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
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 物流助手模块
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.addOrder.html
 * @author yangtao
 * @date 2019/06/11
 */
public interface LogisticsService {

	/**
	 * 查询运单轨迹
	 */
	String GET_PATH = "https://api.weixin.qq.com/cgi-bin/express/business/path/get";

	/**
	 * 生成运单
	 */
	String ADD_ORDER = "https://api.weixin.qq.com/cgi-bin/express/business/order/add";

	/**
	 * 取消运单
	 */
	String CANCEL_ORDER = "https://api.weixin.qq.com/cgi-bin/express/business/order/cancel";

	/**
	 * 获取支持的快递公司列表
	 */
	String GET_ALL_DELIVERY = "https://api.weixin.qq.com/cgi-bin/express/business/delivery/getall";
	
	/**
	 * 获取运单数据
	 */
	String GET_ORDER = "https://api.weixin.qq.com/cgi-bin/express/business/order/get";

	/**
	 * 获取打印员。若需要使用微信打单 PC 软件，才需要调用。
	 */
	String GET_PRINTER = "https://api.weixin.qq.com/cgi-bin/express/business/printer/getall";
	
	/**
	 * 获取电子面单余额。仅在使用加盟类快递公司时，才可以调用。
	 */
	String GET_QUOTA = "https://api.weixin.qq.com/cgi-bin/express/business/quota/get";

	/**
	 * 更新打印员。若需要使用微信打单 PC 软件，才需要调用。
	 */
	String UPDATE_PRINTER = "https://api.weixin.qq.com/cgi-bin/express/business/printer/update";

	/**
	 * 获取面单联系人信息
	 */
	String GET_CONTACT = "https://api.weixin.qq.com/cgi-bin/express/delivery/contact/get";
	
	/**
	 * 预览面单模板。用于调试面单模板使用。
	 */
	String PREVIEW_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/express/delivery/template/preview";
	
	/**
	 * 更新商户审核结果
	 */
	String UPDATE_BUSINESS = "https://api.weixin.qq.com/cgi-bin/express/delivery/service/business/update";
	
	/**
	 * 更新运单轨迹
	 */
	String UPDATE_PATH = "https://api.weixin.qq.com/cgi-bin/express/delivery/path/update";
	
	/**
	 * <pre>
	 * 查询运单轨迹
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getPath.html
	 * </pre>
	 * @param getPath
	 * @return
	 * @throws WxErrorException
	 */
	WxMaLgtGetPathResult getPath(WxMaLgtGetPathRequest getPath) throws WxErrorException;

	/**
	 * <pre>
	 * 生成运单
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.addOrder.html
	 * </pre>
	 * @param addOrder
	 * @return
	 * @throws WxErrorException
	 */
	WxMaLgtAddOrderResult addOrder(WxMaLgtAddOrderRequest addOrder) throws WxErrorException;
	
	/**
	 * <pre>
	 * 取消运单
	 * methods：POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.cancelOrder.html
	 * </pre>
	 * @param cancelRequest
	 * @throws WxErrorException
	 */
	void cancelOrder(WxMaLgtCancelOrderRequest cancelRequest) throws WxErrorException;

	/**
	 * <pre>
	 * 获取支持的快递公司列表
	 * methods:GET
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getAllDelivery.html
	 * </pre>
	 * @return
	 * @throws WxErrorException
	 */
	WxMaLgtGetAllDeliveryResult getAllDelivery() throws WxErrorException;

	/**
	 * <pre>
	 * 获取运单数据
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getOrder.html
	 * </pre>
	 * @param getOrder
	 * @return
	 * @throws WxErrorException
	 */
	WxMaLgtGetOrderResult getOrder(WxMaLgtCancelOrderRequest getOrder) throws WxErrorException;

	/**
	 * <pre>
	 * 获取打印员。若需要使用微信打单 PC 软件，才需要调用。
	 * methods:GET
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getPrinter.html
	 * </pre>
	 * @return
	 * @throws WxErrorException
	 */
	WxMaLgtGetPrinterResult getPrinter() throws WxErrorException;
	
	/**
	 * <pre>
	 * 获取电子面单余额。仅在使用加盟类快递公司时，才可以调用。
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.getQuota.html
	 * </pre>
	 * @param deliveryId 快递公司ID，参见getAllDelivery
	 * @param bizId 快递公司客户编码
	 * @return
	 * @throws WxErrorException
	 */
	Float getQuota(String deliveryId, String bizId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 更新打印员。若需要使用微信打单 PC 软件，才需要调用。
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.updatePrinter.html
	 * </pre>
	 * @param openid 打印员 openid
	 * @param updateType (更新类型：bind	绑定	、unbind	解除绑定)
	 * @throws WxErrorException
	 */
	void updatePrinter(String openid, String updateType) throws WxErrorException;

	/**
	 * <pre>
	 * 获取面单联系人信息
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.getContact.html
	 * </pre>
	 * @param token
	 * @param waybillId
	 * @return
	 * @throws WxErrorException
	 */
	WxMaLgtGetContactResult getContact(String token, String waybillId) throws WxErrorException;

	/**
	 * <pre>
	 * 更新商户审核结果
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.updateBusiness.html
	 * </pre>
	 * @param updateBusiness
	 * @throws WxErrorException
	 */
	void updateBusiness(WxMaLgtUpdateBusinessRequest updateBusiness) throws WxErrorException;

	/**
	 * <pre>
	 * 更新运单轨迹
	 * methods:POST
	 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-provider/logistics.updatePath.html
	 * </pre>
	 * @param updatePath
	 * @throws WxErrorException
	 */
	void updatePath(WxMaLgtUpdatePathRequest updatePath) throws WxErrorException;
}
