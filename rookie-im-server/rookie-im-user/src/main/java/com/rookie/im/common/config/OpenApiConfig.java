package com.rookie.im.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: openapi 界面配置
 * @Author: junqiang.lu
 * @Date: 2023/8/15
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                // 接口文档标题
                .info(new Info().title("Knife4j OpenApi 3")
                        // 接口文档描述
                        .description("Knife4j OpenApi 3 example application")
                        // 接口文档版本
                        .version("v1.0")
                        // 开发者联系方式
                        .contact(new Contact().name("Flying9001").url("https://github.com/Flying9001")))
                .externalDocs(new ExternalDocumentation()
                        // 额外补充说明
                        .description("Github example code")
                        // 额外补充链接
                        .url("https://github.com/Flying9001/springBootDemo/demo-knife4j-openapi3"));
    }


}
