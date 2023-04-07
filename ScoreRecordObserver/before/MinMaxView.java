import java.util.Collections;
import java.util.List;

public class MinMaxView { // 전체 점수가 아니라 최소/최대값만을 출력하는 클래스
	private ScoreRecord scoreRecord;

	public MinMaxView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}

	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMax(record); // 최소/최대값만을 출력
	}

	private void displayMinMax(List<Integer> record) {
		int min = Collections.min(record, null);
		int max = Collections.max(record, null);
		System.out.println("Min: " + min + " Max: " + max);
	}
}
