package me.icanttellyou.mclava;


public interface Delegate {
	@SuppressWarnings("unused")
	Delegate empty = args -> {};
	void call(Object... args);
}
