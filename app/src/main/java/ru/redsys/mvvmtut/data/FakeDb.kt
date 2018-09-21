package ru.redsys.mvvmtut.data

class FakeDb private constructor() {


    val dao = FakeQuoteDao()

    companion object {

        @Volatile
        private var instance: FakeDb? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDb().also { instance = it }
        }
    }
}