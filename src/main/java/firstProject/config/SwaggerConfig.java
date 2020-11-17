package firstProject.config;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${spring.application.name}")
	private String applicationName;

	@Bean
	public Docket productApi() {
		Predicate<RequestHandler> selector = RequestHandlerSelectors.basePackage("firstProject.controller");
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(selector)
				.build()
				.securityContexts(Collections.singletonList(getContextSecurity()))
				.securitySchemes(Collections.singletonList(securityScheme()))
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Project I - Guide by Ms. Giang")
				.description("Service of Project-I in HUST by Mr. Thanh - 201920429")
				.version("1.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.build();
	}
	
	private SecurityScheme securityScheme() {
		return new ApiKey("api-key", "Authorization", "Header");
	}
	
	private SecurityReference securityReference(){
		return new SecurityReference("api_key", new AuthorizationScope[0]);
	}
	
	private SecurityContext getContextSecurity() {
		return SecurityContext.builder().securityReferences(Collections.singletonList(securityReference())).build();
		
	}
}
