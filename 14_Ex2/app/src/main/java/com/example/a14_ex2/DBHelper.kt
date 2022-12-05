package com.example.a14_ex2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?,
) : SQLiteOpenHelper(context, "database.db", null, 1) {

    var sql = arrayOf(
        "CREATE TABLE aluno (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT)",
        "INSERT INTO aluno (nome, email) VALUES('Maria','maria@email.pt')",
        "INSERT INTO aluno (nome, email) VALUES('João','joao@email.pt')",
        "INSERT INTO aluno (nome, email) VALUES('Joana','joana@email.pt')",
        "INSERT INTO aluno (nome, email) VALUES('Filipe','filipe@email.pt')"
    )

    override fun onCreate(db: SQLiteDatabase) {
        sql.forEach { db.execSQL(it) }
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE aluno")
        this.onCreate(db)
    }

    fun selectAll(): ArrayList<Aluno> {
        val db = this.readableDatabase
        val c = db.rawQuery("SELECT * FROM aluno", null)
        val listaAluno = ArrayList<Aluno>()
        if (c.count > 0) {
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val nomeIndex = c.getColumnIndex("nome")
            val emailIndex = c.getColumnIndex("email")
            do {
                val id = c.getInt(idIndex)
                val nome = c.getString(nomeIndex)
                val email = c.getString(emailIndex)
                listaAluno.add(Aluno(id, nome, email))
            } while (c.moveToNext())
        }
        db.close()
        return listaAluno
    }

    fun selectByID(id: Int): Aluno {
        val db = this.readableDatabase
        val c = db.rawQuery("SELECT * FROM aluno", null)
        val aluno = Aluno()
        if (c.count > 0) {
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val nomeIndex = c.getColumnIndex("nome")
            val emailIndex = c.getColumnIndex("email")

            aluno.id = c.getInt(idIndex)
            aluno.nome = c.getString(nomeIndex)
            aluno.email = c.getString(emailIndex)
        }
        db.close()
        return aluno
    }

    fun insert(nome: String, email: String): Long {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("nome", nome)
        cv.put("email", email)
        val res = db.insert("aluno", null, cv)
        db.close()
        return res
    }

    fun update(id: Int, nome: String, email: String): Int {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("nome", nome)
        cv.put("email", email)
        val res = db.update("aluno", cv, "id=?", arrayOf(id.toString()))
        db.close()
        return res
    }

    fun delete(id: Int): Int {
        val db = this.writableDatabase
        val res = db.delete("aluno", "id=?", arrayOf(id.toString()))
        db.close()
        return res
    }
}