
import java.util.List;

public interface NetworkInterface {

	public void sendMessage();

	public void sendCellUpdate();

	public void sendCrossword();

	public List<Server> getServers();

	public void turnServerOn();

	public void turnServerOff();

}
