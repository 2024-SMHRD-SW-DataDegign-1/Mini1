package Mini1;

import DungeonBgm.DBgm;
import javazoom.jl.player.MP3Player;

	public class DungeonBgm {


		MP3Player mp3 = new MP3Player();
		
		
				
		// 로그인 브금
		public void logBgm () {
			
			DBgm bgm = new DBgm("C:\\Users\\smhrd\\Desktop\\JavaStudy\\Musicplayer\\Player\\One Piece - Katakuri Theme (HQ Cover) (1).mp3","Katakuri");
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(bgm.getPath());
		}
		// 노래 키기
		
		public void bgmOn () {
			
			DBgm bgm = new DBgm("C:\\Users\\smhrd\\Desktop\\JavaStudy\\Musicplayer\\Player\\evildom_basecamp.mp3","evildom_basecamp");
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(bgm.getPath());
			
		}
		
		// 노래 끄기
		public void bgmOff() {
			mp3.stop();
		}
		

}