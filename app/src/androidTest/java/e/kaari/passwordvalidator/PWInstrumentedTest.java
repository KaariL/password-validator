package e.kaari.passwordvalidator;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Instrumented test runs on PasswordInputActivity to test possible inputs
 *
 *
 */
@RunWith(AndroidJUnit4.class)
public class PWInstrumentedTest {
    private String badPW = "password";
    private String goodPW = "aG00Dp4%%w3RD";


    @Rule
    public ActivityTestRule<PasswordInputActivity> activityActivityTestRule =
            new ActivityTestRule<PasswordInputActivity>(PasswordInputActivity.class);

    @Before
    public void clear() {
        Espresso.onView(withId(R.id.editPassword)).perform(ViewActions.clearText());
    }

    @Test
    public void goodPWTest() {
        Espresso.onView(withId(R.id.editPassword)).perform(ViewActions.typeText(goodPW));
        Espresso.onView(withId(R.id.strengthView)).check(matches(withText(R.string.success_message)));

    }
    @Test
    public void badPWTest() {
        Espresso.onView(withId(R.id.editPassword)).perform(ViewActions.typeText(badPW));
        Espresso.onView(withId(R.id.strengthView)).check(matches(withText(R.string.pending_success_message)));
    }

}
