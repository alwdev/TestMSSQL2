package com.startech.testmssql2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Connection
import java.sql.ResultSet


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val connect: Connection? = connectionClass().dbConn()

            if (connect != null) {
                querySQL(editTextExe.text.toString(), connect)
            }
        }
    }
    fun querySQL(COMMANDSQL: String, connect: Connection) {
        val rs: ResultSet?
        try
        {
            val statement = connect.createStatement()

            rs = statement.executeQuery(COMMANDSQL)
//            val data: List<Map<String, String>>?
            val data = ArrayList<ModelItem>()
            if (rs != null) {
                while (rs.next()) {
//                    Log.d("getString", rs.getString("ItemDesc"))
                    data.add(ModelItem(rs.getString(1),rs.getString(3)))
                }
            }
            val adapterItem = AdapterItem(data)
            listView.layoutManager  = GridLayoutManager(
                this,
                1,
                GridLayoutManager.VERTICAL,
                false
            )
            listView.adapter = adapterItem

        }
        catch (e: Exception) {
            Log.e("ERROR", e.message)
        }
    }
}