package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.AllureRunner;


//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class MyTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityTestRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void isTextValid() {
        ViewInteraction mainText = onView(withId(R.id.text_home));
        mainText.check(matches(withText("This is home fragment")));
    }

    @Test
    public void isTextSlideshowValid() {
        ViewInteraction appCompatImageButton = onView(allOf(withContentDescription("Open navigation drawer")));
        appCompatImageButton.perform(click());
        ViewInteraction navigationMenuItemView = onView(allOf(withId(R.id.nav_slideshow)));
        navigationMenuItemView.perform(click());
        ViewInteraction textView = onView(allOf(withId(R.id.text_slideshow), withText("This is slideshow fragment"),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))), isDisplayed()));
        textView.check(matches(withText("This is slideshow fragment")));
    }
}
