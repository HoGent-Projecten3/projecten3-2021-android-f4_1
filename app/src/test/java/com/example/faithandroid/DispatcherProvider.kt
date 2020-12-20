package com.example.faithandroid

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val io: CoroutineDispatcher
    val ui: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
<<<<<<< HEAD
}
=======
}
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3
