package com.example.domain.mapper

interface Mapper<R, D> {
    fun map(src: R): D
}