package com.leqi.order.service;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lwep
 * @dareTime 2019/9/11 10:37
 */

@Slf4j
public class MysqlGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 运行方法
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        log.info("项目路径：" + projectPath);
        // TODO 1.类路径与注释
        gc.setOutputDir(projectPath + "/mall-service/order-service/src/main/java");
        gc.setAuthor("lwep");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // TODO 2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://139.9.7.40:3306/mall_order?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2b8");
        dsc.setSchemaName("public");
//        com.mysql.cj.jdbc.Driver--com.mysql.jdbc.Driver
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        // 用户名
        dsc.setUsername("root");
//        // 密码
        dsc.setPassword("Leleleqi123.");
        mpg.setDataSource(dsc);

        // TODO 3.包配置
        PackageConfig pc = new PackageConfig();
        // 如果没有模块，将此行注释
//        pc.setModuleName(scanner("模块名："));
        // 包名
        pc.setParent("com.leqi.order.service");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        //  TODO 4. Mapper文件配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 加载模板
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称--Mapper文件生成目录
//                return projectPath + "/mall-service/order-service/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                return projectPath + "/mall-service/order-service/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // TODO 5.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 基类定义
        strategy.setSuperEntityClass("com.leqi.common.core.BaseEntity");
        strategy.setEntityLombokModel(true);
        // 父类公共字段
        strategy.setSuperEntityColumns("id", "create_time", "update_time");
        // Boolean类型字段是否移除is前缀处理
//        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        // 自定义 mapper 父类 默认BaseMapper
//        strategy .setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")

        // 自定义 service 父类 默认IService
        // .setSuperServiceClass("com.baomidou.demo.TestService")
        // 自定义 service 实现类父类 默认ServiceImpl
        // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")

        strategy.setRestControllerStyle(true);
        // 自定义控制器基类地址
//        strategy.setSuperControllerClass("com.leqi.order.modules.system.controller.BaseController");
        // 设置控制器
        strategy.setControllerMappingHyphenStyle(true);
        // TODO 5.数据表操作
        strategy.setInclude(scanner("表名"));
        // 表名前缀
        strategy.setTablePrefix("order_");
        // 设置策略
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}