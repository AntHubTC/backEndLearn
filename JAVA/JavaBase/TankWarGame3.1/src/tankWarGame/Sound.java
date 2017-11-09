package tankWarGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import sun.audio.*;
public class Sound {
	
	public boolean isStop = true;
	public boolean isLoop = false;
	
	private String url;
	private FileInputStream f;
	private AudioStream curSound;
	private ContinuousAudioDataStream cas;
	AudioData data;
	/***
	 * ��������,���ô��ַ�ʽ������������ÿ��new
	 * ������ÿ�β�����ͻ����һ��
	*/
	/*
	 import sun.audio.AudioData;
	 import sun.audio.AudioPlayer;
	 import sun.audio.AudioStream;
	 import sun.audio.ContinuousAudioDataStream;
	 */
	
	
	public Sound(String url)
	{
		this.url = url;
	}
	
	public Sound(String url, boolean isLoop)
	{
		this(url);
		this.isLoop = isLoop;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void play()//��������
	{
		if(isStop)//����Ƿ����
		{
			try {
				f = new FileInputStream(url);
 				curSound = new AudioStream(f);
				if(isLoop)
				{
					data = curSound.getData();//��������Ὣԭ���Ķ������
					cas = new ContinuousAudioDataStream(data);
					AudioPlayer.player.start(cas);
					isStop = false;
				}
				else
				{
					AudioPlayer.player.start(curSound);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void stop()//ֹͣ
	{
		if(!isStop)
		{
			AudioPlayer.player.stop(cas);
			isStop = true;
		}

	}
}
