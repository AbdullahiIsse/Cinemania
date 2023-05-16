package com.sep.cinemania.Controller.User

import groovyx.net.http.RESTClient
import spock.lang.Specification

class UserControllerTest extends Specification{
    private RESTClient baseEndpoint

    def setup() {
        baseEndpoint = new RESTClient('http://localhost:80/api/user')
    }


}
