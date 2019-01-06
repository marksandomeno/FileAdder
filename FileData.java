import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;

public class FileData {
	
	String s;
	static Scanner sc = new Scanner(System.in);
	
	
	public FileData(String path) {
		// TODO Auto-generated constructor stub
		this.s = path;
	}

	
	public static void main(String args[]) throws IOException {
		
		String file_name = "/Users/marksandomeno/Desktop/MAIN_FILE.txt";
		String addedText = "";

	
		
		System.out.println("ENTER A VALID PATH TO A .TXT FILE");
		System.out.println("Example: /Users/marksandomeno/Desktop/MAIN_FILE.txt");
		System.out.println("You can find a specific file location by dragging it into the Terminal");
		
		System.out.println("_______________________________________________________________________");
		System.out.print("Enter File Path (No Spaces) ->");
		file_name = sc.nextLine();
		file_name = file_name.trim();
		
		
		try {
			
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			int i;
			System.out.println("Fetching File Data...");
			for(i = 0; i < aryLines.length; i++) {
				
				System.out.println(aryLines[i]);
			}
		}
		catch (IOException e) {
			
			System.out.println("Error in trying to read file found at: " + file_name);
		
			
		}
		
		WriteFile data = new WriteFile(file_name, true);
		//added to file
		
		System.out.print("Enter text you wish to import into file:");
		addedText = sc.nextLine();
		
		data.writeToFile("Added Text: " + addedText);
		
		System.out.println("____COMPLETE____");
		
	}


public static class ReadFile {
	
	private String path;
	
	public ReadFile(String file_path) {
		
		path = file_path;
	}

	
	public String[] OpenFile() throws IOException {
		
			FileReader fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader(fr);
			
			int numberOfLines = 0;
			String[] textData = new String[numberOfLines];
			
			int i;
			
			for(i = 0; i < numberOfLines; i++) {
				
				textData[i] = textReader.readLine();
				
			}
			
			textReader.close();
			return textData;
	}
	
	
int readLine() throws IOException {
		
	FileReader file_to_read = new FileReader(path);
	BufferedReader bf = new BufferedReader(file_to_read);
	
	String aLine;
	int numberOfLines = 0;
	
	while ((aLine = bf.readLine()) != null) {
		
		numberOfLines++;
	}
			bf.close();
			return numberOfLines;
	}


}//close read file

public static class WriteFile {
	
	private String path;
	private boolean append_to_file = false;
	
	
	public WriteFile(String file_path, boolean append_value) {
		
		path = file_path;
		append_to_file = append_value;
	}
	
	public void writeToFile(String textLine) throws IOException {
		
		FileWriter write  = new FileWriter(path, append_to_file);
		PrintWriter print_line = new PrintWriter(write);
		
		print_line.printf("%s"+ "%n", textLine);
		
		print_line.close();
		
	}
  }

}
