package ru.gimaz.testmulyiplatform.android.services

import ru.gimaz.testmulyiplatform.android.data.Message

interface MessageService {

    fun getMessages(roomId: String): List<Message>

}