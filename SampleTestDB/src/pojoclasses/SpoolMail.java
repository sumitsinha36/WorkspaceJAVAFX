package pojoclasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SpoolMail {

	public IntegerProperty eid;
	public IntegerProperty state;

	public SpoolMail(Integer eid, Integer status) {
		this.eid = new SimpleIntegerProperty();
		this.state = new SimpleIntegerProperty();
	}

	public IntegerProperty getUserId() {
		return eid;
	}

	public IntegerProperty getUserPhoto() {
		return state;
	}
}
