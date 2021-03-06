package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.JokeLib;
import com.example.harrison.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static android.content.ContentValues.TAG;

//this import works by first you need to rebuild the project once you've added the new endpoint
//class getJokeApi. And then after the "getJokeApi" it is usually the same thing but with the first
//letter capitalized

/**
 * Created by harrison on 5/13/17. taken from the google endpoints tutorial:
 *
 * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 * As you can see in their screen shot they created this class in the main 'app' module. which makes
 * sense as we will use an instance of this class to kick off an async task from main activity in
 * 'app' module and retrieve it from the java library
 *
 * Modified slightly to instead start an asynctask and then show the joke via teh droidjoke module's
 * main activity
 *
 * Overview: When the 'telljoke' button is pushed. We create an asynctask (this class) that
 * asynchronously retrieves a joke from GCE (via the java library) and then, in then in the main
 * activity we take the results of this async task and use it to launch the main activity of the
 * droidjoke android library
 *
 * using a simple custom class Triple so that I can pass the AsyncListener which in this case is the
 * activity that will be calling this asynctask and the jokelib instance created
 * in the main activity and an integer number. Want to pass the jokelib instance so that we
 * don't have to recreate one everytime we want a joke. can pass it around through intents
 * after the first asyncTask (if i want to pass a jokeLib instance object I have to make it
 * parcelable)
 * Remember for an asyncTask class declaration the elemnts within the brackets denote
 * <input type, progress return type, result return type>
 *    ex. we could have put Triple<AsyncListener, Context, Integer> in there.
 */

class EndpointsAsyncTask extends AsyncTask<AsyncListener, Void, String> {
//    the myApiServiceis type MyApi....this type is determined when you set the 'name' (see the
//    name field in MyEndPoint class) in the @API decorator.
    private static MyApi myApiService = null;
    private JokeLib jokes;
    private AsyncListener listener;

    @Override
    protected String doInBackground(AsyncListener... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        listener = params[0];
        String joke;
        try {
            Log.d(TAG, "calling backend");
//            getJoke() returns a getJoke() api method object. Then execute actually executes the
//            code within that method. Then that method returns a MyJoke object which has a
//            getData() method
            joke = myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            Log.d(TAG, "api service didn't work");
            return e.getMessage();
        }
        return joke;
    }


//    BELOW is starter code from teh GCE tutorial url (seen above) with some added coments so I know
//    whats happening. but need to adjust for different functionality for this specific app
//    @Override
//    protected String doInBackground(Pair<Context, String>... params) {
//        if(myApiService == null) {  // Only do this once
////            not exactly sure what this does - but think it creates some instance of an object
////            that is used to interact with the backend
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
//            // end options for devappserver
////          I think the build method creates an instence of MyEndPoint class which can be used
////            to create objects like MyBean to pass along data from the backend back to the app
//            myApiService = builder.build();
//        }
//// since there is a "... parmas" as the argument for this asynctask technically could have multiple
//// pairs. So params[0] is just getting the first pair object. Then .first and .second are a pair
////        object's attributes to get the 1st and 2nd element
//        context = params[0].first;
//        String name = params[0].second;
////        below what this does is uses our api service instance object and calls one of its methods
////        see MyEndpoint and that is has a sayhi method. Which I guess to actually run you need to
////        run the execute() method on. And then it returns a MyBean object. (see sayHi method how
////        response is a MyBean object. Then you see MyBean object has a getData method.
//        try {
//            return myApiService.sayHi(name).execute().getData();
//        } catch (IOException e) {
//            return e.getMessage();
//        }
//    }

//    just like in the movies app. The way I 'wait' for the async task to complete but still have
//    the code execute at the 'app' main activity is the same as the "movies" app by having the
//    main activity implement a AsyncListener interface. Then on the postExecute we call that method
//    on the passed in instance of the AsyncListener (ie the Main Activity calling the AsyncTask)
    @Override
    protected void onPostExecute(String result) {
        listener.onTaskCompletion();
    }
}