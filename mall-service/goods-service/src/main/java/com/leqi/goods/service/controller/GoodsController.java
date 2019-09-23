package com.leqi.goods.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leqi.common.core.Result;
import com.leqi.common.utils.StringUtils;
import com.leqi.goods.service.common.COSFileStorage;
import com.leqi.goods.service.entity.Goods;
import com.leqi.goods.service.service.GoodsService;
import com.leqi.goods.service.vo.GoodsVO;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwep
 * @since 2019-09-11
 */
@RestController
@RequestMapping("/goods/goods")
@Slf4j
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private COSFileStorage cosFileStorage;

    /**
     * 根据id获取单个商品信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public GoodsVO getGoods(@PathVariable("id") Long id){
        Goods goods = goodsService.getById(id);
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setId(goods.getId());
        goodsVO.setGoodsName(goods.getGoodsName());
        return goodsVO;
    }

    /**
     * 批量查询商品信息
     * @param ids
     * @return
     */
    @GetMapping("goods")
    public Result getGoodss(@RequestBody List<Long> ids){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",ids);
        List<Goods> list = goodsService.list(queryWrapper);
        return Result.ok(list);
    }

    @PostMapping("upload")
    public Result upload(MultipartFile file){
        String filename = file.getOriginalFilename();
        log.info("上传图片本地地址"+filename);
        String extName = filename.substring(filename.indexOf("."));

        try {
            cosFileStorage.fileUpload(file.getInputStream(), StringUtils.getFileExt(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.ok("上传成功");

    }

}
