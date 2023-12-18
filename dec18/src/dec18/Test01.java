package dec18;

import com.hoshi.access.Human;

class Connection{
	private static Connection _inst = null;
	private int count = 0;
	
	static public Connection get() {
		if (_inst == null) {
			_inst = new Connection();
		} else {
			_inst = _inst;
		}
		return _inst;
	}
	public void count() {
		count++;
	}
	public int getCount() {
		return count;
	}
}
public class Test01 {
	public static void main(String[] args) {
	Connection conn1 = Connection.get();
	conn1.count();
	Connection conn2 = Connection.get();
	conn1.count();
	Connection conn3 = Connection.get();
	conn1.count();
	Connection conn4 = Connection.get();
	conn1.count();
	}
}
