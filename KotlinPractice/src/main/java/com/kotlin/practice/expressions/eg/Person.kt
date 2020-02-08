package com.kotlin.practice.expressions.eg

class Person(val age: Int, val name: String){
    override fun equals(other: Any?): Boolean {
        val other = (other as? Person)?: return false
        return other.age == age && other.name == name
    }

    override fun hashCode(): Int {
        return 1 + 7 * age + 13 * name.hashCode()
    }
}

fun main() {
    val persons = HashSet<Person>()

//    (0..5).forEach {
//        persons += Person(20, "Benny")
//    }

    val person = Person(20, "Benny")
    persons += person

    // a moment later
    println(persons.size)

    val person2 = Person(person.age+1, person.name)

    persons -= person

    println(persons.size)
}