package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Order(1)
    public FilterRegistrationBean<SiteMeshFilter> siteMeshFilter() {
        FilterRegistrationBean<SiteMeshFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new SiteMeshFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsPrepareAndExecuteFilter() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new StrutsPrepareAndExecuteFilter());
        registrationBean.addUrlPatterns("/");
        registrationBean.addUrlPatterns("/addUserForm.action");
        registrationBean.addUrlPatterns("/addUser.action");
        registrationBean.addUrlPatterns("/findUserForm.action");
        registrationBean.addUrlPatterns("/findUser.action");
        registrationBean.addUrlPatterns("/listAllUsers.action");

        return registrationBean;
    }
}
