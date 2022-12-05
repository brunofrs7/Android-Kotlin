package com.example.a08_ex2

class Pessoa(var latitude: Double, var longitude: Double, var titulo: String, var morada: String) {
    override fun toString(): String {
        return "${titulo} (${morada})";
    }
}