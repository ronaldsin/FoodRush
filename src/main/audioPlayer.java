package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class audioPlayer {//plays audio
	
	URL urlBgm1 = audioPlayer.class.getResource("/resource/audio/bgm1.wav");
	AudioClip bgm1 = Applet.newAudioClip(urlBgm1);
	
	URL urlBgm2 = audioPlayer.class.getResource("/resource/audio/bgm2.wav");
	AudioClip bgm2 = Applet.newAudioClip(urlBgm2);
	
	URL urlBgm3 = audioPlayer.class.getResource("/resource/audio/bgm3.wav");
	AudioClip bgm3 = Applet.newAudioClip(urlBgm3);
	
	URL urlBgm4 = audioPlayer.class.getResource("/resource/audio/bgm4.wav");
	AudioClip bgm4 = Applet.newAudioClip(urlBgm4);
	
	URL urlBgm5 = audioPlayer.class.getResource("/resource/audio/bgm5.wav");
	AudioClip bgm5 = Applet.newAudioClip(urlBgm5);
	
	URL urlBgm6 = audioPlayer.class.getResource("/resource/audio/bgm6.wav");
	AudioClip bgm6 = Applet.newAudioClip(urlBgm6);
	
	URL urlBgm7 = audioPlayer.class.getResource("/resource/audio/bgm7.wav");
	AudioClip bgm7 = Applet.newAudioClip(urlBgm7);
	public audioPlayer(){

	}
	public void playBgm(int x){
		bgm1.stop();
		bgm2.stop();
		bgm3.stop();
		bgm4.stop();
		bgm5.stop();
		bgm6.stop();
		bgm7.stop();
		
		if(x==1)
			bgm1.loop();
		else if(x==2)
			bgm2.loop();
		else if(x==3)
			bgm3.loop();
		else if(x==4)
			bgm4.loop();
		else if(x==5)
			bgm5.loop();
		else if(x==6)
			bgm6.loop();
		else if(x==7)
			bgm7.loop();
	}
	public void stopBgm(){
		bgm1.stop();
		bgm2.stop();
		bgm3.stop();
		bgm4.stop();
		bgm5.stop();
		bgm6.stop();
		bgm7.stop();
	}
	public void play(String file){
		URL url = audioPlayer.class.getResource(file);
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();

	}
	
	public void stop(String file){
		URL url = audioPlayer.class.getResource(file);
		AudioClip clip = Applet.newAudioClip(url);
		clip.stop();
	}
	public void exit(){
	
	}
}