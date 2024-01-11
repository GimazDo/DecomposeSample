package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.RoomsPreview,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when(config) {
            Configuration.ScreenA -> Child.ScreenA(
                ScreenAComponent(
                    componentContext = context,
                    onNavigateToScreenB = { text ->
                        navigation.pushNew(Configuration.Room(text))
                    }
                )
            )
            is Configuration.ScreenB -> Child.ScreenB(
                ScreenBComponent(
                    text = config.text,
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )

            is Configuration.Room -> Child.Room(
                RoomComponent(
                    componentContext = context,
                    roomId = config.roomId,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )

            is Configuration.RoomsPreview -> Child.RoomsPreview(
                RoomsPreviewComponent(
                    componentContext = context,
                    onNavigateToRoom =  { roomId ->
                        navigation.pushNew(Configuration.Room(roomId))
                    }
                )
            )
        }
    }

    sealed class Child {
        data class ScreenA(val component: ScreenAComponent): Child()
        data class ScreenB(val component: ScreenBComponent): Child()
        data class Room(val component: RoomComponent): Child()

        data class RoomsPreview(val component: RoomsPreviewComponent): Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object ScreenA: Configuration()

        @Serializable
        data class ScreenB(val text: String): Configuration()

        @Serializable
        data class Room(val roomId: String): Configuration()

        @Serializable
        data object RoomsPreview: Configuration()
    }
}