package br.com.codenation;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticUtil {

	public static int average(int[] elements) {
		List<Integer> nList = toList(elements);
		return nList.stream().mapToInt(Integer::intValue).sum() / nList.size();
	}

	public static int mode(int[] elements) {
		Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
		List<Integer> nList = toList(elements);
		nList.forEach(n -> {
			frequencies.put(n, Collections.frequency(nList, n));
		});

		return frequencies
				.entrySet()
				.stream()
				.sorted((f1, f2) -> f2.getValue().compareTo(f1.getValue()))
				.findFirst()
				.get()
				.getKey();
	}

	public static int median(int[] elements) {
		List<Integer> nList = toList(elements);

		Integer size = nList.size();

		if(size % 2 == 0) return (nList.get(size/2 - 1) + nList.get(size/2)) /2;
		return nList.get(size/2);
	}

	private static List<Integer> toList(int[] elements) {
		return Arrays
				.stream(elements)
				.boxed()
				.sorted(Comparator.comparingInt(Integer::intValue))
				.collect(Collectors.toList());
	}
}