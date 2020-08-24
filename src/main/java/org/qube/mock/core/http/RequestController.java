package org.qube.mock.core.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
public class RequestController {

    private static final Logger LOG = LogManager.getLogger();

    @RequestMapping("/**")
    public String home(final HttpServletRequest request) throws IOException {
        LOG.debug("request body -> {}", request.getReader().lines().collect(Collectors.joining()));
        return "response";
    }

    public static void main(String[] args) {
        SpringApplication.run(RequestController.class, args);
    }
}
