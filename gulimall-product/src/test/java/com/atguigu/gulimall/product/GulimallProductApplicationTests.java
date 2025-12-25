package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

//    @Test
//    public void testUpload() throws FileNotFoundException {
//        // 从环境变量获取访问凭证
//        String accessKeyId = "";
//        String accessKeySecret = "";
//
//        // 设置OSS地域和Endpoint
//        String region = "cn-beijing";
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//
//        // 创建凭证提供者
//        DefaultCredentialProvider provider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
//
//        // 配置客户端参数
//        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
//        // 显式声明使用V4签名算法
//        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
//
//        // 初始化OSS客户端
//        OSS ossClient = OSSClientBuilder.create()
//                .credentialsProvider(provider)
//                .clientConfiguration(clientBuilderConfiguration)
//                .region(region)
//                .endpoint(endpoint)
//                .build();
//
//        InputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\stayreal.png");
//        ossClient.putObject("gulimall-gxf", "stayreal.jpg", inputStream);
//
//        // 释放资源
//        ossClient.shutdown();
//        System.out.println("上传完成，OSS客户端已关闭");
//    }

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

}
