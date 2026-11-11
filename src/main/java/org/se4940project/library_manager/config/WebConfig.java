package org.se4940project.library_manager.config;

import org.se4940project.library_manager.interceptor.AdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Protect administrative paths, leaving /books and /cart open to everyone
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/books/add", "/books/save");
    }
}
