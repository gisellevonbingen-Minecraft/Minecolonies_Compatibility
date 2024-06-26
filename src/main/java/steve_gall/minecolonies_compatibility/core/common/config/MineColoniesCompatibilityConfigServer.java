package steve_gall.minecolonies_compatibility.core.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import steve_gall.minecolonies_compatibility.core.common.entity.ai.JobConfig;
import steve_gall.minecolonies_compatibility.module.common.ModulesConfig;

public class MineColoniesCompatibilityConfigServer
{
	public static final MineColoniesCompatibilityConfigServer INSTANCE;
	public static final ForgeConfigSpec SPEC;

	static
	{
		var common = new ForgeConfigSpec.Builder().configure(MineColoniesCompatibilityConfigServer::new);
		INSTANCE = common.getLeft();
		SPEC = common.getRight();
	}

	public final JobConfig jobs;
	public final ModulesConfig modules;

	public MineColoniesCompatibilityConfigServer(ForgeConfigSpec.Builder builder)
	{
		builder.push("jobs");
		this.jobs = new JobConfig(builder);
		builder.pop();

		builder.push("modules");
		this.modules = new ModulesConfig(builder);
		builder.pop();
	}

}
