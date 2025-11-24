package mba.sno.myopia.client.mixin;

import com.mojang.blaze3d.textures.FilterMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(targets = "com.mojang.blaze3d.textures.GpuTexture")
public class BlurMixin {
    @ModifyVariable(at = @At(value = "HEAD"), method = "setTextureFilter(Lcom/mojang/blaze3d/textures/FilterMode;Lcom/mojang/blaze3d/textures/FilterMode;Z)V", ordinal = 0, argsOnly = true)
    private static FilterMode setMin(FilterMode value) {
        return FilterMode.LINEAR;
    }
    @ModifyVariable(at = @At(value = "HEAD"), method = "setTextureFilter(Lcom/mojang/blaze3d/textures/FilterMode;Lcom/mojang/blaze3d/textures/FilterMode;Z)V", ordinal = 1, argsOnly = true)
    private static FilterMode setMag(FilterMode value) {
        return FilterMode.LINEAR;
    }
}