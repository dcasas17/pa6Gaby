import java.awt.Color;

class Image {

  int width;
  int height;
  Color[] pixels;

  Image(int width, int height, Color[] pixels) {
    this.width = width;
    this.height = height;
    this.pixels = pixels;
  }

  int getWidth() {
    return this.width;
  }

  int getHeight() {
    return this.height;
  }

  Color[] getPixels() {
    return this.pixels;
  }

  Color[][] getPixels2D() {
    Color[][] pixels2D = new Color[this.height][this.width];
    for (int i = 0; i < this.pixels.length; i += 1) {
      pixels2D[i/this.width][i%this.width] = this.pixels[i];
    }
    return pixels2D;
  }

  Color getColorAtPos(int x, int y) {
    return this.pixels[this.height*y+x];
  }

  int size() {
    return pixels.length;
  }

  public String toString() {
    int w = this.width;
    int h = this.height;
    String pixelRef = this.pixels.toString();
    String p = pixelRef.substring(pixelRef.indexOf("@"));
    return "Image[width=" + w + ",height=" + h + ",pixels=" + p + "]";
  }

}
