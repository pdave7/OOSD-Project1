import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import java.util.ArrayList;
import utilities.BoundingBox;

public class World {

	private static final String backgroundImage = "res/space.png";
	private int startpos = 64;
	private int playerXpos = 480;
	private int playerYpos = 688;
	private int num_enemies = 8;
	private static int enemylocationX = 128;
	private static int enemylocationY = 32;
	private static int total_enemies = 8;

	private ArrayList<Laser> lasers;
	private ArrayList<Droid> enemies;
	private Player renderplayer;
	private Background background;

	/* Initialising all the Sprite in the game */
	public World() {
		this.lasers = new ArrayList<Laser>();
		this.enemies = new ArrayList<Droid>(total_enemies );
		background = new Background(backgroundImage);
		renderplayer = new Player(playerXpos, playerYpos);

		for (int i = 0; i < num_enemies; i++) {
			enemies.add(i, new Droid(startpos + (enemylocationX * i), enemylocationY));
		}

	}

	/* Updating the sprite positions according to what happens in the game. */
	public void update(GameContainer gc, Input input, int delta) {
		background.update(input, delta);
		renderplayer.update(input, delta, lasers);

		ArrayList<Droid> renemies = new ArrayList<>();
		ArrayList<Laser> rlasers = new ArrayList<>();
		for (Laser laser : this.lasers) {
			laser.update(input, delta);

		}
		/*
		 * Removing the lasers and enemies when they make contact with each other using
		 * the bounding box intersect method. It also kills the game once the player
		 * touches the enemy
		 */
		BoundingBox pbox = renderplayer.getBbox();
		for (Droid droid : this.enemies) {
			BoundingBox ebox = droid.getBbox();
			for (Laser laser : this.lasers) {
				BoundingBox lbox = laser.getBbox();
				if (lbox.intersects(ebox)) {
					rlasers.add(laser);
					renemies.add(droid);
				}
			}
			if (pbox.intersects(ebox)) {
				gc.exit();
			}

		}

		for (Droid droid : renemies) {
			this.enemies.remove(droid);
		}
		for (Laser laser : rlasers) {
			this.lasers.remove(laser);
		}

	}

	/* Rendering all the sprites using the Sprite class */
	public void render() {

		background.render();
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render();
		}
		for (Laser dot : this.lasers) {
			dot.render();
		}
		renderplayer.render();
	}
}
