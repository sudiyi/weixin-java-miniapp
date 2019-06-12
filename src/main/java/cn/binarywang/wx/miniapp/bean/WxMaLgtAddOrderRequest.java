package cn.binarywang.wx.miniapp.bean;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 生成运单
 * 接口文档：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/express/by-business/logistics.addOrder.html
 * @author yangtao
 * @date 2019/06/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxMaLgtAddOrderRequest implements Serializable{

	private static final long serialVersionUID = 8645242204059661609L;

	/**
	 * 订单ID，须保证全局唯一，不超过512字节
	 */
	@SerializedName("order_id")
	private String orderId;
	
	/**
	 * 用户 openid
	 */
	private String openid;
	
	/**
	 * 快递公司ID，参见getAllDelivery
	 */
	@SerializedName("delivery_id")
	private String deliveryId;
	
	/**
	 * 快递客户编码或者现付编码
	 */
	@SerializedName("biz_id")
	private String bizId;
	
	/**
	 * 快递备注信息，比如"易碎物品"，不超过1024字节
	 */
	@SerializedName("custom_remark")
	private String customRemark;
	
	/**
	 * 发件人信息
	 */
	private LgtAddOrderInfo sender;
	
	/**
	 * 收件人信息
	 */
	private LgtAddOrderInfo receiver;
	
	/**
	 * 包裹信息，将传递给快递公司
	 */
	private LgtAddOrderCargo cargo;
	
	/**
	 * 商品信息，会展示到物流通知消息中
	 */
	private LgtAddOrderShop shop;
	
	/**
	 * 保价信息
	 */
	private LgtAddOrderInsured insured;
	
	/**
	 * 服务类型
	 */
	private LgtAddOrderService service;
	
	@Data
	public class LgtAddOrderInfo implements Serializable{

		private static final long serialVersionUID = 3712577913483743570L;
		
		/**
		 * 发件人姓名，不超过64字节
		 */
		private String name;
		
		/**
		 * 发件人座机号码，若不填写则必须填写 mobile，不超过32字节
		 */
		private String tel;
		
		/**
		 * 发件人手机号码，若不填写则必须填写 tel，不超过32字节
		 */
		private String mobile;
		
		/**
		 * 发件人公司名称，不超过64字节
		 */
		private String company;
		
		/**
		 * 发件人邮编，不超过10字节
		 */
		@SerializedName("post_code")
		private String postCode;
		
		/**
		 * 发件人国家，不超过64字节
		 */
		private String country;
		
		/**
		 * 发件人省份，比如："广东省"，不超过64字节
		 */
		private String province;
		
		/**
		 * 发件人市/地区，比如："广州市"，不超过64字节
		 */
		private String city;
		
		/**
		 * 发件人区/县，比如："海珠区"，不超过64字节
		 */
		private String area;
		
		/**
		 * 发件人详细地址，比如："XX路XX号XX大厦XX"，不超过512字节
		 */
		private String address;
	}
	
	@Data
	public class LgtAddOrderCargo implements Serializable{

		private static final long serialVersionUID = 2506294322822071028L;
	
		/**
		 * 包裹数量
		 */
		private Integer count;
		
		/**
		 * 包裹总重量，单位是千克(kg)
		 */
		private Float weight;
		
		/**
		 * 包裹长度，单位厘米(cm)
		 */
		@SerializedName("space_x")
		private Float spaceX;
		
		/**
		 * 包裹宽度，单位厘米(cm)
		 */
		@SerializedName("space_y")
		private Float spaceY;
		
		/**
		 * 包裹高度，单位厘米(cm)
		 */
		@SerializedName("space_z")
		private Float spaceZ;
		
		/**
		 * 包裹中商品详情列表
		 */
		@SerializedName("detail_list")
		private List<LgtAddOrderCargoList> detailList;
		
	}
	
	@Data
	public class LgtAddOrderCargoList implements Serializable{

		private static final long serialVersionUID = 8024111056603763157L;
		
		/**
		 * 商品名，不超过128字节
		 */
		private String name;
		
		/**
		 * 商品数量
		 */
		private Integer count;
	}
	
	@Data
	public class LgtAddOrderShop implements Serializable{

		private static final long serialVersionUID = 223215864608532685L;
		
		/**
		 * 商家小程序的路径，建议为订单页面
		 */
		@SerializedName("wxa_path")
		private String wxaPath;
		
		/**
		 * 商品缩略图 url
		 */
		@SerializedName("img_url")
		private String imgUrl;
		
		/**
		 * 商品名称
		 */
		@SerializedName("goods_name")
		private String goodsName;
		
		/**
		 * 商品数量
		 */
		@SerializedName("goods_count")
		private Integer goodsCount;
	}
	
	@Data
	public class LgtAddOrderInsured implements Serializable{

		private static final long serialVersionUID = 4854892269638583633L;
		
		/**
		 * 是否保价，0 表示不保价，1 表示保价
		 */
		@SerializedName("use_insured")
		private Integer useInsured;
		
		/**
		 * 保价金额，单位是分，比如: 10000 表示 100 元
		 */
		@SerializedName("insured_value")
		private Integer insuredValue;
	}
	
	@Data
	public class LgtAddOrderService implements Serializable{

		private static final long serialVersionUID = 6530874133894361736L;
		
		/**
		 * 服务类型ID，详见已经支持的快递公司基本信息
		 */
		@SerializedName("service_type")
		private Integer serviceType;
		
		/**
		 * 服务名称，详见已经支持的快递公司基本信息
		 */
		@SerializedName("service_name")
		private String serviceName;
	}
	
	public String toJson(){
		return WxMaGsonBuilder.create().toJson(this);
	}
}
