package com.example.a13_recyclerview.data

import com.example.a13_recyclerview.model.Carro

class CarroMock() {
    var listaCarros = ArrayList<Carro>()

    init {
        for (i in 0..100) {
            listaCarros.add(Carro(i, i.toString()))
        }
    }
}

