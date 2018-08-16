import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

import org.newdawn.slick.Image;

public class Sprite {

	private Image image = null;
	private String imagename;
	private float x;
	private float y;
	private BoundingBox bbox;

	/* Setting the image with the position in the res folder */
	public Sprite(String imageSrc, float x, float y) {

		try {
			image = new Image(imageSrc);
		} catch (SlickException e) {
			e.printStackTrace();
		}

		this.setImage_name(imageSrc);
		this.setX(x);
		this.setY(y);
		this.setBbox(new BoundingBox(this.getImage(), y, x));

		// Why would the constructor need a path to an image, and a coordinate?
	}

	public void update(Input input, int delta) {

		// How can this one method deal with different types of sprites?
	}

	public void render() {

		image.draw(x, y);
	}

	public void contactSprite(Sprite other) {

		// Should be called when one sprite makes contact with another.
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImage_name(String imagename) {
		this.imagename = imagename;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public BoundingBox getBbox() {
		return bbox;
	}

	public void setBbox(BoundingBox bbox) {
		this.bbox = bbox;
	}
}
