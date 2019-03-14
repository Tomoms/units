import java.io.FileReader;

class TextReader {

	public static void main(String[] args) throws java.io.IOException {
		int i;
		FileReader fr;
		try {
			fr = new FileReader(args[0]);
		} catch (java.io.FileNotFoundException e) {
			System.out.println("File non trovato!");
			return;
		}
		while ((i = fr.read()) != -1)
			System.out.print((char) i);
	}

}
