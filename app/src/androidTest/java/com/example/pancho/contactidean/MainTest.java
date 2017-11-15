package com.example.pancho.contactidean;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.example.pancho.contactidean.utils.RecyclerViewMatcher;
import com.example.pancho.contactidean.view.home.HomeView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by FRANCISCO on 29/08/2017.
 */

public class MainTest {

    @Rule
    public IntentsTestRule<HomeView> intentsTestRule = new IntentsTestRule<>(HomeView.class);

    @Before
    public void setup(){

    }

    @Test
    public void fetchUser() {

        //Opens the overflow menu
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click search
        onView(withText(R.string.fetch_user))
                .perform(click());

    }

    @Test
    public void LikeUser() {

        //Opens the overflow menu
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click search
        onView(withText(R.string.fetch_user))
                .perform(click());

        //Click hearth
        onView(withId(R.id.hearth_button))
                .perform(click());

    }

    @Test
    public void BrowseUser() {

        //Opens the overflow menu
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click search
        onView(withText(R.string.fetch_user))
                .perform(click());

        //Click hearth
        onView(withId(R.id.hearth_button))
                .perform(click());

        //Opens the overflow menu
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click search
        onView(withText(R.string.browse_local))
                .perform(click());

        //Click second element recycler
        onView(withRecyclerView(R.id.recycler)
                .atPositionOnView(1, R.id.img))
                .perform(click());

    }

    // Convenience helper
    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

}
