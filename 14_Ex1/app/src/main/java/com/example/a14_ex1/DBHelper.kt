package com.example.a14_ex1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?
) : SQLiteOpenHelper(context, "database.db", null, 1) {

    val sql = arrayOf(
        "CREATE TABLE utilizador (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)",
        "INSERT INTO utilizador (username, password) VALUES ('user','pass')"
    )

    override fun onCreate(db: SQLiteDatabase) {
        sql.forEach {
            db.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE utilizador")
        onCreate(db)
    }

    fun eliminarConta(id: Int): Int {
        val db = this.writableDatabase
        val res = db.delete("utilizador", "id=?", arrayOf(id.toString()))
        db.close()
        return res
    }

    fun mudarPassword(id: Int, username: String, password: String): Int {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("username", username)
        cv.put("password", password)
        val res = db.update("utilizador", cv, "id=?", arrayOf(id.toString()))
        db.close()
        return res
    }

    fun registar(username: String, password: String): Long {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("username", username)
        cv.put("password", password)
        val res = db.insert("utilizador", null, cv)
        db.close()
        return res
    }

    fun login(username: String, password: String): Int {
        val db = this.readableDatabase
        val c = db.rawQuery(
            "SELECT * FROM utilizador WHERE username=? AND password = ?",
            arrayOf(username, password)
        )
        if (c.count == 1) {
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val id = c.getInt(idIndex)
            db.close()
            return id
        }
        db.close()
        return -1;
    }

    fun select(id: Int): Utilizador? {
        val db = this.readableDatabase
        val c = db.rawQuery(
            "SELECT * FROM utilizador WHERE id= ?",
            arrayOf(id.toString())
        )

        val utilizador = Utilizador()
        if (c.count > 0) {
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val usernameIndex = c.getColumnIndex("username")
            val passwordIndex = c.getColumnIndex("password")
            utilizador.id = c.getInt(idIndex)
            utilizador.username = c.getString(usernameIndex)
            utilizador.password = c.getString(passwordIndex)
            db.close()
            return utilizador
        }
        db.close()
        return null;
    }
}