package com.kotlinspring.entity

import javax.persistence.*


//client 가 쓰는 DTO를 DB에 그대로 쓰는 것은 피해야 한다. 그래서 entity를 따로 이렇게 만드는 것. ㅅㅂ
@Entity
@Table(name = "Courses")
data class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Int?,
    var name :String,
    var category: String
)
