package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.atguigu.gulimall.product.entity.ProductAttrValueEntity;
import com.atguigu.gulimall.product.service.ProductAttrValueService;
import com.atguigu.gulimall.product.vo.AttrGroupRelationVo;
import com.atguigu.gulimall.product.vo.AttrRespVo;
import com.atguigu.gulimall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.atguigu.gulimall.product.service.AttrService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;


/**
 * 商品属性
 *
 * @author Ggg
 * @email 2284467180@qq.com
 * @date 2025-12-17 17:33:07
 */
@RestController
@RequestMapping("/product/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * 获取spu规格
     */
    @GetMapping("/base/listforspu/{spuId}")
    public R baseAttrListForSPU(@PathVariable("spuId") Long spuId){
        List<ProductAttrValueEntity> entities = productAttrValueService.baseAttrListForSPU(spuId);
        return R.ok().put("data", entities);
    }

    /**
     * 基本属性列表
     */
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String, Object> params,
                          @PathVariable("attrType") String type,
                          @PathVariable("catelogId") Long catelogId) {
        PageUtils page = attrService.queryBaseAttrPage(params, catelogId, type);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId) {
        AttrRespVo respVo = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", respVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr) {
        attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr) {
        attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 修改商品规格
     */
    @PostMapping("/update/{spuId}")
    public R updateSpuAtte(@PathVariable("spuId") Long spuId,
                           @RequestBody List<ProductAttrValueEntity> entities) {
        productAttrValueService.updateSpuAtte(spuId, entities);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
