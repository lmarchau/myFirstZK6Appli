package fr.weix.test.zk.services;

import fr.weix.test.zk.entity.Log;
import java.util.List;

public interface MyService {

	Log addLog(Log log);

	List<Log> getLogs();

	void deleteLog(Log log);
}
