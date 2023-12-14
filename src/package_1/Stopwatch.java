package package_1;

public class Stopwatch {
	private final long start;//instance
	public Stopwatch() {
		start =System.currentTimeMillis();
	}
	public double elapsedTime() {
		long now  = System.currentTimeMillis();
		return (now -start)/1000.0;
	}
}
