package packages;
import java.io.*;

public interface innerperson {
	void add() throws IOException;
	void add(String Name, String EmailID, String Phone);
	void modify() throws IOException;
	void display();
}