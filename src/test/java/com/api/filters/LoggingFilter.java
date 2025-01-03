package com.api.filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger= LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification reqSpec,
                           FilterableResponseSpecification resSpec,
                           FilterContext filterContext) {
        logRequest(reqSpec);
        Response response = filterContext.next(reqSpec, resSpec);
        logResponse(response);
        return response; //return for Assertion
    }

    public void logRequest(FilterableRequestSpecification reqSpec){
        logger.info("Base Uri:"+reqSpec.getBaseUri());
        logger.info("Request Header:"+reqSpec.getHeaders());
        logger.info("Request Payload:"+reqSpec.getBody());
    }

    public void logResponse(Response response){
        logger.info("STATUS CODE:"+response.getStatusCode());
        logger.info("Response Header:"+response.getHeaders());
        logger.info("Response Body:"+response.getBody().prettyPrint());
    }
}
