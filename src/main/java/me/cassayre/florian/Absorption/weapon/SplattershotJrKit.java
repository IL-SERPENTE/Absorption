package me.cassayre.florian.Absorption.weapon;

import me.cassayre.florian.Absorption.game.GamePlayer;
import me.cassayre.florian.Absorption.utils.ParticleEffect;
import me.cassayre.florian.Absorption.weapon.core.MainPlayerWeapon;
import me.cassayre.florian.Absorption.weapon.core.WeaponType;
import me.cassayre.florian.Absorption.weapon.core.amo.AbstractAmo;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

public class SplattershotJrKit extends MainPlayerWeapon {
	
	public SplattershotJrKit() {
		super("Liquidateur Jr", "", new ItemStack(Material.WOOD_PICKAXE), WeaponType.SHOOTER, 0, 10, 6, 14);
		
		secondary = new SplashBombWeapon();
		special = new ShieldWeapon();
	}

	@Override
	public void onUse(final GamePlayer player) {
		new AbstractAmo(RANGE, DAMAGES, player.getPlayer().getLocation().getDirection(), player, WeaponType.SHOOTER) {

			@Override
			public void play(Location location) {
				
				for(int i = 0; i < 2; i++)
					ParticleEffect.REDSTONE.display(player.getTeamColor().getParticleColor(), location, 25);
				
				if(Math.random() >= 0.75)
				ParticleEffect.SNOW_SHOVEL.display(0, 0, 0, 0.01F, 1, location, 25);
				
				if(Math.random() >= 0.9)
				ParticleEffect.FIREWORKS_SPARK.display(0, 0, 0, 0.01F, 1, location, 25);
			}
			
			@Override
			public void onFire(Location location) {
				location.getWorld().playSound(location, Sound.ENDERMAN_TELEPORT, 1, 2F);
			}
			
		};
	}
}
