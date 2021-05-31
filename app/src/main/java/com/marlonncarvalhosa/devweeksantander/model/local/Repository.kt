package com.marlonncarvalhosa.devweeksantander.model.local

import com.marlonncarvalhosa.devweeksantander.model.Cartao
import com.marlonncarvalhosa.devweeksantander.model.Cliente
import com.marlonncarvalhosa.devweeksantander.model.Conta

class Repository {

    fun getLocalData(): Conta {
        val cliente = Cliente("Marlonn Carvalhosa")
        val cartao = Cartao("6666")

        return Conta(
            "9999999-2",
            "2111",
            "R$ 9.844,02",
            "R$ 20.000,00",
            cliente,
            cartao
        )
    }

}