/*complement*/
Color complementColor(Color c){
  int red = c.getRed();
  int green = c.getGreen();
  int blue = c.getBlue();
  return new Color( red, blue, green);
}
Color mint = new Color(66, 244, 194);
Color coolBlue = complementColor(mint);
Color coolBlueEx = new Color(66, 194, 244);
Color lime = new Color(131, 249, 92);
Color lavender = complementColor(lime);
Color lavenderEx = new Color(66, 92, 249);

Color[] complementPixels(Color[] originalPixels){
  int size = originalPixels.length;
  Color[] newArray = new Color[size];
  for(int i = 0; i< size; i += 1){
    newArray[i] = complementColor(originalPixels[i]);
  }
  return newArray;
}
Color[] ml = {mint, lime};
Color[] mlPixels = complementPixels(ml);
Color[] mlPixelsEx = {coolBlueEx,lavenderEx};
Color[] bLa = {coolBlueEx, lavenderEx};
Color[] bLaPixels = complementPixels(bLa);
Color[] bLaPixelsEx = {mint,lavender};

Image complement(Image original){
  int width = original.getWidth();
  int height = original.getHeight();
  Color[] pixels = complementPixels(original.getPixels());
  return new Image( width, height, pixels);
}
Image craneComp = complement(readImage("image-files/crane.jpg"));
Image checkerComp = complement(readImage("image-files/checker5.bmp"));
/*chromascale*/
Color chromascaleColor(Color og, Color target){
  double average = (og.getRed()+og.getGreen()+og.getBlue())/3;
  double ratio = (average)/255;
  double red = intToDouble(target.getRed());
  double green = intToDouble(target.getGreen());
  double blue = intToDouble(target.getBlue());
  double multiply = (ratio*red);
  double multiply1 = (ratio*green);
  double multiply2 = (ratio*blue);
  return new Color(doubleToInt(multiply), doubleToInt(multiply1), doubleToInt(multiply2));
}
Color chromascaleEx = chromascaleColor(mint, lavender);
Color chromaEx = new Color(86,60,164);
Color chromascaleEx2 = chromascaleColor(lavenderEx, coolBlueEx);
Color chromaEx2 = new Color(34,102,129);

Color[] chromascalePixels(Color[] ogPixels, Color target){
  int size = ogPixels.length;
  Color[] newArray = new Color[size];
  for(int i = 0; i< size; i += 1){
    newArray[i] = chromascaleColor(ogPixels[i], target);
  }
  return newArray;
}
Color[] chromaPixels = chromascalePixels(ml, coolBlueEx);
Color[] chromaPixelsEx = {new Color(43,127,160), new Color(40,119,150)};
Color[] chromaPixels2 = chromascalePixels(bLa, lavenderEx);
Color[] chromaPixelsEx2 = {new Color(43,60,164), new Color(34,48,131)};

Image chromascale(Image original, Color target){
  int width = original.getWidth();
  int height = original.getHeight();
  Color[] pixels = chromascalePixels(original.getPixels(), target);
  return new Image( width, height, pixels);
}
Image craneChrom = chromascale(readImage("image-files/crane.jpg"), mint);
Image checkerChrom = chromascale(readImage("image-files/crane.jpg"), lavender);
/*gradient*/
Color gradientColor(Color color1, Color color2, double weightFor1){
  double red1 = intToDouble(color1.getRed());
  double green1 = intToDouble(color1.getGreen());
  double blue1 = intToDouble(color1.getBlue());
  double redlvl = intToDouble(color2.getRed());
  double greenlvl = intToDouble(color2.getGreen());
  double bluelvl = intToDouble(color2.getBlue());
  double red = (red1)*(weightFor1)+(redlvl)*(1-weightFor1);
  double green = (green1)*(weightFor1)+(greenlvl)*(1-weightFor1);
  double blue = (blue1)*(weightFor1)+(bluelvl)*(1-weightFor1);
  return new Color(doubleToInt(red),doubleToInt(green),doubleToInt(blue));
}
Color gradColor = gradientColor(mint, lavender, 0.5);
Color gradColorEx = new Color(98, 168, 221);
Color gradColor2 = gradientColor(coolBlueEx, lavenderEx, 0.5);
Color gradColorEx = new Color(66, 143, 246);

Color[] gradientPixels(int numPixels, Color color1, Color color2){
  int size = numPixels;
  Color[] newArray = new Color[size];
  for(int i = 0; i< size; i += 1){
    double weightFor1 = (i*1.0)/numPixels;
    newArray[i] = gradientColor(color1, color2, weightFor1);
}
  return newArray;
}

Color[] gradPixels = gradientPixels(2, mint, lavender);
Color[] gradPixelsEx = {new Color(131,92,249), new Color(98,168,221)};
Color[] gradPixels = gradientPixels(4, mint, lavender);
Color[] gradPixelsEx = {new Color(131,92,249), new Color(98,168,221), new Color(98,168,221), new Color(82,206,207)};

Image gradient( int imageWidth, int imageHeight, Color color1, Color color2){
  int og = imageWidth*imageHeight;
  Color[] pixels = gradientPixels(og, color1, color2);
  return new Image( imageWidth, imageHeight, pixels);
}

Image testGrad = gradient(8, 8, mint, lavender);
Image testingGrad = gradient( 15, 15,lavender, mint);

Color chromaKeyColor( Color fgColor, Color bgColor, Color key, double threshold){
  double red1 = intToDouble(fgColor.getRed());
  double green1 = intToDouble(fgColor.getGreen());
  double blue1 = intToDouble(fgColor.getBlue());
  double redlvl = intToDouble(bgColor.getRed());
  double greenlvl = intToDouble(bgColor.getGreen());
  double bluelvl = intToDouble(bgColor.getBlue());

}
