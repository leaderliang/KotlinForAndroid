package com.kotlin.practice.expressions.eg

/**
 * 添加进去作为 hashmap 的 key 的，或者 作为 HashSet 对象本身的，那么他的 equals 和 hashcode 在存储期间不要发生变化。
 *
 *
 * Person 里 构造函数里的属性，为了保证相等性，就设置为 val ，保持不可变
 *
 * 如果为 var，下面移除的时候，会移除失败
 */
class Person(val age: Int, val name: String) {
    override fun equals(other: Any?): Boolean {
        val other = (other as? Person) ?: return false
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


//    person.age++ // var age:Int
    persons -= person

//    val person2 = Person(person.age+1, person.name)
//    persons -= person2



    println(persons.size)
}