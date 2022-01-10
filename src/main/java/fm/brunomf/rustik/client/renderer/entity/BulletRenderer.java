package fm.brunomf.rustik.client.renderer.entity;

import fm.brunomf.rustik.Rustik;
import fm.brunomf.rustik.entity.projectile.Bullet;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BulletRenderer extends ArrowRenderer<Bullet> {

    public BulletRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Bullet pEntity) {
        return new ResourceLocation(Rustik.MOD_ID,"textures/item/bullet_texture.png");
    }
}
