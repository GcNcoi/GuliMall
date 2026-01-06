package com.atguigu.gulimall.ware.feign;

import com.atguigu.common.to.SkuReductionTo;
import com.atguigu.common.to.SpuBoundTo;
import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimall-product")
public interface ProductFeignService {

    /**
     * 查询SKU信息
     * @param skuId
     * @return
     */
    @RequestMapping("/product/skuinfo/info/{skuId}")
    R findSKUNameById(@PathVariable("skuId") Long skuId);
}
