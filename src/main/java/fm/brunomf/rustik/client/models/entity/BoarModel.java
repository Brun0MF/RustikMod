package fm.brunomf.rustik.client.models.entity;

import fm.brunomf.rustik.entity.custom.Boar;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class BoarModel<Type extends Entity> extends QuadrupedModel<Type> {
    public BoarModel(ModelPart p_170799_) {
        super(p_170799_, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
    }


    public static LayerDefinition createBodyLayer(CubeDeformation cd) {
        MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, cd);
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, cd).texOffs(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, cd), PartPose.offset(0.0F, 12.0F, -6.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }
}
