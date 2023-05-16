package com.sep.cinemania.Controller.Swagger

import groovyx.net.http.RESTClient
import spock.lang.Specification

class SwaggerRedirectControllerTest extends Specification {

    private RESTClient baseEndpoint

    def setup() {
        baseEndpoint = new RESTClient('http://localhost:8080/')
    }

    def "baseEndpoint should redirect to swagger ui when path is '/' "() {
        when: 'Making a get request to the endpoint with the path "/"'
        def response = baseEndpoint.get(path: "/")

        then: 'Request should succeed with a redirection to the swagger ui'
        response.status == 200
        response.context["http.request"].uri.toString() == "/swagger-ui/index.html"
    }


    def "baseEndpoint should not redirect to swagger ui when path is not '/'"() {
        when: 'Making a get request to the endpoint with the path "api/user"'
        def response = baseEndpoint.get(path: "api/user")

        then: 'Request should not succeed with a redirection to the swagger ui'
        response.context["http.request"].uri.toString() != "/swagger-ui/index.html"
    }


}
