package net.sf.aspect4log.text;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LogFormmatterTest {

	@Test
	public void isToStringOverriden() {
		Assert.assertFalse(new LogFormatter().isToStringOverriden(new Object().getClass()));
		Assert.assertFalse(new LogFormatter().isToStringOverriden(new Object[] { 1 }.getClass()));
		Assert.assertTrue(new LogFormatter().isToStringOverriden(new String("s").getClass()));
		Assert.assertTrue(new LogFormatter().isToStringOverriden(new Integer(1).getClass()));
	}

	@Test
	public void testSubstitute() {
		Integer i = 5;
		String s = "s";
		int[] ii = { 1, 2 };
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		List<?> ai = Arrays.asList(4, 5, map);
		Object[] args = { i, s, ii, ai };

		Assert.assertEquals("args are: s, [5, s, [1, 2], {4, 5, {key1=value1, key2=value2}}]", new LogFormatter().toString("args are: ${args[1]}, ${args}", args));
		Assert.assertEquals("${5}, [1, 2]", new LogFormatter().toString("${${args[0]}}, ${args[2]}", args));

		boolean[] bb = { true, false };
		byte[] bytea = { 0 };
		short[] shorta = { 2 };
		long[] longa = { 3 };
		char[] chara = { 'c' };
		float[] floata = { 4 };
		double[] da = { 5 };
		Object[] arguments = { bb, bytea, shorta, longa,chara,floata,da };
		
		Assert.assertEquals("[[true, false], [0], [2], [3], [c], [4.0], [5.0]]", new LogFormatter().toString("${args}", arguments));
	}

}
