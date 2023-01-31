package ru.netology

data class Note(
    val noteId: Int=0,
    var comments: MutableList<Comment> = mutableListOf(),
    val date: Long = System.currentTimeMillis(),
    val title: String?=null,
    val text: String?=null,
    val isDelete: Boolean = false
)