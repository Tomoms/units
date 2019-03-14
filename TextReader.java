import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class TextReader {
	
	private static final String FILENAME = "C:\\Users\\Andrea\\Documents\\code\\java\\Lettore_di_file\\Text.txt";

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			ArrayList<String> lines = new ArrayList<String>();
			String sCurrentLine;
			
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
				System.out.println(sCurrentLine);
			}
			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	
	}

}
