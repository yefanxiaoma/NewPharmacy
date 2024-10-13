package com.online_pharmacies.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;


import java.util.Collections;


/**
 * 代码生成器
 *
 * @author: Wang
 * @since: 2024/7/29 15:28
 * 需要修改的地方：
 * 1. FastAutoGenerator.create("jdbc:mysql://localhost:3306/pharmacy?serverTimezone=GMT%2B8", "root", "wj720829")
 * 2. outputDir(System.getProperty("user.dir") + "/demo/src/main/java"); // 指定输出目录
 * 3. builder.parent("com.example.demo") // 父包模块名
 * 4. builder.addInclude("？") // 设置需要生成的表名
 * 5. pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/demo/src/main/resources/mapper")); // 设置mapperXml生成路径
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 数据源配置
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/pharmacy?serverTimezone=GMT%2B8", "root", "wj720829")
                .globalConfig(builder -> {
                    builder.author("Wang")        // 设置作者
                            .enableSwagger()        // 开启 swagger 模式 默认值:false
                            .disableOpenDir()       // 禁止打开输出目录 默认值:true
                            .commentDate("yyyy-MM-dd") // 注释日期
                            .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                            .outputDir(System.getProperty("user.dir") + "/Online_pharmacies/src/main/java"); // 指定输出目录
                })

                .packageConfig(builder -> {
                    builder.parent("com.online_pharmacies") // 父包模块名
                            .controller("controller")   //Controller 包名 默认值:controller
                            .entity("entity")           //Entity 包名 默认值:entity
                            .service("service")         //Service 包名 默认值:service
                            .mapper("mapper")           //Mapper 包名 默认值:mapper
                            //.moduleName("xxx")        // 设置父包模块名 默认值:无
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/Online_pharmacies/src/main/resources/mapper")); // 设置mapperXml生成路径
                    //默认存放在mapper的xml下
                })

//

                .strategyConfig(builder -> {
                    builder.addInclude("drugdrugtype") // 设置需要生成的表名 可边长参数“user”, “user1”
                            .addTablePrefix("tb_", "gms_") // 设置过滤表前缀
                            .serviceBuilder()//service策略配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()// 实体类策略配置
                            .idType(IdType.ASSIGN_ID)//主键策略  雪花算法自动生成的id
                            .addTableFills(new Column("create_time", FieldFill.INSERT)) // 自动填充配置
                            .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
                            .enableLombok() //开启lombok
                            .logicDeleteColumnName("deleted")// 说明逻辑删除是哪个字段
                            .enableTableFieldAnnotation()// 属性加上注解说明
                            .controllerBuilder() //controller 策略配置
                            .formatFileName("%sController")
                            .enableRestStyle() // 开启RestController注解
                            .mapperBuilder()// mapper策略配置
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()//@mapper注解开启
                            .formatXmlFileName("%sMapper");
                })


                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
