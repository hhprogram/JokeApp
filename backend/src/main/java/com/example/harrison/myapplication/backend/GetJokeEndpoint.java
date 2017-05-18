package com.example.harrison.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

/**
 * An endpoint class we are exposing Don't actually need this second endpoint. Thought at first
 * need one to one for class files and endpoints. But can have multiple MyBean type classes
 * utilized by just one endpoint file. But useful to see how to build an endpoint file myself.
 *
 * https://discussions.udacity.com/t/how-to-create-new-methods-to-call-api/32777/5
 *
 * helpful link. Should use strategy where I right click on a java class int he backened module
 * and click on the create google endpoint java class and it gives me a lot of the boiler plate code
 */
@Api(
        name = "getJokeApi",
        version = "v1",
        resource = "getJoke",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.harrison.example.com",
                ownerName = "backend.myapplication.harrison.example.com",
                packagePath = ""
        )
)
public class GetJokeEndpoint {

    private static final Logger logger = Logger.getLogger(GetJokeEndpoint.class.getName());

    //    returns a MyJoke instance object that has retrieved a joke at random from the java library
    @ApiMethod(name = "getJoke")
    public MyJoke getJoke() {
        MyJoke joke = new MyJoke();
        joke.getData();
        return joke;
    }


}