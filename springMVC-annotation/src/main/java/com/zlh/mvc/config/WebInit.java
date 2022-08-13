package com.zlh.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//web工程的初始化类,代替Web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定Spring的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    /**
     * 指定SpringMVC的配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 指定DispatcherServlet的映射规则,即url-pattern
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        //字符集过滤器
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8",true,true);
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{filter,methodFilter};
    }
}
