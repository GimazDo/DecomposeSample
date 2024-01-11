package ru.gimaz.testmulyiplatform.android.data

import kotlinx.datetime.LocalDateTime

public data class Message(val content: String, val createDate: LocalDateTime, val author: String,val roomId: String)

public val mockMessages = listOf(
    Message("Это очень длинное сообщение вот прям очень очень очень длинное. про выпоыв опыв опт тпуок кулп дыв лдлпы лыдваь  ьывь пткл ьцул лц кьцкт лцжук лцук цлкт цлукд цьук лцут цудщтуйш ьпвбыдж фьхщтй шаьмж буцз щтйоу лад", LocalDateTime.parse("2023-11-03T11:22"), "Корги", "1"),
    Message("Гав гав", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "1"),
    Message("Как дела?", LocalDateTime.parse("2023-11-03T11:22"), "Корги", "1"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "1"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Корги", "1"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
    Message("Привет!!", LocalDateTime.parse("2023-11-03T11:22"), "Ретривер", "2"),
)
