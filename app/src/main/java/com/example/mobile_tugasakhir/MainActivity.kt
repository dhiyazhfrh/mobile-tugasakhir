package com.example.mobile_tugasakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var value: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ref = FirebaseDatabase.getInstance().getReference("sensor")
        val logout = findViewById<ImageView>(R.id.logout_button)
        loadData()

        logout.setOnClickListener {
            finish()
        }

    }

    private fun loadData(){
        val humid = findViewById<TextView>(R.id.humid_value)
        val soil = findViewById<TextView>(R.id.moist_value)
        val temp = findViewById<TextView>(R.id.temp_value)
        val water = findViewById<TextView>(R.id.water_value)
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                value = snapshot.child("humidity_value").value.toString()
                humid.setText(value)
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )

        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                soil.setText(snapshot.child("moisture_value").value.toString())
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )

        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                temp.setText(snapshot.child("temperature_value").value.toString())
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )

        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                water.setText(snapshot.child("water_value").value.toString())
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )


    }
}