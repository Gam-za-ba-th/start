
import java.text.SimpleDateFormat;
import java.util.Date;

class Tools {

	public static String getTime() {
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return formatter.format(now);
	}
}