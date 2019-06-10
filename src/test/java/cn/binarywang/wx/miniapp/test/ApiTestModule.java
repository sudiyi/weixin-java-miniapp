package cn.binarywang.wx.miniapp.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class ApiTestModule implements Module {
  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private static final String TEST_CONFIG_XML = "test-config.xml";

  @Override
  public void configure(Binder binder) {
    try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(TEST_CONFIG_XML)) {
      if (inputStream == null) {
        throw new RuntimeException("测试配置文件【" + TEST_CONFIG_XML + "】未找到，请参照test-config-sample.xml文件生成");
      }
      TestConfig config = TestConfig.fromXml(inputStream);
      config.setAccessTokenLock(new ReentrantLock());

      WxMaService wxService = new cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl();
      wxService.setWxMaConfig(config);

      binder.bind(WxMaService.class).toInstance(wxService);
      binder.bind(WxMaConfig.class).toInstance(config);
    } catch (IOException e) {
      this.log.error(e.getMessage(), e);
    }
  }

}
