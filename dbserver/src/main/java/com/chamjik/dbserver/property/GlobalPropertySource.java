//package com.chamjik.dbserver.property;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
////@PropertySources({
////        @PropertySource( value = "file:c:/private/pvapplication.yml", ignoreResourceNotFound = true)
////})
//public class GlobalPropertySource {
//
//    @Value("${spring.datasource.driverClassName}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    public String getDriverClassName() {
//        return driverClassName;
//    }
//
//    public String getUrl() { return url; }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//}