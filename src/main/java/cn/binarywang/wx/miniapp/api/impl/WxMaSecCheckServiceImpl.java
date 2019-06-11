package cn.binarywang.wx.miniapp.api.impl;

import java.io.File;
import java.util.Map;

import cn.binarywang.wx.miniapp.api.WxMaSecCheckService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;

import com.google.gson.JsonObject;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.MediaUploadRequestExecutor;

/**
 * <pre>
 *
 * Created by Binary Wang on 2018/11/24.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaSecCheckServiceImpl implements WxMaSecCheckService {
  private WxMaService service;

  public WxMaSecCheckServiceImpl(WxMaService service) {
    this.service = service;
  }

  @Override
  public boolean checkImage(File file) throws WxErrorException {
    //这里只是借用MediaUploadRequestExecutor，并不使用其返回值WxMediaUploadResult
    WxMediaUploadResult result = this.service.execute(MediaUploadRequestExecutor
      .create(this.service.getRequestHttp()), IMG_SEC_CHECK_URL, file);
    return result != null;
  }

  @Override
  public boolean checkMessage(String msgString) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("content", msgString);
    try {
      this.service.post(MSG_SEC_CHECK_URL, jsonObject.toString());
    } catch (WxErrorException e) {
      return false;
    }

    return true;
  }

  @Override
  public String mediaCheckAsync(String mediaUrl, Integer mediaType) throws WxErrorException {
	JsonObject params = new JsonObject();
	params.addProperty("media_url", mediaUrl);
	params.addProperty("mediaType", mediaType);
	String responseContent = this.service.post(MEDIA_CHECK_ASYNC, params.toString());
	@SuppressWarnings("unchecked")
	Map<String, Object> result = WxMaGsonBuilder.create().fromJson(responseContent, Map.class);
	return result.get("trace_id").toString();
  }

}
