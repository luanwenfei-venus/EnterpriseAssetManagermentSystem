package eams.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * webMVC配置
 * 
 * @author lil
 * @version v1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan("eams.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 自定义视图解析器
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 定义静态资源处理
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		super.addResourceHandlers(registry);
	}

	/**
	 * 定义拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new ManagerInterceptor())
				.addPathPatterns(new String[] { "/uselogs", "/uselogs/**", "/user", "/user/**" })//添加拦截
				.excludePathPatterns("/user/register");// excludePathPatterns 排除拦截
		registry.addInterceptor(new ManagerInterceptor())
		.addPathPatterns(new String[] {"/admin/**"})//添加拦截
		.excludePathPatterns("/admin/login","/admin");// excludePathPatterns 排除拦截
		super.addInterceptors(registry);
	}

}
