package gamingsquare.vtune.com.gamingsquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.view.View;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareHome;

/**
 * Created by Shreyash on 12/27/2017.
 */

public class IntroScr extends MaterialIntroActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.teal_500)
                .buttonsColor(R.color.first_slide_buttons)
                .image(R.drawable.bethesda)
                .title("Add Target")
                .description("Add your daily task to your regime!")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.second_slide_background)
                .buttonsColor(R.color.second_slide_buttons)
                .image(R.drawable.bethesda)
                .title("Manage Target's")
                .description("Look at all the tasks waiting for you!")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.third_slide_background)
                .buttonsColor(R.color.third_slide_buttons)
                .image(R.drawable.bethesda)
                .title("Track Task")
                .description("Track your tasks to keep yourself posted")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.first_slide_background)
                .buttonsColor(R.color.first_slide_buttons)
                .image(R.drawable.bethesda)
                .title("Track Progress")
                .description("See the progress to check your task status!")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.fourth_slide_background)
                .buttonsColor(R.color.fourth_slide_buttons)
                .title("That's it")
                .description("Would you join us?")
                .build());
    }

    @Override
    public void onFinish() {
        super.onFinish();
        startActivity(new Intent(IntroScr.this, GamingSquareHome.class));
    }
}
