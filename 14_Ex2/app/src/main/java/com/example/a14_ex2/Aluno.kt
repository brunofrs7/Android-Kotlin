package com.example.a14_ex2

class Aluno(var id: Int = 0, var nome: String = "", var email: String = "") {
    override fun toString(): String {
        return nome
    }
}