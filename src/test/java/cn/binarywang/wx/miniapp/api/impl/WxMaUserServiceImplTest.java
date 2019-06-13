package cn.binarywang.wx.miniapp.api.impl;

import cn.binarywang.wx.miniapp.test.TestConfig;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.testng.annotations.*;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import com.google.inject.Inject;
import static org.testng.Assert.*;

/**
 * 测试用户相关的接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Guice(modules = ApiTestModule.class)
@Slf4j
public class WxMaUserServiceImplTest {

  @Inject
  private WxMaService wxService;

  @Test
  public void testGetSessionKey() throws Exception {
	  log.info(WxMaGsonBuilder.create().toJson(this.wxService.getUserService().getSessionInfo("033XbjAg09zfVw19zGxg0SA8Ag0XbjAa")));
	  //【请求地址】: https://api.weixin.qq.com/sns/jscode2session?access_token=22_DdZuPxR6y_49NrBhClKlBae6PnaMzxsbRMAi6DkEwTa_ruXq552fiR6aZiEdXlo5WSvHlj2vQbVgZAAnSI1ycTDlbg-myBBVYjnJlqBMZpcgMeZMlU2u5xRLrg69K2FKaZA42hIhmEFIXMFMSBMjAEAAJU
	  //【请求参数】：js_code=033XbjAg09zfVw19zGxg0SA8Ag0XbjAa&secret=******&grant_type=authorization_code&appid=wxe8b7c5dcd1af04f1
	  //【响应数据】：{"session_key":"LX62yQKyrJ/p8us18UTm2w==","openid":"ofGIs5Ia7QPLpHQ9ynrsMU25vbWk"}
  }

  public void testGetUserInfo() {
    WxMaUserInfo userInfo = this.wxService.getUserService().getUserInfo("tiihtNczf5v6AKRyjwEUhQ==",
      "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==",
      "r7BXXKkLb8qrSNn05n0qiA==");
    assertNotNull(userInfo);
    System.out.println(userInfo.toString());
  }

  public void testCheckUserInfo() {
    assertTrue(this.wxService.getUserService().checkUserInfo("HyVFkGl5F5OQWJZZaNzBBg==",
      "{\"nickName\":\"Band\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"Guangzhou\",\"province\":\"Guangdong\",\"country\":\"CN\",\"avatarUrl\":\"http://wx.qlogo.cn/mmopen/vi_32/1vZvI39NWFQ9XM4LtQpFrQJ1xlgZxx3w7bQxKARol6503Iuswjjn6nIGBiaycAjAtpujxyzYsrztuuICqIM5ibXQ/0\"}",
      "75e81ceda165f4ffa64f4068af58c64b8f54b88c"));
  }

  /**
   * TODO 测试数据有问题，需要替换为正确的数据
   */
  public void testGetPhoneNoInfo() {
    WxMaPhoneNumberInfo phoneNoInfo = this.wxService.getUserService().getPhoneNoInfo("tiihtNczf5v6AKRyjwEUhQ==",
      "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==",
      "r7BXXKkLb8qrSNn05n0qiA==");
    assertNotNull(phoneNoInfo);
    System.out.println(phoneNoInfo.toString());
  }

  public void testGetSessionInfo() {
  }

  /**
   *  TODO 测试数据有问题，需要替换为正确的数据
   */
  public void testSetUserStorage() throws WxErrorException {
    this.wxService.getUserService().setUserStorage(ImmutableMap.of("1","2"),
      "r7BXXKkLb8qrSNn05n0qiA",((TestConfig)this.wxService.getWxMaConfig()).getOpenid());
  }
}
