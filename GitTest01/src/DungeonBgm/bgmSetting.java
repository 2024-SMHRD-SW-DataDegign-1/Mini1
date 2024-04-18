package DungeonBgm;

import javazoom.jl.player.MP3Player;

public class bgmSetting {

	public static void main(String[] args) {

		
		
		MP3Player mp3 = new MP3Player();
		
		mp3.play("C:\\Users\\smhrd\\Desktop\\JavaStudy\\Musicplayer\\Player\\One Piece - Katakuri Theme (HQ Cover) (1).mp3");
		
		mp3.isPlaying();
		mp3.stop();
		
		System.out.println(mp3.isPlaying());
		
		
	}

}