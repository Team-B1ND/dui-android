package kr.hs.dgsw.smartschool.dui

import kr.hs.dgsw.smartschool.dui.screen.Item
import kr.hs.smartschool.components.R

object DataSet {

    val dummyCard : Item =
        Item(R.drawable.ic_info_3d, "Typography", "테스트를 위한 이런 데이터도 괜찮지 않을까요? 사실 저는 말이 그렇게 많다고 생각하진 않는데 이런 걸 적으니까 금방 금방 문장이 불어나네요")

    val dummyList : List<Item> = listOf(
        dummyCard, dummyCard, dummyCard, dummyCard
    )
}