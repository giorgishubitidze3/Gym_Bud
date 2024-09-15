package com.spearson.gymbud.data.json

interface JsonParser <T> {
    suspend fun parse(json:String): List<T>
}