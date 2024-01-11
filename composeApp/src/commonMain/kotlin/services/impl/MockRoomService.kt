package ru.gimaz.testmulyiplatform.android.services.impl

import data.RoomPreviewData
import data.roomPreviews

class MockRoomService {
    fun getRoomsPReview(): List<RoomPreviewData>{
        return roomPreviews
    }
    fun getRoomPreview(id: String): RoomPreviewData {
        return roomPreviews.find { it.roomId==id }!!
    }
}