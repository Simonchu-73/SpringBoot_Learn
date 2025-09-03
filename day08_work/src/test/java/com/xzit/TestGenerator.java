package com.xzit;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Types;

@SpringBootTest
public class TestGenerator {
    @Test
    public void generator() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT%2B8", "root", "080418")
                .globalConfig(builder -> {
                    builder.author("SimonChu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(".\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                                builder.parent("com.xzit") // 设置父包名
                                        .moduleName("generator") // 设置父包模块名
                        /*.pathInfo(Collections.singletonMap(OutputFile.xml, "D://")) // 设置mapperXml生成路径,实际有默认生成地址*/
                )
                .strategyConfig(builder ->
                        builder.addInclude("channel") // 设置需要生成的表名,可以通过,间隔配置多个自动生成相关代码的表名
                                .entityBuilder().enableLombok()
                                .controllerBuilder().enableRestStyle()

                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
