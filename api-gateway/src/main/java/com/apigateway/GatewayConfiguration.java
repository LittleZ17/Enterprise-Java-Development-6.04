package com.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                // Student info Service
                .route(p -> p.path("/api/student/**")
                        .uri("lb://STUDENT-INFO-SERVICE"))

                // Grade data Service
                .route(p -> p.path("/api/grades**")
                        .uri("lb://GRADES-DATA-SERVICE"))
                .route(p -> p.path("/api/course/**")
                        .uri("lb://GRADES-DATA-SERVICE"))

                // Student catalog Service
                .route(p -> p.path("/api/catalog/**")
                        .uri("lb://MOVIE-CATALOG-SERVICE"))

                .build();
    }
}
