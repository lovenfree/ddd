package did.lemonaid.solution.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@Profile({"local","dev"})
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


//    @Bean
//    public Docket raelApi()
//    {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.did"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo())
//                .groupName("01.Rael Common API")
//                .directModelSubstitute(LocalDateTime.class, String.class)
//                .tags(new Tag("test", "Schema"),
//                        new Tag[] { new Tag("Account", " 관리 API") ,
//                                new Tag("Wallet", "Wallet 관리 API"),
//                                new Tag("Organization", "Issuer 관리 API")})
//               .enable(true);
//    }


    @Bean
    public Docket rdisApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.did"))
//                .paths(PathSelectors.ant("/rdis/api/**"))
//                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.ant("/rael/api/file/**")))
                .paths(Predicates.not(PathSelectors.ant("/rael/api/account/**")))
                .paths(Predicates.not(PathSelectors.ant("/rdis/test/**")))
                .paths(Predicates.not(PathSelectors.ant("/")))
                .build()
                .apiInfo(apiInfo())
                .groupName("02.RDIS API")
                .directModelSubstitute(LocalDateTime.class, String.class)
                .tags(new Tag("Schema", "Schema 관리 API"),
                        new Tag[] {
                                new Tag("Schema", "Schema 관리 API"),
                                new Tag("Issue-VC", "VC 발급, 폐기 API"),
                                new Tag("Issue-VC-Performance", "VC 발급, 폐기 성능 API"),
                                new Tag("Credentials", "증명서 목록 관리 API"),
                                new Tag("VC DEF", "VC DEF 관리 API"),
                                new Tag("Wallet", "Wallet 관리 API"),
                                new Tag("Organization", "Issuer 관리 API")})
                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RDIS HTTP API")
//                .description("An Blockchain Spring Boot REST application for different API documentation tools.")
//                .termsOfServiceUrl("http://www.lgcns.com")
//                //todo: licence 확인
//                .license("licence 확인")
//                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("v0.0.1")
                .build();
    }

}
