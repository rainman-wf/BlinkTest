package ru.rainman.blinktest

import android.animation.TimeAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.rainman.blinktest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val drawable = GradientDrawable()
        drawable.orientation = GradientDrawable.Orientation.BL_TR
        drawable.colors = intArrayOf(Color.GRAY, Color.WHITE, Color.GRAY)

        binding.someView.background = drawable

        val animator = TimeAnimator.ofFloat(0f,1f   )
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.RESTART
        animator.duration = 1000
        animator.addUpdateListener {
            drawable.setGradientCenter(it.animatedFraction, 0.5f)
        }
        animator.start()
    }
}