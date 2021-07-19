package com.example.mobile_tugasakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var value: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ref = FirebaseDatabase.getInstance().getReference()

        loadData()
    }

    private fun loadData(){
        val humid = findViewById<TextView>(R.id.humid_value)
        val soil = findViewById<TextView>(R.id.moist_value)
        val temp = findViewById<TextView>(R.id.temp_value)
        val water = findViewById<TextView>(R.id.water_value)
        val humidval = ref.child("humidity_value")
        val soilval = ref.child("moisture_value")
        val tempval = ref.child("temperature_value")
        val waterval = ref.child("water_value")
        humidval.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                value = snapshot.child("humidity_value").getValue().toString()
                humid.setText(value)
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )

        soilval.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                soil.setText(snapshot.child("moisture_value").value.toString())
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )

        tempval.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                temp.setText(snapshot.child("temperature_value").value.toString())
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )

        waterval.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                water.setText(snapshot.child("water_value").value.toString())
            }
            override fun onCancelled(error: DatabaseError) {

            }
        } )


    }
}