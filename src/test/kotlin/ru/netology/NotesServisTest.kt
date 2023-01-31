package ru.netology

import org.junit.Assert.*
import org.junit.Test

class NotesServisTest {

    @Test
    fun addNote() {
        val title = "Note1"
        val text = "text in note1"

        val notes = NotesServis()
        val result = notes.addNote(title = title, text = text)

        assertTrue(result!=0)
    }

    @Test
    fun createComment() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val message = "comment1 for Note1"
        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        val result = notes.createComment(noteId,message )
        assertTrue(result > 0)

    }


    @Test
    fun delete_true() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        val result = notes.delete(noteId)

        assertTrue(result)
    }

    @Test
    fun delete_false() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 10

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        val result = notes.delete(noteId)

        assertFalse(result)
    }

    @Test
    fun deleteComment_true() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val message = "comment1 for Note1"
        val commentId = 1

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        notes.createComment(noteId,message)
        val result = notes.deleteComment(commentId)

        assertTrue(result)
    }

    @Test
    fun deleteComment_false() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val message = "comment1 for Note1"
        val commentId = 10

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        notes.createComment(noteId,message)
        val result = notes.deleteComment(commentId)

        assertFalse(result)
    }

    @Test
    fun edit_true() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val titleEdit = "Note1.1"
        val textEdit = "text in note1.1"

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        val result = notes.edit(noteId = noteId, title = titleEdit, text = textEdit)

        assertTrue(result)
    }

    @Test
    fun edit_false() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 10
        val titleEdit = "Note1.1"
        val textEdit = "text in note1.1"

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        val result = notes.edit(noteId = noteId, title = titleEdit, text = textEdit)

        assertFalse(result)
    }

    @Test
    fun editComment_true() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val message = "comment1 for Note1"
        val commentId = 1
        val messageEdit = "comment1.1 for Note1"
        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        notes.createComment(noteId,message)
        val result = notes.editComment(noteId,messageEdit)
        assertTrue(result)



    }

    @Test
    fun editComment_false() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val message = "comment1 for Note1"
        val commentId = 10
        val messageEdit = "comment1.1 for Note1"

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        notes.createComment(noteId,message)
        val result = notes.editComment(commentId,messageEdit)

        assertFalse(result)
    }

    @Test
    fun get_sortDown() {
        val title1 = "Note1"
        val text1 = "text in note1"
        val title2 = "Note2"
        val text2 = "text in note2"
        val title3 = "Note3"
        val text3 = "text in note3"
        val noteIds = setOf<Int>(1, 3)
        val sort = 0

        val notes = NotesServis()
        notes.addNote(title = title1, text = text1)
        notes.addNote(title = title2, text = text2)
        notes.addNote(title = title3, text = text3)
        val result = notes.get(noteIds = noteIds, sort = sort)

        assertEquals(2, result.size)
    }

    @Test
    fun get_sortUp() {
        val title1 = "Note1"
        val text1 = "text in note1"
        val title2 = "Note2"
        val text2 = "text in note2"
        val title3 = "Note3"
        val text3 = "text in note3"
        val noteIds = setOf<Int>(1, 3)
        val sort = 1

        val notes = NotesServis()
        notes.addNote(title = title1, text = text1)
        notes.addNote(title = title2, text = text2)
        notes.addNote(title = title3, text = text3)
        val result = notes.get(noteIds = noteIds, sort = sort)

        assertEquals(2  , result.size)
    }

    @Test
    fun getById() {
        val title1 = "Note1"
        val text1 = "text in note1"
        val noteId = 1

        val notes = NotesServis()
        notes.addNote(title = title1, text = text1)
        val result = notes.getById(noteId)

        assertEquals(1, result.noteId)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getById_NoteNotFoundException() {
        val title1 = "Note1"
        val text1 = "text in note1"
        val noteId = 0

        val notes = NotesServis()
        notes.addNote(title = title1, text = text1)

        notes.getById(noteId = noteId)
    }

    @Test
    fun getComments_sortDown() {
        val title1 = "Note1"
        val text1 = "text in note1"
        val noteId = 1
        val comment1 = "1"
        val comment2 = "2"
        val sort = 0

        val notes = NotesServis()
        notes.addNote(title = title1, text = text1)
        notes.createComment(noteId = noteId,comment1)
        notes.createComment(noteId = noteId,comment2)
        val result = notes.getComments(noteId = noteId, sort = sort)

        assertEquals(2, result.first().commentId)
    }

    @Test
    fun getComments_sortUp() {
        val title1 = "Note1"
        val text1 = "text in note1"
        val noteId = 1
        val comment1 = "1"
        val comment2 = "2"
        val sort = 1

        val notes = NotesServis()
        notes.addNote(title = title1, text = text1)
        notes.createComment(noteId = noteId,comment1)
        notes.createComment(noteId = noteId,comment2)
        val result = notes.getComments(noteId = noteId, sort = sort)

        assertEquals(1, result.first().commentId)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getComments_NoteNotFoundException() {
        val title1 = "Note1"
        val text1 = "text in note1"
        val noteId = 10
        val comment1 = "1"
        val comment2 = "2"
        val sort = 1

        val notes = NotesServis()
        notes.addNote(title = title1, text = text1)
        notes.createComment(noteId = noteId,comment1)
        notes.createComment(noteId = noteId,comment2)

        notes.getComments(noteId = noteId, sort = sort)
    }

    @Test
    fun restoreComment_true() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val message = "comment1 for Note1"
        val commentId = 1

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        notes.createComment(noteId = noteId,message)
        notes.deleteComment(commentId)
        val result = notes.restoreComment(commentId)

        assertTrue(result)
    }

    @Test
    fun restoreComment_false() {
        val title = "Note1"
        val text = "text in note1"
        val noteId = 1
        val message = "comment1 for Note1"
        val commentId = 10

        val notes = NotesServis()
        notes.addNote(title = title, text = text)
        notes.createComment(noteId = noteId,message)
        notes.deleteComment(commentId)
        val result = notes.restoreComment(commentId = commentId)

        assertFalse(result)
    }
}