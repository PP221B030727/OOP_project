package FirstProject;

import java.io.Serializable;

public class Mark implements Serializable{
	private static final long serialVersionUID = 1L;
	public double firstAt;
	public double secondAt;
	public double finalExam;
	Mark(double f){
		this.firstAt = f;
	}
	Mark(double f , double s){
		this(f);
		this.secondAt = s;
	}
	Mark(double f , double s,double t){
		this(f,s);
		this.finalExam = t;
	}
	public double getFirstAt() {
		return firstAt;
	}
	public void setFirstAt(double firstAt) {
		this.firstAt = firstAt;
	}
	public double getSecondAt() {
		return secondAt;
	}
	public void setSecondAt(double secondAt) {
		this.secondAt = secondAt;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	@Override
	public String toString() {
		return "Mark [firstAt=" + firstAt + ", secondAt=" + secondAt + ", finalExam=" + finalExam + "]";
	}
	
	
}
