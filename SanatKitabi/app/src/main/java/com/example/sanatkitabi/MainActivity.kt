package com.example.sanatkitabi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
  try{
val myDatabase=this.openOrCreateDatabase("Musicians",Context.MODE_PRIVATE,null)
  myDatabase.execSQL("Create Table If Not Exists musicians(id INTEGER Primary key,name VARCHAR ,age Int)")
     // myDatabase.execSQL("UPDATE  musicians SET name ='Kirk  Hammet' where id= 3" )
    //  myDatabase.execSQL("Insert Into musicians (name ,age)Values('Ali',50)")// bu kısımda eğer null yaparsak dahi gelir neden çünkü kayıt yapıldı.
       //myDatabase.execSQL("Insert Into musicians (name ,age)Values('Ekber',540)")
    //  myDatabase.execSQL("Insert Into musicians (name ,age)Values('kirks',1453)")
     // val cursor=myDatabase.rawQuery("Select * from musicians where id = 3 ", null)//Selectionargs filtrlemee istiyotmusun diye soruyor
      // sQL Sorgularında like gibi anlamı taşır.
    // val cursor=myDatabase.rawQuery("Select * from musicians where name LIKE '%s'", null)//Like (gibi)den sonra yüzde işareti kelime içersinde bulunan olarak
                                                                                                                  //ele alınır.

     val cursor=myDatabase.rawQuery("Select * from musicians ", null)
myDatabase.execSQL("DELETE From musicians where name='Lars'")// Bu kısımda verileri silmek için kullanılıyor

      val nameIx=cursor.getColumnIndex("name")
      val ageIx=cursor.getColumnIndex("age")
      val idIx=cursor.getColumnIndex("id")

      while (cursor.moveToNext()){
          println("Name:"+ cursor.getString(nameIx))
          println("Age:"+ cursor.getInt(ageIx))
          println("Id:"+cursor.getInt(idIx))
      }
cursor.close()

  }catch (ex:Exception){
      ex.printStackTrace()
  }



    }
}