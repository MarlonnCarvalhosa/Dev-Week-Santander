package com.marlonncarvalhosa.devweeksantander.ui

import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.marlonncarvalhosa.devweeksantander.R
import com.marlonncarvalhosa.devweeksantander.model.Conta
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        updataSaldo()
        buscarContaCliente()

        // Efeito click
        cv_pagar.setOnClickListener{}
        cv_recarga.setOnClickListener{}
        cv_transferir.setOnClickListener{}

        iv_saldo_hide.setOnClickListener(View.OnClickListener {
            hideBalance()
        })

    }

    private fun updataSaldo(){
        iv_update_saldo.setOnClickListener {
            rotateRefreshSaldo()
            tv_saldo.text = "R$ 2.380,00"
        }
    }

    private fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta){
        tv_nome.text = conta.cliente.nome
        tv_agencia.text = conta.agencia
        tv_conta.text = conta.numero
        tv_saldo.text = conta.saldo
        tv_valor_limite_saldo.text = conta.limite
        tv_numero_conta_final.text = conta.cartao.numeroCartao
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