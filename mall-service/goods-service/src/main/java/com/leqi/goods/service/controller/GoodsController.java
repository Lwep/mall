package com.leqi.goods.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqi.common.core.Result;
import com.leqi.common.utils.StringUtils;
import com.leqi.goods.service.common.COSFileStorage;
import com.leqi.goods.service.entity.Goods;
import com.leqi.goods.service.request.GoodsRequest;
import com.leqi.goods.service.service.GoodsService;
import com.leqi.goods.service.vo.GoodsVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"商品API"})
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


    @PostMapping("/addGoods")
    @ApiOperation(value = "添加商品", notes = "添加商品", httpMethod = "POST")
    public Result addGoods(@RequestBody @Valid Goods goods){
        if (goodsService.add(goods)) {
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }
    /**
     * 根据分类id 查询对应的商品
     * @param cid
     * @return
     */
    @GetMapping("getGoods/{cid}")
    @ApiOperation(value = "根据分类id 查询对应的商品", notes = "根据分类id 查询对应的商品", httpMethod = "GET")
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

    @GetMapping
    @ApiOperation(value = "显示所有商品", notes = "显示所有商品", httpMethod = "GET")
    public Result getAllGoods(GoodsRequest goodsRequest){
        Page page = new Page<>(goodsRequest.getCurrent(), goodsRequest.getSize());
        IPage<Goods> iPage = goodsService.page(page);
        return Result.ok(iPage);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除单个商品", notes = "根据id删除单个商品", httpMethod = "DELETE")
    public Result delete(@PathVariable("id") String id){
        if(goodsService.removeById(id)){
            return Result.ok("删除成功");
        }
        else
            return Result.fail("删除失败");
    }




    @PostMapping("updateGoods")
    @ApiOperation(value = "修改商品", notes = "修改商品", httpMethod = "POST")
    public Result updateProd(@RequestBody Goods goods){
        if(goodsService.updateById(goods)){
            return Result.ok("修改成功");
        }else
            return Result.fail("修改失败");

    }



//    /**
//     * 批量查询商品信息
//     * @param ids
//     * @return
//     */
//    @GetMapping("goods")
//    public Result getGoodss(@RequestBody List<Long> ids){
//        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
//        queryWrapper.in("id",ids);
//        List<Goods> list = goodsService.list(queryWrapper);
//        return Result.ok(list);
//    }

    /**
     *  上传图片
     * @param file
     * @return
     */
    @PostMapping("upload")
    @ApiOperation(value = "上传图片", notes = "上传图片", httpMethod = "POST")

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



    /**
     * 批量删除商品
     * @param ids
     * @return
     */
    @DeleteMapping("batch")
    @ApiOperation(value = "根据ids批量删除商品", notes = "根据ids批量删除商品", httpMethod = "DELETE")
    public Result batch(@RequestBody List<String> ids){
        if(goodsService.removeByIds(ids)){
            return Result.ok("删除成功");
        }
        else
            return Result.fail("删除失败");
    }

}
