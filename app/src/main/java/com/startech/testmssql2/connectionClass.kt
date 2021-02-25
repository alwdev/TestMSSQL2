package com.startech.testmssql2

import android.annotation.SuppressLint
import android.os.StrictMode
import android.util.Log
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class connectionClass {

    private val ip = "192.168.1.222"
    private val db = "wanlamun"
    private val username = "sa"
    private val password = "admin123"

    @SuppressLint("LongLogTag")
    fun dbConn() : Connection? {

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        val connString: String?
        try {
//            Class.forName("net.sourgeforge.jtds.jdbc.Driver")
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password;"
            conn = DriverManager.getConnection(connString)
        }catch (ex: SQLException){
            Log.e("Error SQLException: ", ex.message.toString())
        }catch (ex1: ClassNotFoundException){
            Log.e("Error ClassNotFoundException: ", ex1.message.toString())
        }catch (ex2: Exception){
            Log.e("Error Exception: ", ex2.message.toString())
        }

        return conn
    }
}