package net.Chidoziealways.everythingkorean.item.custom

import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

class HwandoItem(props: Properties): Item(props) {
    override fun onEntitySwing(stack: ItemStack, entity: LivingEntity, hand: InteractionHand): Boolean {
        return super.onEntitySwing(stack, entity, hand)
    }
}