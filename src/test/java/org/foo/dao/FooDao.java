package org.foo.dao;

import java.util.ArrayList;
import java.util.List;

import net.sf.aspect4log.Log;

import org.springframework.stereotype.Repository;

@Repository
@Log
public class FooDao {

	public FooDao(){
		
	}
	
	ArrayList<String> list = new ArrayList<String>();
	
	public void saveFoo(String foo) {
		list.add(foo);
	}

	@SuppressWarnings("unchecked")
	public List<String> findFoo() {
		return (List<String>) list.clone();
	}
}
