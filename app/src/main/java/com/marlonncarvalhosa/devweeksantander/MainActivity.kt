package com.marlonncarvalhosa.devweeksantander

import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_saldo_hide.setOnClickListener(View.OnClickListener {
            hideBalance()
        })

        iv_update_saldo.setOnClickListener {
            rotateRefreshSaldo()
        }

    }

    private fun hideBalance() {
        tv_saldo?.isVisible = tv_saldo?.visibility != View.VISIBLE
        tv_limite_saldo?.isVisible = tv_limite_saldo?.visibility != View.VISIBLE
        tv_valor_limite_saldo?.isVisible = tv_valor_limite_saldo?.visibility != View.VISIBLE

        if(tv_saldo?.visibility != View.VISIBLE) {
            rotatioArrowHide(180f, 0f)
            iv_saldo_hide.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            rotatioArrowHide(180f, 360f)
            iv_saldo_hide.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
        }
    }

    private fun rotateRefreshSaldo() {
        val rotate = RotateAnimation(0f, 360f, 32f, 32f)
        rotate.duration = 500
        rotate.interpolator = LinearInterpolator()
        iv_update_saldo.startAnimation(rotate)
    }

    private fun rotatioArrowHide(from: Float, to: Float) {
        val rotate = RotateAnimation(from, to, 32f, 32f)
        rotate.duration = 500
        rotate.interpolator = LinearInterpolator()
        iv_saldo_hide.startAnimation(rotate)
    }
}