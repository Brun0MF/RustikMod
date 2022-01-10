package fm.brunomf.rustik.entity.projectile;

import fm.brunomf.rustik.entity.ModEntityType;
import fm.brunomf.rustik.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.world.BlockEvent;

public class Bullet extends AbstractArrow {

    private final Item referenceItem;

    public Bullet(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.BULLET.get();
    }

    public Bullet(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.BULLET.get(), shooter, level);
        this.referenceItem = referenceItem;
    }


    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.CROP_BREAK;
    }


    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

}
