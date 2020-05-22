package com.motasem.ziad.mylibrary.db

import AddBook
import android.app.Activity
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.motasem.ziad.mylibrary.model.Categories
import com.motasem.ziad.mylibrary.model.User

class DatabaseHelper(activity: Activity) :
    SQLiteOpenHelper(activity, DATABASE_NAME, null, DATABASE_VERSION) {
    private val db: SQLiteDatabase = this.writableDatabase

    companion object {
        val DATABASE_NAME = "Books"
        val DATABASE_VERSION = 1
    }

    //DDL

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(User.TABLE_CREATE)
        db.execSQL(Categories.TABLE_CREATE)
        db.execSQL(AddBook.TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists ${User.TABLE_NAME}")
        db.execSQL("drop table if exists ${Categories.TABLE_NAME}")
        db.execSQL("drop table if exists ${AddBook.TABLE_NAME}")
        onCreate(db)
    }

    //DML
    fun insertUser(name: String, email: String, password: String, phone: String): Boolean {
        val cv = ContentValues()
        cv.put(User.COL_NAME, name)
        cv.put(User.COL_EMAIL, email)
        cv.put(User.COL_PASSWORD, password)
        cv.put(User.COL_PHONE, phone)
        return db.insert(User.TABLE_NAME, null, cv) > 0
    }

    fun getAllUsers(): ArrayList<User> {
        val data = ArrayList<User>()
        val c =
            db.rawQuery(
                "select * from ${User.TABLE_NAME} order by ${User.COL_ID} desc",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val user =
                User(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4))
            data.add(user)
            c.moveToNext()
        }
        c.close()
        return data
    }

    fun deleteUser(id: Int): Boolean {
        //return db.delete(Student.TABLE_NAME,"${Student.COL_ID} = ?", arrayOf(id.toString()))>0
        return db.delete(User.TABLE_NAME, "${User.COL_ID} = $id", null) > 0
    }

    fun updateUser(oldId: Int, name: String?, email: String?, phone: String): Boolean {
        val cv = ContentValues()
        //if(name!=null)
        cv.put(User.COL_NAME, name)
        cv.put(User.COL_EMAIL, email)
        cv.put(User.COL_PHONE, phone)
        return db.update(User.TABLE_NAME, cv, "${User.COL_ID} = $oldId", null) > 0
    }

    fun insertCategories(name: String, details: String, img: Int): Boolean {
        val cv = ContentValues()
        cv.put(Categories.COL_NAME, name)
        cv.put(Categories.COL_DETAILS, details)
        cv.put(Categories.COL_IMG, img)
        return db.insert(Categories.TABLE_NAME, null, cv) > 0
    }

    fun insertFavorate(id: Int, name: String, details: String, img: Int): Boolean {
        val cv = ContentValues()
        cv.put(Categories.COL_ID, id)
        cv.put(Categories.COL_NAME, name)
        cv.put(Categories.COL_DETAILS, details)
        cv.put(Categories.COL_IMG, img)
        return db.insert(Categories.TABLE_NAME, null, cv) > 0
    }

    fun insertBorrowed(id: Int, name: String, details: String, img: Int): Boolean {
        val cv = ContentValues()
        cv.put(Categories.COL_ID, id)
        cv.put(Categories.COL_NAME, name)
        cv.put(Categories.COL_DETAILS, details)
        cv.put(Categories.COL_IMG, img)
        return db.insert(Categories.TABLE_NAME, null, cv) > 0
    }

    fun getAllFavorate(): ArrayList<Categories> {
        val data = ArrayList<Categories>()
        val c =
            db.rawQuery(
                "select * from ${Categories.TABLE_NAME} order by ${Categories.COL_ID} desc",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val categories = Categories(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3))
            data.add(categories)
            c.moveToNext()
        }
        c.close()
        return data
    }

    fun getAllBorrowed(): ArrayList<Categories> {
        val data = ArrayList<Categories>()
        val c =
            db.rawQuery(
                "select * from ${Categories.TABLE_NAME} order by ${Categories.COL_ID} desc",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val categories = Categories(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3))
            data.add(categories)
            c.moveToNext()
        }
        c.close()
        return data
    }

    fun getAllCategories(): ArrayList<Categories> {
        val data = ArrayList<Categories>()
        val c =
            db.rawQuery(
                "select * from ${Categories.TABLE_NAME} order by ${Categories.COL_ID} desc",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val categories = Categories(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3))
            data.add(categories)
            c.moveToNext()
        }
        c.close()
        return data
    }

    fun deleteCategories(id: Int): Boolean {
        //return db.delete(Student.TABLE_NAME,"${Student.COL_ID} = ?", arrayOf(id.toString()))>0
        return db.delete(Categories.TABLE_NAME, "${Categories.COL_ID} = $id", null) > 0
    }

    fun updateCategories(oldId: Int, name: String?, details: String?): Boolean {
        val cv = ContentValues()
        //if(name!=null)
        cv.put(Categories.COL_NAME, name)
        cv.put(Categories.COL_DETAILS, details)
        return db.update(Categories.TABLE_NAME, cv, "${Categories.COL_ID} = $oldId", null) > 0
    }


    //DML Add Book

    fun insertAddBook(name: String, details: String, img: String): Boolean {
        val cv = ContentValues()
        cv.put(AddBook.COL_NAME, name)
        cv.put(AddBook.COL_DETAILS, details)
        cv.put(AddBook.COL_IMG, img)
        return db.insert(AddBook.TABLE_NAME, null, cv) > 0
    }

    fun getAllAddBook(): ArrayList<AddBook> {
        val data = ArrayList<AddBook>()
        val c =
            db.rawQuery(
                "select * from ${AddBook.TABLE_NAME} order by ${AddBook.COL_ID} desc",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val addBook = AddBook(c.getInt(0), c.getString(1), c.getString(2), c.getString(3))
            data.add(addBook)
            c.moveToNext()
        }
        c.close()
        return data
    }

    fun deleteAddBook(id: Int): Boolean {
        //return db.delete(Student.TABLE_NAME,"${Student.COL_ID} = ?", arrayOf(id.toString()))>0
        return db.delete(AddBook.TABLE_NAME, "${AddBook.COL_ID} = $id", null) > 0
    }

    fun updateAddBook(oldId: Int, name: String?, details: String?): Boolean {
        val cv = ContentValues()
        //if(name!=null)
        cv.put(AddBook.COL_NAME, name)
        cv.put(AddBook.COL_DETAILS, details)
        return db.update(AddBook.TABLE_NAME, cv, "${AddBook.COL_ID} = $oldId", null) > 0
    }
}