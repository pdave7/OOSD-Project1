import org.newdawn.slick.Input;
import utilities.BoundingBox;

public class Laser extends Sprite {

	private static float speed = 3.0f;
	private static String laserimage = "res/shot.png";

	public Laser(float x, float y) {
		super(laserimage, x, y);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Updating the Laser to move up in the Y direction and updating its Boundingbox
	 * for intersection
	 */
	public void update(Input input, int delta) {

		this.setY(this.getY() - delta * speed);
		BoundingBox bbox = this.getBbox();
		bbox.setTop(this.getY());
	}

}
