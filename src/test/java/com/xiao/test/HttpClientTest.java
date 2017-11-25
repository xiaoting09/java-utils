package com.xiao.test;

import com.xiao.http.HttpClientUtil;
import org.junit.Test;

/**
 * 测试类
 *
 * @author 肖亭
 * @since 2017年11月25 17:43
 **/
public class HttpClientTest {
    @Test
    public  void httpClient() {
        String rest = HttpClientUtil.getHttps("https://lsp.wuliu.taobao.com/locationservice/addr/output_address_town_array.do?l1=110000&l2=110100&l3=110101");
        System.out.println("rest = [" + rest + "]");

    }
}
