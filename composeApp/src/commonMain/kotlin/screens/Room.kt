package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import navigation.RoomComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ru.gimaz.testmulyiplatform.android.data.Message
import ru.gimaz.testmulyiplatform.android.services.impl.MockMessageService
import ru.gimaz.testmulyiplatform.android.services.impl.MockRoomService
import services.impl.AvatarMockService

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Room(
    roomId: String,
    component: RoomComponent
) {
    var textState by remember { mutableStateOf("") }
    val messageService = MockMessageService()
    val mockRoomService = MockRoomService()
    val avatarMockService = AvatarMockService()
    val messages = messageService.getMessages(roomId);
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(roomPreviewData = mockRoomService.getRoomPreview(roomId), component::goBack)

        LazyColumn(
            reverseLayout = true,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()

        ) {

            items(messages.size) { index ->
                Row {
                    Box(

                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    ) {
                    Image(
                        painter = painterResource("default.png"),
                        modifier = Modifier.padding(10.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = "test"
                    )
                    }
                    Message(messages[index])
                }
            }
        }

        TextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(8.dp)
        )
    }

}

@Composable
fun TopBar(
    roomPreviewData: RoomPreviewData,
    onGoBack: () -> Unit
) {
    var showMenu by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .border(1.dp, Color.Black)
            .fillMaxWidth(1f)
            .fillMaxHeight(0.05f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onGoBack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Назад")
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = roomPreviewData.roomName,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { showMenu = !showMenu }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Назад")
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Message(message: Message) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {

            Text(
                text = message.author,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(Alignment.Top)
            )
            Text(
                text = message.createDate.toString(),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(Alignment.Top)
            )

        }
        Text(
            text = message.content,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(horizontal = 10.dp)
        )

    }
}

