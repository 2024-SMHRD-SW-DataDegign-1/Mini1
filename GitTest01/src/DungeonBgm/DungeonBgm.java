package DungeonBgm;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class DungeonBgm {

	public static void main(String[] args) {

		MP3Player mp3 = new MP3Player();
		Scanner sc = new Scanner(System.in);

		String compath = "C:\\Users\\smhrd\\Desktop\\JavaStudy\\Musicplayer\\Player\\";

		ArrayList<DBgm> dungeonBgm = new ArrayList<DBgm>();

		dungeonBgm.add(new DBgm(compath + "One Piece - Katakuri Theme (HQ Cover) (1).mp3", "Katakuri"));

		int i = 0;

		while (true) {
			System.out.println("[1] 재생 [2] 정지 [3] 종료");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("===============♪BGM 재생-!♪===============");
				if (mp3.isPlaying()) {
					mp3.stop();
				} else {
					mp3.play(dungeonBgm.get(i).getPath());
					System.out.println(dungeonBgm.get(i).getTitle() + " 재생 중 입니다.");
				}
			} else if (input == 2) {
				System.out.println("==========BGM STOP==========");
				if (mp3.isPlaying()) {
					mp3.stop();
					System.out.println("=========정지=========");
				} else {
					System.out.println("재생중인 곡이 없습니다!");

				}
			} else if (input == 3) {
				System.out.println("==========♬BGM 종료♬===========");
				mp3.stop();
				break;
			}

		}

	}

}
