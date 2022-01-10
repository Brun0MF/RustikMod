package fm.brunomf.rustik.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import fm.brunomf.rustik.Rustik;
import fm.brunomf.rustik.client.models.entity.BoarModel;
import fm.brunomf.rustik.entity.custom.Boar;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BoarRenderer<Type extends Boar> extends MobRenderer<Type, BoarModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Rustik.MOD_ID, "textures/entity/boar.png");
    public BoarRenderer(EntityRendererProvider.Context context) {
        super(context, new BoarModel<>(context.bakeLayer(ModelLayers.PIG)), 0.7f);
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}
