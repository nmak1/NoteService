package ru.netology

data class Comment(
    var commentId: Int=0,
    var noteId: Int?=null,
    var date: Long = System.currentTimeMillis(),
    var message: String?=null,
    var isDelete: Boolean = false
)