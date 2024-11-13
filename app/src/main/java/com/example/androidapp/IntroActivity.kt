package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import com.example.androidapp.Authentication.SignInActivity
import io.github.dreierf.materialintroscreen.MaterialIntroActivity
import io.github.dreierf.materialintroscreen.SlideFragmentBuilder

class IntroActivity : MaterialIntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSlide(
            SlideFragmentBuilder()
                .title("Personalized Skin Analysis")
                .image(R.drawable.intro1)
                .description("Discover a unique approach to skincare with our AI-powered app! Using advanced computer vision, we analyze your skin to detect issues like pimples, acne, dark spots, pigmentation, and more, giving you a clear understanding of your skin’s current condition.")
                .buttonsColor(R.color.introButton)
                .backgroundColor(R.color.intro1)

                .build()
        )
        addSlide(
            SlideFragmentBuilder()
                .title("Ayurvedic Solutions Tailored to You")
                .image(R.drawable.intro2)
                .description("Get personalized, natural solutions with our Ayurvedic remedy recommendations. Our app suggests remedies crafted to address your skin's specific needs, offering a gentle and effective path to radiant, healthy skin.")
                .buttonsColor(R.color.intro2Button)
                .backgroundColor(R.color.intro2)

                .build()
        )
        addSlide(
            SlideFragmentBuilder()
                .title("Stay Consistent with Daily Reminders")
                .image(R.drawable.intro3)
                .description("Achieve lasting results with consistent care! Our app provides daily notifications to remind you of your skincare routine and timely water intake, helping you stay on track for glowing skin.")
                .buttonsColor(R.color.SoftGreen)
                .backgroundColor(R.color.PaleCream)
                .build()
        )

    }
    override fun onFinish() {
        // Start a new activity after the last slide
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()  // End the IntroActivity so users can’t go back to it
    }
}