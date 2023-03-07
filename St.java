package before;

import java.util.ArrayList;
import java.util.List;

public class St {
	private String nm;
	private List<Integer> scores = new ArrayList<>() ;
	
	public St(String name) {
		super();
		this.nm = name;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String name) {
		this.nm = name;
	}
	public List<Integer> getScs() {
		return scores;
	}
	public void setScs(List<Integer> scores) {
		this.scores = scores;
	}
}
