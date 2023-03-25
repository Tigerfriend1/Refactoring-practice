package original;

public class PuzzleBuilder {
	private String[] values;
	private int[] xs;
	private int[] ys;
	private int[] dirs;
	private int index;

	private String name;

	public PuzzleBuilder(String name, int size) {
		this.name = name;
		values = new String[size];
		xs = new int[size];
		ys = new int[size];
		dirs = new int[size];
		index = 0;
	}

	public int getSize() {
		return index;
	}

	public int addWord(String value, int x, int y, int dir) {
		for (int i = 0; i < index; i++) {
			if (values[i].compareTo(value) == 0 && dirs[i] == dir)
				return -1;
		}
		boolean result = isOnPuzzle(value, x, y, dir);
		if (result)
			return -2;

		values[index] = value;
		xs[index] = x;
		ys[index] = y;
		dirs[index] = dir;

		index++;
		return 0;
	}

	private boolean isHorizontal(int x, int y, String value) {
	    for (int i = 0; i < index; i++) {
	        if (dirs[i] == 0 && ys[i] == y) {
	            if ((x >= xs[i] && x <= xs[i] + values[i].length()) ||
	                    (x + value.length() >= xs[i] && x + value.length() <= xs[i] + values[i].length())) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	private boolean isVertical(int x, int y, String value) {
	    for (int i = 0; i < index; i++) {
	        if (dirs[i] == 1 && xs[i] == x) {
	            if ((y >= ys[i] && y <= ys[i] + values[i].length()) ||
	                    (y + value.length() >= ys[i] && y + value.length() <= ys[i] + values[i].length())) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	private boolean isOnPuzzle(String value, int x, int y, int dir) {
	    return (dir == 0 && isHorizontal(x, y, value)) ||
	            (dir == 1 && isVertical(x, y, value));
	}


	public int getWordPosition(int coord, String value, int dir) {
		for (int i = 0; i < index; i++) {
			if (values[i].compareTo(value) == 0 && dirs[i] == dir) {
				if (coord == 0)
					return xs[i];
				else
					return ys[i];
			}
		}

		return -1;
	}

	public int getPoint() {
		int totalPoint = 0;
		for (int i = 0; i < index; i++) {
			int point;
			if (dirs[i] == 0)
				point = values[i].length();
			else
				point = values[i].length() * 2;

			totalPoint += point;
		}
		return totalPoint;
	}

	public String getShortReport(boolean isHTML) {
		String value;
		if (isHTML) {
			value = "<H1> Report on Puzzle <EM> " + name + "</EM></H1>\n";
		} else {
			value = "Report on Puzzle " + name + "\n";
		}
		int point = 0;
		for (int i = 0; i < index; i++) {
			int result;
			if (dirs[i] == 0)
				result = values[i].length();
			else
				result = values[i].length() * 2;

			if (isHTML)
				value += "\tWord: <B>" + values[i] + "</B>\tPoint: <B> " + result + "</B>\n";
			else
				value += "\tWord: " + values[i] + "\tPoint: " + result + "\n";

			point += result;
		}
		if (isHTML) {
			value += "<HR> Total Point: <B>" + point + "</B><P>\n";
		} else {
			value += "Total Point: " + point + "\n";
		}
		return value;
	}

	public String getFullReport(boolean isHTML) {
		String value;
		if (isHTML) {
			value = "<H1> Report on Puzzle <EM> " + name + "</EM></H1>\n";
		} else {
			value = "Report on Puzzle " + name + "\n";
		}
		int point = 0;
		for (int i = 0; i < index; i++) {
			int result;
			if (dirs[i] == 0)
				result = values[i].length();
			else
				result = values[i].length() * 2;

			if (isHTML)
				value += "\tWord: <B>" + values[i] + "\tPosition: [" + xs[i] + ", " + ys[i] + "]" + "\tDir: " + dirs[i]
						+ " </B> Point: <B> " + result + "</B>\n";
			else
				value += "\tWord: " + values[i] + "\tPosition: [" + xs[i] + ", " + ys[i] + "]" + "\tDir: " + dirs[i]
						+ " Point: " + result + "\n";

			point += result;
		}
		if (isHTML) {
			value += "<HR> Total Point: <B>" + point + "</B><P>\n";
		} else {
			value += "Total Point: " + point + "\n";
		}
		return value;
	}
}
