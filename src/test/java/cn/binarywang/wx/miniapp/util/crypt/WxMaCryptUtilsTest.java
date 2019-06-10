package cn.binarywang.wx.miniapp.util.crypt;


import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 *
 * Created by Binary Wang on 2018/12/25.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaCryptUtilsTest {
  @Test
  public void testDecrypt() {
    String sessionKey = "7MG7jbTToVVRWRXVA885rg==";
    String encryptedData = "BY6VOgcWbwGcyrunK0ECWI8rnDsT69DucZ+M78tc1aL9aM/3bEAHFYd4fu7kRjWhD4YfjObw44T9vUqKyHIjbKs6hvtEasZZEIW35x4a91xVgN48ZqZ7MTQqUlP13kDUlkuwYh+/8g8yceu4kNbjowYrhihx+SV7CfjKCveJ7TSepr5Z7aLv1o+rfeelfOwn++WN/YoQsuZ6S3L4fWlWe5DAAUnFUI6cJvxxCohVzbrVXhyH2AqQdSjH2WnMYFeaGFIbcoxMznlk7oEwFn+hBj63dyT/swdYQfEdzuyCBmKXy8d6l1RKVX6Y65coTD8kIlbr+FKsqYrXVUIUBSwehqYuOdhYWZ9Bntl5DWU1oqzAPCnMn2cAIoQpQPKP7IGSxMOvCNAMhVXbE7BvnWuVuGF+AM5tXAa9IVUhcMImGwLQqm4iV5uBd+5OcFObh3A4VJk9iBCBWSkBHa/rV9CVoY0bFv2F9/2Hv82++Ybl274=";
    String ivStr = "TarMFjnzHVxy8pdS93wQbw==";
    System.out.println(WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr));
//    System.out.println(WxMaCryptUtils.decryptAnotherWay(sessionKey, encryptedData, ivStr));
  }

  @Test
  public void testDecryptAnotherWay() {
    String encryptedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==";
    String ivStr = "r7BXXKkLb8qrSNn05n0qiA==";
    String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";

    assertThat(WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr))
      .isEqualTo(WxMaCryptUtils.decryptAnotherWay(sessionKey, encryptedData, ivStr));
  }
}
