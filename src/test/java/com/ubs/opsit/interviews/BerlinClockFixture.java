package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock;
    private String theTime;
    
    @Before
    public void beforeTest() {
    	berlinClock=new TimeConverterImpl();
    }

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
        
    	String convertTime = berlinClock.convertTime(theTime);
    	/*System.out.println("Program OUT# => STARTS||-"+convertTime+"||ENDSHERE");
    	System.out.println(convertTime.length()+"\n");
    	System.out.println("Expected OUT# => STARTS||-"+theExpectedBerlinClockOutput+"||ENDSHERE\n");
    	System.out.println(theExpectedBerlinClockOutput.length()+"\n");*/
		assertThat(convertTime).isEqualTo(theExpectedBerlinClockOutput);
    }
}
