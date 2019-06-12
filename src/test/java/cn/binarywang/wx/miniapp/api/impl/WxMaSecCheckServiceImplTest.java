package cn.binarywang.wx.miniapp.api.impl;

import java.io.File;

import org.testng.annotations.*;

import cn.binarywang.wx.miniapp.api.WxMaSecCheckService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.extern.slf4j.Slf4j;

import com.google.inject.Inject;
import me.chanjar.weixin.common.error.WxErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * <pre>
 *
 * Created by Binary Wang on 2018/11/24.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Test
@Guice(modules = ApiTestModule.class)
@Slf4j
public class WxMaSecCheckServiceImplTest {
  @Inject
  private WxMaService wxService;

  @Test
  public void testCheckImage() throws WxErrorException {
    boolean result = this.wxService.getSecCheckService()
      .checkImage(new File(ClassLoader.getSystemResource("tmp.png").getFile()));
    assertTrue(result);
  }

  @DataProvider
  public Object[][] secData() {
    return new Object[][]{
      {"特3456书yuuo莞6543李zxcz蒜7782法fgnv级", false},
      {"完2347全dfji试3726测asad感3847知qwez到", false},
      {"hello world!", true}
    };
  }

  @Test(dataProvider = "secData")
  public void testCheckMessage(String msg, boolean result) {
    assertThat(this.wxService.getSecCheckService()
      .checkMessage(msg))
      .isEqualTo(result);
  }
  
  @Test
  public void testMediaCheckAsunc()throws WxErrorException{
	  WxMaSecCheckService secCheckService = this.wxService.getSecCheckService();
	  log.info(WxMaGsonBuilder.create().toJson(secCheckService.mediaCheckAsync("NbW2d1viXAHhKKE7Qt9yc-4RuQ2wV9hQJK2y0odxZkUDKpN_FT6jp5fGF3l8RWIa", 2)));
	  //【请求地址】: https://api.weixin.qq.com/wxa/media_check_async?access_token=22_cJ6FKPzg0H_DOLygpUiaIkmS8MX1PAI2BM8UgcZPr9ZT63PWK9xIZNiTWXJ3mTK3hGxd7L5siwGITO9BWc-y-_Ji7v6QBiUEX3saeNHZAbtj3denzit1xjApNPOLG5SplMW3ykHZx3W4aX4rBRJdAEAKAS
	  //【请求参数】：{"media_url":"NbW2d1viXAHhKKE7Qt9yc-4RuQ2wV9hQJK2y0odxZkUDKpN_FT6jp5fGF3l8RWIa","media_type":2}
	  //【响应数据】：{"errcode":0,"errmsg":"ok","trace_id":"4c33094b7a7ed3fc2d6701f67565d2d1"}
  }
}
