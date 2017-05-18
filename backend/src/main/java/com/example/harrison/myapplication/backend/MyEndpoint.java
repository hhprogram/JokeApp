/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.harrison.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.harrison.example.com",
                ownerName = "backend.myapplication.harrison.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {


    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    //    returns a MyJoke instance object that has retrieved a joke at random from the java library
    @ApiMethod(name = "getJoke")
    public MyJoke getJoke() {
        MyJoke joke = new MyJoke();
        joke.setData();
        return joke;
    }

//can add
    @ApiMethod(name = "sayBye")
    public MyBean sayBye(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

}
