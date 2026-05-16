package net.Chidoziealways.everythingkorean.quests

import net.Chidoziealways.everythingcore.quest.Quest
import net.Chidoziealways.everythingcore.quest.QuestReward
import net.Chidoziealways.everythingcore.quest.QuestStage
import net.Chidoziealways.everythingcore.util.SharedRegistries
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation

object KoreanQuests {
    val KILL_PILLAGERS = register("kill_pillagers")

    val KILL_ZOMBIES = register("kill_zombies")

    fun register(name: String): ResourceKey<Quest> {
        return ResourceKey.create(SharedRegistries.QUEST, ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, name))
    }

    fun bootstrap(ctx: BootstrapContext<Quest>) {
        ctx.register(
            KILL_PILLAGERS,
            Quest(
                ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "kill_pillagers"),
                Component.literal("Kill Pillagers"),
                Component.literal("Kill 5 Pillagers"),
                listOf(
                    QuestStage(
                        Component.literal("Kill 5 Pillagers"),
                        ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "pillager")
                    )
                ),
                listOf(
                    QuestReward(
                        ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "pillager")
                    )
                ),
                false,
                ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "air")
            )
        )

        ctx.register(
            KILL_ZOMBIES,
            Quest(
                ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "kill_zombies"),
                Component.literal("Kill Zombies"),
                Component.literal("Kill 15 Zombies"),
                listOf(
                    QuestStage(
                        Component.literal("Kill 15 Zombies"),
                        ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "zombie")
                    )
                ),
                listOf(
                    QuestReward(
                        ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "zombie")
                    )
                ),
                false,
                ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "kill_pillagers")
            )
        )
    }
}