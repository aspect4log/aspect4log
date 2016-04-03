package org.foo.service;

import static net.sf.aspect4log.Log.Level.DEBUG;
import static net.sf.aspect4log.Log.Level.INFO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.foo.dao.FooDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Exceptions;

@Service
@Log
public class FooService {

	@Autowired
	private FooDao fooDao;

	@Log(enterLevel = INFO, exitLevel = DEBUG, argumentsTemplate = "oo={${args[0]},${args[1]}}")
	public void doFoo(Object... oo) {

	}

	@Log(enterLevel = INFO, exitLevel = DEBUG, argumentsTemplate = "foo=${args[0]}")
	public boolean isFoo(String foo) {
		return foo.toLowerCase().startsWith("foo");
	}

	public boolean isAtLeastOneFoo(Object... foo) {
		for (Object f : foo) {
			if (f.equals("foo")) {
				return true;
			}
		}
		return false;
	}

	public List<String> findFoo() {
		return fooDao.findFoo();
	}

	@Log(on = @Exceptions(exceptions = IllegalArgumentException.class, stackTrace = false, template = "was thrown ${exception}"))
	public void saveFoo(String foo) {
		if (isFoo(foo)) {
			fooDao.saveFoo(foo);
		} else
			throw new IllegalArgumentException("Not FOO");
	}

	public Map<String, Integer> getMap() {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("key1", 1);
		map.put("key2", 2);
		return map;
		
	}
}
