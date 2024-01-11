package navigation

import com.arkivanov.decompose.ComponentContext

class RoomComponent
    (
    componentContext: ComponentContext,
    val roomId: String,
    private val onGoBack: () -> Unit
) : ComponentContext by componentContext {
    fun goBack() {
        onGoBack()
    }
}