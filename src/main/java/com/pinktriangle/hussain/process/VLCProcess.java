package com.pinktriangle.hussain.process;

import java.io.File;
import java.io.IOException;

public class VLCProcess {
	private File chosenFile;
	
	public VLCProcess(File chosenFile){
		this.chosenFile = chosenFile;
	}
	
	public void playSelectedFile() throws IOException{
		ProcessBuilder builder = new ProcessBuilder("lib/VLC.app/Contents/MacOS/VLC","file://"+chosenFile.getPath());
		Process process = builder.start();
	}

}
