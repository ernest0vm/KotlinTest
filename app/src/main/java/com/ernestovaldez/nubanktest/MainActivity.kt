package com.ernestovaldez.nubanktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*
import kotlin.collections.ArrayList

data class Employee(
    val name: String,
    val nick: String,
    val birthDate: String,
    val phoneNumber: String,
    val email: String?
)

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newList : MutableList<Employee> = mutableListOf<Employee>()
        newList.add(Employee("nina","doom.slayer","01/01/1990","123",null))
        newList.add(Employee("noah","mister.n","01/01/1990","123",null))
        newList.add(Employee("nigel","nigel","01/01/1990","123",null))
        newList.add(Employee("nina","doom.slayer","01/01/1990","123",null))
        newList.add(Employee("noah","mister.n","01/01/1990","123",null))
        newList.add(Employee("nigel","nigel","01/01/1990","123",null))
        newList.add(Employee("nina","doom.slayer","01/01/1990","123",null))
        newList.add(Employee("nina","doom.slayer","01/01/1990","123",null))
        newList.add(Employee("nina","doom.slayer","01/01/1990","123",null))
        newList.add(Employee("noah","mister.n","01/01/1990","123",null))
        newList.add(Employee("noah","mister.n","01/01/1990","123",null))
        newList.add(Employee("noah","mister.n","01/01/1990","123",null))
        newList.add(Employee("nigel","nigel","01/01/1990","123",null))
        newList.add(Employee("nigel","nigel","01/01/1990","123",null))
        newList.add(Employee("nigel","nigel","01/01/1990","123",null))

        val returnedList = setupNewHires(newList)

        Log.d("output", returnedList.toString())

        val scanner = Scanner(System.`in`)
        val entries = mutableListOf<Entry>()
        while (scanner.hasNextLine()) {
            val newLine: String = scanner.nextLine()
            // Add some code here :)

        }
        entries.add(Entry("src", null))
        entries.add(Entry("File.kt", "src"))
        entries.add(Entry("Build.gradle", null))
        // do not remove this piece of code, or your exercise won't work
        var list: List<String> = getAllFiles(entries)

    }


    fun setupNewHires(employees: List<Employee>): List<Employee> {

        val employeeList : MutableList<Employee> = mutableListOf<Employee>()

        for(item in employees){

            if (!employeeList.any { x -> x.name == item.name
                        && x.nick == item.nick
                        && x.birthDate == item.birthDate
                        && x.phoneNumber == item.phoneNumber }) {

                val emailString: String = item.nick + "@nubank.com.br"
                employeeList.add(Employee(item.name, item.nick, item.birthDate, item.phoneNumber, emailString))

            }
        }

        return employeeList
    }



    // This class can be changed (or even removed), it was created only as a helper
    data class Entry(val name: String, val parent: String?)

    // Implement the function below. Feel free to add/remove parameters to your liking
    fun getAllFiles(entries: List<Entry>): List<String> {
        val entryList : MutableList<String> = mutableListOf<String>()
        for(item in entries){

                var str: String = "/" + item.name

                if(item.name == "src"){
                    str = ""
                }

                if (item.parent != null) {
                    str = "/" + item.parent + str
                }

                if (str != "") {
                    entryList.add(str)
                }
            }


        return entryList
    }

}
