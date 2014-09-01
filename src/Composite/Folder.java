package Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Node {

	private List<Node> nodeList = new ArrayList<Node>();
	private String folderName;

	@Override
	public void copy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add() {
		// TODO Auto-generated method stub

	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

}
