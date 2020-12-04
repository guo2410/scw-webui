package com.atguigu.scw.uiweb.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

@Component
public class AlipayConfig implements InitializingBean {
	public static String app_id;
	public static String merchant_private_key;
	public static String alipay_public_key;
	public static String notify_url;
	public static String return_url;
	public static String sign_type;
	public static String charset;
	public static String gatewayUrl;

	@Value("${alipay.app_id}")
	public String appid;
	@Value("${alipay.merchant_private_key}")
	public String merchantprivatekey;
	@Value("${alipay.alipay_public_key}")
	public String alipaypublickey;
	@Value("${alipay.notify_url}")
	public String notifyurl;
	@Value("${alipay.return_url}")
	public String returnurl;
	@Value("${alipay.sign_type}")
	public String signtype;
	@Value("${alipay.charset}")
	public String charset2;
	@Value("${alipay.gatewayUrl}")
	public String gatewayUrl2;

	@Override
	public void afterPropertiesSet() throws Exception {
		app_id = appid;
		merchant_private_key = merchantprivatekey;
		alipay_public_key = alipaypublickey;
		notify_url = notifyurl;
		return_url = returnurl;
		sign_type = signtype;
		charset = charset2;
		gatewayUrl = gatewayUrl2;
	}
}