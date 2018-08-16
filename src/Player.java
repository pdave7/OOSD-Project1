import java.util.ArrayList;

import org.newdawn.slick.Input;

import utilities.BoundingBox;

public class Player extends Sprite {

	Input input;

	public static String playerimage = "res/spaceship.png";

	private float playerXpos;
	private float playerYpos;
	private static float speed = 0.5f;
	private static float divide_width = 2;
	private static int ScreenStartPos = 0;
	private static int offsetXlaser = 7;

	public Player(float x, float y) {
		super(playerimage, x, y);
	}

	/*
	 * Updating the players Xpos and Ypos when the different keys are hits and also
	 * updates the lasers position when the Space key is hit to align with the
	 * player and also updating its bounding box so to kill the player when it
	 * intersects with the droid bounding box
	 */

	public void update(Input input, int delta, ArrayList<Laser> lasers) {
		if (input.isKeyDown(Input.KEY_LEFT)) {
			playerXpos = this.getX() - delta * speed;
			this.setX(playerXpos);
			if (super.getX() < ScreenStartPos) {
				super.setX(this.getX() + delta * speed);
			}
		}

		if (input.isKeyDown(Input.KEY_RIGHT)) {
			playerXpos = this.getX() + delta * speed;
			this.setX(playerXpos);
			if (super.getX() + super.getImage().getWidth() > App.SCREEN_WIDTH) {
				super.setX(this.getX() - delta * speed);
			}
		}

		if (input.isKeyDown(Input.KEY_UP)) {
			playerYpos = this.getY() - delta * speed;
			this.setY(playerYpos);
			if (super.getY() < ScreenStartPos) {
				this.setY(this.getY() + delta * speed);
			}

		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			playerYpos = this.getY() + delta * speed;
			this.setY(playerYpos);
			if (super.getY() + super.getImage().getHeight() > App.SCREEN_HEIGHT) {
				this.setY(this.getY() - delta * speed);
			}
		}

		if (input.isKeyPressed(Input.KEY_SPACE)) {
			Laser dot = new Laser(this.getX() + super.getImage().getWidth() / divide_width - offsetXlaser, this.getY());
			lasers.add(dot);
		}

		BoundingBox bbox = this.getBbox();
		bbox.setTop(this.getY());
		bbox.setLeft(this.getX());

	}

}
