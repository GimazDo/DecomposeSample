package screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.RoomPreviewData
import navigation.RoomsPreviewComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ru.gimaz.testmulyiplatform.android.services.impl.MockRoomService

@Composable
fun RoomsPreview(
    component: RoomsPreviewComponent,
    modifier: Modifier = Modifier
) {
    val mockRoomService = MockRoomService()
    val rooms = mockRoomService.getRoomsPReview()
    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier) {

            Row(
                modifier = Modifier
                    .border(1.dp, Color.Black)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.05f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Назад")
                Spacer(modifier = Modifier.weight(1f))
            }

            LazyColumn(modifier = Modifier.offset()) {
                items(rooms.size) { index ->
                    ChatPreview(
                        rooms[index],
                        component::navToRoom
                    )
                }
            }
        }
    }
}



@OptIn(ExperimentalResourceApi::class)
@Composable
fun ChatPreview(
    roomPreviewData: RoomPreviewData,
    onNavigateToRoom: (String) -> Unit
) {

    Row(modifier = Modifier.padding(vertical = 5.dp).clickable { onNavigateToRoom(roomPreviewData.roomId) }) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource("default.png"),
                contentScale = ContentScale.Crop,
                contentDescription = "test"
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
        ) {
            // Расположение названия чата и времени в одной строке
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Название комнаты
                Text(
                    text = roomPreviewData.roomName,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.weight(1f)
                )
                //Время сообщения
                Text(
                    text = roomPreviewData.lastMessage.createDate.toString(),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
            val lastMessageContent =
                if (roomPreviewData.roomName == roomPreviewData.lastMessage.author) {
                    roomPreviewData.lastMessage.content
                } else {
                    roomPreviewData.lastMessage.author + ": " + roomPreviewData.lastMessage.content
                }
            // Последнее сообщение
            Text(
                text = lastMessageContent,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }

}