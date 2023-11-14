package mod.linguardium.angrybears.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Predicate;

@Mixin(PolarBearEntity.class)
public class PolarBearEntityMixin  {
	@ModifyArg(method="initGoals",at=@At(value="INVOKE",target="Lnet/minecraft/entity/ai/goal/ActiveTargetGoal;<init>(Lnet/minecraft/entity/mob/MobEntity;Ljava/lang/Class;IZZLjava/util/function/Predicate;)V"))
	private Predicate HulkRule(MobEntity mob, Class targetClass, int reciprocalChance, boolean checkVisibility, boolean checkCanNavigate, Predicate<LivingEntity> predicate) {
		return targetClass.equals(PlayerEntity.class)?null:predicate;
	}
}