
public class Main {

	public static void main(String[] args) {
		
		Image im = ImageReader.read("example.txt");
		
		System.out.println(im.toString());
		
		im.debugIntegralImage();
		
		System.out.println(im.countSetPoints(2, 3, 2));
	}
}
