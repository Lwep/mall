package com.leqi.goods.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leqi.common.core.Result;
import com.leqi.common.utils.StringUtils;
import com.leqi.goods.service.common.COSFileStorage;
import com.leqi.goods.service.entity.Goods;
import com.leqi.goods.service.service.GoodsService;
import com.leqi.goods.service.vo.GoodsVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private COSFileStorage cosFileStorage;
//
//    /**
//     * 根据id获取单个商品信息
//     * @param id
//     * @return
//     */
//    @GetMapping("{id}")
//    public GoodsVO getGoods(@PathVariable("id") Long id){
//        Goods goods = goodsService.getById(id);
//        GoodsVO goodsVO = new GoodsVO();
//        goodsVO.setId(goods.getId());
//        goodsVO.setGoodsName(goods.getGoodsName());
//        return goodsVO;
//    }

    /**
     * 根据分类id 查询对应的商品
     * @param cid
     * @return
     */
    @GetMapping("getGoods/{cid}")
    public Result getAllGoods(@RequestParam("cid") Long cid){
        List<Goods> list = goodsService.getGoodsForCatagory(cid);
        return Result.ok(list);
    }

//    @PostMapping
//    public Result addGoods(@RequestBody @Valid Goods goods){
//    if(goodsService.add(goods)){
//        return Result.ok("添加成功");
//    }
//    return Result.fail("添加失败");
//    }

    @GetMapping("list")
    public Result getAllGoods(){
        List<Goods> list = goodsService.getList();
        return Result.ok(list);
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

    /**
     *  上传图片
     * @param file
     * @return
     */
    @PostMapping("upload")
    public Result upload(MultipartFile file){

        String filename=file.getOriginalFilename();
        log.info(filename);
        try {
            String path=cosFileStorage.fileUpload(file.getInputStream(), StringUtils.getFileExt(filename));
            if(org.apache.commons.lang.StringUtils.isNotEmpty(path)){
                return Result.ok("上传成功",path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.fail("上传失败");
    }

}
