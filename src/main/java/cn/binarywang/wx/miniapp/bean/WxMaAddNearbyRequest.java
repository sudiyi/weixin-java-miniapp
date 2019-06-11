package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

/**
 * 附近的小程序，添加地点
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/nearby-poi/nearbyPoi.add.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@Builder
public class WxMaAddNearbyRequest implements Serializable{

	private static final long serialVersionUID = -2661864706131375674L;

	/**
	 * 必填,写死为"1"
	 */
	@SerializedName("is_comm_nearby")
	private String isCommNearby;
	
	/**
	 * 门店图片，最多9张，最少1张，上传门店图片如门店外景、环境设施、商品服务等，图片将展示在微信客户端的门店页。图片链接通过文档https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738729中的《上传图文消息内的图片获取URL》接口获取。必填，文件格式为bmp、png、jpeg、jpg或gif，大小不超过5M pic_list是字符串，内容是一个json！
	 */
	@SerializedName("pic_list")
	private String picList;
	
	/**
	 * 必服务标签列表 选填，需要填写服务标签ID、APPID、对应服务落地页的path路径，详细字段格式见下方示例
	 */
	@SerializedName("service_infos")
	private String serviceInfos;
	
	/**
	 * 门店名字 必填，门店名称需按照所选地理位置自动拉取腾讯地图门店名称，不可修改，如需修改请重现选择地图地点或重新创建地点
	 */
	@SerializedName("store_name")
	private String storeName;
	
	/**
	 * 营业时间，格式11:11-12:12 必填
	 */
	private String hour;
	
	/**
	 * 资质号 必填, 15位营业执照注册号或9位组织机构代码
	 */
	private String credential;
	
	/**
	 * 地址，必填
	 */
	private String address;
	
	/**
	 * 主体名字，必填
	 */
	private String companyName;
	
	/**
	 * 证明材料 必填 如果company_name和该小程序主体不一致，需要填qualification_list，详细规则见附近的小程序使用指南-如何证明门店的经营主体跟公众号或小程序帐号主体相关http://kf.qq.com/faq/170401MbUnim17040122m2qY.html
	 */
	@SerializedName("qualification_list")
	private String qualificationList;
	
	/**
	 * 客服信息 选填，可自定义服务头像与昵称，具体填写字段见下方示例kf_info pic_list是字符串，内容是一个json！
	 */
	@SerializedName("kf_info")
	private String kfInfo;
	
	/**
	 * 如果创建新的门店，poi_id字段为空 如果更新门店，poi_id参数则填对应门店的poi_id 选填
	 */
	@SerializedName("poi_id")
	private String poiId;
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
