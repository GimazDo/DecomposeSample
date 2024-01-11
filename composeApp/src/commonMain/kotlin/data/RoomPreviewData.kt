package data

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.gimaz.testmulyiplatform.android.data.Message


data class RoomPreviewData(val roomId: String, val roomName: String, val lastMessage: Message)

val roomPreviews= listOf(
    RoomPreviewData("1", "Корги", Message("Последнее сообщение", Clock.System.now().toLocalDateTime(
        TimeZone.currentSystemDefault()), "Koрги", "1")
    ),
    RoomPreviewData("2", "Канал", Message("Время собраться погавкать", Clock.System.now().toLocalDateTime(
        TimeZone.currentSystemDefault()), "Koрги", "2")
    ),
)