package com.example.trackit;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)

public class TripTest {

    private Trip mTrip;


    @Before
    public void setUp(){
        mTrip = new Trip();
    }



    @Test
    public void calculateTimeElapsed() {
        double resultTime = mTrip.getElapsedTime("10", "20");
        assertThat(resultTime, is(equalTo(10.0)));
    }


}
