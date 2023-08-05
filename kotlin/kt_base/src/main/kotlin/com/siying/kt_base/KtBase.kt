package com.siying.kt_base

fun main() {
}

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)

enum class Gender {
    MALE, FEMALE
}

val heroes = listOf(
    Hero("The Captain", 60, Gender.MALE),
    Hero("Frenchy", 42, Gender.MALE),
    Hero("The Kid", 9, null),
    Hero("Lady Lauren", 29, Gender.FEMALE),
    Hero("First Mate", 29, Gender.MALE),
    Hero("Sir Stephen", 37, Gender.MALE)
)