package ru.gimaz.testmulyiplatform.android.services.impl

import ru.gimaz.testmulyiplatform.android.data.Message
import ru.gimaz.testmulyiplatform.android.data.mockMessages

class MockMessageService: ru.gimaz.testmulyiplatform.android.services.MessageService {
    override fun getMessages(roomId: String): List<Message> {
        return mockMessages.filter { it.roomId == roomId }.sortedByDescending { it.createDate }
    }

}