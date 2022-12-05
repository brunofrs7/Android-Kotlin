package com.example.a15_mvvm_login

class PersonRepository {
    fun login(email: String, password: String): Boolean {
        return (email.equals("admin") && password.equals("pass"))
    }
}

