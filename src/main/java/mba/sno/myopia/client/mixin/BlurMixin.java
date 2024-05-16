package mba.sno.myopia.client.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(targets = "com.mojang.blaze3d.platform.GlStateManager")
public class BlurMixin {
    @ModifyVariable(at = @At(value = "HEAD"), method = "_texParameter(III)V", ordinal = 2, argsOnly = true)
    private static int filter(int value, @Local(ordinal = 1, argsOnly = true) int pname) {
        if (pname == 10240 || pname == 10241) {
            return 9729;
        }
        return value;
    }
}