package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by harrison on 5/18/17.
 *
 * useful post:
 *
 * https://discussions.udacity.com/t/async-task-test-where-to-even-begin/159593/4
 *
 * look for Matt_from_Pestulon's post farther down where he posts his solution. except we don't
 * use AndroidTestCase as it has been deprecated. So use the new AndroidJUnit4.class.
 * When creating a new Android Module they provide you with example test classes (see droidjoke).
 * So just use that same decorator for this class. and then no longer have a setUp() method like in
 * AndroidTestCase class. So put all set up in each individual test method. And then instead of
 * putting 'test' in the front of each method we want to run as a test method we put a @Test
 * decorator for every test method we want to run (without it they won't be run).
 *
 * Also in my case my asyncTask doesn't need a Context as a paramter for execution those don't
 * need to make a mock context. If i did then I would need to do:
 * @Mock Context mockContext ...and then use that variable to as my context arg
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest implements AsyncListener{
    EndpointsAsyncTask task;
    String joke;


    public void onTaskCompletion() {

    }

    @Test
    public void TellJoke() throws Exception {
//        creating a new EndpointsAsyncTask instance object but then overriding the onPostExecute
//        because no need to run the onTaskCompletion method for a test. All we need is to make sure
//        RESULT isn't an empty string
        task = new EndpointsAsyncTask() {
            @Override
            public void onPostExecute(String result) {

            }
        };
//        we execute the EndpointsAsyncTask and feed the execute method with an instance of this
//        class which we have denoted as an AsyncListener by just 'implementing'
//        the onTaskCompletion method. Doing that allows us to properly call the asyncTask
        assertNotNull(task.execute(this).get());
    }

}