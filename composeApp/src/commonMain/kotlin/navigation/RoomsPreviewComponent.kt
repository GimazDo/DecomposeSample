package navigation

import com.arkivanov.decompose.ComponentContext

class RoomsPreviewComponent(
    componentContext: ComponentContext,
    private val onNavigateToRoom: (String) -> Unit
) : ComponentContext by componentContext {

    fun navToRoom(roomId: String){
        onNavigateToRoom(roomId)
    }
}